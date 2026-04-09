import java.util.*;

// Goods Bogie Class
class GoodsBogie {
    private String bogieId;
    private String type;   // Cylindrical, Open, Box
    private String cargo;  // Petroleum, Coal, Grain, etc.

    public GoodsBogie(String bogieId, String type, String cargo) {
        this.bogieId = bogieId;
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    public String getBogieId() {
        return bogieId;
    }

    public void displayDetails() {
        System.out.println("Bogie ID: " + bogieId +
                ", Type: " + type +
                ", Cargo: " + cargo);
    }
}

// UC12 Main Class
public class UC12TrainConsistMgmt {

    // Safety validation method
    public static boolean isTrainSafe(List<GoodsBogie> bogies) {

        return bogies.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical") ||
                                b.getCargo().equalsIgnoreCase("Petroleum")
                );
    }

    public static void main(String[] args) {

        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("G1", "Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("G2", "Open", "Coal"));
        bogies.add(new GoodsBogie("G3", "Box", "Grain"));

        boolean isSafe = isTrainSafe(bogies);

        System.out.println("=== Goods Bogies ===");
        bogies.forEach(GoodsBogie::displayDetails);

        System.out.println("\nSafety Status: " +
                (isSafe ? "SAFE ✅" : "UNSAFE ❌"));
    }
}