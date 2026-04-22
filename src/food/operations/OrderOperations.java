package food.operations;

import food.exceptions.InvalidOrderException;

public interface OrderOperations {

    void placeOrder(int quantity) throws InvalidOrderException;

    void cancelOrder();

    double calculateBill();
}