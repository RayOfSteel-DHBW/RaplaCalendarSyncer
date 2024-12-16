package com.example;

public class Main {
    public static void main(String[] args) {
        // Create the bootstrapper which sets up everything needed.
        Bootstrapper bootstrapper = new Bootstrapper();
        
        // Create the job via the bootstrapper and run it.
        SynchronizationJob job = bootstrapper.createSynchronizationJob();
        job.run();
        
        System.out.println("Synchronization completed (or attempted).");
    }
}
