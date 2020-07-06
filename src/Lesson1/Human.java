package Lesson1;

import java.util.Random;

// Класс человек
public class Human implements Jumping,Running,Overcoming {

    protected int maxRun = 0;
    protected double maxJump = 0;
    private String name;
    private Boolean continueOvercoming = true;


    public Human(int num){
        this.name = "Человек " + num;
        setInitialValues();
    }

    private void setInitialValues(){
        Random r = new Random();
        maxRun = 20 + r.nextInt(480); // от 20 до 500
        maxJump = 0.5 + 2.5 * r.nextDouble(); // от 0.5 до 3
        System.out.println("Имя человека: " + name +", Макс. бег: " + maxRun + ", Макс. прыжок: " + maxJump);
    }
    @Override
    public void jump() {
        System.out.println("Человек прыгнул");
    }

    @Override
    public void jumpOverObstacles(Wall obstacle) {
        if(maxJump > obstacle.getHeight()){
            System.out.println("Человек "+name+" прыгнул через стену");
        } else {
            System.out.println("Человек "+name+" не смог перепрыгнуть через стену");
            continueOvercoming = false;
        }
    }

    @Override
    public void run() {
        System.out.println("Человек побежал");
    }

    @Override
    public void runOverObstacles(Treadmill obstacle) {
        if(maxRun > obstacle.getLength()){
            System.out.println("Человек "+name+" пробежал по беговой дорожке");
        } else {
            System.out.println("Человек "+name+" не смог пробежать по беговой дорожке");
            continueOvercoming = false;
        }
    }

    @Override
    public boolean overcomeObstacle(Object obstacle) {
        if (continueOvercoming) {
            if (obstacle instanceof Wall){
                jumpOverObstacles((Wall) obstacle);
            } else if(obstacle instanceof Treadmill) {
                runOverObstacles((Treadmill) obstacle);
            } else {
                System.out.println("Человек "+name+" не знает такого препятствия");
            }
        } else {
            System.out.println("Человек "+name+" не может продолжать");
        }
        return continueOvercoming;
    }
}
