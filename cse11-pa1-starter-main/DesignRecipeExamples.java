import tester.*;

class DesignRecipeExamples {
  int perimeter(int width, int height) {
      return (width*2)+(height*2);
  }
  int borderArea(int width, int height, int width2, int height2) {
      return (width*height)-(width2*height2);
  }
  int metersToCm(int meters) {
      // this method converts meters to centimeters
      // it takes meters as an integer in paramters
      return meters*100;
  }
  int timeInMinutes(int hours, int min) {
      // this method converts total time of hours and minutes into minutes
      // it takes hours and minutes in integers as parameters
      return (hours*60)+min;
  }
  int problem1result = this.perimeter(4, 5);
  // expected result of 18
  int problem1result2 = this.perimeter(10, 3);
  // expected result of 26
  int problem2result = this.borderArea(10, 5, 4, 3);
  // expected result of 38
  int problem2result2 = this.borderArea(20, 20, 15, 15);
  // expected result of 175
  int problem3result = this.metersToCm(354);
  // expected result 35400
  int problem3result2 = this.metersToCm(12);
  // expected result 1200
  int problem4result = this.timeInMinutes(1,30);
  // expected result 90
  int problem4result2 = this.timeInMinutes(5,1);
  // expected result 301
  // all parameters will produce correct output because only integers are allowed
}
