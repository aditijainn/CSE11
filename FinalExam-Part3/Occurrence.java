import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class Occurrence {
    // Task 2: main method
    // Your code here
    public static void main(String[] args) throws IOException {
        int length = 0;
        for(int i=0; i < args.length; i++) {
            if(args[i].contains(".txt") == false) {
                System.out.print("");
            }
            else {
                String input = Files.readString(Paths.get(args[i]));
                length = length + input.length();
            }
        } 
        if(length == 0) {
            System.out.print("");
        }
        else {
        List<String> words = new ArrayList<>();
        for(int i=0; i < args.length; i++) {
            String file = Files.readString(Paths.get(args[i]));
            String[] lines = file.split("[^\\w']+");
            Collections.addAll(words, lines);
        }
        Map<String, Integer> count = new HashMap<>();
        for(String n: words) {
            Integer current = count.get(n);
            if(current == null) {
                count.put(n, 1);
            }
            else {
                count.put(n, current + 1);
            }
        }
        int largestCount = 0;
        for(String n: count.keySet()) {
            if(count.get(n) > largestCount) {
                largestCount = count.get(n);
            }
        }
        for(String n: count.keySet()) {
            if(count.get(n) == largestCount) {
                System.out.println(n +", " + count.get(n));
            }
        }
        }
    }
}