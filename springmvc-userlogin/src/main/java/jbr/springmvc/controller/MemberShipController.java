package jbr.springmvc.controller;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jbr.springmvc.model.Membership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.service.UserService;

@Controller
public class MemberShipController {
  @Autowired
  public UserService userService;

  @RequestMapping(value = "membership", method = RequestMethod.GET)
  public ModelAndView showMemberShip(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("membership");
    mav.addObject("membership",new Membership());
 

    return mav;
  }

  @RequestMapping(value = "/buyprocess", method = RequestMethod.POST)
  public ModelAndView boughtMemberShip(HttpServletRequest request, HttpServletResponse response,
    @ModelAttribute("membership") Membership membership) throws ClassNotFoundException, SQLException {
    if (!(userService.getAllUsername().contains(membership.getUsername())) || Integer.valueOf(membership.getMonths())<1) {
        ModelAndView mav = new ModelAndView("membership");
        mav.addObject("message","Not valid data");
        return mav;
    }
    userService.boughtMemberShip(membership);
    return new ModelAndView("purchase");
  }
}
