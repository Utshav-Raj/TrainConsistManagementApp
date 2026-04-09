import java.util.regex.*;

// UC11 Main Class
public class UC11TrainConsistMgmt {

    // Validate Train ID (TRN-1234)
    public static boolean validateTrainID(String trainId) {
        String pattern = "TRN-\\d{4}";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(trainId);
        return m.matches();
    }

    // Validate Cargo Code (PET-AB)
    public static boolean validateCargoCode(String cargoCode) {
        String pattern = "PET-[A-Z]{2}";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(cargoCode);
        return m.matches();
    }

    public static void main(String[] args) {

        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        System.out.println("Train ID: " + trainId + " -> " +
                (validateTrainID(trainId) ? "Valid" : "Invalid"));

        System.out.println("Cargo Code: " + cargoCode + " -> " +
                (validateCargoCode(cargoCode) ? "Valid" : "Invalid"));
    }
}