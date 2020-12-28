package com.vastika.uis.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vastika.uis.model.User;
import com.vastika.uis.util.DbUtil;

public class UserDaoImpl implements UserDao {

	public static final String SAVE_SQL = "insert into user_tbl(user_name, password, mobile_no,is_active,Salary)values (?,?,?,?,?)";
	public static final String UPDATE_SQL = "update user_tbl set user_name=?, password=?, mobile_no=?,is_active=?,Salary=? where id =?";
	public static final String DELETE_SQL = "delete from user_tbl  where id =?";
	public static final String LIST_SQL = "select * from user_tbl";
	public static final String GET_BY_ID_SQL = "select * from user_tbl where id =?";

	@Override
	public int saveUserInfo(User user) {
		
		int saved = 0;
		try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(SAVE_SQL);){
			
			ps.setString(1, user.getUserName());
			ps.setString(2,user.getPassword());
			ps.setLong(3,user.getMobineNo());
			ps.setBoolean(4,user.isActive());
			ps.setDouble(5,user.getSalary());
			
			saved =  ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saved;
	}

	@Override
	public int updateUserInfo(User user) {
		int updated =0;
		try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(UPDATE_SQL);){
		
			ps.setString(1, user.getUserName());
			ps.setString(2,user.getPassword());
			ps.setLong(3,user.getMobineNo());
			ps.setBoolean(4,user.isActive());
			ps.setDouble(5,user.getSalary());
			ps.setInt(6, user.getId());
			updated =  ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updated;
	}

	@Override
	public int deleteUserInfo(int id) {
		int deleted =0;
		try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(DELETE_SQL);){
		
			ps.setInt(1, id);
			deleted =  ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return deleted;

	}

	@Override
	public List<User> getAllUserInfo() {
		List<User> userList = new ArrayList<>();
		
	
		try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(LIST_SQL);){
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setMobineNo(rs.getLong("mobile_no"));
				user.setSalary(rs.getDouble("salary"));
				user.setId(rs.getInt("id"));
				user.setActive(rs.getBoolean("is_active"));
				userList.add(user);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return userList;

	}

	@Override
	public User getUserById(int id) {
		User user = new User();
		try (PreparedStatement ps = DbUtil.getConnection().prepareStatement(GET_BY_ID_SQL);){
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setMobineNo(rs.getLong("mobile_no"));
				user.setSalary(rs.getDouble("salary"));
				user.setId(rs.getInt("id"));
				user.setActive(rs.getBoolean("is_active"));
				
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return  user;
	}	
}
