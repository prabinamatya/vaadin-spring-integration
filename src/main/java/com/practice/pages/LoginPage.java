package com.practice.pages;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.practice.components.StudentDetailTable;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginPage extends Panel{
	private StudentDetailTable table;
	
	public LoginPage() {
		removeAllComponents();
		rebuild();
	}

/*	private Component generateContent() {
		CustomLayout pageBodyLayout;
		pageBodyLayout = generateLayout();
		pageBodyLayout.addComponent(generateLogin(), "loginLayout");
		return pageBodyLayout;
	}*/
	
	
	private void rebuild() {
		Panel panel = new Panel("Login");
		VerticalLayout vLayout = new VerticalLayout();
		
		HorizontalLayout userhLayout = new HorizontalLayout();
		Label userNameLabel = new Label("Username");
		TextField userTextBox = new TextField();
		userhLayout.addComponent(userNameLabel);
		userhLayout.addComponent(userTextBox);
		
		HorizontalLayout passhLayout = new HorizontalLayout();
		Label passwordLabel = new Label("Password");
		TextField passwordTextBox = new TextField();
		passhLayout.addComponent(passwordLabel);
		passhLayout.addComponent(passwordTextBox);
		
		HorizontalLayout buttonLayout = new HorizontalLayout();
		final Button loginButton = new Button("Login");

		loginButton.addListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				table = new StudentDetailTable();
				loginButton.setCaption("login button got clicked");
			}
		});
		
		Button forgotButton = new Button("Forgot Password");
		buttonLayout.addComponent(loginButton);
		buttonLayout.addComponent(forgotButton);
		
		vLayout.addComponent(userhLayout);
		vLayout.addComponent(passhLayout);
		vLayout.addComponent(buttonLayout);

		Button registerButton = new Button("Register");
		vLayout.addComponent(registerButton);
		
		addComponent(vLayout);
	}
	
/*	private CustomLayout generateLayout() {
		String loginLayoutString = "<div class ='loginLayout' style='float:center'>" +
							"<div location ='centerLogin'/>" +
							"</div>";
		CustomLayout loginLayoutPage = null;
		try {
			loginLayoutPage = new CustomLayout(new ByteArrayInputStream(loginLayoutString.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return loginLayoutPage;
	}*/
}
