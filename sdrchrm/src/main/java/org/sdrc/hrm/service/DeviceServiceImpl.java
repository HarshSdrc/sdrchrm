/**
 * 
 */
package org.sdrc.hrm.service;

import org.sdrc.hrm.domain.DeviceDetails;
import org.sdrc.hrm.model.DeviceModel;
import org.sdrc.hrm.repository.DeviceDetailsRepository;

/**
 * @author Harsh Pratyush
 *
 */
@Service
public class DeviceServiceImpl implements DeviceService {

	/* (non-Javadoc)
	 * @see org.sdrc.hrm.service.DeviceService#addDevice(org.sdrc.hrm.model.DeviceModel)
	 */
	@Autowired
	private DeviceDetailsRepository deviceDetailsRepository;
	
	@Override
	public DeviceModel addDevice(DeviceModel deviceModel) {
		
		DeviceDetails deviceDetails=deviceDetailsRepository.findByBarCode(deviceModel.getBarCode());
		
		if(deviceDetails!=null)
		{
			
		}
		return null;
	}

}
