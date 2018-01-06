/**
 * 
 */
package org.sdrc.hrm.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

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
	 * @throws ParseException 
	 */
	public ReturnModel addDevice (DeviceModel deviceModel) throws ParseException;
	
	/**
	 *  This method will return list of all device grouped by device type
	 * @return Map<String,List<{@link DeviceModel}}>>
	 */
	public Map<String,List<DeviceModel>> getAllDevice();
	
	
	/**
	 * This method will find the device history for given device id.
	 * @param deviceId-Primary key of device details
	 * @return {@link ReturnModel}
	 */
	public ReturnModel getDeviceHistory(int deviceId);

	/**
	 * This method will return all the type of available devices.
	 * @param deviceId-Primary key of device details
	 * @return {@link ReturnModel}
	 */
	
	public ReturnModel getAllDeviceTypes();

}
