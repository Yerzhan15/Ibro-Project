package models;

import play.*;
import play.mvc.*;
import play.Logger;

public class Medicine {

	private Integer idMedicine;
	
	private String nameMedicine;
	
	private Double cost;
	
	private String Description;

	private String Ingredients;

	private String Warnings;

	private Integer count;

	
	public Medicine() {
		//
	}
	
	public Medicine(Integer idMedicine, String nameMedicine, Double cost, String Description, String Ingredients, String Warnings, Integer count) {
		this.idMedicine = idMedicine;
		this.nameMedicine = nameMedicine;
		this.cost = cost;
		this.Description = Description;
		this.Ingredients = Ingredients;
		this.Warnings = Warnings;
		this.count = count;
	}
	
/*	public Cat(CatEntity catEntity) {
		this.id = catEntity.getId();
		this.name = catEntity.getName();
		this.email = catEntity.getEmail();
		this.password = catEntity.getPassword();
	}
*/	
	public Integer getIdMedicine() {
		return idMedicine;
	}

	public void setIdMedicine(Integer id) {
		this.idMedicine = id;
	}


	public String getNameMedicine() {
		return nameMedicine;
	}

	public void setNameMedicine(String nameMedicine) {
		this.nameMedicine = nameMedicine;
	}

	public Double getCost() {
		return cost;
	}                                  

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
	public String getIngredients() {
		return Ingredients;
	}

	public void setIngredients(String Ingredients) {
		this.Ingredients = Ingredients;
	}

	public String getWarnings() {
		return Warnings;
	}

	public void setWarnings(String Warnings) {
		this.Warnings = Warnings;
	}
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
