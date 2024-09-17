package befaster.solutions.CHK;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutSolutionTest {
    @Test
    public void testEmptyBasket() {
        assertEquals(0, CheckoutSolution.checkout(""));
    }

    @Test
    public void testSingleItemWithoutOffer() {
        assertEquals(50, CheckoutSolution.checkout("A"));
        assertEquals(30, CheckoutSolution.checkout("B"));
        assertEquals(20, CheckoutSolution.checkout("C"));
        assertEquals(15, CheckoutSolution.checkout("D"));
    }

    @Test
    public void testSingleItemWithOffer() {
        // Testing the offer for 'A'
        assertEquals(130, CheckoutSolution.checkout("AAA"));
        assertEquals(50, CheckoutSolution.checkout("A"));  // Offer should not apply
        assertEquals(180, CheckoutSolution.checkout("AAAA")); // 130 + 50 = 180

        // Testing the offer for 'B'
        assertEquals(45, CheckoutSolution.checkout("BB"));
        assertEquals(30, CheckoutSolution.checkout("B"));  // Offer should not apply
        assertEquals(75, CheckoutSolution.checkout("BBB")); // 45 + 30 = 75
    }

    @Test
    public void testMultipleItemsWithOffers() {
        // Items and offers combined
        assertEquals(175, CheckoutSolution.checkout("AAABBB")); // 130 + 45
        assertEquals(195, CheckoutSolution.checkout("AAABBBCC")); // 130 + 45 + 20 = 195
        assertEquals(195, CheckoutSolution.checkout("AAABBBCCC")); // Same as above, with extra C
        assertEquals(250, CheckoutSolution.checkout("AAABBBCCCD")); // 130 + 45 + 20 + 15 = 210
    }

    @Test
    public void testInvalidItems() {
        assertEquals(-1, CheckoutSolution.checkout("E"));
        assertEquals(-1, CheckoutSolution.checkout("ABCDE"));
        assertEquals(-1, CheckoutSolution.checkout("A1B2C3"));
    }

    @Test
    public void testLargeQuantity() {
        // Large quantity to test performance and correctness
        assertEquals(19500, CheckoutSolution.checkout("A".repeat(390)));// 130 + 130 + ... + 130
        assertEquals(13500, CheckoutSolution.checkout("B".repeat(300))); // 45 + 45 + ... + 45
    }
}


