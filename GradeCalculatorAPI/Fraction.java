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

    int getNumerator(){
        return numerator;
    }

    int getDenominator(){
        return denominator;
    }

    void addToNumerator(int additive){
        this.numerator += additive;
    }

    void addToDenominator(int additive){
        this.denominator += additive;
    }

    void addToBoth(Fraction other){
        this.numerator += other.numerator;
        this.denominator += other.denominator;
    }
}
