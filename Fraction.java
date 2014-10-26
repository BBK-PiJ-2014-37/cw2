
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int denom) {
        if (denom == 0) {
            System.out.println("Invalid fraction with denominator 0"); 
	    // this should use exceptions
            return;
        }
        int gcd = myGcd(num, denom);
        num = num / gcd;
        denom = denom / gcd;
        if (denom < 0) {
            setNumerator(-num);
            setDenominator(-denom);
        } else {
            setNumerator(num);
            setDenominator(denom);
        }
    }

    @Override
    public String toString() {
        if (getDenominator() == 1) {
            return "" + getNumerator();
        } else {
            return "" + getNumerator() + '/' + getDenominator();
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int num) {
        denominator = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    public Fraction multiply(Fraction other) {

        int num = this.getNumerator() * other.getNumerator();
        int denom = this.getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
    }

    public Fraction divide(Fraction other) {

        int num = this.getNumerator() * other.getDenominator();
        int denom = this.getDenominator() * other.getNumerator();
        return new Fraction(num, denom);
    }

    public Fraction add(Fraction other) {

        int num = (this.getNumerator() * other.getDenominator()) + (other.getNumerator() * this.getDenominator());
        int denom = this.getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
    }

    public Fraction negate() {
        return new Fraction(-this.getNumerator(), this.getDenominator());
    }

    public Fraction absolute() {
        int num = this.getNumerator();
        if (num < 0) {
            num = -num;
        }            
        return new Fraction(num, this.getDenominator());
    }

    public Fraction subtract(Fraction other) {
        return this.add(other.negate());
    }


    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public boolean isValid() {
        return !(this.getDenominator() == 0);
    }

    static public Fraction parseFraction(String str) {
        String[] components = str.split("/");
        int num;
        int denom;
        if (components.length == 2 ){
            num = Integer.parseInt(components[0]);
            denom = Integer.parseInt(components[1]);
        } else if (components.length == 1){
            num = Integer.parseInt(components[0]);
            denom = 1;
        } else {
            System.out.println("parseFraction: " + str + " is not a fraction");
            num = 1;
            denom = 0;
        }
        return new Fraction(num, denom);

    }
}
