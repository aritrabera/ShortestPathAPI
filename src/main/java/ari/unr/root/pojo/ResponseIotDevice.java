package ari.unr.root.pojo;

import java.util.List;

public class ResponseIotDevice {

    public ResponseIotDevice() {

    }

    private String startVertex;

    private String endVertex;

    public String getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(String startVertex) {
        this.startVertex = startVertex;
    }

    public String getEndVertex() {
        return endVertex;
    }

    public void setEndVertex(String endVertex) {
        this.endVertex = endVertex;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    public Integer getHobCount() {
        return hobCount;
    }

    public void setHobCount(Integer hobCount) {
        this.hobCount = hobCount;
    }

    public DeviceError getDeviceError() {
        return deviceError;
    }

    public void setDeviceError(DeviceError deviceError) {
        this.deviceError = deviceError;
    }

    private Double distance;
    private List<String> path;
    private Integer hobCount;
    private DeviceError deviceError;

}