package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {

    // Tabela de preços e ofertas
    private static final Map<Character, Integer> prices = new HashMap<>();
    private static final Map<Character, Offer[]> offers = new HashMap<>();
    private static final int INVALID_INPUT = -1;

    static {
        // Prices
        prices.put('A', 50);
        prices.put('B', 30);
        prices.put('C', 20);
        prices.put('D', 15);
        prices.put('E', 40);

        // Offers
        offers.put('A', new Offer[]{new Offer(5, 200), new Offer(3, 130)});  // 5A for 200, 3A for 130
        offers.put('B', new Offer[]{new Offer(2, 45)}); // 2B for 45
        offers.put('E', new Offer[]{new Offer(2, 80)}); // 2E get 1 B free
    }

    public static int checkout(String skus) {
        if (skus == null || skus.isEmpty()) {
            return 0;  // Retorna 0 para cesta vazia
        }

        Map<Character, Integer> itemCounts = new HashMap<>();
        int total = 0;

        // Contagem de Itens
        for (char item : skus.toCharArray()) {
            if (!prices.containsKey(item)) {
                return INVALID_INPUT;  // Retorna -1 para entrada inválida
            }
            itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
        }

        // Calcula o total com base nas ofertas e preços
        for (Map.Entry<Character, Integer> entry : itemCounts.entrySet()) {
            char item = entry.getKey();
            int count = entry.getValue();
            int itemPrice = prices.get(item);

            Offer[] itemOffers = offers.get(item);
            if (itemOffers != null) {
                int maxTotal = 0;
                for (Offer offer : itemOffers) {
                    int offerCount = count / offer.getQuantity();
                    int remainder = count % offer.getQuantity();
                    int offerTotal = offerCount * offer.getPrice() + remainder * itemPrice;
                    if (item == 'E') {
                        // For 'E', apply the offer where 2E gets 1B free
                        int bCount = itemCounts.getOrDefault('B', 0);
                        int bFreePrice = Math.min(bCount, offerCount) * prices.get('B');
                        offerTotal -= bFreePrice;
                    }
                    maxTotal = Math.max(maxTotal, offerTotal);
                }
                total += maxTotal;
            } else {
                total += count * itemPrice;
            }
        }

        return total;
    }

    // Classe interna para representar uma oferta
    private static class Offer {
        private final int quantity;
        private final int price;

        public Offer(int quantity, int price) {
            this.quantity = quantity;
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public int getPrice() {
            return price;
        }
    }
}



