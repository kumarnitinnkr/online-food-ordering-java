package food.util;

import food.operations.OrderOperations;

public class BillUtil {

    // this is tax percentage (can be modified)
    private static final double TAX_RATE = 5.0; // 5%


    // this method to calculate total bill (without tax)
    public static double calculateTotal(OrderOperations[] orders, int count) {

        double total = 0;

        for (int i = 0; i < count; i++) {
            if (orders[i] != null) {
                total += orders[i].calculateBill();
            }
        }

        return total;
    }


    // this method is used to calculate tax amount
    public static double calculateTax(double amount) {
        return (amount * TAX_RATE) / 100;
    }



    // this method is used to calculate final amount with tax
    public static double calculateFinalAmount(double amount) {
        return amount + calculateTax(amount);
    }


    // this method is used for print formatted bill
    public static void printBill(double subtotal) {

        double tax = calculateTax(subtotal);
        double finalAmount = calculateFinalAmount(subtotal);
        System.out.println("\n========= BILL SUMMARY =========");
        System.out.println("Subtotal      : " + subtotal);
        System.out.println("Tax (" + TAX_RATE + "%) : " + tax);
        System.out.println("---------------------------------");
        System.out.println("Total Amount  : " + finalAmount);
        System.out.println("=================================");
    }
} 