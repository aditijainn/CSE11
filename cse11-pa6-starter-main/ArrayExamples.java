import tester.*;

class Pair {
  int a;
  int b;
  Pair(int a, int b) {
    this.a = a;
    this.b = b;
  }
}
class ArrayExamples{
  static String joinWith(String[] array, String seperator) {
    String output = "";
    if(array.length == 0) {
      return output;
    }
    for(int i=0; i<array.length; i++) {
      if(i==array.length-1) {
        output = output + array[i]; 
      }
      else if(i<array.length) {
        output = output + array[i] + seperator;
      }
    }
    return output;
  }
  static boolean somethingFalse(boolean[] array) {
    boolean output = false;
    for(int i=0; i<array.length; i++) {
      if(array.length == 0) {
        output = false;
      }
      else if(array[i] == false) {
        output = true;
      }
  }
  return output;
}
static int countWithinRange(double[] array, double low, double high) {
  int count = 0;
  if(array.length == 0) {
    return count;
  }
  else {
    for(double num: array) {
      if(low <= num && num <= high) {
        count = count + 1;
      }
    }
  return count;
  }
}
static double[] numsWithinRange(double[] array, double low, double high) {
  double[] output = new double[countWithinRange(array, low, high)];
  int index = 0;
  for(double num: array) {  
    if(low <= num && num <= high) {
      output[index] = num;
      index+=1;
    }
    else if(array.length == 0) {
      return output;
    }
  }
  return output; 
}
static Pair maxmin(int[] array) {
  int min = array[0];
  int max = array[0];
  for(int num: array) {
    if(min > num) {
      min = num;
    }
    if(max < num) {
      max = num;
    }
  }
  Pair pair = new Pair(min,max);
  return pair;
}
static String earliest(String[] array) {
  String earliest = "z";
  for(String letter: array) {
    if(letter.compareTo(earliest) < 0) {
      earliest = letter;
    }
  }
  return earliest;
}
}
class ProvidedArrayExamples {
  void testJoinWith(Tester t){
    String[] example1 = {"a", "b","c"};
    String[] example2 = {"this", "is","example","2"};
    String[] example3 = {"hyphen", "between","every","word", "please"};
    String[] example4 = {};
    t.checkExpect(ArrayExamples.joinWith(example1, ":"), "a:b:c");
    t.checkExpect(ArrayExamples.joinWith(example2, " "), "this is example 2");
    t.checkExpect(ArrayExamples.joinWith(example3, "-"), "hyphen-between-every-word-please");
    t.checkExpect(ArrayExamples.joinWith(example4, "."), "");
  }

  void testSomethingFalse(Tester t){
    boolean[] example1 = {true, false};
    boolean[] example2 = {true, true, true, true};
    boolean[] example3 = {false};
    boolean[] example4 = {};
    t.checkExpect(ArrayExamples.somethingFalse(example1), true);
    t.checkExpect(ArrayExamples.somethingFalse(example2), false);
    t.checkExpect(ArrayExamples.somethingFalse(example3), true);
    t.checkExpect(ArrayExamples.somethingFalse(example4), false);

  }

  void testCountWithinRange(Tester t){
    double[] example = {0.1, 1.3, 2.6};
    double[] example1 = {5.5, 12.6, 15.2, 6.7, 18.4};
    double[] example2 = {1.1, 1.2, 2.3, 6.8};
    double[] example3 = {};
    t.checkExpect(ArrayExamples.countWithinRange(example, 1.1, 2.2), 1);
    t.checkExpect(ArrayExamples.countWithinRange(example1, 5.5, 18.4), 5);
    t.checkExpect(ArrayExamples.countWithinRange(example2, 9.0, 10.0), 0);
    t.checkExpect(ArrayExamples.countWithinRange(example3, 5.5, 10.0), 0);
  }

  void testNumsWithinRange(Tester t){
    double[] example = {0.0, 3.0, 1.4, 1.5, 2.7, 9.1, 2.1};
    double[] expected = {1.4, 1.5, 2.1};
    double[] example1 = {5.5, 12.6, 15.2, 6.7, 18.4};
    double[] expected1 = {5.5, 12.6, 15.2, 6.7, 18.4};
    double[] example2 = {1.1, 1.2, 2.3, 6.8};
    double[] expected2 = {};
    double[] example3 = {};
    double[] expected3 = {};
    t.checkExpect(ArrayExamples.numsWithinRange(example, 1.1, 2.2), expected);
    t.checkExpect(ArrayExamples.numsWithinRange(example1, 5.5, 18.4), expected1);
    t.checkExpect(ArrayExamples.numsWithinRange(example2, 9.0, 10.0), expected2);
    t.checkExpect(ArrayExamples.numsWithinRange(example3, 5.5, 10.0), expected3);
  }

  void testMaxmin(Tester t){
    int[] example = {4, 5, 2, 3, 1};
    int[] example1 = {0, 6, 8};
    int[] example2 = {99, 0, -300, -2};
    int[] example3 = {5};
    t.checkExpect(ArrayExamples.maxmin(example), new Pair(1, 5));
    t.checkExpect(ArrayExamples.maxmin(example1), new Pair(0, 8));
    t.checkExpect(ArrayExamples.maxmin(example2), new Pair(-300, 99));
    t.checkExpect(ArrayExamples.maxmin(example3), new Pair(5, 5));
  }
  void testEarliest(Tester t){
    String[] example = {"aa", "aab", "abcd", "a"};
    String[] example1 = {"b"};
    String[] example2 = {"d","c","q","c","m"};
    String[] example3 = {"which", "one", "wins"};
    t.checkExpect(ArrayExamples.earliest(example), "a");
    t.checkExpect(ArrayExamples.earliest(example1), "b");
    t.checkExpect(ArrayExamples.earliest(example2), "c");
    t.checkExpect(ArrayExamples.earliest(example3), "one");
  }
}