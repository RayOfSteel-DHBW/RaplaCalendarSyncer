package com.example;

import java.util.List;
import java.util.ArrayList;

/**
 * Responsible for syncing EventItem objects with the calendar.
 * 
 * Strategy:
 * - When we receive new data:
 *   1. Identify and remove all events previously created by this code (using a special suffix).
 *   2. Insert the new events from the API with that suffix.
 * 
 * This ensures we never delete manually added events, only those we created ourselves.
 */
public class CalendarSyncService {
    // We use a distinctive suffix for identifying events created by this tool.
    // By using a suffix like "(#Rapla)", we can easily spot and filter events that we created.
    private static final String EVENT_SUFFIX = " (#Rapla)";

    // For demonstration, we’ll simulate a local "calendar" with a list of strings representing events.
    // In a real application:
    // - You would interact with the Google Calendar API, retrieving and updating events there.
    // - You might include a hidden extended property or a unique ID to identify your own events.
    // Here, we keep it simple by just using a string suffix and a simulated list.
    private List<String> simulatedCalendar = new ArrayList<>();

    /**
     * This method coordinates the synchronization process:
     * 1. If there are no new events, we do nothing.
     * 2. If there are new events, we first remove all old events we previously added (identified by the suffix).
     * 3. Then we add the newly fetched events with the suffix.
     * 
     * This way, only the events we manage are cleaned up and replaced, and any manually added events remain untouched.
     */
    public void syncEvents(EventItem[] events) {
        if (events == null || events.length == 0) {
            // If we didn't get any events from the API, let's not remove old ones,
            // because that would leave the calendar empty of our managed events without adding anything new.
            System.out.println("No new events to sync. Skipping deletion/creation.");
            return;
        }

        // Remove events that were previously added by us (recognized by the suffix).
        removePreviouslyCreatedEvents();

        // Add the new events, all tagged with the suffix so we can identify them next time.
        addNewEvents(events);

        System.out.println("Calendar sync completed. Added " + events.length + " events.");
    }

    /**
     * Removes all events that this tool previously created from the simulated calendar.
     * In a real scenario, this would be where you:
     * - Fetch all events from the real calendar.
     * - Filter them by checking if they end with our chosen suffix.
     * - Delete only those events.
     */
    private void removePreviouslyCreatedEvents() {
        // Remove all events in the local list that end with our identifying suffix.
        simulatedCalendar.removeIf(eventTitle -> eventTitle.endsWith(EVENT_SUFFIX));
        System.out.println("Removed previously auto-synced events.");
    }

    /**
     * Adds new events, each tagged with the suffix.
     * In a real scenario, you'd create a proper calendar event object and insert it using the API.
     * Here, we just add strings to our simulated list.
     */
    private void addNewEvents(EventItem[] events) {
        for (EventItem event : events) {
            // Construct a human-readable title for the event, including our suffix at the end.
            // This allows us to identify these events later and avoid touching any events you added manually.
            String title = event.getName() 
                    + " (" + event.getStartTime() + " - " + event.getEndTime() + ")" 
                    + EVENT_SUFFIX;

            simulatedCalendar.add(title);
        }
    }
}