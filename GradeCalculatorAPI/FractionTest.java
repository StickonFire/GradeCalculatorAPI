package GradeCalculatorAPI;

import static org.junit.Assert.*;
import org.junit.*;

public class FractionTest {

    private Fraction test;

    @Before
    public void setup(){
        test = new Fraction(1,1);
    }

    void checkValues(String method,int expectedNumerator, int expectedDenominator){
        assertEquals("Make sure " + method + " has the correct numerator",expectedNumerator,test.getNumerator());
        assertEquals("Make sure " + method +" has the correct denominator",expectedDenominator,test.getDenominator());
    }
    
    @Test
    public void testSetNumerator(){
        test.setNumerator(2);
        checkValues("setNumerator",2,1);
    }

    @Test
    public void testSetDenominator(){
        test.setDenominator(2);
        checkValues("setDenominator",1,2);
    }

    @Test
    public void testAddToNumeratorPositive(){
        test.addToNumerator(2);
        checkValues("addToNumerator(Positive)",3,1);

    }

    @Test
    public void testAddToNumeratorNegative(){
        test.addToNumerator(-1);
        checkValues("addToNumerator(Negative)",0,1);
    }

    @Test
    public void testAddToDenominatorPositive(){
        test.addToDenominator(1);
        checkValues("addtoDenominator(Positive)",1,2);
    }

    @Test
    public void testAddToDenominatorNegative(){
        test.addToDenominator(-1);
        checkValues("addtoDenominator(Negative)",1,0);
    }

    @Test
    public void testAddToBothPositive(){
        test.addToBoth(new Fraction(2,1));
        checkValues("addtoBoth(Positive)",3,2);
    }

    @Test
    public void testAddToBothNegative(){
        test.addToBoth(new Fraction(-1,-2));
        checkValues("addtoBoth(Negative)",0,-1);
    }

    @Test
    public void testAddToBothMixed(){
        test.addToBoth(new Fraction(-4,3));
        checkValues("addToBoth(Mixed)",-3,4);
    }
}
