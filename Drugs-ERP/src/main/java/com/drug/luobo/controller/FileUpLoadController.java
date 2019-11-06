package com.drug.luobo.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.drug.luobo.untils.AppFileUtils;
import com.drug.luobo.untils.RandomUtils;



@Controller
public class FileUpLoadController {
 
	/**
	 * 文件上传
	 * @param mf
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/upload.do")
	@ResponseBody
	public Map<String,Object> UploadContext(MultipartFile mf) throws IOException{
		System.out.println(mf);
		System.out.println(mf.getContentType());//文件的类型
		System.out.println(mf.getName());//表单的name属性值
		System.out.println(mf.getOriginalFilename());//文件名
		System.out.println(mf.getSize());//文件大小
		System.out.println(mf.getInputStream());//文件流
		//文件上传的父目录
		String parentPath=AppFileUtils.PATH;
		//得到当前日期作为文件名称
		String  dirName=RandomUtils.getCurrentDateForString();
		//构造文件夹对象
		File dirFile=new File(parentPath, dirName);
		if(!dirFile.exists()){
			dirFile.mkdirs();//创建文件夹
		}
		//得到文件夹原名
		String oldName=mf.getOriginalFilename();
		//根据文件原名得到姓名
		String newName=RandomUtils.createFileNameUseTime(oldName);
		File dest=new File(dirFile, newName);
		mf.transferTo(dest);
		
		Map<String,Object> map=new HashMap<>();
		 map.put("code", 0);
		 map.put("msg", "");
		 Map<String,Object> data=new HashMap<>();
		 data.put("url",dirName+"/"+newName);
		 data.put("src", "../downloadFile.do?path="+dirName+"/"+newName);
		 map.put("data", data);
		return map;
		
		
	}
	/**
	 * 下载的方法
	 */
	@RequestMapping("/downloadFile.do")
	@ResponseBody
	public ResponseEntity<Object> downloadFile(String path,HttpServletResponse response){
		return AppFileUtils.downloadFile(response, path, "");
	}
	/**
	 * 删除图片
	 */
	@RequestMapping("/deleteHeadImage.do")
	@ResponseBody
	public void deleteHeadImage(String headImage){
		String[] split = headImage.split("=");
		AppFileUtils.removeFileByPath(split[1]);
	}
    
}
