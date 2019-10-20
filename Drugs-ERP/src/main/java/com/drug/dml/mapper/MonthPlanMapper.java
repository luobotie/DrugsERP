package com.drug.dml.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.drug.dml.entity.DrugsMonthPlan;

@Repository
public interface MonthPlanMapper {
	
	@Select("select * from drugs_monthPlan limit #{pageSize},#{pageno}")
	List<DrugsMonthPlan> selectAllMonthPlan(@Param("pageno")Integer pageno,@Param("pageSize")Integer pageSize);
	
	@Select("select count(*) from drugs_monthPlan")
	Integer countAllMonthPlan();
}
