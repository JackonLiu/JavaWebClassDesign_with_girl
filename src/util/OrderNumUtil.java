package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;


//订单生成器
public class OrderNumUtil {
	
	public static String genOrderNum() {
		
		//得到当前的日期,用日期去查找是否有对应记录
		
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(now);
		
		StringBuffer sb=new StringBuffer(date.replace("-", ""));
		
        String sql ="select num from ordernum where prefix=?"; 
        int total=0;	
		try (Connection c = DBUtil.getConnection(); PreparedStatement s = c.prepareStatement(sql);) {
			  
	            s.setString(1, date);
	            
	            ResultSet rs = s.executeQuery(sql);
	            while (rs.next()) {
	                total = rs.getInt(1);
	            }

		//没有对应记录，则插入当前日期和数字1
	    //有对应记录，则去除数字，返回数字加1，同时更新数据库
			if(total==0){
				sql = "insert into ordernum(prefix, num) values(?,?) ";
                try{
                	PreparedStatement s2 = c.prepareStatement(sql);
                	s2.setString(1, date);
                    s2.setInt(2, total);
                    s2.execute(sql);
                }catch(SQLException e) {
      			  
    	            e.printStackTrace();
    	        }
				
			}else{
				PreparedStatement s1 = c.prepareStatement(sql);
				total=total+1;
				sql = "update  ordernum  set num=? where prefix=? ";
                s1 = c.prepareStatement(sql);
                s1.setInt(1, total);
                s1.setString(2, date);
                s1.execute(sql);
			}
			
			int numLength=String.valueOf(total).length();
			for(int i=0;i<11-numLength;i++){
				sb.append("0");
			}
			sb.append(total);
			
			
		  } catch (SQLException e) {
			  
	            e.printStackTrace();
	        }
		return sb.toString();
	}
	
}
