class Client {

    public String name;
    public String address;
    public String email;
    public String phone;
    public String id;

    public Client(
        String name,
        String address,
        String email,
        String phone,
        String id
    ) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.id = id;
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
            ", email='" +
            email +
            '\'' +
            ", phone='" +
            phone +
            '\'' +
            ", id='" +
            id +
            '\'' +
            '}'
        );
    }
}
