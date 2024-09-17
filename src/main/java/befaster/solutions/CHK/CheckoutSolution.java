package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;
public class CheckoutSolution {

    // Tabela de preços e ofertas
    private static final Map<Character, Integer> prices = new HashMap<>();
    private static final Map<Character, Integer[]> offers = new HashMap<>();

    static {
        // Prices
        prices.put('A', 50);
        prices.put('B', 30);
        prices.put('C', 20);
        prices.put('D', 15);

        // Offers
        offers.put('A', new Integer[]{3, 130});  // 3A for 130
        offers.put('B', new Integer[]{2, 45});   // 2B for 45
    }

    public static int checkout(String skus) {
        if (skus == null || skus.isEmpty()) {
            return 0;  // Retorna 0 para cesta vazia
        }

        Map<Character, Integer> itemCounts = new HashMap<>();
        int total = 0;

        // Itens Counting
        for (char item : skus.toCharArray()) {
            if (!prices.containsKey(item)) {
                return -1;  // Retorna -1 para entrada inválida
            }
            itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
        }

        // Calcula o total com base nas ofertas e preços
        for (Map.Entry<Character, Integer> entry : itemCounts.entrySet()) {
            char item = entry.getKey();
            int count = entry.getValue();
            int itemPrice = prices.get(item);

            Integer[] offer = offers.get(item);
            if (offer != null) {
                int offerQuantity = offer[0];
                int offerPrice = offer[1];

                int offerCount = count / offerQuantity;
                int remainder = count % offerQuantity;

                total += offerCount * offerPrice;
                total += remainder * itemPrice;
            } else {
                total += count * itemPrice;
            }
        }

        return total;
    }
}



