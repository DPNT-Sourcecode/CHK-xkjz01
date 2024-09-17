package befaster.solutions.CHK;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutSolutionTest {

    @Test
    public void testCheckoutWithBasicItems() {
        assertEquals(50, CheckoutSolution.checkout("A"), "Single A should cost 50");
        assertEquals(30, CheckoutSolution.checkout("B"), "Single B should cost 30");
        assertEquals(20, CheckoutSolution.checkout("C"), "Single C should cost 20");
        assertEquals(15, CheckoutSolution.checkout("D"), "Single D should cost 15");
        assertEquals(40, CheckoutSolution.checkout("E"), "Single E should cost 40");
    }

    @Test
    public void testCheckoutWithOffers() {
        assertEquals(130, CheckoutSolution.checkout("AAA"), "3 A's should cost 130 with offer");
        assertEquals(200, CheckoutSolution.checkout("AAAAA"), "5 A's should cost 200 with offer");
        assertEquals(95, CheckoutSolution.checkout("AAAA"), "4 A's should cost 130 + 50");
        assertEquals(45, CheckoutSolution.checkout("BB"), "2 B's should cost 45 with offer");
        assertEquals(30, CheckoutSolution.checkout("B"), "1 B should cost 30");
        assertEquals(80, CheckoutSolution.checkout("BBBA"), "3 B's should cost 45 + 30");
    }

    @Test
    public void testCheckoutWithMixedOffers() {
        assertEquals(165, CheckoutSolution.checkout("AAAB"), "3 A's and 1 B should cost 130 + 30");
        assertEquals(155, CheckoutSolution.checkout("AAABBB"), "3 A's and 3 B's should cost 130 + 45 + 30");
        assertEquals(165, CheckoutSolution.checkout("AAABBB"), "3 A's and 3 B's should cost 130 + 45 + 30");
        assertEquals(195, CheckoutSolution.checkout("AAABBBCC"), "3 A's, 3 B's and 2 C's should cost 130 + 45 + 30 + 40");
        assertEquals(80, CheckoutSolution.checkout("EE"), "2 E's should cost 80 and get 1 B free");
        assertEquals(120, CheckoutSolution.checkout("EEE"), "3 E's should cost 120 (80 for E's and 40 for B)");
        assertEquals(80, CheckoutSolution.checkout("EEB"), "2 E's and 1 B should cost 80");
        assertEquals(110, CheckoutSolution.checkout("EEAB"), "2 E's, 1 A and 1 B should cost 80 + 50 + 30");
    }

    @Test
    public void testInvalidInputs() {
        assertEquals(-1, CheckoutSolution.checkout("F"), "Invalid item F should return -1");
        assertEquals(-1, CheckoutSolution.checkout("AAAF"), "Invalid item F should return -1");
        assertEquals(-1, CheckoutSolution.checkout("AAAB1"), "Invalid item 1 should return -1");
        assertEquals(-1, CheckoutSolution.checkout("123"), "Invalid characters should return -1");
    }
}
