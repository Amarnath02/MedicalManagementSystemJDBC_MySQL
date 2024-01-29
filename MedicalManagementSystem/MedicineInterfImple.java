package MedicalManagementSystem;

import java.sql.*;

public class MedicineInterfImple implements MedicineInterface{

    Connection c;
    @Override
    public void AddMedicine(Medicine med) {
        c = DB_connect.createDBConnection();
        String query = "insert into medicine_list values (?,?,?,?)";

        try{
            PreparedStatement p = c.prepareStatement(query);
            p.setInt(1, med.getId());
            p.setString(2, med.getName());
            p.setString(3, med.getDate());
            p.setInt(4, med.getStock());

            int cmt = p.executeUpdate();

            if (cmt != 0){
                System.out.println("Medicine Inserted Successfully !!!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ShowMedicine() {
        c = DB_connect.createDBConnection();
        String query = "select * from medicine_list";
        System.out.println("Medicine Details :");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t%s\t%s\n", "ID", "Name", "Date", "Stock");
        System.out.println("---------------------------------------------");

        try {
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()) {
                System.out.format("%d\t%s\t%s\t%d\n",
                        r.getInt(1),
                        r.getString(2),
                        r.getString(3),
                        r.getInt(4));
                System.out.println("---------------------------------------------");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showAvailableMedicine(int stock) {
        c = DB_connect.createDBConnection();

        String query = "select * from medicine_list where stock > " + stock;

        try{
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()){
                System.out.format("%d\t%s\t%s\t%d\n",
                        r.getInt(1),
                        r.getString(2),
                        r.getString(3),
                        r.getInt(4));
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateStock(int id, int stock) {
        c = DB_connect.createDBConnection();
        String query = "update medicine_list set stock = ? where id = ?";

        try{
            PreparedStatement p = c.prepareStatement(query);
            p.setInt(1, stock);
            p.setInt(2, id);
            int cmt = p.executeUpdate();
            if(cmt != 0)
                System.out.println("Employee Details updated successfully !!");

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteMedicine(int id) {
        c = DB_connect.createDBConnection();
        String query = "delete from medicine_list where id = ?";
        try{
            PreparedStatement p = c.prepareStatement(query);
            p.setInt(1, id);
            int cmt = p.executeUpdate();
            if(cmt != 0)
                System.out.println("Employee Deleted Successfully !!! " + id);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
