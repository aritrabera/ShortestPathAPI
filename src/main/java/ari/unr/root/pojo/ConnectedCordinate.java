package ari.unr.root.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectedCordinate {

	private Double yCoordinate;
	private Double xCoordinate;
	private List<Device> devices;
	private String operationType;
	private DeviceError deviceError;
	private Map<String, Double> nameAndDistanceMap = new HashMap<String, Double>();

	public ConnectedCordinate() {
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public DeviceError getDeviceError() {
		return deviceError;
	}

	public void setDeviceError(DeviceError deviceError) {
		this.deviceError = deviceError;
	}

	public Double getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(Double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public Double getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(Double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public Map<String, Double> getNameAndDistanceMap() {
		return nameAndDistanceMap;
	}

	public void setNameAndDistanceMap(Map<String, Double> nameAndDistanceMap) {
		this.nameAndDistanceMap = nameAndDistanceMap;
	}

}
