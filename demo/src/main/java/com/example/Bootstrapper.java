package com.example;

public class Bootstrapper {
    public SynchronizationJob createSynchronizationJob() {
        // Construct all needed instances here and wire them up.
        ApiClient apiClient = new ApiClient("https://example.com/api/endpoint");
        CalendarSyncService calendarSyncService = new CalendarSyncService();
        
        return new SynchronizationJob(apiClient, calendarSyncService);
    }
}
