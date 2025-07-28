import entity.Customer;
import entity.Vehicle;
import service.BillingService;
import service.VehicleService;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {
        Scanner sc =new Scanner(System.in);
        BillingService service=new BillingService();

        while (true)
        {
            System.out.println("1. Add Customer with Vehicle \n2. Generate Invoice\n3. Show Invoice\n4. Exit");
            int ch=sc.nextInt();
            switch (ch)
            {
                case 1:
                    System.out.print("Customer name: ");
                    String name = sc.next();
                    System.out.print("Phone: ");
                    String phone = sc.next();

                    // Add customer (auto ID set inside)
                    Customer customer = new Customer(name, phone);
                    service.customerService.addCustomer(customer); // this sets customer.setId()

                    System.out.print("Enter Vehicle number: ");
                    String vehicleNum = sc.next();
                    System.out.print("Enter Vehicle model: ");
                    String model = sc.next();

                    // Now add vehicle using customer.getId()
                    service.vehicleService.addVehicle(
                            new Vehicle(vehicleNum, model, customer.getId())
                    );

                    System.out.println("✅ Customer and Vehicle saved with Customer ID: " + customer.getId());
                    break;

                case 2:
                    System.out.print("Enter customer ID:");
                    int cid=sc.nextInt();
                    System.out.print("Enter vehicle Id:");
                    int vid = sc.nextInt();
                    System.out.println("Enter number of services:");
                    int n = sc.nextInt();
                    List<Integer> sids=new ArrayList<>();
                    for(int i=0;i<n;i++)
                    {
                        System.out.println("enter the service id:");
                        sids.add(sc.nextInt());
                    }
                    service.createInvoice(cid,vid,sids);
                    break;
                case 3:
                    service.showAllInvoices();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Not a valid choice");
                    break;
            }
        }
    }
}