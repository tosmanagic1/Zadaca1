package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 *A Java Maven console application that will be used to parse and calculate arithmetic expressions using the Dijkstra expression evaluation algorithm.
 *
 * @author Tarik Osmanagic
 * @version 1.0
 */
public class ExpressionEvaluator {
    /**
     * ops represents stack for operators.
     */
    private Stack<String> ops;

    /**
     * vals represents stack for numbers.
     */
    private Stack<Double> vals;

    /**
     * A constructor that initializes two private attributes of type Stack.
     */
    public ExpressionEvaluator () {
        this.ops = new Stack<String>();
        this.vals = new Stack<Double>();
    }

    public Stack<String> getOps() {
        return ops;
    }

    public void setOps(Stack<String> ops) {
        this.ops = ops;
    }

    public Stack<Double> getVals() {
        return vals;
    }

    public void setVals(Stack<Double> vals) {
        this.vals = vals;
    }

    /**
     * Method evaluate that implements the Dijkstra algorithm.
     * @param s type String that is passed to the function.
     * @return some number of type Double.
     * @throws RuntimeException when the string passed to the class is arithmetically incorrect.
     */
    public Double evaluate (String s) {

        s = s.trim(); // removes the leading and trailing spaces present in the string

        if (s.charAt(0) != '(' || s.charAt((s.length()-1)) != ')') throw new RuntimeException ("The expression is not arithmetically valid!"); //if there are no brackets at the beginning or end of the string

        int counter = 0; //space counter
        for (int i = 0; i < s.length(); i++) { // space counting loop
            if (s.charAt(i) == ' ') counter++;
        }
        String [] s1 = s.split(" "); // split a string into an array of strings

        if (counter != s1.length-1) throw new RuntimeException ("The expression is not arithmetically valid!"); // the number of spaces is always one less than the number of characters in the string

        for (int i = 0; i < s1.length; i++) {
            if (s1[i].equals("(")) continue;
            else if (s1[i].equals("+")) getOps().push(s1[i]);
            else if (s1[i].equals("-")) getOps().push(s1[i]);
            else if (s1[i].equals("*")) getOps().push(s1[i]);
            else if (s1[i].equals("/")) getOps().push(s1[i]);
            else if (s1[i].equals("sqrt")) getOps().push(s1[i]);
            else if (s1[i].equals(")")) {
                String op = getOps().pop();
                Double v = getVals().pop();
                if (op.equals("/") && v.equals(0.0)) throw new RuntimeException ("Division by zero is not allowed!");
                if (op.equals("+")) v = getVals().pop() + v;
                else if (op.equals("-")) v = getVals().pop() - v;
                else if (op.equals("*")) v = getVals().pop() * v;
                else if (op.equals("/")) v = getVals().pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                getVals().push(v);
            }
            else getVals().push(Double.parseDouble(s1[i]));


        }


        return getVals().pop();
    }
}
