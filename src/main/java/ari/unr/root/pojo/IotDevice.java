package ari.unr.root.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IotDevice {

	private String xCoordinate;
	private String yCoordinate;
	private ConnectedCordinate connectedCordinate;
	private int hobCount;

	public IotDevice() {
	}

	public IotDevice(String deviceId, String xCoordinate, String yCoordinate, ConnectedCordinate connectedCordinate,
			int hobCount) {
		this.deviceId = deviceId;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.connectedCordinate = connectedCordinate;
		this.hobCount = hobCount;
	}

	private String deviceId;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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

	public ConnectedCordinate getConnectedCordinate() {
		return connectedCordinate;
	}

	public void setConnectedCordinate(ConnectedCordinate connectedCordinate) {
		this.connectedCordinate = connectedCordinate;
	}

	public int getHobCount() {
		return hobCount;
	}

	public void setHobCount(int hobCount) {
		this.hobCount = hobCount;
	}

}