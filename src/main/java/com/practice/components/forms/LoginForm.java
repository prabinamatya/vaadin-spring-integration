package com.practice.components.forms;

import com.practice.components.bean.LoginBean;
import com.vaadin.data.Item;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.Select;
import com.vaadin.ui.TextField;

public class LoginForm extends Form {
	private LoginBean datasource;
	public LoginForm() {
		super();
		rebuild();
	}

	private void rebuild() {
		setCaption("Login");
		setFormFieldFactory(new FieldFactory());


		bindDataSource();
		

	}

	private void bindDataSource() {
		datasource = new LoginBean();
		BeanItem item = new BeanItem(datasource);
		
	}

	

	

}
