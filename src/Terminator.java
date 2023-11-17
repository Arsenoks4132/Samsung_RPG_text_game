public class Terminator extends Unit{
    protected int rockets = 3;
    protected float defDecrease = 0.7f;
    public Terminator(String unitName) {
        name = "Терминатор " + unitName;
        power = 10;
        defence = 25;
        CriticalChanse = 0.6f;
        ParryChanse = 0.15f;
    }
    public void rocketshot(Unit unit) {
        rockets--;
        System.out.println(this.name + " атакует ракетами " + unit.name + ", пытаясь нанести урон: " + power * 3);
        System.out.println("Ракет осталось: " + rockets);
        unit.takeDamage(power * 3);
    }
    public void weakening(Unit unit) {
        System.out.println("Броня " + name + " снижена: " + (int) ((1 - defDecrease) * 100) + "%");
        unit.setDefence((int) (unit.getDefence() * defDecrease));
    }
    @Override
    public void attack(Unit unit) {
        if (rockets > 0) {
            rocketshot(unit);
        }
        else {
            super.attack(unit);
        }
    }

    @Override
    public void ultimate(Unit[] PlayerUnits, Unit[] RivalUnits) {
        for (Unit enemy : RivalUnits) {
            this.weakening(enemy);
        }
        super.ultimate(PlayerUnits, RivalUnits);
    }

    @Override
    public String toString() {
        return super.toString() + ", Ракеты - " + rockets;
    }
}