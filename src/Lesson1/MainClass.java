package Lesson1;


import java.util.Random;

public class MainClass {


    public static void main(String[] args) {
        Run();
    }

    public static void Run () {
        Random r = new Random();
        Overcoming[] participantArray = new Overcoming[5]; //  объявляем массив участников
        Obstacle[] overcomingArray = new Obstacle[7]; //  объявляем массив препятствий
        // создаем массив участников
        for (int i = 0; i < participantArray.length; i++) {
            int c = r.nextInt(3);
            switch (c) {
                case 0:
                    participantArray[i] = new Human(i);
                    break;
                case 1:
                    participantArray[i] = new Robot(i);
                    break;
                case 2:
                    participantArray[i] = new Cat(i);
                    break;
            }
        }
        // создаем массив препятствий
        for (int j = 0; j < overcomingArray.length; j++) {
            int c = r.nextInt(2);
            switch (c){
                case 0:  overcomingArray[j] = new Wall();
                    break;
                case 1:  overcomingArray[j] = new Treadmill();
                    break;
            }
        }
        // проходим по препятствиям
        for(Overcoming p : participantArray) {
            for (Obstacle ov: overcomingArray) {
                if (!p.overcomeObstacle(ov)) {
                    break;
                }
            }
        }
    }

}
