package com.douzone.comet.service.hr.pamodm;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.douzone.comet.components.DzCometService;
import com.douzone.comet.service.hr.pamodm.dao.PAMODM01800_DAO;
import com.douzone.comet.service.hr.pamodm.models.PAMODM01800_MODEL;
import com.douzone.comet.service.util.StringUtil;
import com.douzone.gpd.components.exception.DzApplicationRuntimeException;
import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.CometModule;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;
import com.douzone.gpd.restful.model.DzGridModel;

@DzApiService(value = "PAMODM01800_Service", module = CometModule.HR, desc = "행사참가직원등록서비스")
public class PAMODM01800_Service extends DzCometService {

	@Autowired
	private PAMODM01800_DAO dao;
 
	// [조회]
	@DzApi(url = "/pamodm01800_service_list", desc = "행사참가직원등록-조회", httpMethod = DzRequestMethod.POST)
	public List<PAMODM01800_MODEL> pamodm01800_service_list(
			@DzParam(key = "COMPANY_CD", desc = "사업장", required = false, paramType = DzParamType.Body) String COMPANY_CD,
			@DzParam(key = "DEPT_CD", desc = "부서", required = false, paramType = DzParamType.Body) String DEPT_CD,
			@DzParam(key = "START_DT", desc = "시작일", required = false, paramType = DzParamType.Body) String START_DT,
			@DzParam(key = "END_DT", desc = "종료일", required = false, paramType = DzParamType.Body) String END_DT,
			@DzParam(key = "DOF_TP", desc = "휴무유형", required = false, paramType = DzParamType.Body) String DOF_TP)
			throws Exception {

		List<PAMODM01800_MODEL> items = new ArrayList<PAMODM01800_MODEL>();
		try {
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("COMPANY_CD", COMPANY_CD);
			parameters.put("DEPT_CD", DEPT_CD);
			parameters.put("START_DT", START_DT);
			parameters.put("END_DT", END_DT);
			parameters.put("DOF_TP", DOF_TP);
			items = dao.selectList_staff_list(parameters);
		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}

		return items;
	}

	// [저장]
	@Transactional(rollbackFor = Exception.class)
	@DzApi(url = "/pamodm01800_service_save", desc = "행사참가직원등록-저장", httpMethod = DzRequestMethod.POST)
	public void pamodm01800_service_save(
			@DzParam(key = "ds1", desc = "마스터그리드", paramType = DzParamType.Body) DzGridModel<PAMODM01800_MODEL> ds1)
			throws Exception {
		try {
			// this는 로그인한 정보이다.
			Date date = new Date();
			String userId = this.getUserId();
			String companyCd = this.getCompanyCode();
			Integer count;
 
			// [데이터 추가]
			for (PAMODM01800_MODEL insertRow : ds1.getAdded()) { // 받아온 ds1을 model에 저장

				insertRow.setEmp_no(insertRow.getEmp_no()); // 사원번호

				if (companyCd == null || companyCd.equals("")) {
					throw new DzApplicationRuntimeException("입력하신 사원번호는 존재하지 않습니다.\n재조회 후 처리하십시오.");
				}
				insertRow.setCompany_cd(companyCd);
				insertRow.setStart_dt(StringUtil.getLocaleTimeString(insertRow.getStart_dt(), "yyyyMMdd"));
				insertRow.setEnd_dt(StringUtil.getLocaleTimeString(insertRow.getEnd_dt(), "yyyyMMdd"));
				insertRow.setInsert_dts(date); // 입력시간
				insertRow.setInsert_id(userId); // 작성자
				insertRow.setInsert_ip(this.getRemoteHost());
				System.out.println("insertRow"+insertRow);
				count = dao.selectPK(insertRow);
				System.out.println("count갯수" + count);
				
				if (count > 0) {
					System.out.println("good throw");
					throw new DzApplicationRuntimeException("이미 등록된 행사이력이 있습니다.\n재조회 후 처리하십시오.");
				}
				
			}
			
			// [삭제]
			for (PAMODM01800_MODEL deleteRow : ds1.getDeleted()) {
 
				deleteRow.setEmp_no(deleteRow.getEmp_no());
				companyCd = dao.selectCompanyCd(deleteRow.getEmp_no());
				deleteRow.setCompany_cd(companyCd);
  
				if (companyCd == null || companyCd.equals("")) {
					throw new DzApplicationRuntimeException("조회하신 회사코드는 존재하지 않습니다.\n재조회 후 처리하십시오.");
				}
				deleteRow.setStart_dt(StringUtil.getLocaleTimeString(deleteRow.getStart_dt(), "yyyyMMdd"));
				deleteRow.setEnd_dt(StringUtil.getLocaleTimeString(deleteRow.getEnd_dt(), "yyyyMMdd"));
 
			}
			
			// [업데이트]
			for (PAMODM01800_MODEL updateRow : ds1.getUpdated()) {
				companyCd = dao.selectCompanyCd(updateRow.getEmp_no()); // 사원번호로 회사코드 받아오기

			    //조건
				updateRow.setCompany_cd(companyCd); //회사코드
				updateRow.setEmp_no(updateRow.getEmp_no()); //사원번호
				
				//업데이트할 데이터
				updateRow.setStart_dt(StringUtil.getLocaleTimeString(updateRow.getStart_dt(), "yyyyMMdd")); //시작일 
				updateRow.setEnd_dt(StringUtil.getLocaleTimeString(updateRow.getEnd_dt(), "yyyyMMdd"));//종료일
				updateRow.setDof_tp(updateRow.getDof_tp()); // 휴무유형
				updateRow.setLve_tm_cnt(updateRow.getLve_tm_cnt());//이탈시간
				updateRow.setUpdate_id(this.getUserId());// 업데이트id
				updateRow.setUpdate_ip(this.getRemoteHost());//업데이트ip
			 
			}

			
			// 배치일때는 따로 실행시켜주기..
			System.out.println("ds1 add :"+ ds1.getAdded() );
					
			if (ds1.getAdded() != null && ds1.getAdded().size() > 0) {
				dao.insertBatch(ds1.getAdded());
			}
			if (ds1.getDeleted() != null && ds1.getDeleted().size() > 0) {
				dao.deleteBatch(ds1.getDeleted());
			}
			if (ds1.getUpdated() != null && ds1.getUpdated().size() > 0) {
				dao.updateBatch(ds1.getUpdated());
			}
			
			

		} catch (Exception e) {
			throw new DzApplicationRuntimeException(e);
		}
	}
}
