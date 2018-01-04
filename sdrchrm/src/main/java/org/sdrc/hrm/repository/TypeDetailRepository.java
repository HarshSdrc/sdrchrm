/**
 * 
 */
package org.sdrc.hrm.repository;

import org.sdrc.hrm.domain.TypeDetail;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
public interface TypeDetailRepository {

	TypeDetail findById(int deviceTypeId);

	TypeDetail findByName(String courseName);

}
