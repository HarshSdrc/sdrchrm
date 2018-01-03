/**
 * 
 */
package org.sdrc.hrm.service;

import org.sdrc.hrm.model.DeviceModel;
import org.sdrc.hrm.model.ReturnModel;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
public interface DeviceService {
	
	/**
	 * This method will add a new device to database
	 * @param deviceModel {@link DeviceModel}
	 * @return {@link ReturnModel}
	 */
	public ReturnModel addDevice (DeviceModel deviceModel);

}
