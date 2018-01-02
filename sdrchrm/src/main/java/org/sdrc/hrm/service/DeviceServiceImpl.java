/**
 * 
 */
package org.sdrc.hrm.service;

import org.sdrc.hrm.domain.DeviceDetails;
import org.sdrc.hrm.domain.TypeDetail;
import org.sdrc.hrm.model.DeviceModel;
import org.sdrc.hrm.model.ReturnModel;
import org.sdrc.hrm.repository.DeviceDetailsRepository;
import org.sdrc.hrm.util.DomainToModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Harsh Pratyush
 *
 */
@Service
public class DeviceServiceImpl implements DeviceService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sdrc.hrm.service.DeviceService#addDevice(org.sdrc.hrm.model.DeviceModel
	 * )
	 */
	@Autowired
	private DeviceDetailsRepository deviceDetailsRepository;

	@Autowired
	private DomainToModelConverter domainToModelConverter;

	@Override
	public ReturnModel addDevice(DeviceModel deviceModel) {

		DeviceDetails deviceDetails = deviceDetailsRepository
				.findByBarCode(deviceModel.getBarCode());

		ReturnModel returnModel = new ReturnModel();

		if (deviceDetails != null) {
			deviceDetails.setDescription(deviceModel.getDescription());
			deviceDetails.setDeviceName(deviceModel.getDeviceName());
			TypeDetail deviceType = new TypeDetail();
			deviceType.setId(deviceModel.getDeviceTypeId());
			deviceDetails.setDeviceType(deviceType);
			deviceDetails.setCreatedBy(deviceDetails.getCreatedBy());
			deviceDetails.setBarCode(deviceModel.getBarCode());

			deviceDetailsRepository.save(deviceDetails);

			returnModel.setStatusCode(200);
			returnModel.setDescription("Success");
			returnModel.setMessage("Success");
			returnModel.setObject(domainToModelConverter
					.deviceDomainToModel(deviceDetails));
		}

		else {
			returnModel.setStatusCode(400);
			returnModel.setDescription("failure");
			returnModel.setMessage("failure");
		}
		return returnModel;
	}

}
