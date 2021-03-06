package com.example.patient_information;

import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;

/** A patient. */
public class Patient implements Serializable {

	/**	A unique ID. */
	private static final long serialVersionUID = -8796021443409988654L;

	/** This is Patient's name.*/
	private String name;

	/** This is Patient's birthday. */
	private String dob;

	/** This is Patient's health card number. */
	private String cardnum;

	/** This is Patient's age */
	private int age;

	/** This is Patient's vital signs */
	private Map<String, VitalSign> vitalsigns;

	/** This is Patient's arrive time */
	private String arrivetime;

	/** This is Patient's arrive date */
	private String arrivedate;

	/** This is whether the patient have seen the physician or not */
	private String seen_physician;

	/** This is Patient's description */
	private String description;

	/** This is Patient's urgencyScore */
	private int urgencyScore;

	/** Constructs a person with his birthday, health card number,arrive time. 
	 * @param name The name of Patient.
	 * @param day The day of Patient birth.
	 * @param month The month of Patient birth.
	 * @param year The year of Patient birth.
	 * @param cardnum The health card number of Patient. 
	 * @param arrivehour The arrive hour of Patient.
	 * @param arrivemin The arrive minute of Patient.
	 * @param arriveday The arrive day of Patient. 
	 * @param arrivemonth The arrive month of Patient.
	 * @param arriveyear The arrive year of Patient.
	 */
	public Patient(String name, int day, int month, int year, String cardnum,
			int arrivehour, int arrivemin, int arriveday, int arrivemonth,
			int arriveyear) {
		this.name = name;
		this.dob = String.valueOf(day) + "/" +  String.valueOf(month) + "/"
				+ String.valueOf(year);
		this.cardnum = cardnum;
		this.age = 2013 - year;
		this.vitalsigns = new HashMap<String, VitalSign>();
		this.arrivetime = String.valueOf(arrivehour) + ":" + String.valueOf(arrivemin);
		this.arrivedate = String.valueOf(arriveday) + "/" + String.valueOf(arrivemonth) + "/" + 
		String.valueOf(arriveyear); 
		this.vitalsigns = new HashMap<String, VitalSign>();
		this.seen_physician = "Haven't seen physician yet";
		this.description = "No Description";
		this.urgencyScore = 0;
	}

	/** Returns this Patient's name.
	 * @return The name of Patient.
	 */
	public String getName() {
		return this.name;
	}

	/** Returns this patient's urgencyScore.
	 * @return The urgencyScore of Patient.
	 */
	public int getUrgencyScore() {
		return this.urgencyScore;
	}

	/**
	 * Sets this patient's urgencyScore.
	 * @param num The patient's urgencyScore.
	 */
	public void setUrgencyScore(int num) {
		if (this.age < 2) {
			this.urgencyScore = num + 1;
		} else {
			this.urgencyScore = num;
		}
	}

	/** Returns the description of the Patient.
	 * @return the description of Patient.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets this patient's description.
	 * @param string The patient's description.
	 */
	public void setDescription(String string) {
		this.description = string;
	}

	/** Returns whether this patient have seen the physician or not.
	 * @return whether this patient have seen the physician or not.
	 */
	public String getSeen_physician() {
		return this.seen_physician;
	}

	/**
	 * Sets whether this patient have seen the physician or not.
	 * @param string whether this patient have seen the physician or not.
	 */
	public void setSeen_physician(String string) {
		this.seen_physician = string;
	}

	/** Returns this Patient's birthday. 
	 * @return the birthday of Patient.
	 */
	public String getDob() {
		return this.dob;
	}

	/** Returns this Patient's health card number.
	 * @return this Patient's health card number.
	 */
	public String getID() {
		return this.cardnum;
	}

	/** Returns the age of the Patient.
	 * @return the age of Patient.
	 */
	public int getAge() {
		return this.age;
	}

	/** Returns the arrive time of the Patient.
	 * @return the arrive time of the Patient.
	 */
	public String getArriveTime() {
		return this.arrivedate + "," + this.arrivetime;
	}

	/** Adds the vital sign to the patient
	 * @param vitalsign the vital sign want to add to patient's record.
	 */
	public void addVitalsigns(VitalSign vitalsign) {
		vitalsigns.put(vitalsign.getTime(), vitalsign);
	}

	/** Returns this patient's vital signs.
	 * @return this patients' vital signs.
	 */
	public Map<String, VitalSign> getVitalsigns() {
		return vitalsigns;
	}

	/** Returns A string representation of this Patient.
	 * @return A string representation of this Patient. 
	 */
	public String toString() {
		String patientString = name + ","  + dob + "," + cardnum + "," + arrivedate + 
				"," + arrivetime + "," + this.seen_physician  + "," + this.description + 
				"," + String.valueOf(this.urgencyScore);
		for (VitalSign vitalsign: vitalsigns.values()){
			patientString += "," + vitalsign.toString();
		}
		return patientString;		
	}		
}
