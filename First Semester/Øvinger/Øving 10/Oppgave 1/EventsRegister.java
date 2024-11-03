import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Manages a collection of Events, allowing registration, searching, and
 * sorting.
 * Stores events in an ArrayList and provides methods to add events, find events
 * by
 * location, date, and retrieve events within a time interval.
 * 
 * @param eventList      The list of registered events.
 * @param currentEventId A counter to automatically assign unique IDs to new
 *                       events.
 * 
 * @see Events
 * 
 * @author Dennis Moe
 */
public class EventsRegister {
    private final ArrayList<Events> eventList; // Dynamic array with all events.
    private int currentEventId; // Counter to auto-assign eventId

    /**
     * Constructs a new EventsRegister with an empty list of events and initializes
     * the event ID counter.
     */
    public EventsRegister() {
        this.eventList = new ArrayList<>();
        this.currentEventId = 1;
    }

    /**
     * Registers a new event and adds it to the central list.
     * 
     * @param eventName      The name of the event.
     * @param eventLocation  The location of the event.
     * @param eventOrganiser The organiser of the event.
     * @param typeOfEvent    The type of event.
     * @param timeOfEvent    The date and time in yyyymmddhhmm format.
     */
    public void registerNewEvent(String eventName, String eventLocation,
            String eventOrganiser, String typeOfEvent, long timeOfEvent) {
        eventList.add(new Events(currentEventId++, eventName, eventLocation,
                eventOrganiser, typeOfEvent, timeOfEvent)); // Adds the info to the central list.
    }

    /**
     * Finds all events by a specific location.
     * 
     * @param eventLocation The location to search for.
     * @return A list of events at the specified location.
     */
    public List<Events> findEventByLocation(String eventLocation) {
        List<Events> matchingTypeOfEvent = new ArrayList<>();

        for (Events event : eventList) {
            if (event.getEventLocation().equalsIgnoreCase(eventLocation)) {
                matchingTypeOfEvent.add(event); // Adds all matching locations to new array.
            }
        }
        return matchingTypeOfEvent; // Returns list, empty if nothing found. Client must display "error".
    }

    /**
     * Finds all events that occur on a specific date.
     * 
     * @param date The date in yyyymmdd format.
     * @return A list of events occurring on the specified date.
     */
    public List<Events> findEventByDate(long date) { // Must also format user input into int without time.
        List<Events> matchingDateOfEvent = new ArrayList<>();

        for (Events event : eventList) {
            long eventDate = event.getTimeOfEvent() / 10000; // Divides whole number created in client by input.
                                                             // Divides by 10.000 to remove time-digits.
            if (eventDate == date) {
                matchingDateOfEvent.add(event); // Adds event if it matches the date.
            }
        }
        return matchingDateOfEvent; // Returns the list, empty if.....
    }

    /**
     * Finds all events within a specified time interval and sorts them by time.
     * 
     * @param dateAndTime1 The start of the time interval in yyyymmddhhmm format.
     * @param dateAndTime2 The end of the time interval in yyyymmddhhmm format.
     * @return A list of events between the specified times, sorted by time.
     */
    public List<Events> eventIntervall(long dateAndTime1, long dateAndTime2) {
        List<Events> betweenTimeIntervall = new ArrayList<>();

        // If dateAndTime2 is misinputted as a smaller date it changes them to work in
        // the next loop.
        if (dateAndTime1 > dateAndTime2) {
            long temporaryTime = dateAndTime1;
            dateAndTime1 = dateAndTime2;
            dateAndTime2 = temporaryTime;
        }

        for (Events event : eventList) {
            long eventDate = event.getTimeOfEvent();
            if (eventDate >= dateAndTime1 && eventDate <= dateAndTime2) {
                betweenTimeIntervall.add(event);
            }
        }

        // Sorts by time. Collections is used to work with collections like lists, here
        // it sorts.
        // Comparator has methods to order them by specific parameters like the
        // getTimeOfEvent int.
        // Together they sort the specific list in a specific way.
        Collections.sort(betweenTimeIntervall, Comparator.comparingLong(Events::getTimeOfEvent));

        return betweenTimeIntervall;
    }

    /**
     * Sorts the list of events by location, then by type within each location,
     * and finally by time within each type.
     * 
     * @return A list of events sorted by location, type, and time.
     */
    public List<Events> sortByLocationTypeAndTime() {
        Collections.sort(eventList, Comparator.comparing(Events::getEventLocation) // First by the location String.
                .thenComparing(Events::getTypeOfEvent) // Then the type String.
                .thenComparingLong(Events::getTimeOfEvent)); // Then by the time Int.
        return eventList;
    }
}
