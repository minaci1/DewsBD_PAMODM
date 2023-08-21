package com.douzone.comet.service.hr.pamodm.models;
 
import java.math.BigDecimal;
import java.util.Date;

import com.douzone.gpd.jdbc.mybatis.model.DzAbstractModel;
import com.douzone.gpd.restful.annotation.DzModel;
import com.douzone.gpd.restful.annotation.DzModelField;
import com.google.gson.annotations.SerializedName;
 
@DzModel(name = "PAMODM01800_MODEL", desc = "행사참가직원리스트")
public class PAMODM01800_MODEL extends DzAbstractModel {

	@SerializedName("COMPANY_CD")
	@DzModelField(name="company_cd", desc="회사코드", colName="COMPANY_CD", colSize="7", isKey=false)
	private String company_cd;
	  
	@SerializedName("EMP_NO")
	@DzModelField(name="emp_no", desc="사원번호", colName="EMP_NO", colSize="20", isKey=false)
	private String emp_no;
	  
	@SerializedName("KOR_NM")
	@DzModelField(name="kor_nm", desc="성명", colName="KOR_NM", colSize="50", isKey=false)
	private String kor_nm;
	  
	@SerializedName("DEPT_CD")
	@DzModelField(name="dept_cd", desc="부서코드", colName="DEPT_CD", colSize="20", isKey=false)
	private String dept_cd;
	  
	@SerializedName("OGRP_CD")
	@DzModelField(name="ogrp_cd", desc="직군코드", colName="OGRP_CD", colSize="5", isKey=false)
	private String ogrp_cd;
	  
	@SerializedName("PSTN_CD")
	@DzModelField(name="pstn_cd", desc="직급코드", colName="PSTN_CD", colSize="5", isKey=false)
	private String pstn_cd;
	  
	@SerializedName("JNCO_DT")
	@DzModelField(name="jnco_dt", desc="입사일", colName="JNCO_DT", colSize="8", isKey=false)
	private String jnco_dt;
	  
	@SerializedName("MNG_LP")
	@DzModelField(name="mng_lp", desc="승격일", colName="MNG_LP", colSize="200", isKey=false)
	private String mng_lp;
	  
	@SerializedName("MNG_EP")
	@DzModelField(name="mng_ep", desc="퇴직예정일", colName="MNG_EP", colSize="200", isKey=false)
	private String mng_ep;
	  
	@SerializedName("START_DT")
	@DzModelField(name="start_dt", desc="시작일", colName="START_DT", colSize="8", isKey=false)
	private String start_dt;
	  
	@SerializedName("END_DT")
	@DzModelField(name="end_dt", desc="종료일", colName="END_DT", colSize="8", isKey=false)
	private String end_dt;
	  
	@SerializedName("TM_CD_NM")
	@DzModelField(name="tm_cd_nm", desc="시간코드명", colName="TM_CD_NM", colSize="50", isKey=false)
	private String tm_cd_nm;
	
	@SerializedName("DOF_TP")
	@DzModelField(name="dof_tp", desc="휴무유형", colName="DOF_TP", colSize="5", isKey=false)
	private String dof_tp;
	  
	@SerializedName("START_TM")
	@DzModelField(name="start_tm", desc="시작시간", colName="START_TM", colSize="5", isKey=false)
	private String start_tm;
	  
	@SerializedName("END_TM")
	@DzModelField(name="end_tm", desc="종료시간", colName="END_TM", colSize="5", isKey=false)
	private String end_tm;
	  
	@SerializedName("DOF_TM_CNT")
	@DzModelField(name="dof_tm_cnt", desc="휴무시간수", colName="DOF_TM_CNT", colSize="0", isKey=false)
	private BigDecimal dof_tm_cnt;
	  
	@SerializedName("LVE_TM_CNT")
	@DzModelField(name="lve_tm_cnt", desc="이탈시간수", colName="LVE_TM_CNT", colSize="0", isKey=false)
	private BigDecimal lve_tm_cnt;
	
	 @SerializedName("INSERT_ID")
    @DzModelField(name="insert_id", desc="INSERT_ID", colName="INSERT_ID")
    protected String insert_id;

    @SerializedName("INSERT_DTS")
    @DzModelField(name="insert_dts", desc="INSERT_DTS", colName="INSERT_DTS")
    protected java.util.Date insert_dts;
    
    @SerializedName("INSERT_IP")
	@DzModelField(name="insert_ip", desc="등록IP", colName="INSERT_IP", colSize="200", isKey=false)
	private String insert_ip;
	  
	public String getInsert_ip() {
		return insert_ip;
	}

	public void setInsert_ip(String insert_ip) {
		this.insert_ip = insert_ip;
	}

	public String getUpdate_ip() {
		return update_ip;
	}

	public void setUpdate_ip(String update_ip) {
		this.update_ip = update_ip;
	}

	@SerializedName("INSERT_MCADDR_NM")
	@DzModelField(name="insert_mcaddr_nm", desc="등록맥어드레스명", colName="INSERT_MCADDR_NM", colSize="200", isKey=false)
	private String insert_mcaddr_nm;
	

