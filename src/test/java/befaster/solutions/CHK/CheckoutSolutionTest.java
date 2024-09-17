package befaster.solutions.CHK;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutSolutionTest {

    @Test
    public void testEmptyBasket() {
        assertEquals(0, CheckoutSolution.checkout(""));
    }

    @Test
    public void testSingleItem() {
        assertEquals(50, CheckoutSolution.checkout("A"));
        assertEquals(30, CheckoutSolution.checkout("B"));
        assertEquals(20, CheckoutSolution.checkout("C"));
        assertEquals(15, CheckoutSolution.checkout("D"));
        assertEquals(40, CheckoutSolution.checkout("E"));
    }

    @Test
    public void testMultipleItemsNoOffers() {
        assertEquals(130, CheckoutSolution.checkout("AA"));
        assertEquals(60, CheckoutSolution.checkout("CC"));
        assertEquals(30, CheckoutSolution.checkout("D"));
        assertEquals(110, CheckoutSolution.checkout("AE"));
    }

    @Test
    public void testOffers() {
        // Testa a oferta de 3A por 130
        assertEquals(130, CheckoutSolution.checkout("AAA"));
        assertEquals(200, CheckoutSolution.checkout("AAAAA"));

        // Testa a oferta de 2B por 45
        assertEquals(45, CheckoutSolution.checkout("BB"));
        assertEquals(90, CheckoutSolution.checkout("BBBB"));

        // Testa a oferta de 2E get 1B free
        assertEquals(80, CheckoutSolution.checkout("EE"));
        assertEquals(120, CheckoutSolution.checkout("EEE")); // 2E + 1B free
        assertEquals(160, CheckoutSolution.checkout("EEEE")); // 2E + 1B free + 2E

        // Testa a combinação de várias ofertas
        assertEquals(200, CheckoutSolution.checkout("AAAABBBBEE")); // 3A + 2B + 2E + 1B free
    }

    @Test
    public void testInvalidItems() {
        assertEquals(-1, CheckoutSolution.checkout("F"));
        assertEquals(-1, CheckoutSolution.checkout("AAB"));
        assertEquals(-1, CheckoutSolution.checkout("ABCDXYZ"));
    }

    @Test
    public void testCombiningOffers() {
        // Testa a combinação de ofertas e itens regulares
        assertEquals(160, CheckoutSolution.checkout("AAABCCDE")); // 3A + 1B + 2E + D
        assertEquals(90, CheckoutSolution.checkout("AAEE")); // 3A + 2E get 1B free, mas só E e A no total
        assertEquals(75, CheckoutSolution.checkout("AAE")); // 3A + 1E
    }
}

