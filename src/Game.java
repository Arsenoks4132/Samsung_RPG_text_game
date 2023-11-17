import java.util.Random;
import java.util.Scanner;

public class Game {
    private static int countOfPlayers = 2;
    private static Player[] players = new Player[countOfPlayers];
    private static int[] gameMode = new int[countOfPlayers];
    private static Scanner inp = new Scanner(System.in);
    public static void startGame(){
        Scenary.greeting();
        for (int i = 0; i < countOfPlayers; i++) {
            Scenary.choiceName();
            players[i] = makePlayer();
            Scenary.choiceGameMode();
            gameMode[i] = setGameMode();
            Scenary.choiceUnits();
            players[i].setUnits(choiseUnits(), inp);
            if (i != countOfPlayers-1) Scenary.nextPlayerChoose();
        }
    }

    public static Player makePlayer(){
        String name = inp.next();
        return new Player(name);
    }

    public static int[] choiseUnits(){
        int[] nums = new int[3];
        for (int i = 0; i < 3; i++){
            nums[i] = inp.nextInt();
        }
        return nums;
    }

    public static int setGameMode(){
        int mode = inp.nextInt();
        return mode;
    }

    public static String fighting(){
        Random rand = new Random();
        int curInd = rand.nextInt(countOfPlayers);
        Player enemy = players[curInd+1 < countOfPlayers ? curInd + 1 : 0], curPlayer = players[curInd];
        Scenary.startFight(curPlayer.getName());
        while (curInd < countOfPlayers){
            if (!curPlayer.isCanPlay()) {
                Scenary.gameOver(curPlayer.getName());
                return enemy.getName();
            }
            curPlayer = players[curInd];
            Scenary.newTurn(curPlayer.getName());
            if (curInd == countOfPlayers-1) curInd = 0;
            else curInd++;

            enemy = players[curInd];
            Scenary.enemyInfo(enemy);
            Scenary.choiceUnit(curPlayer);
            Unit curUnit = curPlayer.chooseUnit(inp.nextInt());

            if (curUnit.isCan_ultimate()) {
                Scenary.choiceAction();
                int numAct = inp.nextInt();
                if (numAct == 1) {
                    Scenary.choiceTarget();
                    int target = inp.nextInt();
                    curUnit.attack(enemy.chooseUnit(target));
                    if (!enemy.chooseUnit(target).isAlive()){
                        enemy.decreaseLiveUnits();
                    }
                } else {
                    curUnit.ultimate(curPlayer.getUnits(), enemy.getUnits());
                }
            } else {
                Scenary.choiceTarget();
                int target = inp.nextInt();
                curUnit.attack(enemy.chooseUnit(target));
                if (!enemy.chooseUnit(target).isAlive()){
                    enemy.decreaseLiveUnits();
                }
            }
        }
        return enemy.getName();
    }
    public static void endGame(String name){
        Scenary.theEnd(name);
    }
}
