package com.sample.mysite.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Value("${file.uploadFolder}")
	private String path;

	@RequestMapping(value= {"/index","/"})
	public String index() {
		
		return "blog/index";
	}
	
	@RequestMapping(value="/push")
	public String publish(@ModelAttribute("content")String content,@RequestParam("file")MultipartFile [] files, HttpServletRequest request) {
		
		 for (MultipartFile file:files
	             ) {

	            if (!file.isEmpty()){
	                //获得上传的目标位置

	                //目标文件的对象
	                String fileName = file.getOriginalFilename();
	                System.out.println(fileName);
	                File file1 = new File(path +"/" + fileName);
	                System.out.println(path);
	                //父级目录  不在  就创建一个
	                if (!file1.getParentFile().exists()){
	                    file1.mkdirs();
	                }

	                //数据库没有的文件  才上传
	                if (!file1.exists()){
	                    try {
							file.transferTo(file1);
						} catch (IllegalStateException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                    
	                }
	            }else {
	            	 System.out.println("文件为空"+path);
	            }
	        }
		 System.out.println(path);
		System.out.println(content);
		return "blog/index";
	}
}
