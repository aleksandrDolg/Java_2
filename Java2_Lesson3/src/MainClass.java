import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {

    public static void main(String[] args) {
        task1();
        System.out.println();
        task2();
    }

    // первое задание
    public static void task1() {
        List<String> sourceArray = Arrays.asList("один", "два", "три", "четыре", "пять", "один", "два", "три",
                "один", "два", "два");
        HashMap<String,Integer> uniqueArray  = new HashMap();
        // сформируем массив уникальных значение
        for (String val:sourceArray) {
            if (uniqueArray.containsKey(val)){
                Integer countVal = uniqueArray.get(val);
                uniqueArray.replace(val,countVal+1);
                //   uniqueArray.put(val,countVal+1); // так тоже работает
            } else {
                uniqueArray.put(val, 1);
            }

        }
        // напечатаем результат
        System.out.println("Задание1");
        System.out.println("Всего уникальных слов: " +uniqueArray.size());
        System.out.println("Уникальные слова и кол-во:");
        for (Map.Entry<String, Integer> o : uniqueArray.entrySet()) {
            System.out.println(o.getKey() + ": " + o.getValue());
        }

    }

    public static void task2() {
        TelephoneDirectory td = new TelephoneDirectory();
        td.add("Иванов", "111-11-11");
        td.add("Иванов", "222-22-22");
        td.add("Петров", "333-33-33");
        td.add("Иванов", "444-44-44");
        td.add("Петров", "555-55-55");
        // напечатаем результат
        System.out.println("Задание2");
        td.get("Иванов");
        td.get("Сидоров");
        td.get("Петров");
    }
}
