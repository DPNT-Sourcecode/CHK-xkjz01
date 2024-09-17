package befaster.solutions.CHK;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutSolutionTest {

    @Test
    public void testCheckoutEmpty() {
        assertEquals(0, CheckoutSolution.checkout(""));
    }

    @Test
    public void testCheckoutSingleItem() {
        assertEquals(50, CheckoutSolution.checkout("A"));
        assertEquals(30, CheckoutSolution.checkout("B"));
        assertEquals(20, CheckoutSolution.checkout("C"));
        assertEquals(15, CheckoutSolution.checkout("D"));
        assertEquals(40, CheckoutSolution.checkout("E"));
    }

    @Test
    public void testCheckoutMultipleItemsNoOffers() {
        assertEquals(100, CheckoutSolution.checkout("AA"));
        assertEquals(60, CheckoutSolution.checkout("BB"));
        assertEquals(80, CheckoutSolution.checkout("CC"));
        assertEquals(30, CheckoutSolution.checkout("DD"));
    }

    @Test
    public void testCheckoutOffers() {
        // Testing the offers
        assertEquals(130, CheckoutSolution.checkout("AAA")); // 3A for 130
        assertEquals(45, CheckoutSolution.checkout("BB"));   // 2B for 45
        assertEquals(80, CheckoutSolution.checkout("EE"));   // 2E for 80

        // Mixed with offers
        assertEquals(195, CheckoutSolution.checkout("AAABBB")); // 3A for 130 + 2B for 45
        assertEquals(130, CheckoutSolution.checkout("AAAB"));   // 3A for 130 + 1B for 30
        assertEquals(185, CheckoutSolution.checkout("AAAAB"));  // 3A for 130 + 1A for 50 + 1B for 30
        assertEquals(75, CheckoutSolution.checkout("EEB"));    // 2E get 1B free => 2E for 80 and 1B free = 80 - 30 = 50
        assertEquals(105, CheckoutSolution.checkout("EEB"));   // 2E get 1B free => 2E for 80 and 1B for 30 = 80 + 30 = 110
    }

    @Test
    public void testCheckoutInvalidInput() {
        assertEquals(-1, CheckoutSolution.checkout("F")); // Invalid item
        assertEquals(-1, CheckoutSolution.checkout("ABF")); // Invalid item
    }
}


