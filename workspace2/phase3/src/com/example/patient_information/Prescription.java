package com.example.patient_information;


/** A Prescription. */
public class Prescription {
	
	/** This is medication.*/
	private String medication;
	
	/** This is instruction.*/
	private String instruction;
	
	/** Constructs a Prescription with medication, instruction. 
	 * @param medication The medication given by physician.
	 * @param instruction The instruction of given by physician.
	 */
	public Prescription(String medication, String instruction) {
		this.medication = medication;
		this.instruction = instruction;
	}
	
	/** Returns the medication given by physician.
	 * @return the medication given by physician.
	 */
	public String getMedication() {
		return medication;
	}
	
	/**
     * Sets the context of this medication.
     * @param medication The medication given by physician.
     */
	public void setMedication(String medication) {
		this.medication = medication;
	}
	
	/** Returns the Instruction given by physician.
	 * @return the Instruction given by physician.
	 */
	public String getInstruction() {
		return instruction;
	}
	
	/**
     * Sets the context of this instruction.
     * @param medication The instruction given by physician.
     */
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	
	@Override
	/**
	 * Returns a String representation of this Prescription.
	 */
	public String toString() {
		return "Medication:" + medication + ";" + "Instruction:" + instruction;
	}

}
