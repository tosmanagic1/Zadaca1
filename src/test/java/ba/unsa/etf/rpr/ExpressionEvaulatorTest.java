package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ExpressionEvaulatorTest tests the ExpressionEvaulator class in ExpressionEvaulator.java.
 *
 * @author Tarik Osmanagic
 * @version 1.0
 * @see ExpressionEvaluator
 */
public class ExpressionEvaulatorTest
{

    /**
     * correctResult method tests the correctness of the results of the evaluate method from the ExpressionEvaulator class.
     */
    @Test
    public void correctResult () {
        ExpressionEvaluator ee = new ExpressionEvaluator();
        String s = "( 1 + ( 5 * 20 ) )";
        Double value = ee.evaluate(s);
        assertEquals(101, value);
    }

    /**
     * correctResult2 method tests the correctness of the results of the evaluate method from the ExpressionEvaulator class.
     */
    @Test
    public void correctResult2 () {
        ExpressionEvaluator ee = new ExpressionEvaluator();
        String s = "( 1 + ( ( 2 - 3 ) * ( 20 / 5 ) ) )";
        Double value = ee.evaluate(s);
        assertEquals(-3, value);
    }

    /**
     * correctResultWithSqrtFunction method tests the correctness of the results of the evaluate method from the ExpressionEvaulator class.
     */
    @Test
    public void correctResultWithSqrtFunction () {
        ExpressionEvaluator ee = new ExpressionEvaluator();
        String s = "( 1 + ( ( 2 * 3 ) * ( 10 * sqrt ( 25 ) ) ) )";
        Double value = ee.evaluate(s);
        assertEquals(301, value);
    }

    /**
     * stringDoesNotBeginOrEndWithParenthesis method tests whether the evaluate method throws a runtime exception, when there are no parentheses at the beginning or end of the string.
     */
    @Test
    public void stringDoesNotBeginOrEndWithParenthesis () {
        ExpressionEvaluator ee = new ExpressionEvaluator();
        String s = " 1 + ( 5 * 20 ) )";
        assertThrows(RuntimeException.class, () -> ee.evaluate(s), "The expression is not arithmetically valid!");
        ExpressionEvaluator ee1 = new ExpressionEvaluator();
        String s1 = "( 1 + 20";
        assertThrows(RuntimeException.class, () -> ee1.evaluate(s1), "The expression is not arithmetically valid!");
    }

    /**
     * arithmeticallyInvalid method tests whether the evaluate method throws a runtime exception, when string is arithmetically invalid.
     */
    @Test
    public void arithmeticallyInvalid () {
        ExpressionEvaluator ee = new ExpressionEvaluator();
        String s = "( 1 + ( 5 * 20 ))";
        assertThrows(RuntimeException.class, () -> ee.evaluate(s), "The expression is not arithmetically valid!");
    }

    /**
     * isResultOfAppropriateType method tests whether the result of evalute method is of the correct type.
     */
    @Test
    public void isResultOfAppropriateType () {
        ExpressionEvaluator ee = new ExpressionEvaluator();
        String s = "( 2 - 1 + ( 2 * 5 ) )";
        assertTrue(ee.evaluate(s) instanceof Double);
    }

    /**
     * doesTrimFunctionWorkProperly method tests does the trim method in the evaluate method erase all spaces at the beginning and end of the string.
     */
    @Test
    public void doesTrimFunctionWorkProperly () {
        ExpressionEvaluator ee = new ExpressionEvaluator();
        String s = "   ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )   ";
        Double value = ee.evaluate(s);
        assertEquals(101, value);
    }

}
