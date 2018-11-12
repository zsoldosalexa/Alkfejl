/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbr.springmvc.model;


/**
 *
 * @author bzolt
 */
public class Lesson {
    private int id=0;
    private String date;
    private int begin;
    private int end;
    private String name;
    private String trainer;
    private int availablePlaces;
    private String trainerUsername;

    public Lesson(String date, int begin, int end, String name, String trainer, int availablePlaces, String trainerUsername) {
        this.date = date;
        this.begin = begin;
        this.end = end;
        this.name = name;
        this.trainer = trainer;
        this.availablePlaces = availablePlaces;
        this.trainerUsername = trainerUsername;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public Lesson() {
    }

    public String getTrainerUsername() {
        return trainerUsername;
    }

    public void setTrainerUsername(String trainerUsername) {
        this.trainerUsername = trainerUsername;
    }

    
    
    public int getAvailablePlaces() {
        return availablePlaces;
    }

    public void setAvailablePlaces(int availablePlaces) {
        this.availablePlaces = availablePlaces;
    }

    
    
    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
    
    
}
