public class Wizard extends Unit{
    protected int mana = 100;
    protected int spellcost = 10;
    public Wizard(String unitName) {
        name = "Волшебник " + unitName;
        power = 35;
        defence = 0;
        CriticalChanse = 0;
        ParryChanse = 0;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void attack(Unit unit) {
        if (mana >= spellcost) {
            System.out.println("Потрачено маны - " + spellcost);
            super.attack(unit);
            mana -= spellcost;
        }
    }

    @Override
    public void ultimate(Unit[] PlayerUnits, Unit[] RivalUnits) {
        for (Unit enemy : RivalUnits) {
            enemy.takeDamage(power / 2);
        }
        super.ultimate(PlayerUnits, RivalUnits);
    }

    @Override
    public String toString() {
        return super.toString() + ", Мана - " + mana;
    }
}