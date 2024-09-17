package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {

    // Tabela de preços e ofertas
    private static final Map<Character, Integer> prices = new HashMap<>();
    private static final Map<Character, Offer> offers = new HashMap<>();
    private static final int INVALID_INPUT = -1;

    static {
        // Prices
        prices.put('A', 50);
        prices.put('B', 30);
        prices.put('C', 20);
        prices.put('D', 15);
        prices.put('E', 40);

        // Offers
        offers.put('A', new Offer(3, 130));  // 3A for 130
        offers.put('B', new Offer(2, 45));   // 2B for 45
        offers.put('E', new Offer(2, 80));   // 2E get 1B free
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

        // Processa ofertas para o item E (2E get 1B free)
        int countE = itemCounts.getOrDefault('E', 0);
        int freeBs = countE / 2;
        int countB = itemCounts.getOrDefault('B', 0);

        // Aplica a oferta de E para B
        if (countB > 0) {
            freeBs = Math.min(freeBs, countB);
            total += freeBs * prices.get('B');
            itemCounts.put('B', countB - freeBs);
        }

        // Calcula o total para outros itens considerando ofertas
        for (Map.Entry<Character, Integer> entry : itemCounts.entrySet()) {
            char item = entry.getKey();
            int count = entry.getValue();
            int itemPrice = prices.get(item);

            Offer offer = offers.get(item);
            if (offer != null) {
                int offerCount = count / offer.getQuantity();
                int remainder = count % offer.getQuantity();

                total += offerCount * offer.getPrice();
                total += remainder * itemPrice;
            } else {
                total += count * itemPrice;
            }
        }

        return total;
    }
}

