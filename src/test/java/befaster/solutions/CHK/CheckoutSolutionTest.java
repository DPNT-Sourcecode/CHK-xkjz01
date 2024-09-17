package befaster.solutions.CHK;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutSolutionTest {
    @Test
    public void testBasicItems() {
        // Testando itens básicos sem ofertas
        assertEquals(50, CheckoutSolution.checkout("A"), "Checkout for A should be 50");
        assertEquals(30, CheckoutSolution.checkout("B"), "Checkout for B should be 30");
        assertEquals(20, CheckoutSolution.checkout("C"), "Checkout for C should be 20");
        assertEquals(15, CheckoutSolution.checkout("D"), "Checkout for D should be 15");
    }

    @Test
    public void testMultipleItemsWithoutOffers() {
        // Testando múltiplos itens sem ofertas
        assertEquals(100, CheckoutSolution.checkout("AA"), "Checkout for AA should be 100");
        assertEquals(60, CheckoutSolution.checkout("BB"), "Checkout for BB should be 60");
        assertEquals(40, CheckoutSolution.checkout("CC"), "Checkout for CC should be 40");
    }

    @Test
    public void testItemsWithOffers() {
        // Testando itens com ofertas especiais
        assertEquals(130, CheckoutSolution.checkout("AAA"), "Checkout for AAA with special offer should be 130");
        assertEquals(175, CheckoutSolution.checkout("AAAB"), "Checkout for AAAB with special offer should be 175");
        assertEquals(75, CheckoutSolution.checkout("AAB"), "Checkout for AAB with special offer should be 175");
    }

    @Test
    public void testMixedItems() {
        // Testando combinação de itens e ofertas
        assertEquals(190, CheckoutSolution.checkout("AABCD"), "Checkout for AABCD should be 190");
        assertEquals(195, CheckoutSolution.checkout("AAABBC"), "Checkout for AAABBC should be 195");
    }

    @Test
    public void testInvalidItems() {
        // Testando itens inválidos
        assertEquals(-1, CheckoutSolution.checkout("AABX"), "Checkout for AABX should be -1");
        assertEquals(-1, CheckoutSolution.checkout("123"), "Checkout for 123 should be -1");
        assertEquals(-1, CheckoutSolution.checkout(""), "Checkout for empty string should be -1");
    }

    @Test
    public void testEmptyInput() {
        // Testando entrada vazia
        assertEquals(0, CheckoutSolution.checkout(""), "Checkout for empty basket should be 0");
    }
}

