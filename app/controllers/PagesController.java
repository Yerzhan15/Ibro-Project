package controllers;

import java.util.*;
import play.Logger;

import dao.interfaces.MedicineDao;

import models.*;

import play.mvc.Before;
import play.mvc.Controller;

public class PagesController extends Controller {

	public static List<MedAndQty> orders = new ArrayList<MedAndQty>();
	public static List<Medicine> storedMedicines = new ArrayList<Medicine>();
	public static Boolean loaded = false;
	public static Boolean done = false;
	public static Double sum = 0.0;
	

    public static void mainPage() {
		
		List<Medicine> medicines = Application.medicineDao.getAllMedicines();
			

		if(!loaded) {
			storedMedicines = medicines;
			loaded = true;
		}
	
		List<MedAndQty> orders2 = new ArrayList<MedAndQty>();
		orders2 = orders;
		
		Double a = sum;
		
		String error1 = flash.get("error1");
		String error2 = flash.get("error2");
		render(error1, error2, a, medicines, orders2);
    }

    public static void cancel() {

    	if(!done) {
    	for(int i = 0; i < storedMedicines.size(); i++) {
    		Medicine med = storedMedicines.get(i);
    		try {
    			Application.medicineDao.updateMedicine(med);
    		} catch(Exception e) {
    			flash.put("error1", e);
    		}
    	}
    	}
    	loaded = false;
    	done = false;
    	sum = 0.0;
    	orders.clear();
    	mainPage();
    }

    public static void orderPage() {
		List<MedAndQty> orders2 = new ArrayList<MedAndQty>();
		orders2 = orders;
		Double sum2 = sum;
		Boolean done2 = done;

    	render(done2, sum2, orders2);
    }

    public static void order(String firstName, String secondName, String email, String phoneNumber, String address) {
    	done = true;
    	orderPage();
    }
    
 
}
