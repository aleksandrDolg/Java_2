import java.util.Arrays;

public class MainClass {



    public static void main(String[] args)  throws InterruptedException  {
        float[] arr = new float[size];
        Arrays.fill(arr,1);
        runOne(arr); // однопоточный вызов
        runTwo(arr); // двухпоточный вызов
    }

    static final int size = 10_000_000;
    static final int h = size / 2;
    public static void runOne(float[] arr){
        System.out.println("Начало однопоточного вызова");
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время однопоточный вызова:" + (System.currentTimeMillis() - a));
    }

    public static void runTwo(float[] arr)  throws InterruptedException {
        System.out.println("Начало многопоточого вызова");
        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        SumClass c1 = new SumClass(a1);
        SumClass c2 = new SumClass(a2);

        Thread thread1 = new Thread(() -> c1.sum());
        Thread thread2 = new Thread(() -> c2.sum());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Время многопоточный вызова:" + (System.currentTimeMillis() - a));
    }

    // Класс для суммирования
    public static class SumClass {
        float[] arr;

        public float[] getArr() {
            return arr;
        }

        public SumClass(float[] arr){
            this.arr = arr;
        }

        public void sum() {
            for (int i = 0; i < arr.length ; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }


    }

}

