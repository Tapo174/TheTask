package UI;

import results.config;
import toys.Toy;
import views.interfaces;
import views.view;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class App {
    public static void buttonClick() {
        view view = new view(new console(), config.pathDb);
        view.loadFromFile();

        String command;

        while (true) {

            command = prompt("""

                     1 - Добавить игрушку
                     2 - Удалить игрушку
                     3 - Разыграть игрушку
                     4 - Список игрушек
                     5 - Очистить все записи
                     6 - Сохраните все записи в файл
                     7 - Загрузите все записи из файла
                     8 - Выход
                    Сделайте свой выбор:\s""");
            if (command.equals("8")) {
                return;
            }
            try {
                switch (command) {
                    case "1" -> view.putForDrawing();
                    case "2" -> view.deleteFromDrawing();
                    case "3" -> view.getDrawing();
                    case "4" -> view.showAll();
                    case "5" -> view.clearAll();
                    case "6" -> view.saveToFile();
                    case "7" -> view.loadFromFile();
                    default -> System.out.println("\n Команда не найдена!");
                }
            } catch (Exception e) {
                System.out.println("Error. " + e.getMessage());
            }
        }
    }

    private static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private static Toy toyCreate() {
        int id = Integer.parseInt(prompt("ID: "));
        String name = prompt("Название игрушки: ");
        String weight = prompt("Вес игрушки: ");
        return (new Toy(id, name, Integer.parseInt(weight)));
    }
}