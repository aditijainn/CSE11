class Interest {
    // Task 1: simpleInterest method
    // Your code here
    double simpleInterest(double p, double r, double t) {
        return Math.round(p*(r/100.0)*t*100.0)/100.0;
    }
    // Task 2: compoundInterest method
    // Your code here
    double compoundInterest(double p, double r, double t, double n) { //
        double result = p*((Math.pow((1+((r/100.0)/n)), t*n))-1); //
        return Math.round(result*100.0)/100.0; //
    }

}
class ExampleInterest {
    Interest example = new Interest();
    double compintr = example.compoundInterest(100, 5, 2, 12);
}
