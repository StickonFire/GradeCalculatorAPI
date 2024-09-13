package GradeCalculatorAPI;

public class Fraction {
    private int numerator;
    private int denominator;

    Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    void setNumerator(int numerator){
        this.numerator = numerator;
    }

    void setDenominator(int denominator){
        this.denominator = denominator;
    }
}
