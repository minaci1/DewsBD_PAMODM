package com.douzone.comet.service.hr.pamodm.dao;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.douzone.comet.jdbc.mybatis.DzMybatisSupport;
import com.douzone.comet.service.hr.pamodm.models.PAMODM01800_MODEL;

@Repository
public class PAMODM01800_DAO {

	private DzMybatisSupport mybatisSupport;

	@Autowired
	public PAMODM01800_DAO(DzMybatisSupport mybatisSupport) {
		this.mybatisSupport = mybatisSupport;
	}

	// 복수 데이터 목록 조회
	public List<PAMODM01800_MODEL> selectList_staff_list(HashMap<String, Object> parameters) throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".selectList_staff_list", parameters);
	}

	// 단일 데이터 목록 조회 (사원번호로 회사코드 추출하기)
	public String selectCompanyCd(String string) throws Exception {
		return this.mybatisSupport.selectOne(this.getClass().getName() + ".selectCompanyCd", string);
	}

	// 중복 데이터 조회
	public Integer selectPK(PAMODM01800_MODEL parameters) throws Exception {
		return this.mybatisSupport.selectOne(this.getClass().getName() + ".selectPK", parameters);
	}

	// 복수 데이터 입력 처리
	public void insertBatch(List<PAMODM01800_MODEL> parameters) throws Exception {
		this.mybatisSupport.insertBatch(this.getClass().getName() + ".insertBatch", parameters);
	} // 1건당 유효성 검사를 위해 insertBatch 대신 insert 로 변경

	// 복수 데이터 수정 처리
	public void updateBatch(List<PAMODM01800_MODEL> parameters) throws Exception {
		this.mybatisSupport.updateBatch(this.getClass().getName() + ".updateBatch", parameters);
	}

	// 복수 데이터 삭제 처리
	public void deleteBatch(List<PAMODM01800_MODEL> parameters) throws Exception {
		this.mybatisSupport.deleteBatch(this.getClass().getName() + ".deleteBatch", parameters);
	}

}
