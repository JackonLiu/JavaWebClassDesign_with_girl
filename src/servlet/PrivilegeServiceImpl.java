package servlet;

import java.util.List;

import bean.Function;
import bean.Role;
import bean.User;
import dao.UserDAO;


public class PrivilegeServiceImpl  {

	private UserDAO dao=new UserDAO();
	public User login(String username, String password) {
		return dao.get(username,password);
	}
	public List<Role> findUserRoles(User user) {
		
		return dao.findUserRoles(user);
	}
	public List<Function> findRoleFunctions(Role role) {
		return dao.findRoleFunctions(role);
	}

}
