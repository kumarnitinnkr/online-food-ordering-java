package food.main;
import food.item.*;
import food.operations.OrderOperations;
import food.util.BillUtil;
import food.exceptions.InvalidOrderException;
import java.util.Scanner;


public class FoodApp {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodItem[] items = new FoodItem[10];
        int itemCount = 0;
        int choice;
// using do while loop.
        do {
            System.out.println("\n===== ONLINE FOOD ORDERING SYSTEM =====");
            System.out.println("1. Add Food Item");
            System.out.println("2. View Menu");
            System.out.println("3. Place Order");
            System.out.println("4. Cancel Order");
            System.out.println("5. Generate Bill");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                // 1 add the food item .
                case 1:
                    if (itemCount >= items.length) {
                        System.out.println("Menu is full!");
                        break;
                    }

                    System.out.println("1. Veg Item");
                    System.out.println("2. Non-Veg Item");
                    System.out.print("Select Type: ");
                    int type = sc.nextInt();

                    if (type == 1) {
                        VegItem veg = new VegItem();
                        veg.accept();
                        items[itemCount++] = veg;
                        System.out.println("Veg Item Added Successfully!");
                    } 
                    else if (type == 2) {
                        NonVegItem nonVeg = new NonVegItem();
                        nonVeg.accept();
                        items[itemCount++] = nonVeg;
                        System.out.println("Non-Veg Item Added Successfully!");
                    } 
                    else {
                        System.out.println("Invalid Type Selection!");
                    }
                    break;

                // 2 view the menu 
                case 2:
                    if (itemCount == 0) {
                        System.out.println("No items available.");
                    } else {
                        for (int i = 0; i < itemCount; i++) {
                            System.out.println("\nItem Index: " + i);
                            items[i].display();  // Polymorphism
                        }
                    }
                    break;

                // 3 placed the order 
                case 3:
                    try {
                        System.out.print("Enter Item Index to Order: ");
                        int index = sc.nextInt();

                        if (index < 0 || index >= itemCount) {
                            throw new InvalidOrderException("Invalid Item Selection!");
                        }

                        if (!(items[index] instanceof OrderOperations)) {
                            throw new InvalidOrderException("Item cannot be ordered!");
                        }

                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();

                        OrderOperations order = (OrderOperations) items[index];
                        order.placeOrder(qty);

                    } catch (InvalidOrderException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                // 4 cancelled the order
                case 4:
                    System.out.print("Enter Item Index to Cancel Order: ");
                    int cancelIndex = sc.nextInt();

                    if (cancelIndex >= 0 && cancelIndex < itemCount
                            && items[cancelIndex] instanceof OrderOperations) {

                        OrderOperations order = (OrderOperations) items[cancelIndex];
                        order.cancelOrder();
                    } else {
                        System.out.println("Invalid Item Selection!");
                    }
                    break;

                // 5  this case is used for generate the bill amount.
                case 5:

                    OrderOperations[] orders = new OrderOperations[itemCount];

                    for (int i = 0; i < itemCount; i++) {
                        if (items[i] instanceof OrderOperations) {
                            orders[i] = (OrderOperations) items[i];
                        }
                    }

                    double subtotal = BillUtil.calculateTotal(orders, itemCount);

                    if (subtotal == 0) {
                        System.out.println("No orders placed.");
                        break;
                    }

                    BillUtil.printBill(subtotal);

                    System.out.print("Enter Payment Amount: ");
                    double payment = sc.nextDouble();

                    double finalAmount = BillUtil.calculateFinalAmount(subtotal);

                    if (payment < finalAmount) {
                        System.out.println("Payment less than bill amount!");
                    } else {
                        System.out.println("Payment Successful!");
                        System.out.println("Change: " + (payment - finalAmount));
                    }
                    break;

                // 6  this case is for  exit 
                case 6:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}