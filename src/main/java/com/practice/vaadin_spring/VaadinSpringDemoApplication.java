
package com.practice.vaadin_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.vaadin.Application;

@Configurable
public class VaadinSpringDemoApplication extends Application {
    private static final long serialVersionUID = 1L;

    public static final String APPLICATION_TITLE = "Vaading-Spring Demo";

    @Autowired
    private MainWindow mainWindow;

    @Override
    public void init() {
        setMainWindow(mainWindow);
    }

}
