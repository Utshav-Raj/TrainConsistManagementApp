import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UC10TrainConsistMgmtTest {

    private List<PassengerBogie> createSampleBogies() {
        List<PassengerBogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("B1", "Sleeper", 72));
        bogies.add(new PassengerBogie("B2", "AC Chair", 60));
        bogies.add(new PassengerBogie("B3", "First Class", 45));
        bogies.add(new PassengerBogie("B4", "Sleeper", 80));
        return bogies;
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        int result = UC10TrainConsistMgmt.calculateTotalSeats(createSampleBogies());

        assertEquals(72 + 60 + 45 + 80, result);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        int result = UC10TrainConsistMgmt.calculateTotalSeats(createSampleBogies());

        assertTrue(result > 0);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<PassengerBogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("B1", "Sleeper", 72));

        int result = UC10TrainConsistMgmt.calculateTotalSeats(bogies);

        assertEquals(72, result);
    }

    @Test
    void testReduce_EmptyBogieList() {
        int result = UC10TrainConsistMgmt.calculateTotalSeats(new ArrayList<>());

        assertEquals(0, result);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        int result = UC10TrainConsistMgmt.calculateTotalSeats(createSampleBogies());

        assertEquals(257, result); // 72 + 60 + 45 + 80
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<PassengerBogie> bogies = createSampleBogies();

        int result = UC10TrainConsistMgmt.calculateTotalSeats(bogies);

        assertEquals(4, bogies.size()); // ensure all included
        assertEquals(257, result);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<PassengerBogie> original = createSampleBogies();
        List<PassengerBogie> copy = new ArrayList<>(original);

        UC10TrainConsistMgmt.calculateTotalSeats(original);

        assertEquals(copy.size(), original.size());
    }
}