package DesignParkingLot;

public interface ParkingStrategy {

    public String park(int vehicleType , String vehicleNumber , String ticketId , int parkingStrategy , int[][][] parkingArea);
}
