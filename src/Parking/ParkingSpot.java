package Parking;
public class ParkingSpot {
    int spotId;
    boolean occupied;

    public ParkingSpot(int spotId) {
        this.spotId = spotId; // 1-10
        this.occupied = false; // if occupied, true
    }
}