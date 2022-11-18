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
            else if (s1[i].equals("+")) ops.push(s1[i]);
            else if (s1[i].equals("-")) ops.push(s1[i]);
            else if (s1[i].equals("*")) ops.push(s1[i]);
            else if (s1[i].equals("/")) ops.push(s1[i]);
            else if (s1[i].equals("sqrt")) ops.push(s1[i]);
            else if (s1[i].equals(")")) {
                if (ops.empty()) continue;
                String op = ops.pop();
                Double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            else vals.push(Double.parseDouble(s1[i]));


        }


        return vals.pop();
    }
}
