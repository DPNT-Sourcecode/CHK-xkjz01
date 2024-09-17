package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {

    private static final Map<Character, Integer> prices = new HashMap<>();
    private static final Map<Character, SpecialOffer> offers = new HashMap<>();

    static {
        // Definindo preços dos itens
        prices.put('A', 50);
        prices.put('B', 30);
        prices.put('C', 20);
        prices.put('D', 15);

        // Definindo ofertas especiais
        offers.put('A', new SpecialOffer(3, 130));
        offers.put('B', new SpecialOffer(2, 45));
    }

    public static int checkout(String skus) {
        if (skus == null || !skus.matches("[A-D]*")) {
            return -1; // Entrada inválida
        }

        int total = 0;
        Map<Character, Integer> itemCount = new HashMap<>();

        // Contar a quantidade de cada item
        for (char sku : skus.toCharArray()) {
            itemCount.put(sku, itemCount.getOrDefault(sku, 0) + 1);
        }

        // Calcular o total com base nas ofertas
        for (Map.Entry<Character, Integer> entry : itemCount.entrySet()) {
            char item = entry.getKey();
            int count = entry.getValue();

            if (!prices.containsKey(item)) {
                return -1; // Item inválido
            }

            SpecialOffer offer = offers.get(item);
            if (offer != null) {
                // Aplicar oferta especial
                total += (count / offer.quantity) * offer.price;
                total += (count % offer.quantity) * prices.get(item);
            } else {
                // Preço padrão
                total += count * prices.get(item);
            }
        }

        return total;
    }

    private static class SpecialOffer {
        int quantity;
        int price;

        SpecialOffer(int quantity, int price) {
            this.quantity = quantity;
            this.price = price;
        }
    }


}

