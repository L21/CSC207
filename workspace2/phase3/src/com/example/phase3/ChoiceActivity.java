package com.example.phase3;



import com.example.NurseManager.Nurse;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

/** Let nurse to make a choice.*/
public class ChoiceActivity extends Activity {
	
	/** This is a Nurse*/
	private Nurse nurse;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choice);
		Intent intent = getIntent();
     	nurse = (Nurse) intent.getSerializableExtra("nurse");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choice, menu);
		return true;
	}
	
	/**Turns to new patient activity.
	 *@param view Turn to new patient activity.
	 */
	public void addNewPatient(View view) {
	    	//turn to new patient activity
	    	Intent intentN = new Intent(this, NewPatientActivity.class);
	    	intentN.putExtra("nurse", nurse);
	    	startActivity(intentN);
	    }
	
	/**Turns to add vitalsign activity.
	 *@param view Turn to addVitalSign activity.
	 */
	public void addVitalSign(View view) {
	    	//turn to addVitalSign activity
	    	Intent intentE = new Intent(this, AddVitalSignActivity.class);
	    	intentE.putExtra("nurse", nurse);
	    	startActivity(intentE);
	    }
	
	/**Turns to urgency list activity.
	 *@param view Turn to UrgencyList activity.
	 */
	public void UrgencyList(View view) {
	    	//turn to UrgencyList activity
	    	Intent intentA = new Intent(this, UrgencyListActivity.class);
	    	intentA.putExtra("nurse", nurse);
	    	startActivity(intentA);
	    }
	
	/**Turns to check time activity.
	 *@param view Turn to CheckTime activity.
	 */
	public void CheckTime(View view) {
	    	//turn to CheckTime activity
	    	Intent intentE = new Intent(this, CheckTimeActivity.class);
	    	intentE.putExtra("nurse", nurse);
	    	startActivity(intentE);
	    }
	
	/**Turns to view patient record activity.
	 *@param view Turn to ViewPatientRecord activity.
	 */
	public void ViewPatientRecord(View view) {
	    	//turn to ViewPatientRecord activity
	    	Intent intentE = new Intent(this, ViewPatientRecordActivity.class);
	    	intentE.putExtra("nurse", nurse);
	    	startActivity(intentE);
	    }

}
