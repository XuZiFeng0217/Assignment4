package Business;

import Business.Customer.Customer;
import Business.Customer.CustomerDirectory;
import Business.DeliveryMan.DeliveryMan;
import Business.DeliveryMan.DeliveryManDirectory;
import Business.Employee.Employee;
import Business.Order.Order;
import Business.Restaurant.Product;
import Business.Restaurant.Restaurant;
import Business.Restaurant.RestaurantDirectory;
import Business.Role.AdminRole;
import Business.Role.CustomerRole;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        List<Order> orders = new ArrayList<>();
        system.setOrderDirectory(orders);
        
        //设置管理员账户
        Employee employee = system.getEmployeeDirectory().createEmployee("RRH");
        UserAccount uaAdmin = system.getUserAccountDirectory().createUserAccount("a1", "123", employee, new SystemAdminRole());
        
        //设置customer账户
        UserAccount uaCustomer1 = system.getUserAccountDirectory().createUserAccount("c1", "123", new CustomerRole());
        UserAccount uaCustomer2 = system.getUserAccountDirectory().createUserAccount("c2", "123", new CustomerRole());
        
        //设置餐厅经理账户
        UserAccount restaurant1 = system.getUserAccountDirectory().createUserAccount("r1", "123", new AdminRole());
        
        //初始化customer数据
        Customer c1 = new Customer(1,"Jack","Smith");
        Customer c2 = new Customer(2,"Jack","Smith");
        Customer c3 = new Customer(3,"Jack","Smith");
        CustomerDirectory customers = new CustomerDirectory();
        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(c1);
        customerList.add(c2);
        customerList.add(c3);
        customers.setCustomerList(customerList);
        system.setCustomerDirectory(customers);
        
        //初始化DeliveryMan数据
        DeliveryMan man1 = new DeliveryMan(1,"Jack","Smith");
        DeliveryMan man2 = new DeliveryMan(2,"lily","kally");
        DeliveryMan man3 = new DeliveryMan(3,"mary","wood");
        DeliveryManDirectory deliveryManDirectory = new DeliveryManDirectory();
        List<DeliveryMan> deliveryManList = new ArrayList<DeliveryMan>();
        deliveryManList.add(man1);
        deliveryManList.add(man2);
        deliveryManList.add(man3);
        deliveryManDirectory.setDeliveryManList(deliveryManList);
        system.setDeliveryManDirectory(deliveryManDirectory);
        
        //初始化Product数据
        Product p1 = new Product(1,"fish","very good",15.7);
        Product p2 = new Product(2,"meat","red",35.7);
        Product p3 = new Product(3,"vegetable","green",25.0);
        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        
        
        //初始化Restaurant数据
        Restaurant r1 = new Restaurant("r1","ss","jack");
        Restaurant r2 = new Restaurant("r2","ss","mary");
        Restaurant r3 = new Restaurant("r3","ss","smith");
        r1.setProductList(products);
        RestaurantDirectory restaurantDirectory = new RestaurantDirectory();
        List<Restaurant> restaurantManList = new ArrayList<Restaurant>();
        restaurantManList.add(r1);
        restaurantManList.add(r2);
        restaurantManList.add(r3);
        restaurantDirectory.setRestaurantList(restaurantManList);
        system.setRestaurantDirectory(restaurantDirectory);
        
       
        

        
        //初始化Restaurant下的Product
        r1.setProductList(products);
        
        uaAdmin.setRole(new SystemAdminRole());
        uaCustomer1.setRole(new CustomerRole());
        uaCustomer2.setRole(new CustomerRole());
        restaurant1.setRole(new AdminRole());
        return system;
    }
    
}
