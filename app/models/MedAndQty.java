package models;

public class MedAndQty {

	private Medicine med;
	
	private Integer qty;
	
	public MedAndQty() {
		//
	}
	
	public MedAndQty(Medicine med, Integer qty) {
		this.med = med;
		this.qty = qty;
	}
	
	public Medicine getMed() {
		return med;
	}

	public void setMed(Medicine med) {
		this.med = med;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

}
