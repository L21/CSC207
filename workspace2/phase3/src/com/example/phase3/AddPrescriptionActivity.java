package com.example.phase3;

import java.io.File;
import java.io.FileNotFoundException;

import com.example.NurseManager.Physician;
import com.example.patient_information.Patient;
import com.example.patient_information.Prescription;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

/**Add the prescription.*/
public class AddPrescriptionActivity extends Activity {
	
	/** This is a Physician*/
	private Physician physician;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_prescription);
		Intent intent = getIntent();
		physician = (Physician) intent.getSerializableExtra("physician");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_prescription, menu);
		return true;
	}
	
	/** Adds the prescription.
	 * @param view
	 * @throws FileNotFoundException if File not exists.
	 */
	public void AddPrescription(View view) throws FileNotFoundException {
		EditText healthcardnumberText = (EditText) findViewById(R.id.cardnum);
		String healthcardnumber = healthcardnumberText.getText().toString().trim();
		
		EditText medicationText = (EditText) findViewById(R.id.medication);
		String medication = medicationText.getText().toString().trim();
		
		EditText instructionText = (EditText) findViewById(R.id.instruction1);
		String instruction = instructionText.getText().toString().trim();
		
		if (healthcardnumber.equals("") || medication.equals("") || instruction.equals("")) {
			new AlertDialog.Builder(this)
            .setTitle("sorry")
            .setMessage("invalid information entered")
            .setPositiveButton("try again", null)
            .show();
		} else {
			
			File file = new File(this.getApplicationContext().getFilesDir(), "patient.txt");
    	    String filepath = file.toString();
    	    physician.readFromFile(filepath);
    	    
    	    if (physician.cotainsPatient(healthcardnumber)) {
    	    	//get the patient by his ID.
    	    	Patient patient = physician.getPatients().get(healthcardnumber);
    	    	
    	    	Prescription prescription = new Prescription(medication, instruction);
    	    	String prescriptionString = prescription.toString();
    	    	
    	    	if (patient.getDescription().equals("No Description")) {
    	    		physician.addPrescription(patient, prescriptionString, filepath);
    	    		
    	    		new AlertDialog.Builder(this)
		            .setTitle("Good")
		            .setMessage("Prescription add successfully")
		            .setPositiveButton("finish", null)
		            .show();
					
					Intent intentC = new Intent(this,Physician_ChoiceActivity.class);
	    		    intentC.putExtra("physician", physician);
	    		    startActivity(intentC);
	    		    //if the patient have already seen by physician.
    	    	} else {
    	    		new AlertDialog.Builder(this)
		            .setTitle("sorry")
		            .setMessage("patient has already add prescription")
		            .setPositiveButton("try again", null)
		            .show();
    	    	}
    	    		
    	    	//if patient not exists.
    	    } else {
    	    	new AlertDialog.Builder(this)
    	    	.setTitle("sorry")
    	    	.setMessage("patient doesn't exist")
    	    	.setPositiveButton("try again", null)
    	    	.show();
    	    }
		}
		
	}

}
