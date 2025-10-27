package example;

import java.util.Date;
import java.util.Vector;

public class Invoice {

    public Client client;
    public Vector<Product> products;
    public Date date;

    public Invoice(Client client) {
        this.client = client;
        this.products = new Vector<>();
        this.date = new Date();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                break;
            }
        }
    }

    public void editProduct(int id, Product product) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setQuantity(product.getQuantity());
                break;
            }
        }
    }

    public Vector<Product> getProducts() {
        return products;
    }
}
