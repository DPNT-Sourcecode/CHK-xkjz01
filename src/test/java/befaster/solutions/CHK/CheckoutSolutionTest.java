package befaster.solutions.CHK;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutSolutionTest {

    private final CheckoutSolution checkoutSolution = new CheckoutSolution();

    @Test
    public void testCheckoutSingleItem() {
        assertEquals(50, checkoutSolution.checkout("A"), "Checkout should return 50 for item A");
        assertEquals(30, checkoutSolution.checkout("B"), "Checkout should return 30 for item B");
        assertEquals(20, checkoutSolution.checkout("C"), "Checkout should return 20 for item C");
        assertEquals(15, checkoutSolution.checkout("D"), "Checkout should return 15 for item D");
    }

    @Test
    public void testCheckoutMultipleItemsNoOffers() {
        assertEquals(115, checkoutSolution.checkout("ABCD"), "Checkout should return 115 for items A, B, C, D without offers");
        assertEquals(100, checkoutSolution.checkout("AABCD"), "Checkout should return 100 for items A, A, B, C, D without offers");
        assertEquals(65, checkoutSolution.checkout("ABCDAB"), "Checkout should return 65 for items A, B, C, D, A, B without offers");
    }

    @Test
    public void testCheckoutWithOffers() {
        assertEquals(130, checkoutSolution.checkout("AAA"), "Checkout should return 130 for three items A with offer");
        assertEquals(45, checkoutSolution.checkout("BB"), "Checkout should return 45 for two items B with offer");
        assertEquals(35, checkoutSolution.checkout("CC"), "Checkout should return 35 for two items C with offer");
        assertEquals(30, checkoutSolution.checkout("DD"), "Checkout should return 30 for two items D with offer");

        assertEquals(165, checkoutSolution.checkout("AAAB"), "Checkout should return 165 for three items A and one item B with offers");
        assertEquals(80, checkoutSolution.checkout("BBCC"), "Checkout should return 80 for two items B and two items C with offers");
        assertEquals(130, checkoutSolution.checkout("AAAAB"), "Checkout should return 130 for four items A and one item B with offers");

        // Combined offers
        assertEquals(195, checkoutSolution.checkout("AAABBC"), "Checkout should return 195 for three items A, two items B, and one item C with offers");
        assertEquals(80, checkoutSolution.checkout("CCDD"), "Checkout should return 80 for two items C and two items D with offers");
    }
}



