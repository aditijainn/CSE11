interface Number {
    // Methods from PA4 - DO NOT MODIFY
    int numerator();
    int denominator();
    Number add(Number n);
    Number multiply(Number n);
    double toDouble();
    String toText();
    // Task 1.1: compare
    // Your code here
    int compare(Number other);
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
    // Task 1.1: compare 
    // Your code here
    public int compare(Number other) {
        if(this.toDouble() > other.toDouble()) {
            return 1;
        }
        else if (this.toDouble() < other.toDouble()) {
            return -1;
        }
        else {
            return 0;
        }
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
    // Task 1.1: compare 
    // Your code here
    public int compare(Number other) {
        if(this.toDouble() > other.toDouble()) {
            return 1;
        }
        else if (this.toDouble() < other.toDouble()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}