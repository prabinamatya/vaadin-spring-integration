
package com.practice.vaadin_spring;

import com.practice.vaadin_spring.Table.StudentDetailTable;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("session")
public class MainWindow extends Window {
    private static final long serialVersionUID = 1L;

    private static int instanceId = 0;
    private StudentDetailTable student;

    @Autowired
    private TextLabelService textLabelService;

    public MainWindow() {
        super(VaadinSpringDemoApplication.APPLICATION_TITLE);
        
        instanceId++;
        student = new StudentDetailTable();

        addComponent(new Label(VaadinSpringDemoApplication.APPLICATION_TITLE));
        
        final Button button = new Button("Don't Click");
        button.addListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				button.setCaption("I told you not to click");
				}
		});
        
       
        addComponent(button);
        addComponent(student);
    }

    @PostConstruct
    public void addInstanceLabels() {
        addComponent(new Label("MainWindow instanceId: " + instanceId));
        addComponent(new Label(textLabelService.getInstanceText()));
    }
}
