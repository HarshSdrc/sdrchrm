/**
 * 
 */
package org.sdrc.hrm.repository.springdata;

import org.sdrc.hrm.domain.DeviceDetails;
import org.sdrc.hrm.repository.DeviceDetailsRepository;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * @author Harsh Pratyush
 *
 */

@RepositoryDefinition(domainClass=DeviceDetails.class,idClass=Integer.class)
public interface SpringDataDeviceDetailsRepository extends DeviceDetailsRepository{

}
