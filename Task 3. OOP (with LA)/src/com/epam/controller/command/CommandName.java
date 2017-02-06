package com.epam.controller.command;

public enum  CommandName {

	INIT_USERS("Init_users"),
	INIT_CATALOG("Init_catalog"),
	LOG_ALL_NEWS("Log_all_news"),
	LOG_ALL_USERS("Log_all_users"),
	REGISTRATION("Registration"),
	SIGN_IN("Sign_in"),
	SIGN_OUT("Sign_out"),
    ADD_NEWS("Add_news"),
    FIND_BY_ID("Find_by_id"),
    FIND_BY_TITLE("Find_by_title"),
    FIND_BY_CATEGORY("Find_by_category"),
    WRONG_REQUEST("Wrong_request");
	
	String name;

    CommandName(String name) {
        this.name = name;
    }
}

