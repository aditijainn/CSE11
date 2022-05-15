import tester.*;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;


class Point {
  int x, y;
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  double distance(Point other) {
    return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
  }
}

class PointCompare implements Comparator<Point> {
  public int compare(Point one, Point two) {
    if(one.y > two.y) {
      return 1;
    }
    else if (one.y < two.y) {
      return -1;
    }
    else {
      if(one.x > two.x) {
        return 1;
      }
      else if (one.x < two.x) {
        return -1;
      }
      else {
        return 0;
      }
    }
  }
}

class PointDistanceCompare implements Comparator<Point> {
  Point other = new Point(0,0);
  public int compare(Point one, Point two) {
    if(one.distance(other) < two.distance(other)) {
      return -1;
    }
    else if (one.distance(other) > two.distance(other)) {
      return 1;
    }
    else {
      return 0;
    }
  }
}

class StringCompare implements Comparator<String> {
  public int compare(String one, String two) { 
    return one.compareTo(two);
  }
}

class StringLengthCompare implements Comparator<String> {
  public int compare(String one, String two) { 
    if(one.length() < two.length()) {
      return -1;
    }
    else if (one.length() > two.length()) {
      return 1;
    }
    else {
      return 0;
    }
  }
}

class BooleanCompare implements Comparator<Boolean> {
  public int compare(Boolean one, Boolean two) { 
    if(one == two) {
        return 0;
    }
    if(one == true && two == false) {
      return 1;
    }
    else {
      return -1;
    }
  }
}

class CompareLists {
  public <E> E minimum (List<E> list, Comparator<E> comparator) {
    if(list.size() == 0) {
      return null;
    } 
    else {
    E minimum = list.get(0);
    for(E loop: list) {
      if(comparator.compare(loop, minimum) == -1)
        minimum = loop;
    }
    return minimum;
    }
  }

  public <E> E minimum(E[] array, Comparator<E> comparator) {
    if(array.length == 0) {
      return null;
    } 
    else {
      E minimum = array[0];
      for(E loop: array) {
        if(comparator.compare(loop, minimum) == -1)
          minimum = loop;
      }
      return minimum;
    }
  }

  public <E> List<E> greaterThan (List<E> list, Comparator<E> comparator, E num) {
    List<E> arraylist = new ArrayList<>();
    if(list.size() == 0) {
      return null;
    } 
    else {
      for(E loop: list) {
        if(comparator.compare(loop, num) > 0) {
          arraylist.add(loop);
        }
      }
      return arraylist;
    }
}

  public <E> boolean inOrder(List<E> list, Comparator<E> comparator) {
    for (int i = 0; i < list.size()-1; i++) {
      if(list.get(i) == null || list.get(i+1) == null) {
        throw new IllegalArgumentException("null value in list");
      }
      if (comparator.compare(list.get(i), list.get(i+1)) == 1) {
        return false;
      }
    }
    return true;
  }


  public <E> boolean inOrder(E[] array, Comparator<E> comparator) {
    for (int i = 0; i < array.length-1; i++) {
      if(array[i] == null || array[i+1] == null) {
        throw new IllegalArgumentException("null value in array");
      }
      if (comparator.compare(array[i], array[i+1]) == 1) {
        return false;
      }
    }
    return true;
    }
  

    <E> List<E> merge(Comparator<E> comparator, List<E> one, List<E> two) {
      ArrayList<E> output = new ArrayList<E>();
      for(int i = 0; i < one.size(); i++) {
        if(one.contains(null)) {
          throw new IllegalArgumentException("null value in first list");
        }
        else {
          output.add(one.get(i));
        }
      }
      for(int i = 0; i < two.size(); i++) {
        if(two.contains(null)) {
          throw new IllegalArgumentException("null value in second list");
        }
        else {
          output.add(two.get(i));
        }
      }
      output.sort(comparator);
      return output;
    }
  }

