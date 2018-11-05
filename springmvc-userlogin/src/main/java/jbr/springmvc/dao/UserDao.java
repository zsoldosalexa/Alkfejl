package jbr.springmvc.dao;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public interface UserDao {

  void register(User user);
  void boughtMemberShip(User user,int memberShip);
  User validateUser(Login login);
}
