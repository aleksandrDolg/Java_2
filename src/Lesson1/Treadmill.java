package Lesson1;
import java.util.Random;

// Класс беговая дорожка
public class Treadmill extends Obstacle {
   private int length;

    public Treadmill(){
        setInitialValues();
    }

    public int getLength() {
        return length;
    }


    @Override
    protected void setInitialValues() {
        Random r = new Random();
        length =  20 + r.nextInt(380); // от 20 до 400
    }

}
