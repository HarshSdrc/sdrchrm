package org.sdrc.hrm.service;

import java.util.List;

import org.sdrc.hrm.model.CourseAnnouncementModel;
import org.sdrc.hrm.model.EmployeeModel;

/**
 * @author Subham Ashish (subham@sdrc.co.in)
 *	16-May-2017
 * 
 */

public interface FeedBackService {

	String courseAnnouncement(CourseAnnouncementModel courseAnnouncementModel);

	List<EmployeeModel> getDropDownList();


}
