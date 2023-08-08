package appLayer.baseAppRealization;

import appLayer.abstracts.aSellingApplications;
import businessLogicLayer.interfaces.iLogic;
import dataBaseLayer.products.Product;

import java.util.List;

/**
 * основной клас с реализацией логики и консольного интерфейса
 * version 1.0
 */
public class BaseAppClientRealization extends aSellingApplications {
    private iLogic logic;

    /**
     * Конструктор класса
     *
     * @param logic объект логики
     */
    public BaseAppClientRealization(iLogic logic) {
        this.logic = logic;
    }

    /**
     * метод основного цикла программы
     */
    public void mainMenu() {
        boolean run = true;
        int choise = -1;
        while (run) {
            printMessage("Добрый день! Магазин 'Эпичных вещей' приветствует Вас.\n");
            printMessage("Чтобы ознакомиться с наше продукцией введите 1\nЧтобы выйти\tвведите 0\n");
            printMessage("Ожидание ввода -> ");
            try {
                choise = inputInt(0, 1);
            } catch (RuntimeException e) {
                printMessage(e.getMessage() + "\n");
                continue;
            }
            run = selectMainMenu(choise);
        }
    }

    /**
     * Меню выбора пользователя
     *
     * @param choice выбор
     * @return продолжение работы
     */
    private boolean selectMainMenu(int choice) {
        if (choice == 1) {
            catalogMenu();
        } else {
            return false;
        }
        return true;
    }

    /**
     * меню каталога продуктов
     */
    private void catalogMenu() {
        boolean run = true;
        while (run) {
            int choice = -1;
            printMessage("Добрый день! Магазин 'Эпичных вещей' приветствует Вас.\n");
            printMessage("Каталог товаров\n");
            var count = printAllProducts(logic);
            printMessage("Чтобы купить товар\tвведите номер позиции товара\nЧтобы выйти введите 0\n");
            printMessage("Ожидаю ввода -> ");
            try {
                choice = inputInt(0, count);
                run = selectBuyMenu(choice);
            } catch (RuntimeException e) {
                printMessage(e.getMessage() + "\n");

            }
        }
    }

    /**
     * Меню выбора товара
     *
     * @param choice выбор покупателя
     * @return продолжение работы
     * @throws RuntimeException
     */
    private boolean selectBuyMenu(int choice) throws RuntimeException {
        if (choice == 0) {
            return false;
        }
        buyMenu(choice);
        return true;
    }

    /**
     * Меню покупки товара
     *
     * @param id индефикатор товара
     */
    private void buyMenu(int id) {
        //printMessage("Добрый день! Магазин 'Эпичных вещей' приветствует Вас.\n");
        var product = logic.showSelectedProduct(id);
        printMessage("Товар " + product.getName().trim() + " по цене " + product.getPrice() + " р. осталось на складе "
                + product.getCount() + " штук.\nВведите количество товара > ");

        int count = -1;

        try {
            count = inputInt(1, product.getCount());
            if (count>0 & count<product.getCount()){
                printMessage("Вы действительно хотите приобрести товар " + product.getName().trim() + " в количестве " + count
                        + " штук, общей стоимостью " + product.getPrice() * count + " рублей?\nДля подтверждения введите Y > ");
            }else return;
        } catch (RuntimeException ex) {
            printMessage(ex.getMessage() + "\n");
        }

        if (inputString().equals("y")) {
            try {
                logic.buyProduct(id, count);
            } catch (RuntimeException ex) {
                printMessage(ex.getMessage() + "\n");
            }

        } else return;

        printMessage("Поздравляю! Вы приобрели " + count + " штук " + product.getName().trim() + ", общей стоимостью "
                + product.getPrice() * count + "\n");

        waitInputEnter();

    }
}
