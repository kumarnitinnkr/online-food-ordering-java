package food.item;

import java.util.Scanner;

public class FoodItem {

    // Encapsulation - for hiding the data and show only necessary data to outside the world.

    private int itemId;
    private String itemName;
    private double price;

    // Default Constructor which has no parameters.
    public FoodItem() {
    }


    // this is a parametrized constructor .
    public FoodItem(int itemId, String itemName, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
    }


    //here we use the get () method for retrieving the data.
    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }


    // Here we use the Setter Method to modify the details.
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    // Here we use the accept() method to accept the food item details.
    public void accept() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Item ID: ");
        this.itemId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Item Name: ");
        this.itemName = sc.nextLine();

        System.out.print("Enter Price: ");
        this.price = sc.nextDouble();
    }
    

    // Here we display the food item details with the help of display() method.
    public void display() {
        System.out.println("Item ID   : " + itemId);
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : " + price);
    }
}