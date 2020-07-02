import java.util.Random;

public class MainClass {

    public static void main(String[] args) {
        Random r = new Random();
        int sum = 0;
        String[][] arr= new String[4][4];
        //arr= new String[5][4];
        fillArray(arr);
        //arr[2][3] = "*";
        OutputArray(arr);
        try {
            sum = calculateArray(arr);
            System.out.println("Сумма = " + sum);
        } catch (MyArraySizeException e) {
            System.out.println(e.toString());
        } catch (MyArrayDataException e) {
            System.out.println(e.toString());
        }

    }


    public static int calculateArray(String[][] arr) throws MyArraySizeException, MyArrayDataException{
        int res = 0;
            if (arr.length == 0 || arr.length >4 || arr[0].length>4) {
                throw new MyArraySizeException("Не верный размер массива (длина должна быть 4х4)", arr.length, arr[0].length);
            }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    res += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверное числовое значение",i,j);
                }
            }
        }
        return res;
    }

    // заполнение массива
    public static void fillArray(String[][] arr)
    {
        Random random=new Random();
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                arr[i][j] = String.valueOf(random.nextInt(255));
            }
        }
    }

    // печать массива
    public static void OutputArray(String[][] arr)
    {

        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
