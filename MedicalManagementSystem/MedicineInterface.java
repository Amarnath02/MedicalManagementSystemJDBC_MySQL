package MedicalManagementSystem;

public interface MedicineInterface {
    public void AddMedicine(Medicine med);
    public void ShowMedicine();
    public void showAvailableMedicine(int stock);
    public void updateStock(int id, int stock);
    public void deleteMedicine(int id);

}
