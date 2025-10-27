package example;

import java.util.Vector;

public class App {

    private Invoice current_invoice;

    private void handleAdd() {
        if (current_invoice == null) {
            System.out.println("No invoice selected");
            return;
        }
        System.out.println("Enter product name: ");
        String product_name = System.console().readLine();
        System.out.println("Enter product price: ");
        double product_price = Double.parseDouble(System.console().readLine());
        System.out.println("Enter product quantity: ");
        int product_quantity = Integer.parseInt(System.console().readLine());
        System.out.println("Enter unit of measurement: ");
        String product_unit = System.console().readLine();
        Product product = new Product(
            product_name,
            product_price,
            product_quantity,
            product_unit
        );
        current_invoice.addProduct(product);
    }

    private void listProducts() {
        if (current_invoice == null) {
            System.out.println("No invoice selected");
            return;
        }
        System.out.println("Products:");
        int i = 0;
        for (Product product : current_invoice.getProducts()) {
            System.out.println(
                (i) +
                    ". " +
                    product.name +
                    " - " +
                    product.price +
                    " - " +
                    product.quantity +
                    " - " +
                    product.unit
            );
            i++;
        }
    }

    private void handleEdit() {
        if (current_invoice == null) {
            System.out.println("No invoice selected");
            return;
        }
        listProducts();
        System.out.println("Enter product id: ");
        int product_id = Integer.parseInt(System.console().readLine());
        System.out.println("Enter new product name: ");
        String product_name = System.console().readLine();
        System.out.println("Enter new product price: ");
        double product_price = Double.parseDouble(System.console().readLine());
        System.out.println("Enter new product quantity: ");
        int product_quantity = Integer.parseInt(System.console().readLine());
        System.out.println("Enter new product unit: ");
        String product_unit = System.console().readLine();

        Product product = new Product(
            product_name,
            product_price,
            product_quantity,
            product_unit
        );
        current_invoice.editProduct(product_id, product);
    }

    private void handleDelete() {
        if (current_invoice == null) {
            System.out.println("No invoice selected");
            return;
        }
        listProducts();
        System.out.println("Enter product id: ");
        int product_id = Integer.parseInt(System.console().readLine());
        current_invoice.removeProduct(product_id);
    }

    private void handleHelp() {
        System.out.println("Available commands:");
        System.out.println("add - add a new product to the invoice");
        System.out.println("edit - edit an existing product in the invoice");
        System.out.println("delete - delete a product from the invoice");
        System.out.println("help - display this help message");
        System.out.println("quit - exit the program");
    }

    private void handleCommand(String cmd) {
        switch (cmd) {
            case "add":
                handleAdd();
                break;
            case "edit":
                handleEdit();
                break;
            case "delete":
                handleDelete();
                break;
            case "help":
                handleHelp();
                break;
            default:
                System.out.println("Invalid command");
        }
    }

    private Client clientInit() {
        String cmd = "n";
        while (cmd != "y") {
            System.out.println("Firm name: ");
            String firm_name = System.console().readLine();
            System.out.println("Enter address: ");
            String address = System.console().readLine();
            System.out.println("Enter NIP: ");
            String nip = System.console().readLine();

            Client client = new Client(firm_name, address, nip);

            System.out.println("Client information: " + client.toString());
            System.out.println("Confirm (y, n): ");
            cmd = System.console().readLine();
        }

        return client;
    }

    public static void main(String[] args) {
        Client current_client = clientInit();
        current_invoice = new Invoice(current_client);

        System.out.println("Enter one of the following instructions: ");
        System.out.println("1. add");
        System.out.println("2. edit");
        System.out.println("3. delete");
        System.out.println("4. exit");
        System.out.println("5. help");

        while (cmd != "exit") {
            System.out.println("Enter command: ");
            String cmd = System.console().readLine();
            handleCommand(cmd);
        }
    }
}
