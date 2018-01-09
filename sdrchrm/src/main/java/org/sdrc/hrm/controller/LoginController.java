package org.sdrc.hrm.controller;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sdrc.hrm.UserAuthenticationProvider;
import org.sdrc.hrm.model.ReturnModel;
import org.sdrc.hrm.model.UserDataModel;
import org.sdrc.hrm.model.UserDetailsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LoginController {
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private  UserAuthenticationProvider userAuthenticationProvider;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ReturnModel login(@RequestBody UserDataModel userDataModel,HttpServletResponse response,HttpServletRequest request)
	{
		ReturnModel returnModel=new ReturnModel();
		try
		{
//			System.out.println("Before Login");
//			
//			for(String header :response.getHeaderNames())
//			{
//				System.out.println("Header : "+ header +" value : "+response.getHeader(header));
//			}
//			
//			Enumeration enums=request.getHeaderNames();
//			while(enums.hasMoreElements())
//			{
//				System.out.println("Headers : "+ enums.nextElement() +" value : "+request.getHeader(enums.nextElement().toString()));
//			}
			
			
		UserDetails userDetails=userDetailsService.loadUserByUsername(userDataModel.getUserName());
		
		
		userAuthenticationProvider.additionalAuthenticationChecks(userDetails,new UsernamePasswordAuthenticationToken(userDataModel.getUserName(),userDataModel.getPassword(),userDetails.getAuthorities()));
	
		 UserDetails userDetail = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
		 UserDetailsModel userDetailModel = new  UserDetailsModel();
		 userDetailModel.setPassword(userDetail.getPassword());
		 userDetailModel.setUserName(userDetail.getPassword());
		 Set<String> authorities=new HashSet<String>();
		 for(GrantedAuthority  authority:userDetails.getAuthorities())	
		 {
			 authorities.add(authority.getAuthority());
		 }
		 userDetailModel.setGrantedAuthorithies(authorities);
		 returnModel.setDescription("");
		 returnModel.setStatusCode(200);
		returnModel.setObject(userDetailModel);
		
//		System.out.println("After Login");
//		
//		for(String header :response.getHeaderNames())
//		{
//			System.out.println("Header : "+ header +" value : "+response.getHeader(header));
//		}
//		
//		 enums=request.getHeaderNames();
//		while(enums.hasMoreElements())
//		{
//			System.out.println("Headers : "+ enums.nextElement() +" value : "+request.getHeader(enums.nextElement().toString()));
//		}
		
		}
		
		catch (Exception e)
		{
			returnModel.setMessage("Login Failure");
			 returnModel.setDescription("Username/password inncorect");
			 returnModel.setStatusCode(415);
			 
		}
		 return returnModel;
	}
	
	

}
