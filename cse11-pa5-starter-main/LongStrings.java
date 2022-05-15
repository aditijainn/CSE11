import tester.*;
class LongStrings {
    public String[] longStrings(String[] array, int n) {
        int newlength = 0;
        for (int i=0; i < array.length; i++) {
            if (array[i].length() >= n) {
                newlength = newlength + 1;
            }
        }
        String[] output = new String[newlength];
        int index = 0;
        for (int i=0; i < array.length; i++) {
            if (array[i].length() >= n) {
                output[index++] = array[i];
            }
        }
        return output;
    }

boolean testLongStrings(Tester t) {
    String [] one = new String [] {"pink", "purple", "blue", "orange"};
    String [] two = new String [] {"hi", "my", "name", "is", "aditi"};
    String [] three = new String [] {"test", "number", "three"};
    String [] four = new String [] {"this", "is", "pa", "five"};

    return t.checkExpect (longStrings(one, 6), new String [] {"purple", "orange"})
    && t.checkExpect (longStrings(two, 2), new String [] {"hi", "my", "name", "is", "aditi"})
    && t.checkExpect (longStrings(three, 7), new String [] {})
    && t.checkExpect (longStrings(four, 4), new String [] {"this","five"});
}
}

