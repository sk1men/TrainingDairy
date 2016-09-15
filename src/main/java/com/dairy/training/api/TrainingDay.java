package com.dairy.training.api;


import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrainingDay {

    public LocalDate date;
    public boolean status;
    public String comments;
    public String summary;// легка важка короткий опис

    public String getUser() {
        return user;
    }

    public String user;
//    public List<?> exercises;// перелік вправ

    public TrainingDay(LocalDate date) {
        this.date = date;
        this.status = false; //todo DataBase
        this.comments = ""; //todo DataBase
        this.summary = "";  //todo DataBase
    }

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
}
