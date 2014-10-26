public class FractionCalculatorTest {
    public static void main(String[] args) {

    	test(new Fraction(2, 5), "1/2 / 5/4", "Division failed");
    	test(new Fraction(2,5), "1/2 * 4/5", "Multiplication failed");
    	test(new Fraction(4,5), "1/2 / 5/4 + 2/5", "Division and addition failed");
    	test(new Fraction(1, 2), "1/2 - 3/4 * 2 abs", "Calculation #1 failed");
        test(new Fraction(-7,8),"8 7/8 neg", "Calculation #2 failed");
        test(new Fraction(19, 48), "2 * 3/4 / 8 + 2 - 1 abs / 3", "Calculation #3 failed");
        test(new Fraction(-3, 2), "-2 + 1/2", "Calculation #4 failed");
    }

    static void test(Fraction f1, String expression, String msg){
    	Fraction result = FractionCalculator.evaluate(new Fraction(0, 1), expression);
    	if (! f1.equals(result)) {
			System.out.println(msg + ": expression: " + expression + " expected " + f1 + " got " + result);
		}
    }

}
