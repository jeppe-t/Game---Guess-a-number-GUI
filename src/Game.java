package video25;

import java.util.Random;

public class Game {

    private int randomNumber;

    public Game() {

        Random random = new Random();
        randomNumber = random.nextInt(10) + 1;


    }

    int getRandomNumber(){
        return randomNumber;
    }




}
