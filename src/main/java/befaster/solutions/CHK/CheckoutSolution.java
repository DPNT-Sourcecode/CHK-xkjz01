package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {

    private static final Map<Character, Integer> itemPrices = new HashMap<>();
    private static final Map<Character, Integer> itemQuantities = new HashMap<>();
    private static final Map<Character, Integer> discountQuantities = new HashMap<>();
    private static final Map<Character, Integer> discountPrices = new HashMap<>();
    private static final Map<Character, Character> freeItemOffers = new HashMap<>();

    static {
        // Define prices for each item
        itemPrices.put('A', 50);
        itemPrices.put('B', 30);
        itemPrices.put('C', 20);
        itemPrices.put('D', 15);
        itemPrices.put('E', 40);

        // Define discount quantities and prices for items
        discountQuantities.put('A', 3);
        discountPrices.put('A', 130);
        discountQuantities.put('B', 2);
        discountPrices.put('B', 45);
        discountQuantities.put('E', 2);
        discountPrices.put('E', 80);

        // Define free item offers
        freeItemOffers.put('E', 'B');
    }

    public static int checkout(String skus) {
        if (skus == null || skus.isEmpty()) {
            return 0;
        }

        // Count the quantity of each item
        for (char sku : skus.toCharArray()) {
            if (!itemPrices.containsKey(sku)) {
                return -1; // Invalid item
            }
            itemQuantities.put(sku, itemQuantities.getOrDefault(sku, 0) + 1);
        }

        // Calculate the total price
        int totalPrice = 0;

        for (Map.Entry<Character, Integer> entry : itemQuantities.entrySet()) {
            char item = entry.getKey();
            int quantity = entry.getValue();
            int price = itemPrices.get(item);

            // Apply discounts
            if (discountQuantities.containsKey(item)) {
                int discountQuantity = discountQuantities.get(item);
                int discountPrice = discountPrices.get(item);
                int discountedSets = quantity / discountQuantity;
                int remainder = quantity % discountQuantity;
                totalPrice += discountedSets * discountPrice + remainder * price;
            } else {
                totalPrice += quantity * price;
            }
        }

        // Apply free item offers
        for (Map.Entry<Character, Character> entry : freeItemOffers.entrySet()) {
            char offerItem = entry.getKey();
            char freeItem = entry.getValue();
            int offerQuantity = itemQuantities.getOrDefault(offerItem, 0);
            int freeQuantity = itemQuantities.getOrDefault(freeItem, 0);

            int freeItemsGiven = offerQuantity / discountQuantities.getOrDefault(offerItem, 1);
            int remainingFreeItems = freeQuantity - freeItemsGiven;

            // Apply free items
            if (remainingFreeItems < 0) {
                totalPrice -= (remainingFreeItems * itemPrices.get(freeItem));
            } else {
                totalPrice -= (offerQuantity / discountQuantities.getOrDefault(offerItem, 1)) * itemPrices.get(freeItem);
            }
        }

        return totalPrice;
    }
}



