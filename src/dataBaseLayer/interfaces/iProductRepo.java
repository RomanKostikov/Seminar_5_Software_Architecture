package dataBaseLayer.interfaces;

import dataBaseLayer.products.Product;

import java.util.List;

/**
 * интерфейс репозитория наших продуктов продажи
 */
public interface iProductRepo {

    /**
     * метод получения всех товаров из БД
     */
    List<Product> getAllProducts();

    /**
     * получение товара по id из БД
     *
     * @param id индефикатор товара
     */
    Product getProductById(int id);

    /**
     * изменение количества товаров
     *
     * @param id    индефикатор товара
     * @param count устанавливаемое количества товара
     */
    void setCountProduct(int id, int count);

}
