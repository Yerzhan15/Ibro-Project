package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Medicine")
public class MedicineEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, name="idMedicine")
	private Integer idMedicine;

	@Column(name="NameMedicine")	
	private String nameMedicine;

	@Column(name="Cost")	
	private Double cost;

	@Column(name="Description")	
	private String Description;

	@Column(name="Ingredients")
	private String Ingredients;

	@Column(name="Warnings")
	private String Warnings;

	@Column(name="Count")
	private Integer count;

	
	public MedicineEntity() {
		//
	}
	
	public MedicineEntity(Medicine med) {
		this.idMedicine = med.getIdMedicine();
		this.nameMedicine = med.getNameMedicine();
		this.cost = med.getCost();
		this.Description = med.getDescription();
		this.Ingredients = med.getIngredients();
		this.Warnings = med.getWarnings();
		this.count = med.getCount();
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
