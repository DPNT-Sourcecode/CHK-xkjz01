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
        assertEquals(40, CheckoutSolution.checkout("E"));
    }

    @Test
    public void testSingleItemWithOffer() {
        // Testing the offer for 'A'
        assertEquals(130, CheckoutSolution.checkout("AAA")); // 3A for 130
        assertEquals(200, CheckoutSolution.checkout("AAAAA")); // 5A for 200
        assertEquals(50, CheckoutSolution.checkout("A")); // Offer should not apply
        assertEquals(180, CheckoutSolution.checkout("AAAA")); // 130 + 50 = 180

        // Testing the offer for 'B'
        assertEquals(45, CheckoutSolution.checkout("BB")); // 2B for 45
        assertEquals(30, CheckoutSolution.checkout("B")); // Offer should not apply
        assertEquals(75, CheckoutSolution.checkout("BBB")); // 45 + 30 = 75
    }

    @Test
    public void testItemWithOfferE() {
        assertEquals(80, CheckoutSolution.checkout("EE")); // 2E get 1 B free
        assertEquals(120, CheckoutSolution.checkout("EEE")); // 80 + 40 = 120
        assertEquals(120, CheckoutSolution.checkout("EEEE")); // 80 + 40 = 120
        assertEquals(160, CheckoutSolution.checkout("EEEEEE")); // 80 + 80 = 160
        assertEquals(160, CheckoutSolution.checkout("EEEEEEE")); // 80 + 80 = 160
    }

    @Test
    public void testMultipleItemsWithOffers() {
        // Items and offers combined
        assertEquals(175, CheckoutSolution.checkout("AAABBB")); // 130 + 45
        assertEquals(195, CheckoutSolution.checkout("AAABBBCC")); // 130 + 45 + 20 = 195
        assertEquals(195, CheckoutSolution.checkout("AAABBBCCC")); // Same as above, with extra C
        assertEquals(210, CheckoutSolution.checkout("AAABBBCCCD")); // 130 + 45 + 20 + 15 = 210
        assertEquals(225, CheckoutSolution.checkout("AAABBBCCCDDD")); // 130 + 45 + 20 + 15 + 15 = 225

        // Testing 'E' with other items
        assertEquals(250, CheckoutSolution.checkout("AAABBBCCCDDEE")); // 130 + 45 + 20 + 15 + 40 + 80 = 250
        assertEquals(250, CheckoutSolution.checkout("AAABBBCCCDDEEES")); // 250 (with invalid 'S', result should still be 250)
    }

    @Test
    public void testInvalidItems() {
        assertEquals(-1, CheckoutSolution.checkout("F")); // Invalid item
        assertEquals(-1, CheckoutSolution.checkout("ABCDE")); // Contains invalid item 'E'
        assertEquals(-1, CheckoutSolution.checkout("A1B2C3")); // Contains non-alphabetic characters
    }

    @Test
    public void testLargeQuantity() {
        // Large quantity to test performance and correctness
        assertEquals(19500, CheckoutSolution.checkout("A".repeat(390))); // 130 + 130 + ... + 130
        assertEquals(13500, CheckoutSolution.checkout("B".repeat(300))); // 45 + 45 + ... + 45
        assertEquals(16000, CheckoutSolution.checkout("E".repeat(400))); // 80 + 80 + ... + 80
    }
}
