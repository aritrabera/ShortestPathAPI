package ari.unr.root.pojo;

public class ConnectedCordinate {

	public ConnectedCordinate() {
	}

	private String xCoordinate;
	private String yCoordinate;
	private Device devices;
	private String operationType;
	private DeviceError deviceError;

	public Device getDevices() {
		return devices;
	}

	public void setDevices(Device devices) {
		this.devices = devices;
	}

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

}
