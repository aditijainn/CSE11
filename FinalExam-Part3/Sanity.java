import tester.*;
import java.util.*;

class FinalPart3_Sanity {
    void testSum(Tester t) {
        Sum example = new Sum();
        List<String> list = new ArrayList();
        list.add("bb");
        list.add("c");
        list.add("cccc");

        int x = example.sum(list, new StringLengthSum())); 
    }
}

class StringLengthSum implements Summable<String> { 
    public int getVal(String s) {
        return s.length(); 
    }
}
/*
class               method     this reference      other variables
FinalPart3_Sanity   testSum    <ignore>            example = :1; list = :2;
Sum                 sum         :1                 StringLengthSum() = :3; i = 0; total = 0;
StringLengthSum     getVal      :3                 s = :4; s = "bb"; s.length() = 2;
Sum                 sum         :1                 total = 2; i = 1; total = 2;
StringLengthSum     getVal      :3                 s = :5; s = "c" ; s.length = 3;
*/
// java Occurrence data_1.txt data_2.txt data_3.txt
// a, 11