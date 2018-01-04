package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Function;
import bean.Role;
import bean.User;
import util.DBUtil;

public class UserDAO {
 
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "select count(*) from User";
 
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return total;
    }
 
    public void add(User bean) {
 
        String sql = "insert into user(name,user_phone,password) values(?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setString(1, bean.getName());
            ps.setString(2, bean.getPhone());
            ps.setString(3, bean.getPassword());
            ps.execute();
 
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId(id);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
    }
 
    public void update(User bean) {
 
        String sql = "update user set name= ? ,user_phone=?, password = ? where id = ? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, bean.getName());
            ps.setString(2, bean.getPhone());
            ps.setString(3, bean.getPassword());
            ps.setInt(4, bean.getId());
  
            ps.execute();
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
  
    }
  
    public void delete(int id) {
  
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from User where id = " + id;
  
            s.execute(sql);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
  
    public User get(int id) {
        User bean = null;
  
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from User where id = " + id;
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {
                bean = new User();
                String name = rs.getString("name");
                bean.setName(name);
                String user_phone = rs.getString("user_phone");
                bean.setPhone(user_phone);
                String password = rs.getString("password");
                bean.setPassword(password);
                bean.setId(id);
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return bean;
    }
  
    public List<User> list() {
        return list(0, Short.MAX_VALUE);
    }
  
    public List<User> list(int start, int count) {
        List<User> beans = new ArrayList<User>();
  
        String sql = "select * from User order by id desc limit ?,? ";
  
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, start);
            ps.setInt(2, count);
  
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
                User bean = new User();
                int id = rs.getInt(1);
 
                String name = rs.getString("name");
                bean.setName(name);
                String user_phone = rs.getString("user_phone");
                bean.setPhone(user_phone);
                String password = rs.getString("password");
                bean.setPassword(password);
                 
                bean.setId(id);
                beans.add(bean);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return beans;
    }
 
    public boolean isExist(String name) {
        User user = get(name);
        return user!=null;
 
    }
 
    public User get(String name) {
        User bean = null;
          
        String sql = "select * from User where name = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs =ps.executeQuery();
  
            if (rs.next()) {
                bean = new User();
                int id = rs.getInt("id");
                bean.setName(name);
                String user_phone = rs.getString("user_phone");
                bean.setPhone(user_phone);
                String password = rs.getString("password");
                bean.setPassword(password);
                bean.setId(id);
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return bean;
    }
 
    public User get(String name, String password) {
        User bean = null;
          
        String sql = "select * from User where name = ? and password=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
  
            if (rs.next()) {
                bean = new User();
                int id = rs.getInt("id");
                bean.setName(name);
                String phone=rs.getString("user_phone");
                bean.setPhone(phone);
                bean.setPassword(password);
                bean.setId(id);
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return bean;
    }
    
    
    public List<Role> findUserRoles(User user) {
    	 List<Role> beans = new ArrayList<Role>();
    	 Role role =new Role();
    	 String sql = "select * from roles where id in (select r_id from user_role where u_id=?)";
         try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
             ps.setInt(1, user.getId());
             ResultSet rs =ps.executeQuery();
             	
             if (rs.next()) {
                 int id = rs.getInt("id");
                 role.setId(String.valueOf(id));
                 String name=rs.getString("name");
                 role.setName(name);
                 String description=rs.getString("description");
                 role.setDescription(description);
                 beans.add(role);
             }
   
         } catch (SQLException e) {
   
             e.printStackTrace();
         }
         return beans;
	}
    
    public List<Function> findRoleFunctions(Role role) {
   	 List<Function> beans = new ArrayList<Function>();
    Function fun =new Function();
   	 String sql = "select * from functions where id in (select f_id from role_function where r_id=?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, role.getId());
            ResultSet rs =ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                fun.setId(String.valueOf(id));
                String name=rs.getString("name");
                fun.setName(name);
                String uri=rs.getString("uri");
                fun.setUri(uri);
                beans.add(fun);
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return beans;
	}


}
