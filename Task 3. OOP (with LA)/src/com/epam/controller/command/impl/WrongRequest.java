package com.epam.controller.command.impl;

import com.epam.controller.command.Command;

public class WrongRequest implements Command{

	@Override
	public String execute(String request) {
		return "Wrong request";
	}

}
