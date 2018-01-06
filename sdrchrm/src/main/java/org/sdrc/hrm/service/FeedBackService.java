package org.sdrc.hrm.service;

import org.sdrc.hrm.model.CourseAnnouncementModel;
import org.sdrc.hrm.model.DropDown;
import org.sdrc.hrm.model.ReturnModel;

/**
 * @author Subham Ashish (subham@sdrc.co.in)
 *	16-May-2017
 * 
 */

public interface FeedBackService {

	ReturnModel courseAnnouncement(CourseAnnouncementModel courseAnnouncementModel);

	DropDown getDropDownList();

	ReturnModel courseEnrollment(String courseName, String courseCode,
			String traineeName);

	ReturnModel getDropDownEnrollment();



}
