public class Knight extends Unit{
    protected int healrate = 10;
    public Knight(String unitName) {
        name = "Мечник " + unitName;
        health = 125;
        CriticalChanse = 0.3f;
        ParryChanse = 0.3f;
    }
    public void healing(Unit unit) {
        unit.takeHealing(healrate);
    }
    @Override
    public void ultimate(Unit[] PlayerUnits, Unit[] RivalUnits) {
        for (Unit teammate : PlayerUnits) {
            this.healing(teammate);
        }
        super.ultimate(PlayerUnits, RivalUnits);
    }
}