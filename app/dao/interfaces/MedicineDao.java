package dao.interfaces;

import java.util.List;

import models.Medicine;

public interface MedicineDao {

	public boolean updateMedicine(Medicine medicine) throws Exception;
	
	public Medicine getMedicineById(String id);

	public List<Medicine> getAllMedicines();

	
}
