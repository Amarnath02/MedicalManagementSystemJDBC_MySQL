package MedicalManagementSystem;

import java.util.Date;

public class Medicine {

    private int id;
    private String name;
    private String date;
    private int stock;

    public Medicine(){

    }

    public Medicine(int id, String name, String date, int stock) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", stock=" + stock +
                '}';
    }
}
