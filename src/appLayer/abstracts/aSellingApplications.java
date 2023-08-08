package appLayer.abstracts;


import businessLogicLayer.interfaces.iLogic;
import dataBaseLayer.products.Product;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Абстрактный класс приложения для продажи
 * демонстративная реализация в консоли
 */
public abstract class aSellingApplications {


    /**
     * Выводим список в консоль
     *
     * @param logic объект логики
     * @return количество позиций
     */
    protected int printAll(iLogic logic) {
        List<Product> productList = logic.showAllProducts();
        for (Product product : productList) {
            System.out.println("| " + product.getId() + "\t\t\t| " + product.getName() + "\t\t\t| " + product.getPrice() +
                    "\t| " + product.getCount() + "\t\t| " + product.getDescription() + "\t\t\t| ");
        }
        return productList.size();
    }

    /**
     * метод выводящий товары в консоль
     *
     * @param logic объект уровня логики
     * @return count количество товаров
     */
    protected int printAllProducts(iLogic logic) {
        System.out.println("+-----------+-------------------------------+-------+-----------+---------------------------" +
                "--------------------+");
        System.out.println("| N позиции\t| Наименование\t\t\t\t\t| Цена\t| Количество| Описание\t\t\t\t\t\t\t\t\t\t|");
        System.out.println("+-----------+-------------------------------+-------+-----------+---------------------------" +
                "--------------------+");
        var count = printAll(logic);
        System.out.println("+-----------+-------------------------------+-------+-----------+---------------------------" +
                "--------------------+");
        return count;
    }

    /**
     * Метод ввода строки
     *
     * @return строка
     */
    protected String inputString() throws RuntimeException {
        Scanner input = new Scanner(System.in);
        String str;
        try {
            str = input.next();
        } catch (Exception e) {
            throw new RuntimeException("Что-то вообще не верно ");
        }
        if (str.isEmpty()) {
            throw new RuntimeException("Введите что-нибудь...");
        }
        return str;
    }

    /**
     * ожидание команды и ввода
     */
    protected void waitInputEnter() {
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }

    /**
     * метод валидации числа
     *
     * @param min минимальное
     * @param max максимальное значение
     * @return введеное число
     * @throws RuntimeException
     */

    protected int inputInt(int min, int max) throws RuntimeException {
        int num = 0;
        Scanner input = new Scanner(System.in);
        try {
            num = input.nextInt();
        } catch (InputMismatchException e) {
            throw new RuntimeException("Это не число!");
        } catch (Exception e) {
            throw new RuntimeException("Что-т непонятное и странное -)");
        }
        if (num < min || num > max){
            throw new RuntimeException("Вы ввели неверное число!");
        }
        return num;
    }

    /**
     * выводим сообщение для пользователя
     * @param message сообщение
     */
    protected void printMessage(String message){
        System.out.println("==========================================================");
        System.out.print(message);
    }
}