    @SerializedName("UPDATE_ID")
    @DzModelField(name="update_id", desc="UPDATE_ID", colName="UPDATE_ID")
    protected String update_id;

    @SerializedName("UPDATE_DTS")
    @DzModelField(name="update_dts", desc="UPDATE_DTS", colName="UPDATE_DTS")
    protected java.util.Date update_dts;
    
    @SerializedName("UPDATE_IP")
	@DzModelField(name="update_ip", desc="수정IP", colName="UPDATE_IP", colSize="200", isKey=false)
	private String update_ip;
 
	public String getCompany_cd() {
		return company_cd;
	}

	public void setCompany_cd(String company_cd) {
		this.company_cd = company_cd;
	}
 
	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
 
	public String getKor_nm() {
		return kor_nm;
	}

	public void setKor_nm(String kor_nm) {
		this.kor_nm = kor_nm;
	}
 
	public String getDept_cd() {
		return dept_cd;
	}

	public void setDept_cd(String dept_cd) {
		this.dept_cd = dept_cd;
	}
 
	public String getOgrp_cd() {
		return ogrp_cd;
	}

	public void setOgrp_cd(String ogrp_cd) {
		this.ogrp_cd = ogrp_cd;
	}
 
	public String getPstn_cd() {
		return pstn_cd;
	}

	public void setPstn_cd(String pstn_cd) {
		this.pstn_cd = pstn_cd;
	}
 
	public String getJnco_dt() {
		return jnco_dt;
	}

	public void setJnco_dt(String jnco_dt) {
		this.jnco_dt = jnco_dt;
	}
 
	public String getMng_lp() {
		return mng_lp;
	}

	public void setMng_lp(String mng_lp) {
		this.mng_lp = mng_lp;
	}
 
	public String getMng_ep() {
		return mng_ep;
	}

	public void setMng_ep(String mng_ep) {
		this.mng_ep = mng_ep;
	}
 
	public String getStart_dt() {
		return start_dt;
	}

	public void setStart_dt(String start_dt) {
		this.start_dt = start_dt;
	}
 
	public String getEnd_dt() {
		return end_dt;
	}

	public void setEnd_dt(String end_dt) {
		this.end_dt = end_dt;
	}
 
	public String getTm_cd_nm() {
		return tm_cd_nm;
	}

	public void setTm_cd_nm(String tm_cd_nm) {
		this.tm_cd_nm = tm_cd_nm;
	}
	
	public String getDof_tp() {
		return dof_tp;
	}

	public void setDof_tp(String dof_tp) {
		this.dof_tp = dof_tp;
	}
	
	public String getStart_tm() {
		return start_tm;
	}

	public void setStart_tm(String start_tm) {
		this.start_tm = start_tm;
	}
 
	public String getEnd_tm() {
		return end_tm;
	}

	public void setEnd_tm(String end_tm) {
		this.end_tm = end_tm;
	}
 
	public BigDecimal getDof_tm_cnt() {
		return dof_tm_cnt;
	}

	public void setDof_tm_cnt(BigDecimal dof_tm_cnt) {
		this.dof_tm_cnt = dof_tm_cnt;
	}
 
	public BigDecimal getLve_tm_cnt() {
		return lve_tm_cnt;
	}

	public void setLve_tm_cnt(BigDecimal lve_tm_cnt) {
		this.lve_tm_cnt = lve_tm_cnt;
	}
	
	public String getInsert_id() {
		return insert_id;
	}

	public void setInsert_id(String insert_id) {
		this.insert_id = insert_id;
	}

	public java.util.Date getInsert_dts() {
		return insert_dts;
	}

	public void setInsert_dts(java.util.Date insert_dts) {
		this.insert_dts = insert_dts;
	}

	public String getUpdate_id() {
		return update_id;
	}

	public void setUpdate_id(String update_id) {
		this.update_id = update_id;
	}

	public java.util.Date getUpdate_dts() {
		return update_dts;
	}

	public void setUpdate_dts(java.util.Date update_dts) {
		this.update_dts = update_dts;
	}

	@Override
	public String toString() {
		return "PAMODM01800_MODEL [company_cd=" + company_cd + ", emp_no=" + emp_no + ", kor_nm=" + kor_nm
				+ ", dept_cd=" + dept_cd + ", ogrp_cd=" + ogrp_cd + ", pstn_cd=" + pstn_cd + ", jnco_dt=" + jnco_dt
				+ ", mng_lp=" + mng_lp + ", mng_ep=" + mng_ep + ", start_dt=" + start_dt + ", end_dt=" + end_dt
				+ ", tm_cd_nm=" + tm_cd_nm + ", dof_tp=" + dof_tp + ", start_tm=" + start_tm + ", end_tm=" + end_tm
				+ ", dof_tm_cnt=" + dof_tm_cnt + ", lve_tm_cnt=" + lve_tm_cnt + ", insert_id=" + insert_id
				+ ", insert_dts=" + insert_dts + ", insert_ip=" + insert_ip + ", insert_mcaddr_nm=" + insert_mcaddr_nm
				+ ", update_id=" + update_id + ", update_dts=" + update_dts + ", update_ip=" + update_ip + "]";
	}
	
  
}
