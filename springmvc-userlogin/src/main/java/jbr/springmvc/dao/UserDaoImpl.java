package jbr.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import jbr.springmvc.model.Lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.Membership;
import jbr.springmvc.model.User;
import org.springframework.web.servlet.ModelAndView;

public class UserDaoImpl implements UserDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public void register(User user) {
    jdbcTemplate.update("insert into users values (?,?,?,?,?,?,?,?,?)" , user.getUsername(), user.getPassword(), user.getFirstname(),
        user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone(), user.isTrainer(),user.getMembership());
  }
  
  public ArrayList<String> getAllUsername() throws ClassNotFoundException, SQLException {
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/myusers","root","root");
    Statement stm;
    stm = conn.createStatement();
    String sql = "Select * From users";
    ResultSet rst;
    rst = stm.executeQuery(sql);
    ArrayList<String> customerList = new ArrayList<String>();
    while (rst.next()) {
        customerList.add(rst.getString("username"));
    }
    return customerList;
  }
  
  
  
  
  public void reservePlace(Lesson lesson) {
      jdbcTemplate.update("UPDATE LESSONS SET availableplaces=availableplaces-1 where name= '"+lesson.getName()+"'");
  }
  
  public void boughtMemberShip(Membership membership) {
      jdbcTemplate.update("UPDATE USERS SET membership = membership+'"+membership.getMonths()+"' WHERE username='"+ membership.getUsername()+"'");
  }
  

  public User validateUser(Login login) {

    String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
        + "'";

    List<User> users = jdbcTemplate.query(sql, new UserMapper());

    return users.size() > 0 ? users.get(0) : null;
  }

}

class UserMapper implements RowMapper<User> {

  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();

    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    user.setFirstname(rs.getString("firstname"));
    user.setLastname(rs.getString("lastname"));
    user.setEmail(rs.getString("email"));
    user.setAddress(rs.getString("address"));
    user.setPhone(rs.getInt("phone"));
    user.setTrainer(rs.getBoolean("trainer"));
    return user;
  }
}