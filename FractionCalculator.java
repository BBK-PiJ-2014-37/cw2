
class FractionCalculator {

	public static void main(String[] args) {

		System.out.println("Welcome to Calculator. My name is Joel Armando.");
		System.out.println("This calculator takes as input: ");
		System.out.println("---> <fraction> ('a/b') ");
		System.out.println("---> <operator> <fraction> ('+ a/b', '- a/b)', '* a/b', '/ a/b')");
		System.out.println("---> 'abs' (or 'a', or 'A')");
		System.out.println("---> 'neg'(or 'n' or 'N')");
		System.out.println("---> 'clear'(or 'c' or 'C')");
		System.out.println("All of them can be combined by separating them with single space.");
		System.out.println("Please, enter the calculations you would like to do (key in 'quit', 'q' or 'Q' to finish).");
		Fraction acc = new Fraction(0, 1);

		while (true) {
			System.out.print("> ");
			String input = System.console().readLine();
			if (input.equals("q") || input.equals("quit") || input.equals("Q") ) {
				System.out.println("Goodbye!");
				return;
			}
			acc = evaluate(acc, input);
			System.out.println(acc);
		}
	}

	public static Fraction evaluate(Fraction acc, String expression) {
		String[] components = expression.split(" ");
		for(int i = 0; i < components.length; i++){
			switch(components[i]) {
				case "+":
				case "-":
				case "/":
				case "*":
					if (i == components.length - 1) {
						System.out.println("Expression ends with an operator.");
						return new Fraction(0,1);
					} 
					Fraction f2 = Fraction.parseFraction(components[i+1]);
					if (!f2.isValid()) {
						System.out.println(components[i+1] + " is not a fraction.");
						return new Fraction(0,1);
					}

					switch(components[i]){
						case "+":
        					acc = acc.add(f2);
        					break;
        				case "-":
        					acc = acc.subtract(f2);
        			   		break;
        				case "*":
        					acc = acc.multiply(f2);
        					break;
        				case "/":
        					acc = acc.divide(f2);
        					break;
					}
					i++;
					break;
				case "a":
        		case "A":
        		case "abs":
        			acc = acc.absolute();
        			break;
        		case "n":
        		case "N":
        		case "neg":
        			acc = acc.negate();
        			break;
        		case "c":
        		case "C":
        		case "clear":
        			acc = new Fraction(0, 1);
        			break;

        		default:
        			Fraction f = Fraction.parseFraction(components[i]);
        			if (f.isValid()){
        				acc = f;
        			} else {
        				System.out.println("Expecting a number, got: " + components[i]);
        				return new Fraction(0, 1);
        			}
        	}
        }
        return acc;
	}
}