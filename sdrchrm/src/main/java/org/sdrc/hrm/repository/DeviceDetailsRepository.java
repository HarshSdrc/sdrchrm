/**
 * 
 */
package org.sdrc.hrm.repository;

import org.sdrc.hrm.domain.DeviceDetails;

/**
 * @author Harsh Pratyush(harsh@sdrc.co.in)
 *
 */
public interface DeviceDetailsRepository {

	DeviceDetails findByBarCode(String barCode);

}
