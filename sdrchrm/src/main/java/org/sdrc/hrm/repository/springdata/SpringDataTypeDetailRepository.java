/**
 * 
 */
package org.sdrc.hrm.repository.springdata;

import java.util.List;

import org.sdrc.hrm.domain.TypeDetail;
import org.sdrc.hrm.repository.TypeDetailRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
@RepositoryDefinition(domainClass = TypeDetail.class, idClass = Integer.class)
public interface SpringDataTypeDetailRepository extends TypeDetailRepository {

	@Override
	@Query(value = "select tp from TypeDetail tp where tp.description='Course' Order By tp.name asc")
	List<TypeDetail> findByDescriptionOrderByName();

}
