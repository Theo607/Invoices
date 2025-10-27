import Client;
import Product;
import java.util.ArrayList;
import java.util.Date;

class Invoice {

    public Client client;
    public ArrayList<Product> products;
    public Date date;

    public Invoice(Client client) {
        this.client = client;
        this.products = new ArrayList<>();
        this.date = new Date();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }
}
