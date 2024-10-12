package DesignParkingLot;

public class ParkingStrategy1 implements ParkingStrategy {
    
    @Override
    public String park(int vehicleType, String vehicleNumber, String ticketId, int parkingStrategy , int[][][] parkingArea) {
        int minIndexFloorWithMaxFreeSpot = 0;
        int maxFreeSpots = 0;
        for(int k = 0; k < parkingArea.length; k++) {
            int count = 0;
            for(int i = 0; i < parkingArea[k].length; i++) {
                for(int j = 0; j < parkingArea[k][i].length; j++) {
                    if(parkingArea[k][i][j] == vehicleType) {
                        count++;
                    }
                }
            }
            if(count > maxFreeSpots) {
                maxFreeSpots = count;
                minIndexFloorWithMaxFreeSpot = k;
            }
        }
        int[][] parkingFloorArea = parkingArea[minIndexFloorWithMaxFreeSpot];
        for(int i = 0; i < parkingFloorArea.length; i++) {
            for(int j = 0; j < parkingFloorArea[i].length; j++) {
                if(parkingFloorArea[i][j] == vehicleType) {
                    parkingFloorArea[i][j] = vehicleType + 10;
                    return minIndexFloorWithMaxFreeSpot + "-" + i + "-" + j;
                }
            }
        }
        return "No free spot found for vehicle: " + vehicleNumber;
    }
}
