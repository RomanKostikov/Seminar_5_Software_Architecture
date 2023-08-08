import appLayer.baseAppRealization.BaseAppClientRealization;
import businessLogicLayer.AppLogic;
import dataBaseLayer.DataBase;
import dataBaseLayer.ProductRepo;

public class Main {
    public static void main(String[] args) {
        // содание и подключение БД, репозитория и логики
        var dbInstance = DataBase.getInstance();
        var repository = new ProductRepo(dbInstance);
        var logic = new AppLogic(repository);

        // запуск main блока
        BaseAppClientRealization realization = new BaseAppClientRealization(logic);
        realization.mainMenu();

    }
}