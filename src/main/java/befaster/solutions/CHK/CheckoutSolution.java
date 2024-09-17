package befaster.solutions.CHK;
import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {

    private static final Map<Character, Integer> prices = new HashMap<>();
    private static final Map<Character, Offer> offers = new HashMap<>();

    static {
        // Preço dos itens
        prices.put('A', 50);
        prices.put('B', 30);
        prices.put('E', 40);

        // Ofertas
        offers.put('A', new Offer(3, 130));
        offers.put('B', new Offer(2, 45));
    }

    public static int checkout(String items) {
        Map<Character, Integer> itemCounts = new HashMap<>();
        for (char item : items.toCharArray()) {
            itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
        }

        int totalCost = 0;

        for (Map.Entry<Character, Integer> entry : itemCounts.entrySet()) {
            char item = entry.getKey();
            int count = entry.getValue();
            int itemPrice = prices.get(item);

            Offer offer = offers.get(item);
            if (offer != null) {
                int offerQuantity = offer.quantity;
                int offerPrice = offer.price;

                int offerCount = count / offerQuantity;
                int remainingCount = count % offerQuantity;

                totalCost += offerCount * offerPrice;
                totalCost += remainingCount * itemPrice;
            } else {
                totalCost += count * itemPrice;
            }
        }

        return totalCost;
    }

    private static class Offer {
        int quantity;
        int price;

        Offer(int quantity, int price) {
            this.quantity = quantity;
            this.price = price;
        }
    }
}

