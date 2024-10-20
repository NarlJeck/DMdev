package entity;

public class Product {
    private String Id;
    private Float price;
    private String name;
    private String Description;

    public Product(String id, Float price, String name, String description) {
        Id = id;
        this.price = price;
        this.name = name;
        Description = description;
    }

    public Product(String id, Float price, String name) {
        Id = id;
        this.price = price;
        this.name = name;
    }

    public Product() {

    }

    public void setId(String id) {
        Id = id;
    }

    public String getId() {
        return Id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + Id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
