package com.example.sleepcalc;

import java.time.*;
import java.util.Date;

public class Calculation {
    private LocalDateTime currentTime;
    private LocalDateTime sleepStart;
    private Duration duration;

    public Calculation() {
    }

    public Calculation(LocalDateTime currentTime, LocalDateTime sleepStart, Duration duration) {
        this.currentTime = currentTime;
        this.sleepStart = sleepStart;
        this.duration = duration;
    }

    public void calculateSleepTime(Date wakeupTime) {
        currentTime = LocalDateTime.now();

        // Date to LocalTime
        LocalTime timeBase = wakeupTime.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

        // Base timeBase on current date
        LocalDateTime dateTime = currentTime.plusDays(1).withHour(timeBase.getHour()).withMinute(timeBase.getMinute());

        // Optimal sleep time 7:30
        LocalDateTime sleepTime = dateTime.minusHours(7).minusMinutes(30);
        
        // Remove one sleep cycle (1:30) if unable to sleep whole duration
        while (sleepTime.isBefore(currentTime)) {
            sleepTime = sleepTime.plusHours(1).plusMinutes(30);
        }

        sleepStart = sleepTime;
        duration = Duration.between(sleepTime, dateTime);
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }

    public LocalDateTime getSleepStart() {
        return sleepStart;
    }

    public void setSleepStart(LocalDateTime sleepStart) {
        this.sleepStart = sleepStart;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
