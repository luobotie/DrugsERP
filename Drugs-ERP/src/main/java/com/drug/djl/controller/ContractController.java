package com.drug.djl.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.djl.biz.ContractBiz;
import com.drug.djl.entity.BranchStoreInfo;
import com.drug.djl.entity.Contract;

import net.sf.ehcache.search.expression.And;

/**
 * 
 * 描述:合同管理的控制层
 * @author djl
 * 2019年10月28日下午4:43:29
 * version:1.0
 */
@RestController
public class ContractController {
	@Autowired
	private ContractBiz contractBiz;

	/**
	 * 
	 * 描述:分页查询合同
	 * @param page
	 * @param limit
	 * @return
	 * 2019年10月29日下午4:06:09
	 */
	@RequestMapping("getAllContract.do")
	public Map<String, Object> getAllContract(int page,int limit,String type,String state) {
		System.out.println(page+"\t"+limit);
		System.out.println("模糊查询："+type);
		System.out.println("模糊查询："+state);
		//分页查询的Map
		Map<String, Object> map = new HashMap<String, Object>();
		//总行数
		Map<String, Object> countmap = new HashMap<String, Object>();
		countmap.put("type", type);//模糊查询
		countmap.put("state", state);//模糊查询
		int counts=contractBiz.countContract(countmap);
		//为分页查询创建map
		Map<String, Object> branchPage=new HashMap<>();
		branchPage.put("page", (page-1)*limit);//当前页数-1*每页显示数量
		branchPage.put("limit", limit);//每页显示数
		branchPage.put("type", type);//模糊查询
		branchPage.put("state", state);//模糊查询
		List<Contract> contracts=contractBiz.getAllContract(branchPage);
		
		map.put("code", 0);
		map.put("count", counts);
		map.put("data", contracts);
		return map;
	}

	/**
	 * 
	 * 描述:添加合同
	 * @param contract
	 * @return
	 * 2019年10月29日下午4:07:07
	 */
	@RequestMapping("addContract.do")
	public int addContract(Contract contract) {
		//编号用时间格式化代替
		Date date = new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSS");
		String conNum=format.format(date);
		contract.setConNum(conNum);
		int row=contractBiz.addContract(contract);
		return row;
	}
	/**
	 * 
	 * 描述:失效合同
	 * @param id
	 * @return
	 * 2019年10月29日下午4:08:09
	 */
	@RequestMapping("lostContract.do")
	public int lostContract(Integer id){
		Map<String, Object> map=new HashMap<>();
		Date date = new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String lostTime=format.format(date);
		//失效时间
		map.put("lost", "失效");
		map.put("lostTime", lostTime);
		map.put("id", id);
		int row=contractBiz.lostContract(map);
		return row;
	}

	/**
	 * 
	 * 描述:永久删除合同
	 * @return
	 * 2019年10月30日上午10:55:12
	 */
	@RequestMapping("delContract.do")
	public int delContract(Integer id){
		int row=contractBiz.delContract(id);
		return row;
	}







	public static void main(String[] args) {
		int a=1;
		int b=2;
		if (a==1 && b!=2) {
			System.out.println(a);
		} else if (b==2 && a!=1) {
			System.out.println(b);
		} else if ( a==1 && b==2){
			System.out.println(a+b);
		}

		
		

	}
}
