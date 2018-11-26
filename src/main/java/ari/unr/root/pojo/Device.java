package ari.unr.root.pojo;

public class Device {

	public Device() {
	}

	private String deviceName;
	private String deviceCount;
	private Double xCoordinate;
	private Double yCoordinate;
	private int hobCount;
	
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceCount() {
		return deviceCount;
	}

	public void setDeviceCount(String deviceCount) {
		this.deviceCount = deviceCount;
	}

	
	public int getHobCount() {
		return hobCount;
	}

	public void setHobCount(int hobCount) {
		this.hobCount = hobCount;
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
