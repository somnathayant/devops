package com.ayantsoft.springbootdeploy.springbootdeploy.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PingController {

	@GetMapping("/")
	public String pingMethod() {
		return "Server Running";
	}
	
	
	@GetMapping("/home")
	public ModelAndView displayJsp() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	
	@GetMapping("/free/expo1")//this is free resource need no user access
	public String openToAll() {
		return "Open to all";
	}
	
	@GetMapping("/user/resource")//this is free resource need no user access
	public String openToUserRole() {
		return "Open to User";
	}
	
    @GetMapping("/admin/resource")  //secure resource need user account
   //@PreAuthorize("hasAuthority('ADMIN')")  
    public String admin() {  

        return "admin";  

    }
    
    
    
    
    
	
}
