package ari.unr.ops;

import ari.unr.root.pojo.ConnectedCordinate;
import ari.unr.root.pojo.Device;
import ari.unr.root.pojo.IotDevice;
import ari.unr.root.pojo.ResponseIotDevice;

import java.util.*;

public class DeviceParser {

    public static List<ResponseIotDevice> addDistanceToEachDevice(List<IotDevice> iotDevices) {
    	List<ResponseIotDevice> responseIotDevice = null;
        TreeMap<String, Double> nameAndDistanceMapForEachDevice = null;
        NavigableMap<String, Double> nmap = null;
        Double matrix[][]=null;

        NavigableMap<String, Map<String, Double>> nmyMap = null;

        TreeMap<String, Map<String, Double>> myMap = new TreeMap<String, Map<String, Double>>();

        List<String> idList = new ArrayList<String>();

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

            for (IotDevice iotDevice : iotDevices) {
                nameAndDistanceMapForEachDevice = new TreeMap<String, Double>();
                if (null != iotDevice && !iotDevice.getConnectedCordinate().isEmpty()) {
                    for (ConnectedCordinate connectedIotDevice : iotDevice.getConnectedCordinate()) {

                        for (Device connectedIotDevices : connectedIotDevice.getDevices()) {
                            if (null != iotDevice.getxCoordinate() && null != iotDevice.getyCoordinate()
                                    && null != connectedIotDevices.getxCoordinate()
                                    && null != connectedIotDevices.getyCoordinate()) {

                                Double shortPath = ShortestPathAlgo.distanceBetweenTwoPoint(iotDevice.getxCoordinate(),
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
            List<String> keysInList = new ArrayList<String>(nmyMap.keySet());
            System.out.println(keysInList);
            for (Map.Entry<String, Map<String, Double>> entry : nmyMap.entrySet()) {
                idList.add(entry.getKey());
                xaxis++;
                yaxis = 0;
                Map<String, Double> entry3 = entry.getValue();
                /*for (Map.Entry<String, Double> entry2 : entry3.entrySet()) {
                    yaxis++;
                    matrix[xaxis - 1][yaxis - 1] = entry2.getValue();
                }*/
                for(int i=0;i<keysInList.size();i++){
                    yaxis++;
                    if(entry3.get(keysInList.get(i))!=null){
                        matrix[xaxis - 1][yaxis - 1] = entry3.get(keysInList.get(i));
                    }

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
        System.out.println(idList);
        ShortestPathAlgo.dijkstra(matrix, 0, idList);
        return responseIotDevice;
    }
}
