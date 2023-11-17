import java.util.Random;

public class Util {
    Random random = new Random();
    public int CritHitCheck(int value, float chanse) {
        if (chanse > Math.abs(random.nextFloat())) {
            value *= 2;
        }
        return value;
    }

    public int ParyChek(int value, float chanse) {
        if (chanse > Math.abs(random.nextFloat())) {
            return 0;
        }
        return value;
    }

    public int Resistance(int value, int coeff) {
        value -= value * (coeff) / 100;
        return value;
    }
}
