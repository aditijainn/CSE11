import java.security.cert.X509CRL;
import java.time.temporal.Temporal;

import tester.*;

class ExampleArrays { 
    // Task 1.1: averageWithoutLowest
    Number averageWithoutLowest(Number[] nums) {
        if (nums.length == 1) { 
            return nums[0];
        }
        if (nums.length == 0) { 
            return new WholeNumber(0); 
        }
        for (int i = 1; i < nums.length; i++) {
            int x = nums[0].compare(nums[i]);
            if (x == 1) {
                Number temp = nums[i];
                nums[i] = nums[0];
                nums[0] = temp;
            }                 
        }
        double total = 0;
        for(Number add: nums) {
            total = total + add.toDouble();
        }
        /*
        nums = {3, 4, 1, 2}
        add total before total after
        3    0              3
        4    3              7
        1    7              8
        2    8              10
        */
        int toInteger = (int)(total - nums[0].toDouble()); 
        return new Fraction(toInteger,(nums.length-1));
    }
    // Task 1.2: sumPairs
    // Your code here
    Pair [] sumPairs(Pair[] first, Pair[] second) {
        int arrayLength = 0;
        if (first.length < second.length) {
            arrayLength = first.length;
            Pair[] returnArray = new Pair[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                returnArray[i] = new Pair(first[i].a + second[i].a,
                first[i].b + second[i].b);
        }
        return returnArray;
        }
        else if (first.length > second.length) {
            arrayLength = second.length;
            Pair[] returnArray = new Pair[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                returnArray[i] = new Pair(first[i].a + second[i].a,
                first[i].b + second[i].b);
        }
        return returnArray;
        }
        else {
            return new Pair[0];
        }
    }
    // Task 1.3: onRegionEdge
    // Your code here
    public Region[] onRegionEdge(Region[] r, Point p) {
        int count = 0;
        if (r.length >= 1) {
            for (Region x: r) {
                if(x.onEdge(p)) {
                    count++;
                }
            }
        Region[] returnArray = new Region[count];
        int index = 0;
        for (Region x: r) {
            if(x.onEdge(p)) {
                returnArray[index] = x;
                index++;
            }
        }
        return returnArray;
        }
        else {
            return new Region[0];
        }
    }
}

class Pair {
    // Task 1.2: Pair class
    // Your code here
    int a, b;
    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
