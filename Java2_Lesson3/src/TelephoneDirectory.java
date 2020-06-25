import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// телефонный справочник
public class TelephoneDirectory {

    private HashMap<String,Object> directory = new HashMap();

    public void add(String surname, String number) {
        if (directory.containsKey(surname)) {
            ArrayList<String> arrNumbers = (ArrayList<String> )directory.get(surname);
            arrNumbers.add(number);
            directory.replace(surname, arrNumbers);
        } else {
            ArrayList<String> arrNumbers = new ArrayList<>(Arrays.asList(number));
            directory.put(surname, arrNumbers);
        }

    }

    public void get(String surname) {
        if (directory.containsKey(surname)) {
            ArrayList<String> arrNumbers = (ArrayList<String> )directory.get(surname);
            System.out.println("Найдены следующие номера телефонов для фамилии " + surname + ":");
            for (String number:arrNumbers) {
                System.out.println(number);
            }
        } else {
            System.out.println("Нет номеров телефона для фамилии " + surname + ".");
        }
    }
}

