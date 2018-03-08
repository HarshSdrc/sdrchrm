package org.sdrc.hrm.controller;

import org.sdrc.hrm.model.CourseAnnouncementModel;
import org.sdrc.hrm.model.DropDown;
import org.sdrc.hrm.model.ReturnModel;
import org.sdrc.hrm.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Subham Ashish (subham@sdrc.co.in) 16-May-2017
 */

@Controller
public class FeedBackController {

	@Autowired
	private FeedBackService feedbackService;

	@PostMapping(value = "courseAnnounce", consumes = { "multipart/form-data" })
	@ResponseBody
	public ReturnModel courseAnnouncement(
			@RequestPart("model") CourseAnnouncementModel courseAnnouncementModel,
			@RequestPart("file") MultipartFile file) {

		courseAnnouncementModel.setFile(file);

		return feedbackService.courseAnnouncement(courseAnnouncementModel);
	}

	/**
	 * @return drop down value of employeeName
	 * so it can choose trainerName
	 */
	@GetMapping(value = "dropDownEmp")
	@ResponseBody
	public DropDown dropDownEmloyeeName() {
		return feedbackService.getDropDownList();

	}

	
	/**
	 * @return drop down for enrollment, courseId, CourseName, TraineeName
	 */
	@GetMapping(value = "dropDownEnroll")
	@ResponseBody
	public ReturnModel dropDownEnrollment() {
		return feedbackService.getDropDownEnrollment();

	}

	
	/**
	 * @param courseName
	 * @param courseCode
	 * @param traineeName
	 * @return
	 */
	@ResponseBody
	@PostMapping(value = "courseEnroll")
	public ReturnModel courseEnrollment(
			@RequestParam("courseName") String courseName,
			@RequestParam("courseCode") String courseCode,
			@RequestParam("traineeName") String traineeName) {

		return feedbackService.courseEnrollment(courseName,courseCode,traineeName);

	}



}
