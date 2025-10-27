package example;

public class Client {

    public String name;
    public String address;
    public String nip;

    public Client(String name, String address, String nip) {
        this.name = name;
        this.address = address;
        this.nip = nip;
    }

    public String toString() {
        return (
            "Client{" +
            "name='" +
            name +
            '\'' +
            ", address='" +
            address +
            '\'' +
            ", nip='" +
            nip +
            '\'' +
            '}'
        );
    }
}
