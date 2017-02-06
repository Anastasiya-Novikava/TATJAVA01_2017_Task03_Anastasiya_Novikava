package com.epam.view;

import com.epam.controller.Controller;

public class Runner {
	public static void main(String[] args){
		Controller controller = new Controller();
		System.out.println(controller.executeTask("Init_catalog "));
		System.out.println(controller.executeTask("Init_users "));
		System.out.println(controller.executeTask("Sign_in admin admin"));
		System.out.println(controller.executeTask("Add_news df Film dfgg"));
		System.out.println(controller.executeTask("Add_news df Film dfgg"));
		System.out.println(controller.executeTask("Find_by_category "));
		System.out.println(controller.executeTask("Find_by_title Film"));
		System.out.println(controller.executeTask("Find_by_title Oscar_nominees"));
		System.out.println(controller.executeTask("Sign_out admin admin"));
		System.out.println(controller.executeTask("Registration login password"));
		System.out.println(controller.executeTask("Log_all_news "));	//look result in log_news.txt
		System.out.println(controller.executeTask("Log_all_users "));	//look result in log_users.txt
	}
}
