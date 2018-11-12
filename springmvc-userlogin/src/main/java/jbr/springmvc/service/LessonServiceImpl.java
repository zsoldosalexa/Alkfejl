/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbr.springmvc.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import jbr.springmvc.dao.LessonDao;
import jbr.springmvc.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author bzolt
 */
public class LessonServiceImpl implements LessonService {
    
    @Autowired
    public LessonDao lessonDao;
    
     public void deleteLesson(int id) {
         lessonDao.deleteLesson(id);
     }
     
     public void modifyLesson(Lesson lesson) throws ParseException {
         lessonDao.modifyLesson(lesson);
     }
    
    public void addLesson(Lesson lesson) throws ParseException {
        lessonDao.addLesson(lesson);
    }
    
    public ArrayList<String> getAllLessonName() throws ClassNotFoundException, SQLException {
      return lessonDao.getAllLessonName();
    }
    
     public ArrayList<Lesson> getAllLesson() throws ClassNotFoundException, SQLException {
      return lessonDao.getAllLesson();
     }
}
