package com.example.patient_information;

public class test {
	public static void main(String[] args){
		Patient p = new Patient("fushen", 11,11,2012,"1111",11,11,11,11,2013);
		VitalSign v = new VitalSign(40,190,190,190,11,12,01,12,2013);
		p.setUrgencyScore(v.getUrgencyScore());
		System.out.print(p.getUrgencyScore());
	}
}
