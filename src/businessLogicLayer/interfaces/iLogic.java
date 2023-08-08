package businessLogicLayer.interfaces;

import dataBaseLayer.products.Product;

import java.util.List;

/**
 * интерфейс бизнес логики
 */
public interface iLogic {

    /**
     * метод покупки товара
     * @param id индефикатор
     * @param count количество
     * @throws RuntimeException
     */
    void buyProduct(int id, int count) throws RuntimeException;

    /**
     * метод возвращающий все товары
     * @return товары
     */
    List<Product> showAllProducts();


    /**
     * метод возвращает выбранный товар
     * @param id индефикатор товара
     * @return
     * @throws RuntimeException
     */
    Product showSelectedProduct(int id) throws RuntimeException;
}
