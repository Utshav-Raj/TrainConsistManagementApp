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

    public String getType() {
        return type;
    }

    public String getBogieId() {
        return bogieId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void displayDetails() {
        System.out.println("Bogie ID: " + bogieId +
                ", Type: " + type +
                ", Capacity: " + capacity);
    }
}

// UC9 Main Class
public class UC9TrainConsistMgmt {

    // Group bogies by type
    public static Map<String, List<PassengerBogie>> groupBogiesByType(List<PassengerBogie> bogies) {

        return bogies.stream()
                .collect(Collectors.groupingBy(PassengerBogie::getType));
    }

    public static void main(String[] args) {

        List<PassengerBogie> bogies = new ArrayList<>();

        bogies.add(new PassengerBogie("B1", "Sleeper", 72));
        bogies.add(new PassengerBogie("B2", "AC Chair", 60));
        bogies.add(new PassengerBogie("B3", "First Class", 45));
        bogies.add(new PassengerBogie("B4", "Sleeper", 80));
        bogies.add(new PassengerBogie("B5", "AC Chair", 65));

        Map<String, List<PassengerBogie>> grouped = groupBogiesByType(bogies);

        System.out.println("=== Grouped Bogies ===");

        for (String type : grouped.keySet()) {
            System.out.println("\nType: " + type);
            grouped.get(type).forEach(PassengerBogie::displayDetails);
        }
    }
}