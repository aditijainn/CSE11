import tester.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Collections;

// Task 1.0 Make Queue generic
// Edit the following class declaration
class Queue<E> {
    
    // Task 1.0: Set up Fields
    // Your code here
    List<E> contents;
    Comparator<E> comp;
    Queue(List<E> contents, Comparator<E> comp) {
        this.contents = contents;
        this.comp=comp;
    }

    // Task 1.1: add() method
    // Your code here
    void add(E addNum) {
        this.contents.add(addNum);
        Collections.sort(contents, comp);
        
    }

    // Task 1.2: contains() method
    // Your code here
    boolean contains(E containNum) {
        boolean output = false;
        for(int i = 0; i < contents.size(); i++) {
            if(contents.get(i).equals(containNum)) {
                output = true;
            }
        }
        return output;
    }
    // Task 1.3: remove() method
    // Your code here
    boolean remove(E removeNum) {
        boolean output = false;
        int x = 0;
        Collections.sort(contents, comp);
        for(int i = 0; i < contents.size(); i++) {
            if(contents.get(i).equals(removeNum) && x==0) {
                x = x+1;
                contents.remove(i);
                output = true;
            }
            else {
                throw new NoSuchElementException(); //this line is on stack
            }
        }
        return output;
    }
    /*
    class                           method      this reference      other variables
    ProvidedQueueTests_Sanity       testRemove  ignore              q = :2
    Queue<E>                        remove      :3                  output=ignore; x=0; i=contents.size();
    */
    // Task 1.4: poll() method
    // Your code here
    E poll() {
        if(contents.size() > 0) {
            E output = contents.get(0);
            contents.remove(0);
            Collections.sort(contents, comp);
            return output;
        }
        else {
            return null;
        }
    } 
}