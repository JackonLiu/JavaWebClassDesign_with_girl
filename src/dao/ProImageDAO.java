package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.ProImage;
import bean.Product;
import util.DBUtil;

public class ProImageDAO {
	public static final String type_single = "type_single";
    public static final String type_detail = "type_detail";
 
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select count(*) from ProductImage";
  
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return total;
    }
  
    public void add(ProImage bean) {
 
        String sql = "insert into ProductImage values(null,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, bean.getProduct().getId());
            ps.setString(2, bean.getType());
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
  
    public void update(ProImage bean) {
  
    }
  
    public void delete(int id) {
  
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from ProductImage where id = " + id;
  
            s.execute(sql);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
  
    public ProImage get(int id) {
    	ProImage bean = new ProImage();
 
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from ProductImage where id = " + id;
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {
                int pid = rs.getInt("pid");
                String type = rs.getString("type");
                Product product = new ProductDAO().get(pid);
                bean.setProduct(product);
                bean.setType(type);
                bean.setId(id);
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return bean;
    }
  
    public List<ProImage> list(Product p, String type) {
        return list(p, type,0, Short.MAX_VALUE);
    }
  
    public List<ProImage> list(Product p, String type, int start, int count) {
        List<ProImage> beans = new ArrayList<ProImage>();
  
        String sql = "select * from ProductImage where pid =?  order by id desc limit ?,? ";
  
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, p.getId());
  
            ps.setInt(2, start);
            ps.setInt(3, count);
             
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
 
            	ProImage bean = new ProImage();
                int id = rs.getInt(1);
                String path = rs.getString(2);
                bean.setProduct(p);
                bean.setType(path);
                bean.setId(id);
                   
                beans.add(bean);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return beans;
    }
}
