package sem;
import org.junit.jupiter.api.Test;
import sem.totalattendance.TotalAttendanceCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalAttendanceCalculatorTest {
    @Test
    public void testCalculateTotalAttendance() {
        String result = TotalAttendanceCalculator.calculateTotalAttendance("1,2,3,4,5");
        assertEquals("15.0", result);
    }

    @Test
    public void testInvalidInput() {
        String result = TotalAttendanceCalculator.calculateTotalAttendance("1,2,one,4");
        assertEquals("Error: Invalid input. Please enter a comma separated list of numbers.", result);
    }

    @Test
    public void testEmptyInput() {
        String result = TotalAttendanceCalculator.calculateTotalAttendance("");
        assertEquals("Error: Invalid input. Please enter a comma separated list of numbers.", result);
    }

    @Test
    public void testSingleInput() {
        String result = TotalAttendanceCalculator.calculateTotalAttendance("1");
        assertEquals("1.0", result);
    }
}
