package ari.unr.ops;

import ari.unr.root.pojo.ConnectedCordinate;
import ari.unr.root.pojo.Device;
import ari.unr.root.pojo.IotDevice;

import java.util.*;

public class DeviceParser {

    public static List<IotDevice> addDistanceToEachDevice(List<IotDevice> iotDevices) {
        TreeMap<String, Double> nameAndDistanceMapForEachDevice = null;
        NavigableMap<String, Double> nmap = null;
        Double matrix[][]=null;

        NavigableMap<String, Map<String, Double>> nmyMap = null;
        //using treeMap to sort the IOT objects names 
        TreeMap<String, Map<String, Double>> myMap = new TreeMap<String, Map<String, Double>>();

        int deviceCount = 0;
        int xaxis = 0;
        int yaxis = 0;

        if (!iotDevices.isEmpty() && iotDevices != null) {
            deviceCount = iotDevices.size();

            matrix = new Double[deviceCount][deviceCount];

            for (int i = 0; i < deviceCount; i++) {
                for (int j = 0; j < deviceCount; j++) {
                    matrix[i][j] = 0.0;
                }
            }
//
            for (IotDevice iotDevice : iotDevices) {
                nameAndDistanceMapForEachDevice = new TreeMap<String, Double>();
                if (null != iotDevice && !iotDevice.getConnectedCordinate().isEmpty()) {
                    for (ConnectedCordinate connectedIotDevice : iotDevice.getConnectedCordinate()) {

                        for (Device connectedIotDevices : connectedIotDevice.getDevices()) {
                            if (null != iotDevice.getxCoordinate() && null != iotDevice.getyCoordinate()
                                    && null != connectedIotDevices.getxCoordinate()
                                    && null != connectedIotDevices.getyCoordinate()) {

                                Double shortPath = TestAlgos.distanceBetweenTwoPoint(iotDevice.getxCoordinate(),
                                        iotDevice.getyCoordinate(), connectedIotDevices.getxCoordinate(),
                                        connectedIotDevices.getyCoordinate());
                                nameAndDistanceMapForEachDevice.put(connectedIotDevices.getDeviceName(), shortPath);
                            }
                        }
                        nmap = nameAndDistanceMapForEachDevice.descendingMap();
                        connectedIotDevice.setNameAndDistanceMap(nmap);
                    }
                }
                myMap.put(iotDevice.getDeviceId(), nmap);
            }
            nmyMap = myMap.descendingMap();
            for (Map.Entry<String, Map<String, Double>> entry : nmyMap.entrySet()) {
                xaxis++;
                yaxis = 0;
                Map<String, Double> entry3 = entry.getValue();
                for (Map.Entry<String, Double> entry2 : entry3.entrySet()) {
                    yaxis++;
                    matrix[xaxis - 1][yaxis - 1] = entry2.getValue();
                }
            }
        }
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i = 0;i<row; i++) {

            for(int j = 0;j<col; j++) {
                System.out.print("\t"+matrix[i][j]+" ");
            }
            System.out.println();
        }
        TestAlgos.dijkstra(matrix, 0);
        return iotDevices;
    }
}
