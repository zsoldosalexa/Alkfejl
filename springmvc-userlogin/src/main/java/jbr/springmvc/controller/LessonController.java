/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbr.springmvc.controller;

import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jbr.springmvc.model.Lesson;
import jbr.springmvc.model.Membership;
import jbr.springmvc.service.LessonService;
import jbr.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author bzolt
 */

@Controller
public class LessonController {
 @Autowired
  public UserService userService;
 @Autowired
 public LessonService lessonService;

  @RequestMapping(value = "lessons", method = RequestMethod.GET)
  public ModelAndView showLessons(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("lessons");
    mav.addObject("lessons",new Lesson());
 

    return mav;
  }

  @RequestMapping(value = "/reserveprocess", method = RequestMethod.POST)
  public ModelAndView rerservePlace(HttpServletRequest request, HttpServletResponse response,
    @ModelAttribute("lessons") Lesson lesson) throws ClassNotFoundException, SQLException {
     if (!lessonService.getAllLessonName().contains(lesson.getName())) {
         ModelAndView mav = new ModelAndView("lessons");
         mav.addObject("message","Not valid data");
         return mav;
     }
    userService.reservePlace(lesson);
    return new ModelAndView("reservation-success");
  }

  @RequestMapping(value = "trainerlessons", method = RequestMethod.GET)
  public ModelAndView trainerLessonMain(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("trainerlessons");
    mav.addObject("trainerlessons",new Lesson());
 

    return mav;
  }

  @RequestMapping(value = "/showlessons", method = RequestMethod.POST)
  public ModelAndView showLessons(HttpServletRequest request, HttpServletResponse response,
    @ModelAttribute("trainerlessons") Lesson lesson) throws ClassNotFoundException, SQLException {
    ModelAndView mav = new ModelAndView("trainerlessons");
    if (userService.getAllUsername().contains(lesson.getTrainerUsername()))
        mav.addObject("trainerlessons",lesson.getTrainerUsername());
    return mav;
  }
  
  @RequestMapping(value = "newlesson", method = RequestMethod.GET)
  public ModelAndView newLessonMain(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("newlesson");
    mav.addObject("newlesson",new Lesson());
 

    return mav;
  }

  @RequestMapping(value = "/addlesson", method = RequestMethod.POST)
  public ModelAndView lessonAdded(HttpServletRequest request, HttpServletResponse response,
    @ModelAttribute("newlesson") Lesson lesson) throws ClassNotFoundException, SQLException, ParseException {
    if (lesson.getAvailablePlaces()!=0 && lesson.getBegin()!=0 && !lesson.getDate().isEmpty() && lesson.getEnd()!=0 &&
        lesson.getId()!=0 && !lesson.getName().isEmpty() && !lesson.getTrainer().isEmpty() && !lesson.getTrainerUsername().isEmpty() && 
        !lessonService.getAllLesson().contains(lesson) && userService.getAllUsername().contains(lesson.getTrainerUsername())) {
        lessonService.addLesson(lesson);
        return new ModelAndView("lesson-added");
    }
    return new ModelAndView("newlesson");
  }
    
  @RequestMapping(value = "deletelesson", method = RequestMethod.GET)
  public ModelAndView deleteLessonMain(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("deletelesson");
    mav.addObject("deletelesson",new Lesson());
 

    return mav;
  }

  @RequestMapping(value = "/deletedlesson", method = RequestMethod.POST)
  public ModelAndView lessonDeleted(HttpServletRequest request, HttpServletResponse response,
    @ModelAttribute("deletelesson") Lesson lesson) throws ClassNotFoundException, SQLException {
      
    if (lesson.getId()>0 && lesson.getId()<=lessonService.getAllLesson().size()) {
        lessonService.deleteLesson(lesson.getId());
        return new ModelAndView("lesson-deleted");
    }
    return new ModelAndView("deletelesson");
  }  
  
  @RequestMapping(value = "modifylesson", method = RequestMethod.GET)
  public ModelAndView modifyLessonMain(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("modifylesson");
    mav.addObject("modifylesson",new Lesson());
 

    return mav;
  }

  @RequestMapping(value = "/lessonmodified", method = RequestMethod.POST)
  public ModelAndView lessonModified(HttpServletRequest request, HttpServletResponse response,
    @ModelAttribute("modifylesson") Lesson lesson) throws ClassNotFoundException, SQLException, ParseException {
    if (lesson.getId()!=0) {
        lessonService.modifyLesson(lesson);
        return new ModelAndView("lesson-modified");
    }
    return new ModelAndView("modifylesson");
  }  
  
}


