package jbr.springmvc.service;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public interface UserService {

  void register(User user);
  
  void boughtMemberShip(User user,int memberShip);

  User validateUser(Login login);
}
