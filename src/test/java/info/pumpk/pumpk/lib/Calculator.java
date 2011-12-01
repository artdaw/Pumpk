package info.pumpk.pumpk.lib;

/**
 * @author Gleb Galkin
 * @since 12/1/11
 */
public class Calculator {
    private float currentTotal;

    public Calculator() {
        this.currentTotal = 0;
    }

    public void add(float n) {
        this.currentTotal += n;
    }

    public float getCurrentTotal() {
        return currentTotal;
    }

    public void setCurrentTotal(float currentTotal) {
        this.currentTotal = currentTotal;
    }
}
