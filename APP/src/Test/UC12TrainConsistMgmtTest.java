import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UC12TrainConsistMgmtTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("G1", "Cylindrical", "Petroleum"),
                new GoodsBogie("G2", "Open", "Coal")
        );

        assertTrue(UC12TrainConsistMgmt.isTrainSafe(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("G1", "Cylindrical", "Coal")
        );

        assertFalse(UC12TrainConsistMgmt.isTrainSafe(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("G1", "Open", "Coal"),
                new GoodsBogie("G2", "Box", "Grain")
        );

        assertTrue(UC12TrainConsistMgmt.isTrainSafe(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("G1", "Cylindrical", "Petroleum"),
                new GoodsBogie("G2", "Cylindrical", "Coal") // invalid
        );

        assertFalse(UC12TrainConsistMgmt.isTrainSafe(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> bogies = new ArrayList<>();

        assertTrue(UC12TrainConsistMgmt.isTrainSafe(bogies));
    }
}