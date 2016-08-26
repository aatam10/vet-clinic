package serenitylabs.tutorials.vetclinic.domain;

public class ComplainRegister {

	private static String complaint1;

	public static void recordComplaint(String complaint) {
		// TODO Auto-generated method stub
		complaint1 = complaint;
		
	}

	public String getComplaints() {
		// TODO Auto-generated method stub
		return complaint1;
	}

}
