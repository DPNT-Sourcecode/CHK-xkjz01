package befaster.solutions.CHK;
import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {

    private static final Map<Character, Integer> PRICE_MAP = new HashMap<>();
    private static final Map<Character, Integer> OFFER_1 = new HashMap<>();
    private static final Map<Character, Integer> OFFER_2 = new HashMap<>();
    private static final Map<Character, Integer> OFFER_3 = new HashMap<>();

    static {
        PRICE_MAP.put('A', 50);
        PRICE_MAP.put('B', 30);
        PRICE_MAP.put('C', 20);
        PRICE_MAP.put('D', 15);
        PRICE_MAP.put('E', 40);

        // Offer 1: 3A for 130, 5A for 200
        OFFER_1.put('A', 3);

        // Offer 2: 2B for 45
        OFFER_2.put('B', 2);

        // Offer 3: 2E get one B free
        OFFER_3.put('E', 2);
    }

    public static int checkout(String skus) {
        if (skus == null || !skus.matches("[A-E]*")) {
            return -1;
        }

        Map<Character, Integer> basket = new HashMap<>();
        for (char sku : skus.toCharArray()) {
            basket.put(sku, basket.getOrDefault(sku, 0) + 1);
        }

        int total = 0;
        int countE = basket.getOrDefault('E', 0);
        int countB = basket.getOrDefault('B', 0);

        // Apply offer for E
        int freeBs = countE / 2;
        if (freeBs > countB) {
            freeBs = countB;
        }
        countB -= freeBs;

        // Apply offers for A
        int countA = basket.getOrDefault('A', 0);
        total += (countA / 5) * 200;
        countA %= 5;
        total += (countA / 3) * 130;
        countA %= 3;
        total += countA * PRICE_MAP.get('A');

        // Apply offers for B
        total += (countB / 2) * 45;
        countB %= 2;
        total += countB * PRICE_MAP.get('B');

        // Apply offers for C and D
        total += (basket.getOrDefault('C', 0)) * PRICE_MAP.get('C');
        total += (basket.getOrDefault('D', 0)) * PRICE_MAP.get('D');

        return total;
    }
}



