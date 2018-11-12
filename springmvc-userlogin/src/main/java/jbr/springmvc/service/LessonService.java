/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbr.springmvc.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import jbr.springmvc.model.Lesson;

/**
 *
 * @author bzolt
 */
public interface LessonService {
  public ArrayList<Lesson> getAllLesson() throws ClassNotFoundException, SQLException;
  public ArrayList<String> getAllLessonName() throws ClassNotFoundException, SQLException;
  public void addLesson(Lesson lesson) throws ParseException;
  public void deleteLesson(int id);
  public void modifyLesson(Lesson lesson) throws ParseException;
  
}
