package befaster.solutions.CHK;

// Classe para representar uma oferta
 public class Offer {
    private final int quantity;
    private final int price;

    public Offer(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}