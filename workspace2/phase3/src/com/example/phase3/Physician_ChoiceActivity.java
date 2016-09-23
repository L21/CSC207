package com.example.phase3;


import com.example.NurseManager.Physician;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

/** let physician to make a choice.*/
public class Physician_ChoiceActivity extends Activity {
	
	/** This is a Physician*/
	private Physician physician;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_physician__choice);
		Intent intent = getIntent();
		physician = (Physician) intent.getSerializableExtra("physician");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.physician__choice, menu);
		return true;
	}
	
	/**
	 * Chooses to view the patient record.
	 * @param view turn to view patient record activity.
	 */
	public void ViewPatientRecord(View view) {
    	//turn to view patient record activity.
    	Intent intentN = new Intent(this, ViewPatientRecordActivity.class);
    	intentN.putExtra("physician", physician);
    	startActivity(intentN);
    }
    
   
    
    /**
     * Chooses to add prescription to the patient record.
     * @param view turn to addPrescription activity.
     */
	public void AddPrescription(View view) {
    	//turn to addPrescription activity
    	Intent intentE = new Intent(this, AddPrescriptionActivity.class);
    	intentE.putExtra("physician", physician);
    	startActivity(intentE);
    }

}
