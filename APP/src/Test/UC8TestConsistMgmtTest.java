import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

 class UC8TrainConsistMgmtTest {

    private List<PassengerBogie> createSampleBogies() {
        List<PassengerBogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("B1", "Sleeper", 72));
        bogies.add(new PassengerBogie("B2", "AC Chair", 70));
        bogies.add(new PassengerBogie("B3", "First Class", 50));
        bogies.add(new PassengerBogie("B4", "Sleeper", 80));
        return bogies;
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<PassengerBogie> result =
                UC8TrainConsistMgmt.filterBogiesByCapacity(createSampleBogies(), 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<PassengerBogie> result =
                UC8TrainConsistMgmt.filterBogiesByCapacity(createSampleBogies(), 70);

        // Capacity == 70 should NOT be included
        assertTrue(result.stream().noneMatch(b -> b.getCapacity() == 70));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<PassengerBogie> result =
                UC8TrainConsistMgmt.filterBogiesByCapacity(createSampleBogies(), 70);

        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 70));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<PassengerBogie> result =
                UC8TrainConsistMgmt.filterBogiesByCapacity(createSampleBogies(), 60);

        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<PassengerBogie> result =
                UC8TrainConsistMgmt.filterBogiesByCapacity(createSampleBogies(), 100);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<PassengerBogie> result =
                UC8TrainConsistMgmt.filterBogiesByCapacity(createSampleBogies(), 40);

        assertEquals(4, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<PassengerBogie> result =
                UC8TrainConsistMgmt.filterBogiesByCapacity(new ArrayList<>(), 60);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<PassengerBogie> original = createSampleBogies();
        List<PassengerBogie> copy = new ArrayList<>(original);

        UC8TrainConsistMgmt.filterBogiesByCapacity(original, 60);

        assertEquals(copy.size(), original.size());
    }
}