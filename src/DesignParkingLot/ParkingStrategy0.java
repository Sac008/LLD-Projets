package DesignParkingLot;

public class ParkingStrategy0 implements ParkingStrategy {

    @Override
    public String park(int vehicleType, String vehicleNumber, String ticketId, int parkingStrategy , int[][][] parkingArea) {
        for(int k = 0; k < parkingArea.length; k++) {
            for(int i = 0; i < parkingArea[k].length; i++) {
                for(int j = 0; j < parkingArea[k][i].length; j++) {
                    if(parkingArea[k][i][j] == vehicleType) {
                        parkingArea[k][i][j] = vehicleType + 10;
                        return k + "-" + i + "-" + j;
                    }
                }
            }
        }
        return "No free spot found for vehicle: " + vehicleNumber;
    }
}
