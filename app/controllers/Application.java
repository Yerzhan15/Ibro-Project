package controllers;

import play.*;
import play.mvc.*;
import play.Logger;

import java.util.*;

import dao.impl.MedicineDaoJDBC;
import dao.interfaces.MedicineDao;

import models.*;


public class Application extends Controller {

	public static MedicineDao medicineDao = new MedicineDaoJDBC(); 

    public static void registrationPage() {
    	String error = flash.get("error");
    	render(error);
    }
    
    public static void buy(Integer id, Integer qty) {
        Medicine med = medicineDao.getMedicineById(String.valueOf(id));
        
        if(qty <= 0) {
            flash.put("error1", "Invalid quantity!");
            PagesController.mainPage();
        }

        Integer cnt = med.getCount();
        if(qty <= cnt) {
            med.setCount(cnt - qty);
            try {
               medicineDao.updateMedicine(med);
            }
            catch (Exception e){
                flash.put("error1", e);
                PagesController.mainPage();
            }
        }                                  	
        else {
            flash.put("error2", "Sorry, the amount of medicine is limited!");
            PagesController.mainPage();
        }

        flash.put("error1", null);
        flash.put("error2", null);

        PagesController.sum += med.getCost() * qty;
        PagesController.orders.add(new MedAndQty(med, qty));

        PagesController.mainPage();
    }

    public static void checkOut() {
          PagesController.orderPage();
    }

}

