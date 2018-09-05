package com.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.biz.TestBiz;
import com.entity.User;
@Controller
public class TextController {
	@Resource
	private TestBiz testbiz;
@RequestMapping("test1.do")
public String test1(){
	System.out.println("这是第一个");
	testbiz.test();
	return "success";
}

@RequestMapping("reg.do")
public String reg(@RequestParam(value="file")MultipartFile file, User user,HttpServletRequest req){
	System.out.println("这是reg");
	try{
		
		String filename=file.getOriginalFilename();
		String path=req.getRealPath("/images/"+filename);
		System.out.println("name==="+filename);
		InputStream is=file.getInputStream();
		OutputStream os=new FileOutputStream(path);
		int size=-1;
		byte[] temp =new byte[1024];
		do{
			size=is.read(temp);
			if(size!=-1){
				os.write(temp, 0, size);
			}
		}while(size!=-1);
		os.flush();
		os.close();
		is.close();
		HttpSession session = req.getSession();
		testbiz.addUser(user);	
		session.setAttribute("user", user);
	}catch(Exception e){
		e.printStackTrace();
	}
	
	return "success";
}

public TestBiz getTestbiz() {
	return testbiz;
}
public void setTestbiz(TestBiz testbiz) {
	this.testbiz = testbiz;
}

}
