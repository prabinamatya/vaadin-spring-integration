
package com.practice.vaadin_spring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.practice.components.LoginPage;
import com.practice.components.StudentDetailTable;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.Window;

@Component
@Scope("session")
public class MainWindow extends Window {
    private static final long serialVersionUID = 1L;

    private static int instanceId = 0;
    final Button button;
    
    private StudentDetailTable student;
    private LoginPage loginPage;

    @Autowired
    private TextLabelService textLabelService;

    public MainWindow() {
        super(VaadinSpringDemoApplication.APPLICATION_TITLE);
        
        instanceId++;
        student = new StudentDetailTable();
        loginPage = new LoginPage();

        addComponent(new Label(VaadinSpringDemoApplication.APPLICATION_TITLE));
        
        button = new Button("Don't Click");
        button.addListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				button.setCaption("I told you not to click");
			}
		});
        
        addComponent(button);
        addComponent(student);
        addComponent(loginPage);
    }

	private void setTableProperties(Table table) {
		table.setSizeFull();
		table.setSelectable(true);
		table.setImmediate(true);
		table.setMultiSelect(true);
	}

    @PostConstruct
    public void addInstanceLabels() {
        addComponent(new Label("MainWindow instanceId: " + instanceId));
        addComponent(new Label(textLabelService.getInstanceText()));
    }
}
