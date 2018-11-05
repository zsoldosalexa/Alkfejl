package jbr.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;

@Controller
public class MemberShipController {
  @Autowired
  public UserService userService;

  @RequestMapping(value = "/membership", method = RequestMethod.GET)
  public ModelAndView showMemberShip(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("membership");
    mav.addObject("membership", new User().getMemberShip());

    return mav;
  }

  @RequestMapping(value = "/buy", method = RequestMethod.POST)
  public ModelAndView boughtMemberShip(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("membership") User user,int memberShip) {

    userService.boughtMemberShip(user,memberShip);

    return new ModelAndView("guest", "firstname", user.getFirstname());
  }
}
