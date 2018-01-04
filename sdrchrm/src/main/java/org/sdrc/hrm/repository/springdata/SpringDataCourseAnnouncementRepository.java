package org.sdrc.hrm.repository.springdata;

import org.sdrc.hrm.domain.CourseAnnouncement;
import org.sdrc.hrm.repository.CourseAnnouncementRepository;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * @author Subham Ashish (subham@sdrc.co.in)
 *	16-May-2017
 * 
 */

@RepositoryDefinition(domainClass = CourseAnnouncement.class, idClass = Integer.class)
public interface SpringDataCourseAnnouncementRepository extends
		CourseAnnouncementRepository {

}
