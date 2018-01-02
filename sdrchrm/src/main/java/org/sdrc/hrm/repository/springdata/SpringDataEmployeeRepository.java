/**
 * 
 */
package org.sdrc.hrm.repository.springdata;

import org.sdrc.hrm.domain.EmployeeDetails;
import org.sdrc.hrm.repository.EmployeeRepository;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */

@RepositoryDefinition(domainClass=EmployeeDetails.class,idClass=Integer.class)
public interface SpringDataEmployeeRepository extends EmployeeRepository {

}
