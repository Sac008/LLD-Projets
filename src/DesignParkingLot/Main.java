package DesignParkingLot;

public class Main {

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setParkingStrategy(new ParkingStrategy0());
        parkingLot.setParkingStrategy(new ParkingStrategy1());
        System.out.println(parkingLot.park(4 , "UP47GH2001" , "tkt0123" , 1));
        System.out.println(parkingLot.getFreeSpotsCount(0 , 2));
    }
}
