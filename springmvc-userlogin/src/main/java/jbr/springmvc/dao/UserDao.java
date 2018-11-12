package jbr.springmvc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import jbr.springmvc.model.Lesson;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.Membership;
import jbr.springmvc.model.User;

public interface UserDao {

  void register(User user);
  void reservePlace(Lesson lesson);
  public ArrayList<String> getAllUsername() throws ClassNotFoundException, SQLException;
  void boughtMemberShip(Membership membership);
  User validateUser(Login login);
}
