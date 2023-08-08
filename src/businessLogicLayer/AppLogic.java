package businessLogicLayer;

import businessLogicLayer.interfaces.iLogic;
import dataBaseLayer.interfaces.iProductRepo;
import dataBaseLayer.products.Product;

import java.util.List;

/**
 * класс бизнес логики приложения
 */
public class AppLogic implements iLogic {
    private iProductRepo repository;

    /**
     * конструктор класса
     *
     * @param repository ссылка на репозиторий
     */
    public AppLogic(iProductRepo repository) {
        this.repository = repository;
    }

    /**
     * получаем товар по id
     *
     * @param id индефикатор товара
     * @return товар
     * @throws RuntimeException
     */
    private Product tryGetProduct(int id) throws RuntimeException {
        Product product = repository.getProductById(id);
        if (product == null) {
            throw new RuntimeException("Такой товар отсутствует в Базе");
        }
        return product;
    }

    /**
     * метод покупки товара
     *
     * @param id    индефикатор
     * @param count количество
     * @throws RuntimeException
     */
    @Override
    public void buyProduct(int id, int count) throws RuntimeException {
        Product product = tryGetProduct(id);
        if (product.getCount()<count){
            throw new RuntimeException("Такого количества товара нет ");
        }

        // payment logic - логика проведения оплаты


        // устанавливаем новое количество товара
        repository.setCountProduct(id,count);

    }

    /**
     * Получаем список продуктов
     * @return
     */
    @Override
    public List<Product> showAllProducts() {
        return repository.getAllProducts() ;
    }

    /**
     * получам товар по id
     * @param id индефикатор товара
     * @return товар
     * @throws RuntimeException
     */
    @Override
    public Product showSelectedProduct(int id) throws RuntimeException {
        return tryGetProduct(id);
    }

}
