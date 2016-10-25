package com.dairy.training.api;


import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TrainingDay {
    public LocalDate date;

    public boolean status;
    public String comments;
    public String summary;// easy or hard training description
    public String user;

    public TrainingDay(LocalDate date, boolean status, String comments, String summary, String user) {
        this.date = date;
        this.status = status;
        this.comments = comments;
        this.summary = summary;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Training Day " + date + ", " + user + " status = " + status + ", " + comments + ", " + summary + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingDay that = (TrainingDay) o;
        return status == that.status &&
                Objects.equals(date, that.date) &&
                Objects.equals(comments, that.comments) &&
                Objects.equals(summary, that.summary) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, status, comments, summary, user);
    }
}
