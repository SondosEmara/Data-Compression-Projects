package arithmeticcoding;

public class Symbol {

    char character;
    double lowRange;
    double highRange;
    double rage;
    double lower;
    double upper;

    public char getchar() {
        return character;
    }

    public double getLowRange() {
        return lowRange;
    }

    public double getHighRange() {
        return highRange;
    }

    public double getRage() {
        return rage;
    }

    public double getLower() {
        return lower;
    }

    public double getUpper() {
        return upper;
    }

    public void setchar(char character) {
        this.character = character;
    }

    public void setLowRange(double lowRange) {
        this.lowRange = lowRange;
    }

    public void setHighRange(double highRange) {
        this.highRange = highRange;
    }

    public void setRage(double rage) {
        this.rage = rage;
    }

    public void setLower(double lower) {
        this.lower = lower;
    }

    public void setUpper(double upper) {
        this.upper = upper;
    }

    public void print() {
        System.out.println(
                "character " + character
                + "   lowRange " + lowRange
                + "   highRange " + highRange
                + "   lower " + lower
                + "   upper " + upper
                + "   range " + rage
        );
    }
}
