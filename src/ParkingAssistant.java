import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ParkingAssistant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of people: ");
        int numberOfPeople = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        Person[] personArray = new Person[numberOfPeople];

        // Loop to input ID and rank for each person
        for (int i = 0; i < numberOfPeople; i++) {
            System.out.println("Enter the person's name: ");
            String name = scanner.nextLine();

            System.out.print("Enter ID for " + name + ":");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            System.out.print("Enter rank for " + name + ". (Teacher: 1, Staff: 2, Student: 3): ");
            int rank = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            personArray[i] = new Person(id, rank, name);
        }

        // Bubble sort to sort the array by rank (1, 2, 3)
        for (int i = 0; i < numberOfPeople - 1; i++) {
            for (int j = 0; j < numberOfPeople - 1 - i; j++) {
                if (personArray[j].rank > personArray[j + 1].rank) {
                    // Swap Persons
                    Person tempPerson = personArray[j];
                    personArray[j] = personArray[j + 1];
                    personArray[j + 1] = tempPerson;
                }
            }
        }

        // Creating a queue to store the sorted information
        Queue<Person> queue = new LinkedList<>();

        // Enqueue the sorted information
        for (int i = 0; i < numberOfPeople; i++) {
            queue.offer(personArray[i]);
        }

        // Create a parking lot
        ParkingLot parkingLot = new ParkingLot();

        while (true) {
            System.out.print("Type 'Next on line' to print the next person, 'Check spot' to see if a spot is vacant, 'Print Queue' to print the queue, or 'Exit' to exit: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("Next on line")) {
                if (!queue.isEmpty()) {
                    Person nextPerson = queue.poll();
                    System.out.println("The next Person in line: Name - " + nextPerson.name + ", ID - " + nextPerson.id);

                    // Assign a parking spot
                    ParkingSpot assignedSpot = parkingLot.assignParkingSpot();
                    if (assignedSpot != null) {
                        System.out.println("Assigned Parking Spot: " + assignedSpot.spotId);
                    }
                } else {
                    System.out.println("Queue is empty. All people have been processed.");
                    break;
                }
            } else if (userInput.equalsIgnoreCase("Check spot")) {
                System.out.print("Enter the spot ID to check if it's vacant: ");
                int spotIdToCheck = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                ParkingSpot spotToCheck = parkingLot.spotMap.get(spotIdToCheck);
                if (spotToCheck != null) {
                    if (spotToCheck.occupied) {
                        System.out.println("Spot " + spotToCheck.spotId + " is occupied.");
                    } else {
                        System.out.println("Spot " + spotToCheck.spotId + " is vacant.");
                    }
                } else {
                    System.out.println("Invalid spot ID. Please enter a valid spot ID.");
                }
            } else if (userInput.equalsIgnoreCase("Print Queue")) {
                // Print the queue, get the person's name and prnt it on single line
                System.out.println("Printing the queue...");
                for (Person person : queue) {
                    System.out.print(person.name + ", ");
                }
                System.out.println();
            } else if (userInput.equalsIgnoreCase("Exit")) {
                System.out.println("Exiting the program.");
                break;
            } else {
                System.out.println("Invalid input. Please type 'Next on line', 'Check spot', or 'Exit'.");
            }
        }

        scanner.close();
    }
}