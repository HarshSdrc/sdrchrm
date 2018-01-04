package org.sdrc.hrm.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.sdrc.hrm.domain.CourseAnnouncement;
import org.sdrc.hrm.domain.EmployeeDetails;
import org.sdrc.hrm.domain.TypeDetail;
import org.sdrc.hrm.model.CourseAnnouncementModel;
import org.sdrc.hrm.model.EmployeeModel;
import org.sdrc.hrm.repository.CourseAnnouncementRepository;
import org.sdrc.hrm.repository.EmployeeRepository;
import org.sdrc.hrm.repository.TypeDetailRepository;
import org.sdrc.hrm.util.DomainToModelConverter;
import org.sdrc.hrm.util.FileSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Subham Ashish (subham@sdrc.co.in) 16-May-2017
 * 
 */

@Service
public class FeedBackServiceImpl implements FeedBackService {

	@Autowired
	private CourseAnnouncementRepository courseAnnouncementRepository;

	@Autowired
	private TypeDetailRepository typeDetailRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DomainToModelConverter domainToModelConverter;

	/* (non-Javadoc)
	 * @see org.sdrc.hrm.service.FeedBackService#courseAnnouncement(org.sdrc.hrm.model.CourseAnnouncementModel)
	 */
	@Override
	@Transactional
	public String courseAnnouncement(CourseAnnouncementModel courseAnnouncementModel) {

		SimpleDateFormat newFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyyMM");

		String courseName = courseAnnouncementModel.getCourseName();
		TypeDetail typeDetails = typeDetailRepository.findByName(courseName);

		try {

			String traineeName = courseAnnouncementModel.getTraineeName();
			EmployeeDetails employeeDetails = employeeRepository.findByemployeeNameAndIsLiveTrue(traineeName);

			CourseAnnouncement courseAnnouncement = new CourseAnnouncement();

			courseAnnouncement.setCourseCode(courseAnnouncementModel.getCourseCode());
			courseAnnouncement.setCourseName(typeDetails);
			courseAnnouncement.setEmail(courseAnnouncementModel.getEmail());
			courseAnnouncement.setStartDate(courseAnnouncementModel.getStartDate());
			courseAnnouncement.setEndDate(courseAnnouncementModel.getEndDate());
			courseAnnouncement.setFrom(courseAnnouncementModel.getFrom());
			courseAnnouncement.setTo(courseAnnouncementModel.getTo());
			courseAnnouncement.setTrainerName(employeeDetails);
			courseAnnouncement.setRemarks(courseAnnouncementModel.getRemarks());

			String reportPathDir = "D:/AndroidIMS/course Structure/"+ simpleFormat.format((new Date()));
			String reportFileName = "/courseStructure"+ newFormat.format(new Date()) + ".xlsx";

			String coursePath = FileSave.saveFile(courseAnnouncementModel.getFile().getBytes(), reportPathDir, reportFileName);

			courseAnnouncement.setCoursePath(coursePath);

			CourseAnnouncement courseAnnouncementSave = courseAnnouncementRepository.save(courseAnnouncement);

			if (courseAnnouncementSave != null) {
				// send mail to above mention email
				String emailMessage = sendMail(courseAnnouncementModel.getEmail());
				if(emailMessage.equals("successfull")){
					return "successfull";
				}else
					return "mail not sent";
			}

		} catch (IOException e) {
			
		}
		return "successfull";

	}

	private String sendMail(String email) {
		
		
		
		return null;
	}

	/* (non-Javadoc)
	 * @see org.sdrc.hrm.service.FeedBackService#getDropDownList()
	 */
	@Override
	@Transactional
	public List<EmployeeModel> getDropDownList(){

		//shows all employess whose islive is true
		
		List<EmployeeDetails> employeeDetailsList = employeeRepository.findByIsLiveTrue();
		List<EmployeeModel> employeeModelList = new ArrayList<EmployeeModel>();
		
		for(EmployeeDetails employeeDetails : employeeDetailsList){
			
		
			
			employeeModelList.add(domainToModelConverter.employeeDomainToModel(employeeDetails));
			
		}
		
		return employeeModelList;
	}


	
}
