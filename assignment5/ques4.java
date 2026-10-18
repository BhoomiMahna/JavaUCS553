import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Scanner;

public class ques4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter event name: ");
        String eventName = sc.nextLine();

        System.out.print("Enter event date ");
        LocalDate eventDate = LocalDate.parse(sc.nextLine());

        System.out.print("Enter start time ");
        LocalTime startTime = LocalTime.parse(sc.nextLine());

        System.out.print("Enter venue (leave blank if unavailable): ");
        String venueName = sc.nextLine();

        Optional<String> venue = Optional.ofNullable(
            venueName.isBlank() ? null : venueName
        );

        LocalDate today = LocalDate.now();
        LocalTime endTime = startTime.plusHours(2);

        System.out.println("\nEvent Name is " + eventName);
        System.out.println("Event Date is " + eventDate);
        System.out.println("Start Time is " + startTime);
        System.out.println("End Time is " + endTime);
        System.out.println("Venue is " + venue.orElse("Venue not specified"));

        if (eventDate.isAfter(today)) {
            System.out.println("Event is in the future");
        } else if (eventDate.isEqual(today)) {
            System.out.println("Event is today");
        } else {
            System.out.println("Event is in the past");
        }

        long daysRemaining = ChronoUnit.DAYS.between(today, eventDate);
        System.out.println("Days remaining: " + daysRemaining);

        sc.close();
    }
}