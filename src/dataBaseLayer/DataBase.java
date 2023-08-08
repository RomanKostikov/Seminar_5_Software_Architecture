package dataBaseLayer;

import dataBaseLayer.products.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * класс базы данных (симуляция)
 */
public class DataBase {
    private List<Product> products = new ArrayList<>();
    private static DataBase dataBase;

    /**
     * получения класса базы (синглтон)
     */
    public static DataBase getInstance(){
        if (dataBase == null){
            dataBase = new DataBase();
        }
        return dataBase;
    }

    /**
     * примерный товар
     */
    private DataBase(){
        products.add(new Product(1,"Человек-паук\t\t","Экшен фигурка человека-паука\t\t",3500,20));
        products.add(new Product(2,"Супермэн\t\t\t","Экшен фигурка супермэна\t\t\t",3500,45));
        products.add(new Product(3,"Т-90\t\t\t\t","модель танка Т-90\t\t\t\t\t",4000,10));
        products.add(new Product(4,"Армата\t\t\t","модель танка Армата\t\t\t\t",4500,10));

    }

    /**
     * Геттер и сеттер товаров
     */
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
