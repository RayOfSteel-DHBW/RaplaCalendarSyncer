package com.example;

public class SynchronizationJob implements Runnable {
    private final ApiClient apiClient;
    private final CalendarSyncService calendarSyncService;

    public SynchronizationJob(ApiClient apiClient, CalendarSyncService calendarSyncService) {
        this.apiClient = apiClient;
        this.calendarSyncService = calendarSyncService;
    }

    @Override
    public void run() {
        EventItem[] events = apiClient.getEvents();

        // Now that we have events, let's sync them with the calendar.
        // This will remove previously created events and add these new ones.
        calendarSyncService.syncEvents(events);

        System.out.println("Fetched " + events.length + " events from the API and attempted to sync.");
    }
}
