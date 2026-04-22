package food.item;

import food.operations.OrderOperations;
import food.exceptions.InvalidOrderException;

public class NonVegItem extends FoodItem implements OrderOperations {


    private String spiceLevel;                  // Low / Medium / High
    private int quantity;
    private boolean orderPlaced;

    // Default Constructor
    public NonVegItem() {
        super();
    }

    // this is a  parameterized Constructor
    public NonVegItem(int itemId, String itemName, double price, String spiceLevel) {
        super(itemId, itemName, price);
        this.spiceLevel = spiceLevel;
    }

    // Getter and Setter for retrieving and modifying data.
    public String getSpiceLevel() {
        return spiceLevel;
    }

    public void setSpiceLevel(String spiceLevel) {
        this.spiceLevel = spiceLevel;
    }

    // here we accept Non-Veg Item Details
    @Override
    public void accept() {
        super.accept();
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter Spice Level (Low/Medium/High): ");
        this.spiceLevel = sc.nextLine();
    }

    // Overriding display() method (Polymorphism)
    @Override
    public void display() {
        super.display();
        System.out.println("Spice Level : " + spiceLevel);
    }

    // Interface Method for  Place Order
    @Override
    public void placeOrder(int quantity) throws InvalidOrderException {

        if (quantity <= 0) {
            throw new InvalidOrderException("Quantity cannot be zero or negative!");
        }

        this.quantity = quantity;
        orderPlaced = true;
        System.out.println("Non-Veg Order Placed Successfully!");
    }

    // Interface Method for Cancel Order
    @Override
    public void cancelOrder() {
        if (orderPlaced) {
            orderPlaced = false;
            quantity = 0;
            System.out.println("Non-Veg Order Cancelled Successfully!");
        } else {
            System.out.println("No Non-Veg order to cancel.");
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