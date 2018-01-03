/**
 * 
 */
package org.sdrc.hrm.repository.springdata;

import org.sdrc.hrm.domain.TypeDetail;
import org.sdrc.hrm.repository.TypeDetailRepository;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
@RepositoryDefinition(domainClass=TypeDetail.class,idClass=Integer.class)
public interface SpringDataTypeDetailRepository extends TypeDetailRepository {

}
