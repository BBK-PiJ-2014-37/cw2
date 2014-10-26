public class FractionTest {
    public static void main(String[] args) {

        // test divide by zero - should print an error and exit
    Fraction invalid = new Fraction(1, 0);

    if (invalid.isValid()) {
    	System.out.println("1/0 should be invalid!");
    }

        // test multiply
	Fraction f = new Fraction(3,10); 
    if (!f.isValid()) {
    	System.out.println("3/10 should be invalid!");
    }
 
	Fraction g = new Fraction(1,2);
	Fraction h = new Fraction(3,5);
	Fraction i = new Fraction(-10,5);
	Fraction j = new Fraction(-1,4);
	test(f, g.multiply(h), "Multiply failed");

        // test equals
	test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
	test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
	test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
	test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
	test(new Fraction(4, -8),new Fraction(-1, 2),"error test 5");

	       // test divide
	test(h, f.divide(g), "Divide #1 failed");
	test(j, g.divide(i), "Divide #2 failed");

			// test addition
	Fraction p = new Fraction(11,10); 
	
	test(p, g.add(h), "Addition failed");
	test(new Fraction(-3, 2), new Fraction(-18,9).add(new Fraction(1,2)), "Addition #2 failed");

			// test negation
	Fraction q = new Fraction(-1,10); 
	Fraction r = new Fraction(1,10);

	test(r, q.negate(), "Opposite failed" );
	test(new Fraction(11,-10), p.negate(), "Opposite failed");
	
			//test absolute
	test(r, q.absolute(), "Absolute failed");
	test(r, r.absolute(), "Absolute failed");

			//test subtraction
	test(q, g.subtract(h), "Subtraction failed");
	test(new Fraction(6,-5), q.subtract(p), "Subtraction failed");

			//test parsing
	test(new Fraction(1, 5), Fraction.parseFraction("1/5"), "Parse failed");
	test(new Fraction(1, 5), Fraction.parseFraction("2/10"), "Parse failed");
	test(new Fraction(2, 1), Fraction.parseFraction("2"), "Parse failed");
    }

    static void test(Fraction f1, Fraction f2, String msg){
    	if (! f1.equals(f2)) {
			System.out.println(msg + ": expected " + f1 + " got " + f2);
		}
    }

}
