package com.shrikant.problems.hashmap;

import java.util.HashMap;
import java.util.List;

//import com.shrikant.problems.utils.Pair;

// Asked in Best Buy phone interview.
// A mall vendor has 10 pairs of shoes in his shop with the following sizes:
// 2 3 4 5 6 8 7 6 5 18

// N customers are willing to pay Xi amount of money for the shoe of the correct size.

// How much money has the shop owner made if:

// Customer 1: wants size 6 and will pay $55 {6, 55}
// Customer 2: wants size 6 and will pay $45 {6, 45}
// Customer 3: wants size 6 and will pay $55
// Customer 4: wants size 4 and will pay $40
// Customer 5: wants size 18 and will pay $60
// Customer 6: wants size 10 and will pay $50

// Customer transactions will be processed in order, (first come, first served...)

// Answer : $200

public class Sales {

    public int getTotalSales(int[] inventory, List<Order> orders) {
        int result = 0;

        if (inventory == null) {
            return 0;
        }

        HashMap<Integer, Integer> inventoryMap = new HashMap<>();

        for (int i = 0; i < inventory.length; i++) {

            inventoryMap.merge(inventory[i], 1, (oldValue, newValue) -> newValue = ++oldValue);
            // if (inventoryMap.containsKey(inventory[i]))
            // {

            // Integer newValue = inventoryMap.get(inventory[i]);
            // newValue++;
            // inventoryMap.put(inventory[i], newValue);
            // } else {
            // inventoryMap.put(inventory[i], 1);
            // }
        }

        // start procesing the orders
        for (Order order : orders) 
        {
            Integer newValue = inventoryMap.computeIfPresent(order.shoeSize, (k, v) -> v = v - 1);
            if (newValue == null) {
                continue;
            }
            if (newValue <= 0) {
                inventoryMap.remove(order.shoeSize);
            }
            result += order.price;

            // if (inventoryMap.containsKey(order.first)) {
            //     int quantity = inventoryMap.get(order.first);
            //     result += order.second;
            //     quantity--;
            //     inventoryMap.put(order.first, quantity);
            //     if (quantity <= 0) {
            //         inventoryMap.remove(order.first);
            //     }
            // }
        }

        return result;
    }
}

class Order {
    public int shoeSize;
    public int price;

    public Order(int shoeSize, int price)
    {
        this.shoeSize = shoeSize;
        this.price = price;
    }
}
