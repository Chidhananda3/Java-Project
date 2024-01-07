package com.tap.lastmain;

import java.util.List;

import com.tap.modules.user;

import projectbo.userboImpl;

public class lastprogram {
	public static void main(String[] args)   {
		userboImpl userbo= new userboImpl();
		List<user>users=userbo.getAll();
		for(user user : users) {
			System.out.println(user);
		}
		
		
}
}