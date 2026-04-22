package food.item;

import food.operations.OrderOperations;
import food.exceptions.InvalidOrderException;

public class VegItem extends FoodItem implements OrderOperations {

    // Starter / Main Course  -------------this  is private data 
    private String category;
    private int quantity;
    private boolean orderPlaced;

    // Default Constructor
    public VegItem() {
        super();
    }

    // this is a parameterized Constructor
    public VegItem(int itemId, String itemName, double price, String category) {
        super(itemId, itemName, price);
        this.category = category;
    }

    // Getter & Setter for retrieving and modifying data.
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Here we accept Veg Item Details
    @Override
    public void accept() {
        super.accept();
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter Category (Starter/Main Course): ");
        this.category = sc.nextLine();
    }

    // this is Overriding display() method (Polymorphism)
    @Override
    public void display() {
        super.display();
        System.out.println("Category  : " + category);
    }

    // Interface Method  for Place Order
    @Override
    public void placeOrder(int quantity) throws InvalidOrderException {

        if (quantity <= 0) {
            throw new InvalidOrderException("Quantity cannot be zero or negative!");
        }

        this.quantity = quantity;
        orderPlaced = true;
        System.out.println("Veg Order Placed Successfully!");
    }

    // Interface Method for Cancel Order
    @Override
    public void cancelOrder() {
        if (orderPlaced) {
            orderPlaced = false;
            quantity = 0;
            System.out.println("Veg Order Cancelled Successfully!");
        } else {
            System.out.println("No Veg order to cancel.");
        }
    }

    // Interface Method for Calculate Bill
    @Override
    public double calculateBill() {
        if (orderPlaced) {
            return getPrice() * quantity;
        } else {
            return 0;
        }
    }
}