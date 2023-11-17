import java.util.Scanner;
public class Player {

    private String name = "Noname";
    public String getName() {
        return name;
    }
    
    private Unit[] units = new Unit[3];
    public Unit[] getUnits() {
        return units;
    }
    private int liveUnits = 3;
    public int getLiveUnits() {
        return liveUnits;
    }

    public void decreaseLiveUnits() {
        liveUnits--;
        if (liveUnits==0) canPlay = false;
    }

    private boolean canPlay = true;
    public boolean isCanPlay() {
        return canPlay;
    }
    public Player(String name){
        this.name = name;
    }

    public void setUnits(int[] choice, Scanner scan){
        for (int i = 0; i < units.length; i++) {
            switch (choice[i]){
                case(1):
                    System.out.println("Введите прозвище вашего мечника: ");
                    units[i] = new Knight(scan.next());
                    break;
                case(2):
                    System.out.println("Введите прозвище вашего терминатора: ");
                    units[i] = new Terminator(scan.next());
                    break;
                case(3):
                    System.out.println("Введите прозвище вашего волшебника: ");
                    units[i] = new Wizard(scan.next());
                    break;
                default:
                    System.out.println("Вы не нашли такого воина, однако к вам пришел мечник!\nВведите прозвище вашего подопечного: ");
                    units[i] = new Knight(scan.next());
                    break;
            }
        }
    }

    public void printUnitsParameters(){
        for (Unit unit : units) {
            System.out.println("\t" + unit);
        }
    }

    public Unit chooseUnit(int ind){
        return units[ind-1];
    }


}
