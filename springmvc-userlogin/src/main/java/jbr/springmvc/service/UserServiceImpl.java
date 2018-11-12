package jbr.springmvc.service;

import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

import jbr.springmvc.dao.UserDao;
import jbr.springmvc.model.Lesson;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.Membership;
import jbr.springmvc.model.User;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public void boughtMemberShip(Membership membership) {
      userDao.boughtMemberShip(membership);
  }
  
  public ArrayList<String> getAllUsername() throws ClassNotFoundException, SQLException {
      return userDao.getAllUsername();
  }
  
  public void reservePlace(Lesson lesson) {
      userDao.reservePlace(lesson);
  }
  
  public void register(User user) {
    userDao.register(user);
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

}
