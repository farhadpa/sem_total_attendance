package sem.totalattendance;


public class TotalAttendanceCalculator {

    /**
     * Calculates the total attendance from a comma separated list of numbers.
     * @param attendance A comma separated list of numbers.
     * @return The total attendance as a string.
     */
    public static String calculateTotalAttendance(String attendance) {
        try {
            float totalAttendance = 0;
            String[] attendanceString = attendance.split(",");
            for (String i : attendanceString) {
                totalAttendance += Float.parseFloat(i);
            }
            return String.valueOf(totalAttendance);
        } catch (Exception e) {
            return "Error: Invalid input. Please enter a comma separated list of numbers." ;
        }

    }
}
