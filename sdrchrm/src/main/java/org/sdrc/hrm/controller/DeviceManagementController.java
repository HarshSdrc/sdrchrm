/**
 * 
 */
package org.sdrc.hrm.controller;

import org.sdrc.hrm.UserAuthenticationProvider;
import org.sdrc.hrm.model.DeviceModel;
import org.sdrc.hrm.model.ReturnModel;
import org.sdrc.hrm.model.UserDataModel;
import org.sdrc.hrm.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
@RestController
public class DeviceManagementController {
	
	@Autowired
	DeviceService deviceService;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private  UserAuthenticationProvider userAuthenticationProvider;
	
	@RequestMapping(value="/addDevice",method=RequestMethod.POST)
	public ReturnModel addDevice(@RequestBody UserDataModel userDataModel)
	{
		ReturnModel returnModel = new ReturnModel();
		try
		{
		UserDetails userDetails=userDetailsService.loadUserByUsername(userDataModel.getUserName());
		
		
		userAuthenticationProvider.additionalAuthenticationChecks(userDetails,new UsernamePasswordAuthenticationToken(userDataModel.getUserName(),userDataModel.getPassword(),userDetails.getAuthorities()));
	
		 Object userDetail = SecurityContextHolder.getContext().getAuthentication().getDetails();
	        
		 ObjectMapper objectMapper = new ObjectMapper();
		DeviceModel deviceModel= objectMapper.convertValue(userDataModel.getSubmissionObject(), DeviceModel.class);
		 
		 if (userDetail instanceof UserDetails  ) {
	        	
			 userDetails = (UserDetails) userDetail;
			 if(userDetails.getAuthorities()!=null&&userDetails.getAuthorities().contains((new SimpleGrantedAuthority("SysAdmin"))))
			 {
				 returnModel=deviceService.addDevice(deviceModel);
			 }
			 else
			 {
					returnModel.setDescription("Not Authorized");
					returnModel.setMessage("Not Authorized");
					returnModel.setStatusCode(400);
			 }
	        }
		 else
		 {
				returnModel.setDescription("Bad Data");
				returnModel.setMessage("Bad Data");
				returnModel.setStatusCode(400);
		 
			 
		 }
	        
		return returnModel;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnModel.setDescription("Authentication Failed");
			returnModel.setMessage("Please Login");
			returnModel.setStatusCode(400);
			return returnModel;
		}
		
	}

}
