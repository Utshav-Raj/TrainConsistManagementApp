import java.util.HashSet;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // Step 1: Create HashSet for bogie IDs
        HashSet<String> bogieIds = new HashSet<>();

        // Step 2: Add bogie IDs (including duplicates intentionally)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        // Step 3: Display the bogie IDs
        System.out.println("Unique Bogie IDs in the Train:");
        System.out.println(bogieIds);
    }
}