import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * A client application for managing events using a console-based menu.
 * Allows users to register events, search for events by location or date,
 * and view all events within a time interval.
 *
 * @see Events
 * @see EventsRegister
 */
public class EventClient {
    public static void main(String[] args) throws InterruptedException {
        EventsRegister eventsRegister = new EventsRegister();
        Scanner scanner = new Scanner(System.in);

        // Pre-populate the EventsRegister with 20 sample events
        eventsRegister.registerNewEvent("Concert in Oslo", "Oslo", "MusicOrg", "Concert", 202310051800L);
        eventsRegister.registerNewEvent("Wedding in Bergen", "Bergen", "WeddingPlanners", "Wedding", 202312151500L);
        eventsRegister.registerNewEvent("Tech Conference", "Trondheim", "TechCorp", "Conference", 202311201000L);
        // ... (other events)

        boolean running = true;

        while (running) {
            System.out.println("\nEvent Management System:");
            System.out.println("1. Register a new event");
            System.out.println("2. Find events by location");
            System.out.println("3. Find events by date");
            System.out.println("4. List events within a time interval");
            System.out.println("5. List all events sorted by location, type, and time");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter event name: ");
                    String eventName = scanner.nextLine();
                    System.out.print("Enter event location: ");
                    String eventLocation = scanner.nextLine();
                    System.out.print("Enter event organiser: ");
                    String eventOrganiser = scanner.nextLine();
                    System.out.print("Enter event type (e.g., concert, wedding): ");
                    String typeOfEvent = scanner.nextLine();

                    System.out.print("Enter event time in hhmm format (e.g., 1732 for 17:32): ");
                    String time = String.format("%04d", scanner.nextInt());
                    System.out.print("Enter event day (1-31): ");
                    String day = String.format("%02d", scanner.nextInt());
                    System.out.print("Enter event month (1-12): ");
                    String month = String.format("%02d", scanner.nextInt());
                    System.out.print("Enter event year (e.g., 2023): ");
                    String year = scanner.next();

                    long timeOfEvent = Long.parseLong(year + month + day + time);
                    eventsRegister.registerNewEvent(eventName, eventLocation, eventOrganiser, typeOfEvent, timeOfEvent);
                    System.out.println("Event registered successfully.");
                    Thread.sleep(2000); // 2-second wait
                }
                case 2 -> {
                    System.out.print("Enter location to search: ");
                    String location = scanner.nextLine();
                    List<Events> foundEvents = eventsRegister.findEventByLocation(location);
                    displayEvents(foundEvents, "Events at location: " + location);
                }
                case 3 -> {
                    System.out.print("Enter day (1-31): ");
                    String day = String.format("%02d", scanner.nextInt());
                    System.out.print("Enter month (1-12): ");
                    String month = String.format("%02d", scanner.nextInt());
                    System.out.print("Enter year (e.g., 2023): ");
                    String year = scanner.next();

                    long date = Long.parseLong(year + month + day);
                    List<Events> foundEvents = eventsRegister.findEventByDate(date);
                    displayEvents(foundEvents, "Events on date: " + date);
                }
                case 4 -> {
                    System.out.print("Enter start time in hhmm format (e.g., 1732 for 17:32): ");
                    String startTime = String.format("%04d", scanner.nextInt());
                    System.out.print("Enter start day (1-31): ");
                    String startDay = String.format("%02d", scanner.nextInt());
                    System.out.print("Enter start month (1-12): ");
                    String startMonth = String.format("%02d", scanner.nextInt());
                    System.out.print("Enter start year (e.g., 2023): ");
                    String startYear = scanner.next();

                    long startDateTime = Long.parseLong(startYear + startMonth + startDay + startTime);

                    System.out.print("Enter end time in hhmm format (e.g., 1732 for 17:32): ");
                    String endTime = String.format("%04d", scanner.nextInt());
                    System.out.print("Enter end day (1-31): ");
                    String endDay = String.format("%02d", scanner.nextInt());
                    System.out.print("Enter end month (1-12): ");
                    String endMonth = String.format("%02d", scanner.nextInt());
                    System.out.print("Enter end year (e.g., 2023): ");
                    String endYear = scanner.next();

                    long endDateTime = Long.parseLong(endYear + endMonth + endDay + endTime);

                    List<Events> eventsInInterval = eventsRegister.eventIntervall(startDateTime, endDateTime);
                    displayEvents(eventsInInterval, "Events between " + startDateTime + " and " + endDateTime);
                }
                case 5 -> {
                    List<Events> sortedEvents = eventsRegister.sortByLocationTypeAndTime();
                    displayEvents(sortedEvents, "All events sorted by location, type, and time:");
                }
                case 6 -> {
                    running = false;
                    System.out.println("Exiting Event Management System. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
            Thread.sleep(2000); // 2-second wait after each action
        }
        scanner.close();
    }

    /**
     * Displays events in a formatted box with concise details.
     *
     * @param events The list of events to display
     * @param header The header for the display box
     */
    private static void displayEvents(List<Events> events, String header) {
        System.out.println("\n==============================");
        System.out.println(header);
        System.out.println("==============================");

        if (events.isEmpty()) {
            System.out.println("No events found.");
        } else {
            for (Events event : events) {
                System.out.printf("| %s - %s - %s - %s - %s |\n",
                        event.getEventName(),
                        event.getEventLocation(),
                        event.getEventOrganiser(),
                        event.getTypeOfEvent(),
                        formatEventDate(event.getTimeOfEvent()));
            }
        }
        System.out.println("==============================\n");
    }

    /**
     * Formats a date in yyyymmddhhmm format to a readable format, e.g.,
     * "16:32 the 26. of October 2023".
     *
     * @param dateTime The date in yyyymmddhhmm format
     * @return The formatted date as a String
     */
    private static String formatEventDate(long dateTime) {
        String dateTimeStr = String.format("%012d", dateTime);
        int year = Integer.parseInt(dateTimeStr.substring(0, 4));
        int month = Integer.parseInt(dateTimeStr.substring(4, 6));
        int day = Integer.parseInt(dateTimeStr.substring(6, 8));
        int hour = Integer.parseInt(dateTimeStr.substring(8, 10));
        int minute = Integer.parseInt(dateTimeStr.substring(10, 12));

        LocalDateTime date = LocalDateTime.of(year, month, day, hour, minute);
        String monthName = date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        return String.format("%02d:%02d the %d. of %s %d",
                hour,
                minute,
                day,
                monthName,
                year);
    }
}
