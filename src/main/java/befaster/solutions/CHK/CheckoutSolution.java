package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    private static final Map<Character, Integer> prices = new HashMap<>();
    private static final Map<Character, Integer> Offers = new HashMap<>();

    static{
        prices.put('A', 50);
        prices.put('B', 30);
        prices.put('C', 20);
        prices.put('D', 10);

    }



    public Integer checkout(String skus) {
        if (skus == null  || !skus.matches("[A-D]*"){
        return -1;
    }

    int total = 0;
    Map<Character, Integer> itemCount = new HashMap<>();

    //conta a quantidade de cada item
       for (char sku : skus.toCharArray()){
           itemCount.put(sku, itemCount.getOrderDefault(sku,0)+1);
       }
    }
}
