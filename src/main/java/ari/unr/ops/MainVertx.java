package ari.unr.ops;

import java.util.HashMap;
import java.util.Map;

public class MainVertx {

    public static void main(String[] args) {
        Map<Integer, Double> distance = new HashMap<>();

        Map<Integer, String> identity = new HashMap<>();
        identity.put(0,"M1-M1");
        identity.put(0,"M1-R1");
        identity.put(0,"M1-L1");

        distance.put(0,0.0);
        distance.put(1,8.94);
        distance.put(2, 11.31);

        Double arr[][] = new Double[3][3];

        for(int i = 0;i<3; i++) {
            for(int j = 0;j<3; j++) {
                arr[i][j] = 0.0;
            }
        }
        int baseKey = 0;
        for(Integer key: distance.keySet()) {
            if(distance.get(key) == 0) {
                baseKey = key;
                break;
            }
        }

        for(Integer key: distance.keySet()) {
            arr[key][baseKey] = distance.get(key);
            arr[baseKey][key] = distance.get(key);
        }

        for(int i = 0;i<3; i++) {
            System.out.println();
            for(int j = 0;j<3; j++) {
                System.out.print("\t\t"+arr[i][j]);
            }
        }
    }
}