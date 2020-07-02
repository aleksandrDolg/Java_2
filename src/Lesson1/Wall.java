package Lesson1;

import java.util.Random;

//Класс стена
public class Wall extends Obstacle {

    private double height;

    public Wall(){
        setInitialValues();
    }

    public double getHeight() {
        return height;
    }

    @Override
    protected void setInitialValues() {
        Random r = new Random();
        height =  0.5 + 2 * r.nextDouble(); // от 0.5 до 2.5
    }
}
