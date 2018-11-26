package ari.unr.root.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IotDevice {

	private Double xCoordinate;
	private Double yCoordinate;
	private List<ConnectedCordinate> connectedCordinate;
	private int hobCount;
	private String operationType;
	private Device devices;
	private String shoptestPath;
	private String deviceID;

	public IotDevice() {
	}

	public IotDevice(String deviceId, Double xCoordinate, Double yCoordinate,
			List<ConnectedCordinate> connectedCordinate, int hobCount, String operationType, Device devices,
			String deviceID) {
		this.deviceId = deviceId;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.connectedCordinate = connectedCordinate;
		this.hobCount = hobCount;
		this.operationType = operationType;
		this.devices = devices;
		this.deviceID = deviceID;
	}

	private String deviceId;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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

	public Device getDevices() {
		return devices;
	}

	public void setDevices(Device devices) {
		this.devices = devices;
	}

	public String getShoptestPath() {
		return shoptestPath;
	}

	public void setShoptestPath(String shoptestPath) {
		this.shoptestPath = shoptestPath;
	}

	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
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

	

}