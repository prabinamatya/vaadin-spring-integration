
package com.practice.vaadin_spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.practice.pages.LoginPage;
import com.vaadin.ui.Window;

@Component
@Scope("session")
public class MainWindow extends Window {
    private LoginPage loginPage;

    public MainWindow() {
        loginPage = new LoginPage();
        addComponent(loginPage);
    }

}
