package dataBaseLayer;

import dataBaseLayer.interfaces.iProductRepo;
import dataBaseLayer.products.Product;

import java.util.List;

/**
 * класс репозитория наших продуктов
 */

public class ProductRepo implements iProductRepo {
    private DataBase dataBase;

    /**
     * Конструктор репозитория
     *
     * @param dataBase ссылка на базу данных для работы с ней
     */
    public ProductRepo(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    /**
     * метод получения списка товаров
     *
     * @return список товаров
     */
    @Override
    public List<Product> getAllProducts() {
        return dataBase.getProducts();
    }

    /**
     * получение товара по индефикатору
     *
     * @param id индефикатор товара
     * @return товар
     */
    @Override
    public Product getProductById(int id) {
        return dataBase.getProducts().stream().filter(x -> x.getId() == id).findAny().get();
    }

    /**
     * меняем количество товаров
     *
     * @param id    индефикатор товара
     * @param count устанавливаемое количества товара
     */
    @Override
    public void setCountProduct(int id, int count) {
        int newCount = dataBase.getProducts().stream().filter(x -> x.getId() == id).findAny().get().getCount() - count;
        dataBase.getProducts().stream().filter(x -> x.getId() == id).findAny().get().setCount(newCount);
    }
}
