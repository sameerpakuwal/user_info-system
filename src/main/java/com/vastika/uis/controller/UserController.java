package com.vastika.uis.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.vastika.uis.model.User;
import com.vastika.uis.service.UserService;
import com.vastika.uis.service.UserServiceImpl;

public class UserController {

	public static void main(String[] args) {

		UserService userService = new UserServiceImpl();
		String  decision = null;
do {
	String choice = JOptionPane.showInputDialog("Enter choice save | update | delete| list | get");
	switch (choice) {
	case "save":
		User user = getUser();
		int saved = userService.saveUserInfo(user);

		if (saved >= 1) {
			JOptionPane.showMessageDialog(null, "user info is saved sucessfully");
		} else {
			JOptionPane.showMessageDialog(null, "Error in  db.");

		}
		break;
	case "update":
		User updatedUser = getUser();
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id"));
		updatedUser.setId(id);
		int updated = userService.updateUserInfo(updatedUser);

		if (updated >= 1) {
			JOptionPane.showMessageDialog(null, "user info is updated sucessfully");
		} else {
			JOptionPane.showMessageDialog(null, "Error in  db.");

		}
		break;
	case "delete":
		id = Integer.parseInt(JOptionPane.showInputDialog("Enter id"));
		int deleted = userService.deleteUserInfo(id);

		if (deleted >= 1) {
			JOptionPane.showMessageDialog(null, "user info is deleted sucessfully");
		} else {
			JOptionPane.showMessageDialog(null, "Error in  db.");

		}
		break;
	case "list":
		List<User> userList = userService.getAllUserInfo();
		for (User u : userList) {
			System.out.println("User id  is " + u.getId());
			System.out.println("Username  is " + u.getUserName());
			System.out.println("User password  is " + u.getPassword());
			System.out.println("User mobile no is " + u.getMobineNo());
			System.out.println("User salary is " + u.getSalary());
			System.out.println("Is user active? " + u.isActive());
			System.out.println("===================");
		}
		break;
	case "get":
		id = Integer.parseInt(JOptionPane.showInputDialog("Enter id"));
		User u = userService.getUserById(id);
		
			System.out.println("User id  is " + u.getId());
			System.out.println("Username  is " + u.getUserName());
			System.out.println("User password  is " + u.getPassword());
			System.out.println("User mobile no is " + u.getMobineNo());
			System.out.println("User salary is " + u.getSalary());
			System.out.println("Is user active? " + u.isActive());
			System.out.println("===================");
		
		break;
	default:

		JOptionPane.showMessageDialog(null, "Wrong Choice");
		break;
	}
	
	decision = JOptionPane.showInputDialog("Do you want to  perform next operation? enter yes or no");
} while (decision.equalsIgnoreCase("yes"));

JOptionPane.showInternalMessageDialog(null, "bye ! happy coding");
		
	}

	public static User getUser() {
		User user = new User();
		String username = JOptionPane.showInputDialog("enter username");
		String password = JOptionPane.showInputDialog("enter password");
		long mobileNo = Long.parseLong(JOptionPane.showInputDialog("enter mobile no"));
		double salary = Double.parseDouble(JOptionPane.showInputDialog("enter salary"));
		boolean isActive = Boolean.parseBoolean(JOptionPane.showInputDialog("Is user active?"));

		user.setUserName(username);
		user.setPassword(password);
		user.setMobineNo(mobileNo);
		user.setActive(isActive);
		user.setSalary(salary);

		return user;

	}
}
