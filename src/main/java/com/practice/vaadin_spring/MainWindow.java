
package com.practice.vaadin_spring;

import com.practice.vaadin_spring.Table.StudentDetailTable;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.ItemClickEvent;
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
    final Button button;
//    private StudentDetailTable student;

    @Autowired
    private TextLabelService textLabelService;

    public MainWindow() {
        super(VaadinSpringDemoApplication.APPLICATION_TITLE);
        
        instanceId++;
//        student = new StudentDetailTable();

        addComponent(new Label(VaadinSpringDemoApplication.APPLICATION_TITLE));
        
        button = new Button("Don't Click");
        button.addListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				button.setCaption("I told you not to click");
				}
		});
        
       
        addComponent(button);
//        addComponent(student);
        
        Table table = createTable1();
		
		addComponent(table);
    }

	private Table createTable1() {
		Table table = new Table();
		setTableProperties(table);
		
		IndexedContainer cont = new IndexedContainer();
		cont.addContainerProperty("property1", String.class, "");
		cont.addContainerProperty("property2", String.class, "");
		cont.addContainerProperty("property3", String.class, "");
		
		for(int i = 0; i < 1000; i++) {
			cont.addItem(i);
			cont.getContainerProperty(i, "property1").setValue("Item "+i);
			cont.getContainerProperty(i, "property2").setValue("Item "+i);
			cont.getContainerProperty(i, "property3").setValue("Item "+i);
		}
		table.setContainerDataSource(cont);
		
		table.addListener(new ItemClickEvent.ItemClickListener() {
			
			@Override
			public void itemClick(ItemClickEvent event) {
				button.setCaption("row got clicked");
			}
		});
		return table;
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
