package ari.unr.root.pojo;

import java.util.List;

public class ConnectedCordinate {

	public ConnectedCordinate() {
	}

	private String xCoordinate;
	private String yCoordinate;
	private List<Device> devices;
	private String operationType;
	private DeviceError deviceError;

	public String getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(String xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public String getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(String yCoordinate) {
		this.yCoordinate = yCoordinate;
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

}
