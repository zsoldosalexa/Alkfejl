package jbr.springmvc.service;

import java.sql.SQLException;
import java.util.ArrayList;
import jbr.springmvc.model.Lesson;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.Membership;
import jbr.springmvc.model.User;

public interface UserService {

  void register(User user);
  
  void boughtMemberShip(Membership memberShip);
  
  public ArrayList<String> getAllUsername() throws ClassNotFoundException, SQLException;


  void reservePlace(Lesson lesson);
  
  User validateUser(Login login);
}
