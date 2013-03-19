package com.practice.vaadin_spring.Table;

import com.vaadin.ui.Table;

public class StudentDetailTable extends Table{
	
	public StudentDetailTable() {
//		removeAllItems();
		rebuild();
	}

	private void rebuild() {
		Table table = new Table("This is a new Table");
		
		table.setSizeFull();
		table.setImmediate(true);
	/*	table.addContainerProperty("First Name", String.class, null);
		
		table.addItem(new Object[] {"Ben"});*/
		
		/* Define the names and data types of columns.
		 * The "default value" parameter is meaningless here. */
		
		table.addContainerProperty("First Name", String.class,  null);
		table.addContainerProperty("Last Name",  String.class,  null);
		table.addContainerProperty("Year",       Integer.class, null);

		/* Add a few items in the table. */
		table.addItem(new Object[] {
		    "Nicolaus","Copernicus",new Integer(1473)}, new Integer(1));
		table.addItem(new Object[] {
		    "Tycho",   "Brahe",     new Integer(1546)}, new Integer(2));
		table.addItem(new Object[] {
		    "Giordano","Bruno",     new Integer(1548)}, new Integer(3));
		table.addItem(new Object[] {
		    "Galileo", "Galilei",   new Integer(1564)}, new Integer(4));
		table.addItem(new Object[] {
		    "Johannes","Kepler",    new Integer(1571)}, new Integer(5));
		table.addItem(new Object[] {
		    "Isaac",   "Newton",    new Integer(1643)}, new Integer(6));
		
		System.out.println("I got upto here``````````````````````````````````");
	}
	
	
	
}
