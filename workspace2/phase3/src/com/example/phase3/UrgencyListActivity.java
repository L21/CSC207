package com.example.phase3;


import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

import com.example.NurseManager.Nurse;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;

import android.content.Intent;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**The Urgency list.*/
public class UrgencyListActivity extends Activity {
	
	/** This is a Nurse*/
	private Nurse nurse;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_urgency_list);
		
		Intent intent = getIntent();
     	nurse = (Nurse) intent.getSerializableExtra("nurse");
     	//use Listview to show information.
     	ListView list = (ListView) findViewById(R.id.ListView01);
     	
     	ArrayList<String> urgency_list = new ArrayList<String>();
     	//get the urgency list.
     	Map<String, ArrayList<String>> list_urgent = nurse.getUrgencyList();
     	
     	//if no one in urgency list, raise it.
     	if (list_urgent.size() == 0) {
     		new AlertDialog.Builder(this)
            .setTitle("sorry")
            .setMessage("No people is in urgency list")
            .setPositiveButton("finish", null)
            .show();
     	} else {
     		//add the urgency people to the arraylist by decreasing urgency score.
     		urgency_list.addAll(list_urgent.get("Urgent"));
     		urgency_list.addAll(list_urgent.get("Less_Urgent"));
     		urgency_list.addAll(list_urgent.get("Non_Urgent"));
     		urgency_list.addAll(list_urgent.get("Not_Urgent"));

     		ArrayList<Map<String, Object>> list_of_patient = new ArrayList<Map<String, Object>>();
     		//use for loop to add all the patient.
     		for (int i =0 ; i < urgency_list.size(); i++) {
     			
     			//get the urgency score.
     			int Urgency_score = nurse.getPatients().get(urgency_list.get(i)).getUrgencyScore();
     			String urgency_score_information = "Urgency Score : " + Urgency_score;
     			String patient_information = nurse.getPatients().get(urgency_list.get(i)).getName() + "," + "Health Card Number:" +
     					urgency_list.get(i) + "," + "Birthday:" + nurse.getPatients().get(urgency_list.get(i)).getDob();
     			HashMap<String, Object> urgency_information = new HashMap<String, Object>();
     			urgency_information.put("urgency_score", urgency_score_information);
     			urgency_information.put("patient_information", patient_information);
     			list_of_patient.add(urgency_information);
     		}

     		//show the information.
     		SimpleAdapter listItemAdapter = new SimpleAdapter(this,list_of_patient, R.layout.activity_urgency_list_help, 
     				new String[] {"urgency_score", "patient_information"}, new int[] {R.id.urgency_score,R.id.patient_information});  
     		list.setAdapter(listItemAdapter);

     	}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.urgency_list, menu);
		return true;
	}

}
