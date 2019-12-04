package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Arena {
    private int numOfBattles;
    private ArrayList<Fighter> fighters = new ArrayList<>();
    private int attacks[] = new int[5];
    private int blocks[] = new int[5];

    public Arena(){
        readFile();
    }

    public void readFile(){
        File file = new File("S:\\1920 Classes\\1st_Programing_II\\AK71\\arena\\src\\sample\\arena.dat");
        try {
            Scanner scanner = new Scanner(file);
            // this sets the total number of battles
            int num = Integer.parseInt(scanner.nextLine());
            setNumOfBattles(num);
            // singlePlayer sets each individual fighters data
            while(scanner.hasNextLine()) {
                singlePlayer(scanner);
            }
            // starts a battle
            for(int i = 0; i < fighters.size(); i = i + 2){
                battleTime(fighters.get(i), fighters.get(i + 1));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not find the file");
        }
    }

    public void singlePlayer(Scanner scanner){
        Fighter temp = new Fighter();
        fighters.add(temp);
        // goes through two lines and fills the attacks and blocks data
        for(int j = 0; j < 2; j ++) {
            for (int i = 0; i < 5; i++) {
                if(j == 0) {
                    int attack = scanner.nextInt();
                    temp.getAttackHeight()[i] = attack;
                }
                else{
                    int block = scanner.nextInt();
                    temp.getBlockHeight()[i] = block;
                }
            }
        }
    }

    public void battleTime(Fighter playerOne, Fighter playerTwo) {
        // Player one attacks
        for (int i = 0; i < 5; i++) {
            if (playerOne.getAttackHeight()[i] != playerTwo.getBlockHeight()[i]) {
                playerTwo.setHealth(playerTwo.getHealth() - 2);
            }
            else if (playerOne.getAttackHeight()[i] == playerTwo.getBlockHeight()[i]) {
                playerTwo.setHealth(playerTwo.getHealth());
            }
        }
        // Player two attacks
        for (int j = 0; j < 5; j++) {
            if (playerTwo.getAttackHeight()[j] != playerOne.getBlockHeight()[j]) {
                playerOne.setHealth(playerOne.getHealth() - 2);
            }
            else if (playerTwo.getAttackHeight()[j] == playerOne.getBlockHeight()[j]) {
                playerOne.setHealth(playerOne.getHealth());
            }
        }
        // Finding the result
            if (playerOne.getHealth() > 0 && playerOne.getHealth() > playerTwo.getHealth()) {
                System.out.println("Fighter 1 is the victor!");
            }
            else if(playerTwo.getHealth() > 0 && playerTwo.getHealth() > playerOne.getHealth()){
                System.out.println("Fighter 2 is the victor!");
            }
            else{
                System.out.println("This battle ended in a draw!");
            }
        }

    public int getNumOfBattles() {
        return numOfBattles;
    }

    public void setNumOfBattles(int numOfBattles) {
        this.numOfBattles = numOfBattles;
    }
}
