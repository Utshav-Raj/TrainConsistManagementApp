import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC11TrainConsistMgmtTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(UC11TrainConsistMgmt.validateTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(UC11TrainConsistMgmt.validateTrainID("TRAIN12"));
        assertFalse(UC11TrainConsistMgmt.validateTrainID("TRN12A"));
        assertFalse(UC11TrainConsistMgmt.validateTrainID("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(UC11TrainConsistMgmt.validateCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(UC11TrainConsistMgmt.validateCargoCode("PET-ab"));
        assertFalse(UC11TrainConsistMgmt.validateCargoCode("PET123"));
        assertFalse(UC11TrainConsistMgmt.validateCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(UC11TrainConsistMgmt.validateTrainID("TRN-123"));
        assertFalse(UC11TrainConsistMgmt.validateTrainID("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(UC11TrainConsistMgmt.validateCargoCode("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(UC11TrainConsistMgmt.validateTrainID(""));
        assertFalse(UC11TrainConsistMgmt.validateCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(UC11TrainConsistMgmt.validateTrainID("TRN-1234XYZ"));
        assertFalse(UC11TrainConsistMgmt.validateCargoCode("PET-AB12"));
    }
}