package com.example;

import java.util.List;

/**
 * Represents a single event from the API.
 * Fields match the JSON structure so that JSON parsing is straightforward.
 */
public class EventItem {
    // These fields correspond directly to the keys in the JSON.
    private String date;
    private String site;
    private String startTime;
    private String endTime;
    private String name;
    private String type;
    private String lecturer;
    private List<String> rooms;
    private String course;
    private int id;

    // Getters and setters for all fields.
    // Using getters and setters (instead of public fields) is a common practice
    // to encourage encapsulation and potentially validate data in the future.
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getSite() { return site; }
    public void setSite(String site) { this.site = site; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getLecturer() { return lecturer; }
    public void setLecturer(String lecturer) { this.lecturer = lecturer; }

    public List<String> getRooms() { return rooms; }
    public void setRooms(List<String> rooms) { this.rooms = rooms; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}
