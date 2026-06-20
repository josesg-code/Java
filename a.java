
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class a {
    public static void main(String[] args) {

LocalDate today = LocalDate.now();
LocalDate nextWeek = today.plusDays(22);
LocalDate lastMonth = today.minusMonths(4);

System.out.println(nextWeek);
System.out.println(lastMonth);
}
}