package DesignParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    int[][][] parkingLotArea = {{{4,4,2,2} , {2,4,2,0},{0,2,2,2},{4,4,4,0}}};

    List<ParkingStrategy> parkingStrategyList;
    Map<String , String> vehNum_ticketId;
    Map<String , String> ticketId_spotId;

    public ParkingLot() {
        parkingStrategyList = new ArrayList<>();
        this.vehNum_ticketId = new HashMap<>();
        this.ticketId_spotId = new HashMap<>();
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        parkingStrategyList.add(parkingStrategy);
    }

    public ParkingStrategy getParkingStrategy(int parkingStrategyId) {
        if(parkingStrategyList.size() >= parkingStrategyId)
            return parkingStrategyList.get(parkingStrategyId - 1);
        return null;
    }

    public String searchVehicleSpot(String query) {
        if(query.startsWith("tkt")) {
            if(ticketId_spotId.containsKey(query)) {
                return ticketId_spotId.get(query);
            }
            return "No place found for this ticket: " + query + " please check if you are searching at right place";
        }
        else {
            if(vehNum_ticketId.containsKey(query)) {
                return vehNum_ticketId.get(query);
            }
            return "No place found for this VehicleNumber: " + query + " please check if you are searching at right place";
        }
    }

    public String park(int vehicleType, String vehicleNumber, String ticketId, int parkingStrategy) {
        ParkingStrategy parkingStrategyObj = getParkingStrategy(parkingStrategy);
        vehNum_ticketId.put(vehicleNumber, ticketId);
        String spot_id =  parkingStrategyObj.park(vehicleType , vehicleNumber , ticketId , parkingStrategy , parkingLotArea);
        ticketId_spotId.put(vehicleNumber, spot_id);
        return spot_id;
    }


    public int getFreeSpotsCount(int floor , int vehicleType) {
        int freeSpotCount = 0;
        int[][] vehicles = parkingLotArea[floor];
        for (int[] vehicle : vehicles) {
            for (int i : vehicle) {
                if (i == vehicleType) {
                    freeSpotCount++;
                }
            }
        }
        return freeSpotCount;
    }

    public int removeVehicle(String spotId) {
        String[] parkingValues = spotId.split("-");
        int val = parkingLotArea[Integer.parseInt(parkingValues[0])][Integer.parseInt(parkingValues[1])][Integer.parseInt(parkingValues[2])];
        parkingLotArea[Integer.parseInt(parkingValues[0])][Integer.parseInt(parkingValues[1])][Integer.parseInt(parkingValues[2])] = val - 10;
        return getFreeSpotsCount(Integer.parseInt(parkingValues[0]) , val - 10);
    }


}
