package Lesson1;

import java.util.Random;

// класс кошка
public class Cat implements Jumping,Running,Overcoming {

    protected int maxRun = 0;
    protected double maxJump = 0;
    private String name;
    private Boolean continueOvercoming = true;


    public Cat(int num){
        this.name = "Кошка " + num;
        setInitialValues();
    }

    private void setInitialValues(){
        Random r = new Random();
        maxRun = 20 + r.nextInt(480); // от 20 до 500
        maxJump = 0.5 + 2.5 * r.nextDouble(); // от 0.5 до 3
        System.out.println("Имя кошки: " + name +", Макс. бег: " + maxRun + ", Макс. прыжок: " + maxJump);
    }

    @Override
    public void jump() {
        System.out.println("Кошка прыгнула");
    }

    @Override
    public void jumpOverObstacles(Wall obstacle) {
        if(maxJump > obstacle.getHeight()){
            System.out.println("Кошка "+name+" прыгнула через стену");
        } else {
            System.out.println("Кошка "+name+" не смогла перепрыгнуть через стену");
            continueOvercoming = false;
        }
    }

    @Override
    public void run() {
        System.out.println("Кошка побежала");
    }

    @Override
    public void runOverObstacles(Treadmill obstacle) {
        if(maxRun > obstacle.getLength()){
            System.out.println("Кошка "+name+" пробежала по беговой дорожке");
        } else {
            System.out.println("Кошка "+name+" не смогла пробежать по беговой дорожке");
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
                System.out.println("Кошка "+name+" не знает такого препятствия");
            }
        } else {
            System.out.println("Кошка "+name+" не может продолжать");
        }
        return continueOvercoming;
    }
}
