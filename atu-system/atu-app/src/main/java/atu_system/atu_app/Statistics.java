package atu_system.atu_app;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Statistics is the class for creating statistic entries of students' data.
 * It contains the index#, entry(i.e. the name of the kind of statistic) and value of the statistic object.
 * It is important for showing data in the Tableview GUI.
 * 
 * @author cherry
 */
public  class Statistics {
	private final SimpleIntegerProperty index;
	private final SimpleStringProperty entry;
	private final SimpleStringProperty value;

	/** 
	* Class constructor. Set the index, entry and value according to the input parameter.
	* 
	* @param index
	* @param fName
	* @param lName
	*/
	public Statistics(int index, String fName, String lName) {
		this.index = new SimpleIntegerProperty(index);
		this.entry = new SimpleStringProperty(fName);
		this.value = new SimpleStringProperty(lName);
	}

	/** 
	* This method returns the index of this statistic object.
	* @return          the index of this statistic object      
	*/
	public int getIndex() {
		return index.get();
	}

	/** 
	* This method allow user to change the index of this statistic object.
	* @param val      the integer to be changed to
	*/
	public void setIndex(int val) {
		index.set(val);
	}
	
	/** 
	* This method returns the name of this statistic object.
	* @return          the name of this statistic object      
	*/
	public String getEntry() {
		return entry.get();
	}

	/** 
	* This method allow user to change the name of this statistic object.
	* @param val      the name to be changed to
	*/
	public void setEntry(String val) {
		entry.set(val);
	}

	/** 
	* This method returns the value of this statistic object.
	* @return          the value of this statistic object      
	*/                                                                                                                                                                          
	public String getValue() {
		return value.get();
	}

	/** 
	* This method allow user to change the value of this statistic object.
	* @param val      the value to be changed to
	*/
	public void setValue(String val) {
		value.set(val);
	}
}

