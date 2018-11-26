package ari.unr.workFlow;

import java.util.List;

import ari.unr.ops.DeviceParser;
import ari.unr.root.pojo.IotDevice;

public class ShortestPathWorkFlow {

	public ShortestPathWorkFlow() {
	}

	public List<IotDevice> getShortestPathForAllDevices(List<IotDevice> iotDeviceList) {

		List<IotDevice> iotDeviceListResults = DeviceParser.addDistanceToEachDevice(iotDeviceList);

		return iotDeviceListResults;

	}

	public List<IotDevice> getShortestPathForOneDevice(List<IotDevice> iotDeviceList) {

		List<IotDevice> iotDeviceListResults = DeviceParser.addDistanceToEachDevice(iotDeviceList);

		return iotDeviceListResults;
	}

}
