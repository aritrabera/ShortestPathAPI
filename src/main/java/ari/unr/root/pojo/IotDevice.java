package ari.unr.root.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IotDevice {

	private String xCoordinate;
	private String yCoordinate;
	private List<ConnectedCordinate> connectedCordinate;
	private int hobCount;
	private String operationType;

	public IotDevice() {
	}

	public IotDevice(String deviceId, String xCoordinate, String yCoordinate,
			List<ConnectedCordinate> connectedCordinate, int hobCount, String operationType) {
		this.deviceId = deviceId;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.connectedCordinate = connectedCordinate;
		this.hobCount = hobCount;
		this.operationType = operationType;
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

	public int getHobCount() {
		return hobCount;
	}

	public void setHobCount(int hobCount) {
		this.hobCount = hobCount;
	}

	public List<ConnectedCordinate> getConnectedCordinate() {
		return connectedCordinate;
	}

	public void setConnectedCordinate(List<ConnectedCordinate> connectedCordinate) {
		this.connectedCordinate = connectedCordinate;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

}