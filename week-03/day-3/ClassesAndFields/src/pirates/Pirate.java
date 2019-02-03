package pirates;

import java.util.Random;

public class Pirate {
    int levelOfIntoxication;
    boolean isDead;

    public Pirate(){
        levelOfIntoxication = 0;
        isDead = false;
    }
    public void drinkSomeRum(){
        if (!isDead){
            levelOfIntoxication ++;
        } else {
            System.out.println("He is dead.");
        }
    }
    public void howItGoingMate(){
        if (0 <= levelOfIntoxication && levelOfIntoxication <= 4 && !isDead){
            System.out.println("Pour me anudder!");
        }else if(levelOfIntoxication > 4 && !isDead) {
            System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
        }else if(isDead){
            System.out.println("He is dead.");
        }
    }

    public void die(){
        isDead = true;
    }
    public boolean getIsDead(){
        return isDead;
    }

    public void brawl(Pirate pirateToBrawlWith){
        int chance = (int)(0+Math.random()*3);

        if(chance < 1){
            this.die();
            System.out.println(chance);
            System.out.println(1/3);
        }else if (chance >= 1 && chance < 2){
            pirateToBrawlWith.die();
            System.out.println(chance);
            System.out.println(1/3);
            System.out.println(2/3);
        }else if (chance >= 2){
            this.die();
            pirateToBrawlWith.die();
            System.out.println(chance);
            System.out.println(2/3);
        }
    }
}
