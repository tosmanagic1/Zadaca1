package ba.unsa.etf.rpr;

/**
 * App class that has a main method.
 *
 * @author Tarik Osmanagic
 * @version 1.0
 */
public class App
{
    /**
     * Main method, which parses the input from the console from the args parameter and performs its validation.
     *
     * @param args stores the incoming command line arguments for the program.
     */
    public static void main( String[] args )
    {
        if (args.length != 0) {
            ExpressionEvaluator ee = new ExpressionEvaluator();
            String str = String.join(" ", args);
            Double value = ee.evaluate(str);
            System.out.println(value);
        }
    }
}
