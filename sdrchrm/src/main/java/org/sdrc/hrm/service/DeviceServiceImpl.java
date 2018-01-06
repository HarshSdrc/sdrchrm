/**
 * 
 */
package org.sdrc.hrm.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.sdrc.hrm.domain.DeviceDetails;
import org.sdrc.hrm.domain.EmployeeDeviceMapping;
import org.sdrc.hrm.domain.TypeDetail;
import org.sdrc.hrm.model.DeviceModel;
import org.sdrc.hrm.model.EmployeeDeviceMappingModel;
import org.sdrc.hrm.model.ReturnModel;
import org.sdrc.hrm.model.TypeDetailModel;
import org.sdrc.hrm.repository.DeviceDetailsRepository;
import org.sdrc.hrm.repository.TypeDetailRepository;
import org.sdrc.hrm.util.DomainToModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
	
	@Autowired
	private TypeDetailRepository typeDetailRepository;
	
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	private final SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");


	@Override
	public ReturnModel addDevice(DeviceModel deviceModel) throws ParseException {

		DeviceDetails deviceDetails = deviceDetailsRepository
				.findByBarCode(deviceModel.getBarCode());

		ReturnModel returnModel = new ReturnModel();

		if (deviceDetails == null) {
			DeviceDetails device= deviceDetailsRepository.findTop1ByOrderByCreatedDateDesc();
			deviceDetails=new DeviceDetails();
			deviceDetails.setDescription(deviceModel.getDescription());
			deviceDetails.setDeviceName(deviceModel.getDeviceName());
			deviceDetails.setCreatedBy(((UserDetails)SecurityContextHolder.getContext().getAuthentication().getDetails()).getUsername());
			deviceDetails.setMacAdress(deviceModel.getMacAdress());
			deviceDetails.setModel(deviceModel.getModel());
			deviceDetails.setFirmWare(deviceModel.getFirmWare());
			deviceDetails.setFirmwareVersion(deviceModel.getFirmwareVersion());
			deviceDetails.setPurchaseDate(new Date(sdf.parse(deviceModel.getPurchaseDate()).getTime()));
			deviceDetails.setSerialNo(deviceModel.getSerialNo());
			
			if(device==null)
			{
				deviceDetails.setDeviceCode("sdrc/device/001");
			}
			else
			{
				int deviceNumb=1+Integer.parseInt(device.getDeviceCode().split("sdrc/device/")[1]);
				if(deviceNumb>=100)
				{
					deviceDetails.setDeviceCode("sdrc/device/"+deviceNumb);
				}
				else
				{
					deviceDetails.setDeviceCode("sdrc/device/"+	String.format("%03d",deviceNumb));
				}	
			
				
			}
			
			TypeDetail deviceType = new TypeDetail();
			deviceType.setId(deviceModel.getDeviceTypeId());
			deviceDetails.setDeviceType(deviceType);
			deviceDetails.setBarCode(deviceModel.getBarCode());
			DeviceDetails deviceSaved=deviceDetailsRepository.save(deviceDetails);

			returnModel.setStatusCode(200);
			returnModel.setDescription("Success");
			returnModel.setMessage("Success");
			returnModel.setObject(domainToModelConverter
					.deviceDomainToModel(deviceSaved));
		}

		else {
			returnModel.setStatusCode(400);
			returnModel.setDescription("failure");
			returnModel.setMessage("failure");
		}
		return returnModel;
	}

	@Override
	public Map<String, List<DeviceModel>> getAllDevice() {
		
		Map<String, List<DeviceModel>> deviceModelListMap = new LinkedHashMap<String, List<DeviceModel>>();
		
		List<DeviceModel> deviceModels = new ArrayList<DeviceModel>();
		
		List<DeviceDetails> deviceDetailsList=deviceDetailsRepository.findAll();
		
		for(DeviceDetails deviceDetails:deviceDetailsList)
		{
			if(deviceModelListMap.containsKey(deviceDetails.getDeviceType().getName()))
			{
				deviceModelListMap.get(deviceDetails.getDeviceType().getName()).add(domainToModelConverter.deviceDomainToModel(deviceDetails));
			}
			else
			{
				deviceModels = new ArrayList<DeviceModel>();
				deviceModels.add(domainToModelConverter.deviceDomainToModel(deviceDetails));
				deviceModelListMap.put(deviceDetails.getDeviceType().getName(), deviceModels);
			}
			
		}
		
		return deviceModelListMap;
	}
	
	@Override
	public ReturnModel getDeviceHistory(int deviceId)
	{
		DeviceDetails deviceDetails = deviceDetailsRepository.findByDeviceId(deviceId);
		ReturnModel returnModel = new ReturnModel();
		if(deviceDetails!=null)
		{
		DeviceModel deviceModel = domainToModelConverter.deviceDomainToModel(deviceDetails);
		List<EmployeeDeviceMappingModel> employeeDeviceMappingModels=new ArrayList<EmployeeDeviceMappingModel>();
		
		for(EmployeeDeviceMapping deviceMapping:deviceDetails.getEmployeeDeviceMapping())
		{
			employeeDeviceMappingModels.add(domainToModelConverter.employeeDeviceMappintToModel(deviceMapping));
		}
		
		returnModel.setStatusCode(200);
		Map<String,Object> deviceHistory = new  HashMap<String, Object>();
		deviceHistory.put("deviceDetail", deviceModel);
		deviceHistory.put("deviceHistory", employeeDeviceMappingModels);
		returnModel.setObject(deviceHistory);
			
		}
		else
		{
			returnModel.setDescription("Please register this device");
			returnModel.setMessage("Sorry Can't find the device");
			returnModel.setStatusCode(400);
		}
		
		return returnModel;
	}

	@Override
	public ReturnModel getAllDeviceTypes() {
		int deviceTypeId= Integer.parseInt(messageSource.getMessage("typeId.device", null,null));
		List<TypeDetail> typeDetails =typeDetailRepository.findByTypeIdId(deviceTypeId);
		List<TypeDetailModel> typeDetailModels = new ArrayList<TypeDetailModel>();
		ReturnModel returnModel = new ReturnModel();
		for(TypeDetail typeDetail:typeDetails)
		{
			typeDetailModels.add(domainToModelConverter.typeDetailToModel(typeDetail));
		}
		returnModel.setObject(typeDetailModels);
		returnModel.setStatusCode(200);
		// TODO Auto-generated method stub
		return returnModel;
	}

}
