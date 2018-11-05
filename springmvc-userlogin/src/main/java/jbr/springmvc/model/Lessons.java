/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbr.springmvc.model;

import java.text.SimpleDateFormat;

/**
 *
 * @author bzolt
 */
public class Lessons {
    private SimpleDateFormat begin;
    private SimpleDateFormat end;
    private String name;
    private String trainer;

    public SimpleDateFormat getBegin() {
        return begin;
    }

    public void setBegin(SimpleDateFormat begin) {
        this.begin = begin;
    }

    public SimpleDateFormat getEnd() {
        return end;
    }

    public void setEnd(SimpleDateFormat end) {
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
    
    
    
    
    
}
