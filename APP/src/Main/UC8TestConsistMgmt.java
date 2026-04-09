import java.util.*;
import java.util.stream.Collectors;

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

    public String getBogieId() {
        return bogieId;
    }

    public String getType() {
        return type;
    }

    public void displayDetails() {
        System.out.println("Bogie ID: " + bogieId +
                ", Type: " + type +
                ", Capacity: " + capacity);
    }
}

// UC8 Main Class
class UC8TrainConsistMgmt {

    // Method to filter bogies using Stream API
    public static List<PassengerBogie> filterBogiesByCapacity(List<PassengerBogie> bogies, int threshold) {

        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    // Main method (Demo run)
    public static void main(String[] args) {

        List<PassengerBogie> bogies = new ArrayList<>();

        bogies.add(new PassengerBogie("B1", "Sleeper", 72));
        bogies.add(new PassengerBogie("B2", "AC Chair", 60));
        bogies.add(new PassengerBogie("B3", "First Class", 45));
        bogies.add(new PassengerBogie("B4", "Sleeper", 80));
        bogies.add(new PassengerBogie("B5", "AC Chair", 65));

        System.out.println("=== Original Bogies ===");
        bogies.forEach(PassengerBogie::displayDetails);

        List<PassengerBogie> filtered = filterBogiesByCapacity(bogies, 60);

        System.out.println("\n=== Filtered Bogies (Capacity > 60) ===");
        filtered.forEach(PassengerBogie::displayDetails);
    }
}