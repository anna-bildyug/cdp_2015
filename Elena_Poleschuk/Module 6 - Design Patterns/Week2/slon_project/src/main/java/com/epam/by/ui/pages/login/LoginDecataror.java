package com.epam.by.ui.pages.login;

import com.epam.by.ui.pages.LogisticsAndSettingsPage;

public class LoginDecataror implements ILogin {

	protected LoginPage lg;

	public LoginDecataror(LoginPage lg) {
		this.lg = lg;
	}

	public LogisticsAndSettingsPage logIn(String userName, String userPassword) {
		System.out.println("Accsess data: userName = " + userName + ", userPassword = " + userPassword);
		return lg.logIn(userName, userPassword);
	}

}
