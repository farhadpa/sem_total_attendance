package sem.totalattendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@SpringBootApplication
@RestController
public class TotalAttendanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TotalAttendanceApplication.class, args);
    }


//    @CrossOrigin(origins = "http://semfrontend.40387377.qpc.hal.davecutting.uk/")
    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public HashMap<String, String> totalAttendance(@RequestParam(value="attendance", defaultValue = "0") String attendance) {
        try {
            String totalAttendance = TotalAttendanceCalculator.calculateTotalAttendance(attendance);
            HashMap<String, String> result = new HashMap<>();
            result.put("result", totalAttendance);
            if (totalAttendance.contains("Error")) {
                result.put("status", "400");
            } else {
                result.put("status", "200");
            }
            return result;
        } catch (Exception e) {
            HashMap<String, String> result = new HashMap<>();
            result.put("result", e.getMessage());
            result.put("status", "400");
            return result;
        }
    }
}
