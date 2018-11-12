/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbr.springmvc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.sql.DataSource;
import jbr.springmvc.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author bzolt
 */
public class LessonDaoImpl implements LessonDao{
      
  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;
  
  
 public ArrayList<String> getAllLessonName() throws ClassNotFoundException, SQLException {
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/myusers","root","root");
    Statement stm;
    stm = conn.createStatement();
    String sql = "Select * From lessons";
    ResultSet rst;
    rst = stm.executeQuery(sql);
    ArrayList<String> customerList = new ArrayList<String>();
    while (rst.next()) {
        customerList.add(rst.getString("name"));
    }
    return customerList;
  }
 
 public ArrayList<Lesson> getAllLesson() throws ClassNotFoundException, SQLException {
     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/myusers","root","root");
    Statement stm;
    stm = conn.createStatement();
    String sql = "Select * From lessons";
    ResultSet rst;
    rst = stm.executeQuery(sql);
    ArrayList<Lesson> customerList = new ArrayList<Lesson>();
    while (rst.next()) {
        customerList.add(new Lesson(rst.getString("date"),rst.getInt("begin"),rst.getInt("end"),rst.getString("name"),rst.getString("trainer"),rst.getInt("availablepalces"),rst.getString("trainerusername")));
    }
    return customerList;
 }
  
 
 public void addLesson(Lesson lesson) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    if (!lesson.getDate().isEmpty()) {
        java.util.Date date = sdf.parse(lesson.getDate());
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        jdbcTemplate.update("insert into lessons(date,begin,end,name,trainer,availableplaces,trainerusername) values (?,?,?,?,?,?,?)" , sqlDate, lesson.getBegin(), lesson.getEnd(),
                       lesson.getName(), lesson.getTrainer(), lesson.getAvailablePlaces(), lesson.getTrainerUsername());
    }
  }
 
  public void deleteLesson(int id) {
      jdbcTemplate.update("DELETE FROM LESSONS WHERE ID='"+id+"'");
  }
  
  public void modifyLesson(Lesson lesson) throws ParseException {
      if (lesson.getAvailablePlaces()>=0) {
       jdbcTemplate.update("update lessons set availableplaces='"+lesson.getAvailablePlaces()+"' where id='"+lesson.getId()+"'");   
      }
      if (lesson.getBegin()!=0) {
       jdbcTemplate.update("update lessons set begin='"+lesson.getBegin()+"' where id='"+lesson.getId()+"'");  
      }
      if (lesson.getEnd()!=0) {
       jdbcTemplate.update("update lessons set end='"+lesson.getEnd()+"' where id='"+lesson.getId()+"'");   
      }
      if (!lesson.getName().isEmpty()) {
       jdbcTemplate.update("update lessons set name='"+lesson.getName()+"' where id='"+lesson.getId()+"'");   
      }
      if (lesson.getDate().toString().length()!=0) {
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           java.util.Date date = sdf.parse(lesson.getDate());
           java.sql.Date sqlDate = new java.sql.Date(date.getTime());
           jdbcTemplate.update("update lessons set date='"+sqlDate+"' where id='"+lesson.getId()+"'");   
      }
      if (!lesson.getTrainer().isEmpty()) {
       jdbcTemplate.update("update lessons set trainer='"+lesson.getTrainer()+"' where id='"+lesson.getId()+"'");   
      }
      if (!lesson.getTrainerUsername().isEmpty()) {
       jdbcTemplate.update("update lessons set trainerusername='"+lesson.getTrainerUsername()+"' where id='"+lesson.getId()+"'");   
      }
  }
  
  
}
