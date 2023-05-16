package UI;

import java.util.List;
import java.util.Scanner;

import results.config;
import views.interfaces;
import toys.Toy;

public class console implements interfaces {
    Scanner in;

    public console() {
        in = new Scanner(System.in);
    }

    @Override
    public int getToyId() {
        System.out.print("Идентификатор игрушки: ");
        return Integer.parseInt(in.nextLine());
    }

    @Override
    public String getToyNaming() {
        System.out.print("Название игрушки: ");
        return in.nextLine();
    }

    @Override
    public int getToyWeight() {
        System.out.print("Вес игрушки: ");
        return Integer.parseInt(in.nextLine());
    }

    @Override
    public void showAll(List<Toy> toys) {
        System.out.println("\nВсе игрушки для рисования:");
        for (Toy toy : toys) {
            System.out.println(toy);
        }

    }

    @Override
    public void showGetToy(Toy toy) {
        System.out.print("\nРезультаты жеребьевки: ");
        System.out.println(toy);
    }

    @Override
    public void loadMessage() {
        System.out.println("\nFile is loaded to current session");
    }

    @Override
    public boolean clearAllDecision() {
        boolean f = false;
        System.out.print("\nВы уверены, что очистили все записи (y/n): ");
        if (in.nextLine().equalsIgnoreCase("Y")) {
            f = true;
        }
        return f;
    }

    @Override
    public void savedAll() {
        System.out.println("\nВсе записи сохраняются в файл: " + config.pathDb);
    }

    @Override
    public void savedItem() {
        System.out.println("\nУспешно добавлено в текущий сервис");
    }

    @Override
    public void saveError() {
        System.out.println("\nНе удалось добавить текущую службу");
    }

    @Override
    public void emptyListMessage() {
        System.out.println("Список игрушек пуст!");
    }

    @Override
    public int getDrawTimes() {
        System.out.print("Сколько раз вы хотите нарисовать: ");
        return Integer.parseInt(in.nextLine());
    }
}