package org.sdrc.hrm.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.sdrc.hrm.domain.CourseAnnouncement;
import org.sdrc.hrm.domain.EmployeeDetails;
import org.sdrc.hrm.domain.TypeDetail;
import org.sdrc.hrm.model.CourseAnnouncementModel;
import org.sdrc.hrm.model.DropDown;
import org.sdrc.hrm.model.EmployeeModel;
import org.sdrc.hrm.model.ReturnModel;
import org.sdrc.hrm.repository.CourseAnnouncementRepository;
import org.sdrc.hrm.repository.EmployeeRepository;
import org.sdrc.hrm.repository.TypeDetailRepository;
import org.sdrc.hrm.util.DomainToModelConverter;
import org.sdrc.hrm.util.FileSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
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
	
	@Autowired
	private ResourceBundleMessageSource messageSource;

	/* (non-Javadoc)
	 * @see org.sdrc.hrm.service.FeedBackService#courseAnnouncement(org.sdrc.hrm.model.CourseAnnouncementModel)
	 */
	@Override
	@Transactional
	public ReturnModel courseAnnouncement(CourseAnnouncementModel courseAnnouncementModel) {

		SimpleDateFormat newFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyyMM");

		ReturnModel returnModel = new ReturnModel();
		
		//TypeDetail typeDetails = typeDetailRepository.findById(courseAnnouncementModel.getCourseId());
		TypeDetail typeDetails = new TypeDetail(courseAnnouncementModel.getCourseId());
		EmployeeDetails employeeDetails = new EmployeeDetails(courseAnnouncementModel.getTrainerId());

		try {

			//String traineeName = courseAnnouncementModel.getTrainerName();
			
			//EmployeeDetails employeeDetails = employeeRepository.findByemployeeNameAndIsLiveTrue(traineeName);

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

			String reportPathDir = messageSource.getMessage("feedback.save.path", null, null)+"/course Structure/"+ simpleFormat.format((new Date()));
			String reportFileName = "/courseStructure"+ newFormat.format(new Date()) + ".xlsx";

			String coursePath = FileSave.saveFile(courseAnnouncementModel.getFile().getBytes(), reportPathDir, reportFileName);

			courseAnnouncement.setCoursePath(coursePath);

			CourseAnnouncement courseAnnouncementSave = courseAnnouncementRepository.save(courseAnnouncement);

			if (courseAnnouncementSave != null) {
				
				// send mail to above mention email
				String emailMessage = sendMail(courseAnnouncementModel,coursePath);
				
				if(emailMessage.equals("successfull")){
					
					returnModel.setStatusCode(200);
					returnModel.setMessage("succss");
					returnModel.setDescription("successfully saved in DB");
					returnModel.setObject(courseAnnouncementSave);
					return returnModel;
					
				}else{
					returnModel.setStatusCode(400);
					returnModel.setMessage("Not found");
					returnModel.setDescription("No data found");
					return returnModel;
				}
			}

		} catch (IOException e) {
			
			throw new RuntimeException();
		}
		return null;

	}

	
	//it send email to mention email id's
	private String sendMail(CourseAnnouncementModel courseAnnouncementModel, String coursePath) {
		
		try {
			
			String email = courseAnnouncementModel.getEmail();
		
			String[] recipientList = email.split(",");
			
			InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
			int counter = 0;
			for (String recipient : recipientList) {
    		
				recipientAddress[counter] = new InternetAddress(recipient.trim());
			
				counter++;
			}
			//message.setRecipients(Message.RecipientType.TO, recipientAddress);
		 
		
			final String userName = "sdrcims@gmail.com";
			final String password = "sdrc@ims2017";

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session ses = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
			});

			Message message = new MimeMessage(ses);

			message.setFrom(new InternetAddress("from-userName"));
			// message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
			message.setRecipients(Message.RecipientType.TO, recipientAddress);
			message.setSubject("Course Announcement");
			// message.setText("hello");

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Now set the actual message
			messageBodyPart.setText( "Dear All,\n\n This is to announce "
					+ "the beginning of the new course as "
					+ "part of the on going in-house training program.\n\n Tech-Training-JAVA \n\n -This course is not open for those "
					+ "who have already enrolled,in any of the currently ongoing courses.\n -if you are interested in enrolling for this course "
					+ "please mail me your intent.\n\n "
					+ "Details are given below : \n____________________________\n\n"
					+ " Course Name - Java \n Code - abc \n Trainer(s) - " + courseAnnouncementModel.getTrainerName()+"\n Start Date -"+courseAnnouncementModel.getStartDate()+ "\n End Date - "+courseAnnouncementModel.getEndDate()
					+ "\n Time :"+courseAnnouncementModel.getFrom()+"-"+ courseAnnouncementModel.getTo()+ "\n Duration :"+ "20Days" +"\n Location - SDRC \n Prep - "+courseAnnouncementModel.getRemarks()+ "\n PFA - Course Structure"
					+ "");

			// Create a multipar message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			String filename = coursePath;
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("course_structure");
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);

			Transport.send(message);
			
			return "successfull";
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} 
	}

	
	
	/* (non-Javadoc)
	 * @see org.sdrc.hrm.service.FeedBackService#getDropDownList()
	 */
	@Override
	@Transactional
	public DropDown getDropDownList(){

		//shows all employess whose islive is true
		DropDown dropDown = new DropDown();
		
		List<EmployeeDetails> employeeDetailsList = employeeRepository.findByIsLiveTrue();
		
		List<EmployeeModel> employeeModelList = new ArrayList<EmployeeModel>();
		
		if(!employeeDetailsList.isEmpty()){
			
		for(EmployeeDetails employeeDetails : employeeDetailsList){
			
			employeeModelList.add(domainToModelConverter.employeeDomainToModel(employeeDetails));
			
			}
		
		dropDown.setEmployeeModel(employeeModelList);
		dropDown.setStatus(200);
		String reportPathDir = messageSource.getMessage("feedback.save.path", null, null);
		return dropDown;
		
		}else{
			dropDown.setStatus(400);
			return dropDown;
		}
		
	}


	/* (non-Javadoc)
	 * @see org.sdrc.hrm.service.FeedBackService#courseEnrollment(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ReturnModel courseEnrollment(String courseName, String courseCode,
			String traineeName) {
		
		
		
		return null;
	}


	/* (non-Javadoc)
	 * @see org.sdrc.hrm.service.FeedBackService#getDropDownEnrollment()
	 * return courseCode,CourseName,TrainerName
	 */
	@Override
	public ReturnModel getDropDownEnrollment() {
		
		
		
		
		
		return null;
	}
	
}
