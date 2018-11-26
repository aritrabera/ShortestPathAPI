package ari.unr.ops;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ari.unr.root.pojo.ConnectedCordinate;
import ari.unr.root.pojo.Device;
import ari.unr.root.pojo.IotDevice;

public class DeviceParser {

	public void addDistanceToEachDevice(List<IotDevice> iotDevices) {
		Map<String, Double> nameAndDistanceMapForEachDevice = null;

		for (IotDevice iotDevice : iotDevices) {
			nameAndDistanceMapForEachDevice = new HashMap<String, Double>();
			if (null != iotDevice && !iotDevice.getConnectedCordinate().isEmpty()) {
				for (ConnectedCordinate connectedIotDevice : iotDevice.getConnectedCordinate()) {
					for (Device connectedIotDevices : connectedIotDevice.getDevices()) {
						if (null != iotDevice.getxCoordinate() && null != iotDevice.getyCoordinate()
								&& null != connectedIotDevices.getxCoordinate()
								&& null != connectedIotDevices.getyCoordinate()) {

							Double shortPath = TestAlgo.distanceBetweenTwoPoint(iotDevice.getxCoordinate(),
									iotDevice.getyCoordinate(), connectedIotDevices.getxCoordinate(),
									connectedIotDevices.getyCoordinate());
							nameAndDistanceMapForEachDevice.put(connectedIotDevices.getDeviceName(), shortPath);

						}
					}
				}
			}
		}

	}
}
