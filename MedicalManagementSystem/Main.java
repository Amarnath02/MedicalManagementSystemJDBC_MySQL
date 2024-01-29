package MedicalManagementSystem;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int id;
        String name;
        String date;
        int stock;

        MedicineInterface m = new MedicineInterfImple();

        Scanner in = new Scanner(System.in);
        do{
            System.out.println("\n1. Add the new medicine");
            System.out.println("2. Show the medicine");
            System.out.println("3. Show the available medicine");
            System.out.println("4. Update the medicine");
            System.out.println("5. Delete the medicine");
            System.out.println("6. Exit");

            System.out.println("\nEnter the choice : ");
            int ch = in.nextInt();
            switch (ch){
                case 1:
                    Medicine med = new Medicine();
                    System.out.println("Enter ID : ");
                    id=in.nextInt();
                    System.out.println("Enter name ");
                    name=in.next();
                    System.out.println("Enter date ");
                    date = in.next();
                    System.out.println("Enter stock");
                    stock = in.nextInt();

                    med.setId(id);
                    med.setName(name);
                    med.setDate(date);
                    med.setStock(stock);
                    m.AddMedicine(med);
                    break;

                case 2:
                    m.ShowMedicine();
                    break;

                case 3:
                    System.out.println("Enter id to show the details ");
                    int med_id1 = in.nextInt();
                    m.showAvailableMedicine(med_id1);
                    break;
                case 4:
                    System.out.println("Enter id to update the details");
                    int med_id2 = in.nextInt();
                    System.out.println("Enter the new stock");
                    stock = in.nextInt();
                    m.updateStock(med_id2, stock);
                    break;
                case 5:
                    System.out.println("Enter the id to delete");
                    id = in.nextInt();
                    m.deleteMedicine(id);
                    break;
                case 6:
                    System.out.println("Thank you for using our Application !!!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        while (true);
    }
}
