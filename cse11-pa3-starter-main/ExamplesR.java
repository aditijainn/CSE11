class R {
    String one;
    R two;
    R(String one, R two) {
        this.one = one;
        this.two = two;
    }
}
class ExamplesR {
    R example = new R("no", example);
}
// Output:
// ExamplesR.java:10: error: self-reference in initializer
// R example = new R("yes", example);
//                          ^
//1 error
// I am not able to construct an example R object because
// it requires an R object as one of it's parameters
// and there is no R object previously defined because 
// paradoxically it requires an R object as one of it's parameters too