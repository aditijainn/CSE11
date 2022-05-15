import java.util.*;

interface Summable<T> {
    int getVal(T t);
}

class Sum {
    // Task 1: sum method
    // Your code here
    <T> int sum(List<T> list, Summable<T> object) {
        int total = 0;
        if(list.size() == 0 || list.contains(null)) { 
            total = 0;
        }
        else {
            for(int i=0; i<list.size(); i++) { 
                total = total + object.getVal(list.get(i)); 
            }
        }
        return total;
    }
}