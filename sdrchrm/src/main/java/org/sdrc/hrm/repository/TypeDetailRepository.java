/**
 * 
 */
package org.sdrc.hrm.repository;

import java.util.List;

import org.sdrc.hrm.domain.TypeDetail;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
public interface TypeDetailRepository {

	TypeDetail findById(int deviceTypeId);

	TypeDetail findByName(String courseName);

	List<TypeDetail> findByTypeIdId(int typeId);

}
