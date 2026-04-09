import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UC9TrainConsistMgmtTest {

    private List<PassengerBogie> createSampleBogies() {
        List<PassengerBogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("B1", "Sleeper", 72));
        bogies.add(new PassengerBogie("B2", "AC Chair", 60));
        bogies.add(new PassengerBogie("B3", "First Class", 45));
        bogies.add(new PassengerBogie("B4", "Sleeper", 80));
        bogies.add(new PassengerBogie("B5", "AC Chair", 65));
        return bogies;
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        Map<String, List<PassengerBogie>> result =
                UC9TrainConsistMgmt.groupBogiesByType(createSampleBogies());

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<PassengerBogie>> result =
                UC9TrainConsistMgmt.groupBogiesByType(createSampleBogies());

        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        Map<String, List<PassengerBogie>> result =
                UC9TrainConsistMgmt.groupBogiesByType(createSampleBogies());

        assertEquals(3, result.keySet().size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        Map<String, List<PassengerBogie>> result =
                UC9TrainConsistMgmt.groupBogiesByType(new ArrayList<>());

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<PassengerBogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("B1", "Sleeper", 72));

        Map<String, List<PassengerBogie>> result =
                UC9TrainConsistMgmt.groupBogiesByType(bogies);

        assertEquals(1, result.size());
        assertTrue(result.containsKey("Sleeper"));
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<PassengerBogie>> result =
                UC9TrainConsistMgmt.groupBogiesByType(createSampleBogies());

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        Map<String, List<PassengerBogie>> result =
                UC9TrainConsistMgmt.groupBogiesByType(createSampleBogies());

        assertEquals(2, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<PassengerBogie> original = createSampleBogies();
        List<PassengerBogie> copy = new ArrayList<>(original);

        UC9TrainConsistMgmt.groupBogiesByType(original);

        assertEquals(copy.size(), original.size());
    }
}