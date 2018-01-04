package org.sdrc.hrm.controller;

import java.util.List;

import org.sdrc.hrm.model.CourseAnnouncementModel;
import org.sdrc.hrm.model.EmployeeModel;
import org.sdrc.hrm.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Subham Ashish (subham@sdrc.co.in) 16-May-2017
 */

@Controller
public class FeedBackController {

	@Autowired
	private FeedBackService leaveManagementService;

	@RequestMapping(value="courseAnnounce",method=RequestMethod.POST,consumes={ "multipart/form-data"})
	@ResponseBody
	public String courseAnnouncement(
			@RequestPart("model") CourseAnnouncementModel courseAnnouncementModel,
			@RequestPart("file") MultipartFile file) {
		
		courseAnnouncementModel.setFile(file);

		return leaveManagementService.courseAnnouncement(courseAnnouncementModel);
	}
	
	
	/**
	 * @return drop down value of employeeName
	 */
	@RequestMapping(value = "dropdown")
	@ResponseBody
	public List<EmployeeModel> dropDown(){
		return leaveManagementService.getDropDownList();
		
	}

}
