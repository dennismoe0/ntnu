/**
 * Represents an event with an ID, name, location, organizer, type, and time.
 * The time is stored as a long in the format yyyymmddhhmm, e.g., 202310051800
 * for
 * October 5th, 2023, at 18:00.
 * 
 * @param eventId        The unique ID of the event.
 * @param eventName      The name of the event.
 * @param eventLocation  The location of the event.
 * @param eventOrganiser The name of the organiser.
 * @param typeOfEvent    The type of the event (e.g., party, wedding, concert).
 * @param timeOfEvent    The time of the event in yyyymmddhhmm format.
 * 
 * @author Dennis Moe
 */
public class Events {
    private final int eventId; // Unique ID
    private final String eventName; // Name of event
    private final String eventLocation; // Location, use cities in Norway.
    private final String eventOrganiser; // Name of the organiser.
    private final String typeOfEvent; // Type, party, wedding, concert.
    private final long timeOfEvent; // Long

    /**
     * Constructs a new Events object with the specified parameters.
     * 
     * @param eventId        The unique ID for the event.
     * @param eventName      The name of the event.
     * @param eventLocation  The location of the event.
     * @param eventOrganiser The name of the organiser.
     * @param typeOfEvent    The type of event.
     * @param timeOfEvent    The date and time of the event in yyyymmddhhmm format.
     */
    public Events(int eventId, String eventName, String eventLocation,
            String eventOrganiser, String typeOfEvent, long timeOfEvent) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventOrganiser = eventOrganiser;
        this.typeOfEvent = typeOfEvent;
        this.timeOfEvent = timeOfEvent;
    }

    // Getters

    /**
     * @return the unique ID of the event
     */
    public int getEventID() {
        return eventId;
    }

    /**
     * @return the name of the event
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * @return the location of the event
     */
    public String getEventLocation() {
        return eventLocation;
    }

    /**
     * @return the name of the organiser
     */
    public String getEventOrganiser() {
        return eventOrganiser;
    }

    /**
     * @return the type of the event
     */
    public String getTypeOfEvent() {
        return typeOfEvent;
    }

    /**
     * @return the date and time of the event in yyyymmddhhmm format
     */
    public long getTimeOfEvent() {
        return timeOfEvent;
    }
}
