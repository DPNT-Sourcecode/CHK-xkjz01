package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    private static final Map<Character, Integer> itemPrices = Map.of(
            'A', 50,
            'B', 30,
            'C', 20,
            'D', 15
    );

    private static final Map<String, Integer> offers = Map.of(
            "AAA", 130,
            "BB", 45,
            "CC", 35,
            "DD", 30
    );

    public int checkout(String items) {
        Map<Character, Integer> itemCount = new HashMap<>();
        for (char item : items.toCharArray()) {
            itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
        }

        int total = 0;

        // Apply offers first
        total += applyOffers(itemCount);

        // Apply individual prices
        for (Map.Entry<Character, Integer> entry : itemCount.entrySet()) {
            char item = entry.getKey();
            int count = entry.getValue();
            if (itemPrices.containsKey(item)) {
                total += count * itemPrices.get(item);
            }
        }

        return total;
    }

    private int applyOffers(Map<Character, Integer> itemCount) {
        int totalOffer = 0;

        // Apply special offers for multiple items
        if (itemCount.getOrDefault('A', 0) >= 3) {
            int offerCount = itemCount.get('A') / 3;
            totalOffer += offerCount * 130;
            itemCount.put('A', itemCount.get('A') % 3);
        }

        if (itemCount.getOrDefault('B', 0) >= 2) {
            int offerCount = itemCount.get('B') / 2;
            totalOffer += offerCount * 45;
            itemCount.put('B', itemCount.get('B') % 2);
        }

        if (itemCount.getOrDefault('C', 0) >= 2) {
            int offerCount = itemCount.get('C') / 2;
            totalOffer += offerCount * 35;
            itemCount.put('C', itemCount.get('C') % 2);
        }

        if (itemCount.getOrDefault('D', 0) >= 2) {
            int offerCount = itemCount.get('D') / 2;
            totalOffer += offerCount * 30;
            itemCount.put('D', itemCount.get('D') % 2);
        }

        return totalOffer;
    }
}






