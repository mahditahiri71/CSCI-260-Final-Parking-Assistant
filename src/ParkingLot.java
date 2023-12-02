import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class ParkingLot {
    LinkedList<ParkingSpot> spotsList;
    HashMap<Integer, ParkingSpot> spotMap;
    Stack<ParkingSpot> availableSpots;

    public ParkingLot() {
        spotsList = new LinkedList<>();
        spotMap = new HashMap<>();
        availableSpots = new Stack<>();

        // Initialize 10 parking spots
        for (int i = 1; i <= 10; i++) {
            ParkingSpot spot = new ParkingSpot(i);
            spotsList.add(spot);
            spotMap.put(i, spot);
            availableSpots.push(spot);
        }
    }

    // Method to assign a parking spot to a person
    public ParkingSpot assignParkingSpot() {
        if (!availableSpots.isEmpty()) {
            ParkingSpot assignedSpot = availableSpots.pop();
            assignedSpot.occupied = true;
            return assignedSpot;
        } else {
            System.out.println("No available parking spots.");
            return null;
        }
    }
}