import java.util.Map;
import java.util.HashMap;

class Mode {
    // Task 1: mode method
    // Your code here
    int mode(int[] array) {
        if(array.length == 0) {
            return 0;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for(int n: array) {
            Integer current = count.get(n);
            if(current == null) {
                count.put(n, 1);
            }
            else {
                count.put(n, current + 1);
            }
        }
        int largestCount = 0;
        int mode = 0;
        for(Integer n: count.keySet()) {
            if(count.get(n) > largestCount) {
                largestCount = count.get(n);
                mode = n;
            }
        }
        /*
        n    count.get(n)   largestCount start   largestCount end   mode start    mode end
        5       1               0                    1                  0           5
        4       1               1                    1                  5           5
        1       2               1                    2                  5           1
        2       1               2                    2                  1           1
        */
        return mode;
    }
}

class ExampleMode {
    Mode example = new Mode();
    int result = example.mode(new int[]{5,4,1,1,2});
}