package com.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.biz.UserBiz;
import com.entity.User;

@Controller
@RequestMapping("/user/*")
public class UserController {
	@Resource
	private UserBiz userbiz;
	@RequestMapping("reg.do")
	public String addUser(User user){
		try {
			userbiz.addUser(user);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
	@RequestMapping("login.do")
	public String login(User user,HttpServletRequest req){
		try {
			User u = userbiz.findUserByLogin(user);
			if(u==null)
				return "login";
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
	@ResponseBody
	@RequestMapping("findUsersBySex.do")
	public List<User> findUsersBySex(String sex){
		try {
			List<User> userList = userbiz.findUsersBySex(sex);
			return userList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("update.do")
	public String update(User user ,HttpServletRequest req,@RequestParam(value="file")MultipartFile file){
		try {
			String filename=file.getOriginalFilename();
			user.setImage(filename);
			String path=req.getRealPath("/images/"+filename);
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
			userbiz.updateUser(user);
			
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
	@RequestMapping("checkid.do")
	public void checkid(String idnumber,HttpServletResponse resp){
		try {
			
			User user = userbiz.findUserByIdnumber(idnumber);
			resp.setCharacterEncoding("utf-8");
			PrintWriter out =resp.getWriter();
			if(user==null)
				out.write("号码可用");
			else
				out.write("号码已经存在");
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public UserBiz getUserbiz() {
		return userbiz;
	}

	public void setUserbiz(UserBiz userbiz) {
		this.userbiz = userbiz;
	}
}
