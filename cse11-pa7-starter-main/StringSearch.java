import java.nio.file.*;
import java.io.IOException;

class FileHelper {
  /*
    Takes a path to a file and returns all of the lines in the file as an
    array of strings, printing an error if it failed.
  */
  static String[] getLines(String path) {
    try {
      return Files.readAllLines(Paths.get(path)).toArray(String[]::new);
    }
    catch(IOException e) {
      System.err.println("Error reading file " + path + ": " + e);
      return new String[]{"Error reading file " + path + ": " + e};
    }
  }
}

interface Query {
    boolean matches(String s);
}
class Length implements Query {
    int length;
    Length(String length) {
        this.length = Integer.parseInt(length);
    }
    public boolean matches(String s) {
        return this.length = s.length();
    }
}
class Greater implements Query {
    int greater;
    Greater(String greater) {
        this.greater = Integer.parseInt(greater);
    }
    public boolean matches(String s) {
        return this.greater < s.length();
    }
}
class Less implements Query {
    int less;
    Less(String less) {
        this.less = Integer.parseInt(less);
    }
    public boolean matches(String s) {
        return this.less < s.length();
    }
}
class Contains implements Query {
    String contain;
    Contains(String contain) {
        this.contain = contain;
    }
    public boolean matches(String s) {
        return s.includes(contain);
    }
}
class Starts implements Query {
    String start;
    Starts(String start) {
        this.start = start;
    }
    public boolean matches(String s) {
        return s.substring(0, start.length()).equals(start);
    }
}
class Ends implements Query {
    String end;
    Ends(String end) {
        this.end = end;
    }
    public boolean matches(String s) {
        return s.substring(s.length - end.length()).equals(end);
    }
}
class Not implements Query {
    String not;
    Not(String not) {
        this.not = not;
    }
    public boolean matches(String s) {
        Query new = StringSearch.readQuery(this.new);
        return new.matches(s) == false;
    }
}
class StringSearch {
    public static void main(String[] args) throws IOException {
        String file = Files.readString(Paths.get(args[0]));
        String[] lines = file.split("\n");
        for(String words: lines) {
            System.out.println(words);
        }
    }
    static int countQueries(String[] q) {
        String[] queries = args[1].split("&");
        return queries.length();
    }
    static void printArray(String[] q) {
        for(String s : q) {
            System.out.println(s);
        }
    }
    
    static Query[] readQuery(String[] array) {
        Query[] args = new Query[countQueries(array)];
        int index = 0;
        if(array[0].contains("length")) {
            args[0] = new Length();
        }
        else if(array[0].contains("product")) {
            args[0] = new Product();
        }
        else if(array[0].contains("mean")) {
            args[0] = new Mean();
        }
        else if(array[0].contains("max")) {
            args[0] = new Max();
        }
        else if(array[0].contains("min")) {
            args[0] = new Min();
        }
        else if(array[0].contains("count")) {
            args[0] = new Count();
        }
        else if(array[0].contains("positive")) {
            args[0] = new Positive();
        }
        else if(array[0].contains("negative")) {
            args[0] = new Negative();
        }
        else if(array[0].contains("greater")) {
            args[0] = new Greater(array[1]);
        }
        else if(array[0].contains("lesser")) {
            args[0] = new Less(array[1]);
        }
        else if(array[0].contains("equal")) {
            args[0] = new Equal(array[1]);
        }
        else if(array[0].equals("-l") || array[0].equals("-list")) {
            for(int i = 1; i < array.length-1; i++) {
                if(array[i].contains("sum")) {
                    args[index] = new Sum();
                    index = index + 1;
                }
                else if(array[i].contains("product")) {
                    args[index] = new Product();
                    index = index + 1;
                }
                else if(array[i].contains("mean")) {
                    args[index] = new Mean();
                    index = index + 1;
                }
                else if(array[i].contains("max")) {
                    args[index] = new Max();
                    index = index + 1;
                }
                else if(array[i].contains("min")) {
                    args[index] = new Min();
                    index = index + 1;
                }
                else if(array[i].contains("count")) {
                    args[index] = new Count();
                    index = index + 1;
                }
                else if(array[i].contains("positive")) {
                    args[index] = new Positive();
                    index = index + 1;
                }
                else if(array[i].contains("negative")) {
                    args[index] = new Negative();
                    index = index + 1;
                }
                else if(array[i].contains("greater")) {
                    args[index] = new Greater(array[i + 1]);
                    index = index + 1;
                }
                else if(array[i].contains("lesser")) {
                    args[index] = new Lesser(array[i + 1]);
                    index = index + 1;
                }
                else if(array[i].contains("equal")) {
                    args[index] = new Equal(array[i + 1]);
                    index = index + 1;
                }
            }
        }
        return args;
    }
    public static void main(String[] args) throws IOException {
        if(args.length == 1) {
            String file = Files.readString(Paths.get(args[0]));
            String[] lines = file.split("\n");
            for(String words: lines) {
                System.out.println(words);
            }
        }
        else if (args.length == 2) {
            String file = Files.readString(Paths.get(args[0]));
            String[] lines = file.split("\n");
            int size = StringSearch.countQueries(args[1]);
            Query[] queries = new Query[size];
            for(int i = 0; i < size; i++) {
                lines[i] = readQuery(queries[i]);
            }

        }
    }
}