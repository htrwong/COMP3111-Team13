package atu_system.atu_app;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public  class Statistics {
	private final SimpleIntegerProperty index;
	private final SimpleStringProperty entry;
	private final SimpleStringProperty value;

	public Statistics(int index, String fName, String lName) {
		this.index = new SimpleIntegerProperty(index);
		this.entry = new SimpleStringProperty(fName);
		this.value = new SimpleStringProperty(lName);
	}

	public int getIndex() {
		return index.get();
	}

	public void setIndex(int val) {
		index.set(val);
	}
	
	public String getEntry() {
		return entry.get();
	}

	public void setEntry(String val) {
		entry.set(val);
	}

	public String getValue() {
		return value.get();
	}

	public void setValue(String val) {
		value.set(val);
	}
}

