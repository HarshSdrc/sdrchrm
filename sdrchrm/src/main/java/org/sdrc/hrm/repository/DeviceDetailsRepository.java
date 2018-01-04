/**
 * 
 */
package org.sdrc.hrm.repository;

import java.util.List;

import org.sdrc.hrm.domain.DeviceDetails;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Harsh Pratyush(harsh@sdrc.co.in)
 *
 */
public interface DeviceDetailsRepository {

	DeviceDetails findByBarCode(String barCode);

	@Transactional
	DeviceDetails save(DeviceDetails deviceDetails);

	DeviceDetails findTop1ByDeviceTypeIdOrderByCreatedDateDesc(int deviceTypeId);

	List<DeviceDetails> findAll();

	DeviceDetails findTop1ByOrderByCreatedDateDesc();

	DeviceDetails findByDeviceId(int deviceId);

}
