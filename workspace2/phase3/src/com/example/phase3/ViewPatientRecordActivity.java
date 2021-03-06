package com.example.phase3;

import com.example.NurseManager.Nurse;
import com.example.NurseManager.Physician;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

/** View Patient Record */
public class ViewPatientRecordActivity extends Activity {
	
	/** This is a Nurse*/
	private Nurse nurse;
	
	/** This is a Physician*/
	private Physician physician;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_patient_record);
		Intent intent = getIntent();
		nurse = (Nurse) intent.getSerializableExtra("nurse");
		physician = (Physician) intent.getSerializableExtra("physician");
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_patient_record, menu);
		return true;
	}
	
	/**Uses the health card number to view a patient's data.
	 * @param view
	 */
	public void ViewRecord(View view) {
		EditText cardnumberText = (EditText) findViewById(R.id.HCcard);
		String cardnumber = cardnumberText.getText().toString().trim();
		//raise invalid information exception
		if (cardnumber.equals("")) {
			new AlertDialog.Builder(this)
			.setTitle("sorry")
			.setMessage("invalid information entered")
			.setPositiveButton("try again", null)
			.show();
		} else {

			//if the data is viewed by the physician.
			if (nurse == null) {
				//if the patient exists.
				if (physician.cotainsPatient(cardnumber)) {
					Intent intentE = new Intent(this, PatientRecordActivity.class);
					intentE.putExtra("physician", physician);
					intentE.putExtra("HCcard", cardnumber);
					startActivity(intentE);
				} else {
					new AlertDialog.Builder(this)
					.setTitle("sorry")
					.setMessage("patient doesn't exist")
					.setPositiveButton("try again", null)
					.show();
				}
				//if the data is viewed by the nurse.
			} else {
				if (nurse.cotainsPatient(cardnumber)) {
					Intent intentE = new Intent(this, PatientRecordActivity.class);
					intentE.putExtra("nurse", nurse);
					intentE.putExtra("HCcard", cardnumber);
					startActivity(intentE);
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
}
