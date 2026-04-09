import java.util.*;

// Passenger Bogie Class
class PassengerBogie {
    private String bogieId;
    private String type;
    private int capacity;

    public PassengerBogie(String bogieId, String type, int capacity) {
        this.bogieId = bogieId;
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    public String getBogieId() {
        return bogieId;
    }

    public void displayDetails() {
        System.out.println("Bogie ID: " + bogieId +
                ", Type: " + type +
                ", Capacity: " + capacity);
    }
}

// UC10 Main Class
public class UC10TrainConsistMgmt {

    // Method to calculate total seating capacity
    public static int calculateTotalSeats(List<PassengerBogie> bogies) {

        return bogies.stream()
                .map(b -> b.getCapacity())   // extract capacity
                .reduce(0, Integer::sum);   // aggregate (sum)
    }

    public static void main(String[] args) {

        List<PassengerBogie> bogies = new ArrayList<>();

        bogies.add(new PassengerBogie("B1", "Sleeper", 72));
        bogies.add(new PassengerBogie("B2", "AC Chair", 60));
        bogies.add(new PassengerBogie("B3", "First Class", 45));
        bogies.add(new PassengerBogie("B4", "Sleeper", 80));
        bogies.add(new PassengerBogie("B5", "AC Chair", 65));

        System.out.println("=== Bogies ===");
        bogies.forEach(PassengerBogie::displayDetails);

        int totalSeats = calculateTotalSeats(bogies);

        System.out.println("\nTotal Seating Capacity: " + totalSeats);
    }
}