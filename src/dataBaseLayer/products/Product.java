package dataBaseLayer.products;


/**
 * начальная модель продукта
 */
public class Product {
    private int id;
    private String name;
    private String description;
    private int price;
    private int count;

    /**
     * Конструктор класса модели товара
     *
     * @param id          идентификатор товара
     * @param name        название товара
     * @param count       количество данного товара на складе
     * @param price       цена товара
     * @param description описание товара
     */
    public Product(int id, String name, String description, int price, int count) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
