import tester.*;

interface Number {
    int numerator();
    int denominator();
    Number add(Number other);
    Number multiply(Number other);
    String toText();
    double toDouble();
}

class WholeNumber implements Number {
    int n;
    WholeNumber(int n) {
        this.n = n;
    }
    public int numerator() {
        return n;
    }
    public int denominator() {
        return 1;
    }
    public Number add(Number other) {
        return new Fraction((this.numerator() * other.denominator() + other.numerator()), other.denominator());
    }
    public Number multiply(Number other) {
        return new Fraction(n * other.numerator(), other.denominator());
    }
    public String toText() {
        return n + "";
    }
    public double toDouble() {
        return this.n * 1.0;
    }
}
class Fraction implements Number {
    int n;
    int d;
    Fraction(int n, int d) {
        this.n = n;
        this.d = d;
    }
    public int numerator() {
        return n;
    }
    public int denominator() {
        return d;
    }
    public Number add(Number other) {
        return new Fraction((this.numerator() * other.denominator() + this.numerator() * other.numerator()), this.denominator() * other.denominator());
    }
    public Number multiply(Number other) {
        return new Fraction(this.numerator() * other.numerator(), this.denominator() * other.denominator());
    }
    public String toText() {
        return n + "/" + d;
    }
    public double toDouble() {
        return this.numerator() * 1.0 / this.denominator() * 1.0;
    }
}
class Decimal implements Number {
    int mantissa;
    int exponent;
    Decimal(String decimal) {
        this.mantissa = Integer.parseInt(decimal.substring(0,decimal.indexOf("."))+decimal.substring(decimal.indexOf(".")+1, decimal.length()));
        this.exponent = -1 * decimal.substring(decimal.indexOf("."), decimal.length()).length() + 1;
    }
    public int numerator() {
        return mantissa;
    }
    public int denominator() {
        return (int) Math.pow(10, exponent * -1);
    }
    public Number add(Number other) {
        return new Fraction((mantissa * other.denominator() + (int) Math.pow(10, exponent * -1) * other.numerator()), this.denominator() * other.denominator());
    }
    public Number multiply(Number other) {
        return new Fraction(mantissa * other.numerator(), (int) Math.pow(10, exponent * -1) * other.denominator());
    }
    public String toText() {
        return String.valueOf(this.numerator() * 1.0 / this.denominator() * 1.0);
    }
    public double toDouble() {
        return this.numerator() * 1.0 / this.denominator() * 1.0;
    }
}
class ExampleNumbers {
    Number n1 = new WholeNumber(5);
    Number n2 = new WholeNumber(7);
    Number n3 = new Fraction(7, 2);
    Number n4 = new Fraction(1, 2);
    Number n5 = new Decimal("3.25");
    Number n6 = new Decimal("5.5");

    void testAdd(Tester t) {
        t.checkExpect(this.n1.add(this.n2).toDouble(), 12.0);
        t.checkExpect(this.n1.add(this.n3).toDouble(), 5 + 7.0/2.0);
        t.checkExpect(this.n3.add(this.n3).toDouble(), 7.0);
        t.checkExpect(this.n5.add(this.n4).toDouble(), 3.75);
    }

    void testMultiply(Tester t) {
        t.checkExpect(this.n1.multiply(this.n4).toDouble(), 2.5);
        t.checkExpect(this.n3.multiply(this.n4).toDouble(), 7.0/4.0);
        t.checkExpect(this.n6.multiply(this.n1).toDouble(), 27.5);
    }

    void testNumDem(Tester t) {
        t.checkExpect(this.n3.numerator(), 7);
        t.checkExpect(this.n1.numerator(), 5);
        t.checkExpect(this.n5.numerator(), 325);
        t.checkExpect(this.n4.denominator(), 2);
        t.checkExpect(this.n2.denominator(), 1);
        t.checkExpect(this.n6.denominator(), 10);
    }

    void testToString(Tester t) {
        t.checkExpect(this.n4.toText(), "1/2");
        t.checkExpect(this.n3.toText(), "7/2");
        t.checkExpect(this.n2.toText(), "7");
        t.checkExpect(this.n5.toText(), "3.25");
    }
}