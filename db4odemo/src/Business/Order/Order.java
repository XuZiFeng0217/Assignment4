/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Customer.Customer;
import Business.DeliveryMan.DeliveryMan;
import Business.Restaurant.Product;
import Business.Restaurant.Restaurant;
import Business.UserAccount.UserAccount;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zzz
 */
public class Order {
    
    private Restaurant restaurant;
    private DeliveryMan deliveryMan;
    private List<Map<Product,Integer>> products;
    private UserAccount customer;
    private double total;
    //1.待接单 2.已接单待配送 3.已完成
    private int status;
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public List<Map<Product,Integer>> getProducts() {
        return products;
    }

    public void setProducts(List<Map<Product,Integer>> products) {
        this.products = products;
    }

    public UserAccount getCustomer() {
        return customer;
    }

    public void setCustomer(UserAccount customer) {
        this.customer = customer;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.getRestaurant().getName();
    }
    
    
    
    
    
    
    
}
