import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String[] menu = {"Добавить", "Показать", "Удалить", "Найти"};
        List<String> list = new ArrayList<>();

        Scanner in = new Scanner(System.in);


        while (true) {

            System.out.println("Выберите меню");
            for (int i = 0; i < menu.length; i++) {
                System.out.println(i + 1 + " " + menu[i]);
            }
            String s = in.nextLine();
            System.out.println();

            if (s.equals("end")) {
                break;
            }

            int mInt = 0;
            try {
                mInt = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Введите корректный номер меню!");
                continue;
            }
            ;

            switch (mInt) {
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    String item = in.nextLine();
                    list.add(item);
                    System.out.println("Итого в списке покупок: " + list.size());
                    break;
                case 2:
                    System.out.println("Список покупок:");
                    showList(list);
                    break;
                case 3:
                    showList(list);
                    System.out.println("Какую хотите удалить? Введите номер или название");
                    item = in.nextLine();
                    try {
                        int itemInt = Integer.parseInt(item);
                        if (itemInt >= 0 && itemInt <= list.size()) {
                            System.out.println("Покупка " + list.remove(itemInt - 1) + " удалена, список покупок:");
                            showList(list);
                        } else {
                            System.out.println("Такового номера нет!");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        boolean deleted = false;
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).equals(item)) {
                                System.out.println("Покупка " + list.remove(i) + " удалена, список покупок:");
                                showList(list);
                                deleted = true;
                            }
                        }
                        if (!deleted) {
                            System.out.println("Такого товара нет");
                            continue;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Введите текст для поиска:");
                    item = in.nextLine();
                    System.out.println("Найдено:");
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).toLowerCase().indexOf(item.toLowerCase()) != -1) {
                            System.out.println(i + 1 + " " + list.get(i));
                        }
                    }

                    break;
                default:
                    System.out.println("Такого номера меню нет!");
                    break;
            }

            System.out.println();
        }
    }

    private static void showList(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + " " + list.get(i));
        }
    }

}
