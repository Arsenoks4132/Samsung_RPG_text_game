public class Unit {
    Util util = new Util();
    protected String name = "Персонаж";
    protected boolean Alive = true;
    protected int health = 100;
    protected boolean can_ultimate = false;
    protected int defence = 10;
    protected int power = 15;
    protected float CriticalChanse = 0.1f;
    protected float ParryChanse = 0.1f;

    public boolean isAlive() {
        return Alive;
    }
    public void setAlive(boolean alive) {
        Alive = alive;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isCan_ultimate() {
        return can_ultimate;
    }

    public void setCan_ultimate(boolean can_ultimate) {
        this.can_ultimate = can_ultimate;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public float getCriticalChanse() {
        return CriticalChanse;
    }

    public void setCriticalChanse(float criticalChanse) {
        CriticalChanse = criticalChanse;
    }

    public float getParryChanse() {
        return ParryChanse;
    }

    public void setParryChanse(float parryChanse) {
        ParryChanse = parryChanse;
    }

    public void attack(Unit unit) {
        int damage = util.CritHitCheck(power, CriticalChanse);
        System.out.println(this.name + " атакует " + unit.name + ", пытаясь нанести урон: " + damage);
        if (damage > power) {
            System.out.println("Критический удар!");
        }
        unit.takeDamage(damage);
        if (!can_ultimate) {
            System.out.println("Обретена концентрация");
            this.can_ultimate = true;
        }
    }
    public void ultimate(Unit[] PlayerUnits, Unit[] RivalUnits) {
        this.can_ultimate = false;
        System.out.println("Концентрация потрачена");
    }
    public void takeDamage(int damage) {
        damage = util.Resistance(damage, defence);
        this.health -= util.ParyChek(damage, ParryChanse);
        System.out.println(name + " - получено урона: " + damage);
        if (damage == 0) {
            System.out.println("Успешное парирование!");
        }
        if (this.health <= 0) {
            this.health = 0;
            this.Alive = false;
            System.out.println(this.name + " погиб...");
        }
    }
    public void takeHealing(int hprec) {
        this.health += hprec;
        System.out.println(name + " восстановил здоровье: " + hprec);
    }
    public String toString() {
        return name + ": Здоровье - " + health + ", Концентрация - " + (can_ultimate ? "Полная" : "Недостаточная");
    }
}