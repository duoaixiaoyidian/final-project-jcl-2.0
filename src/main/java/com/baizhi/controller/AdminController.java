package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by M on 2018/8/28.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/add")
    public String addAdmin(Admin admin){
        adminService.addAdmin(admin);
        return "/main/main";
    }
    @RequestMapping("/login.do")
    @ResponseBody
    public ModelAndView login(String username,String password,String clientCode,HttpSession session ){
        ModelAndView mv = new ModelAndView();
		String serverCode = (String) session.getAttribute("serverCode");
		if(serverCode.equalsIgnoreCase(clientCode)){
            Admin admin = adminService.queryAdmin(username,password);
			if(username.equals(admin.getUsername()) && password.equals(password)){
				session.setAttribute("flag", "ok");
				mv.setViewName("redirect:/main/main.jsp");
				return mv;
			}else{
				mv.setViewName("redirect:/login.jsp");
				mv.addObject("errorMsg", "用户名或者密码有误");
				return mv;
			}
		}else{
			mv.setViewName("redirect:/login.jsp");
			mv.addObject("errorMsg", "验证码不对，请重新输入！~");
			return mv;
		}

    }
    @RequestMapping("/delete")
    public String delete(Admin admin){
        adminService.deleteAdmin(admin);
        return "/main/main";
    }
}
