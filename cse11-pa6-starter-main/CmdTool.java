import java.util.Arrays;

interface Command{
    String[] execute(String[] data);
}
class Sum implements Command {
    public String[] execute(String[] data) {
        int total = 0;
        if(data.length==0) {
            total = 0;
        }
        else {
            for(String num: data) {
                total = total + Integer.parseInt(num);
            }
        }
        String[] output = new String[1];
        output[0] = String.valueOf(total);
        return output;       
    }
}
class Product implements Command {
    public String[] execute(String[] data) {
        int total = 1;
        if(data.length==0) {
            total = 1;
        }
        else {
            for(String num: data) {
                total = total * Integer.parseInt(num);
            }
        }
        String[] output = new String[1];
        output[0] = String.valueOf(total);
        return output;       
    }
}
class Mean implements Command {
    public String[] execute(String[] data) {
        double sum = 0;
        if(data.length==0) {
            sum = 0;
        }
        else {
            for(String num: data) {
                sum = sum + Double.parseDouble(num);
            }
        }
        double total = sum/(data.length);
        String[] output = new String[1];
        output[0] = String.valueOf(total);
        return output;       
    }
}
class Max implements Command {
    public String[] execute(String[] data) {
        int max = 0;
        if(data.length==0) {
            max = 0;
        }
        else {
            for(String num: data) {
                if(Integer.parseInt(num)>Integer.parseInt(data[0])) {
                    max = Integer.parseInt(num);
                }
            }
        }
        String[] output = new String[1];
        output[0] = String.valueOf(max);
        return output;       
    }
}
class Min implements Command {
    public String[] execute(String[] data) {
        int min = 0;
        if(data.length==0) {
            min = 0;
        }
        else {
            for(int i = 0; i<data.length; i++) {
                if(Integer.parseInt(data[i])<Integer.parseInt(data[0])) {
                    min = Integer.parseInt(data[i]);
                }
                else {
                    min = Integer.parseInt(data[0]);
                }
            }
        }
        String[] output = new String[1];
        output[0] = String.valueOf(min);
        return output;       
    }
}
class Positive implements Command {
    public String[] execute(String[] data) {
        int count = 0;
        for(String num: data) {
            if(Integer.parseInt(num)>0) {
                count = count + 1;
            }
            else {
                count = count + 0;
            }
        }
        String[] output = new String[count];
        if(count>0) {
            int index = 0;
            for(String num: data) {
                if(Integer.parseInt(num)>0) {
                    output[index] = num;
                    index = index + 1;
                }
                else {
                    index = index + 0;
                }
            }
        }
        return output;       
    }
}
class Negative implements Command {
    public String[] execute(String[] data) {
        int count = 0;
        for(String num: data) {
            if(Integer.parseInt(num)<0) {
                count = count + 1;
            }
            else {
                count = count + 0;
            }
        }
        String[] output = new String[count];
        if(count>0) {
            int index = 0;
            for(String num: data) {
                if(Integer.parseInt(num)<0) {
                    output[index] = num;
                    index = index + 1;
                }
                else {
                    index = index + 0;
                }
            }
        }
        return output;    
    }
}
class Count implements Command {
    public String[] execute(String[] data) {
        String[] output = {String.valueOf(data.length)}; 
        return output;     
    }
}
class Greater implements Command {
    String str;

    Greater(String str) {
        this.str = str;
    }
    public String[] execute(String[] data) {
        int count = 0;
        for(String num: data) {
            if(Integer.parseInt(num)>Integer.parseInt(str)) {
                count = count + 1;
            }
            else {
                count = count + 0;
            }
        }
        String[] output = new String[count];
        if(count>0) {
            int index = 0;
            for(String num: data) {
                if(Integer.parseInt(num)>Integer.parseInt(str)) {
                    output[index] = num;
                    index = index + 1;
                }
                else {
                    index = index + 0;
                }
            }
        }
        return output;    
    }
}
class Lesser implements Command {
    String str;

    Lesser(String str) {
        this.str = str;
    }
    public String[] execute(String[] data) {
        int count = 0;
        for(String num: data) {
            if(Integer.parseInt(num)<Integer.parseInt(str)) {
                count = count + 1;
            }
            else {
                count = count + 0;
            }
        }
        String[] output = new String[count];
        if(count>0) {
            int index = 0;
            for(String num: data) {
                if(Integer.parseInt(num)<Integer.parseInt(str)) {
                    output[index] = num;
                    index = index + 1;
                }
                else {
                    index = index + 0;
                }
            }
        }
        return output;    
    }
}
class Equal implements Command {
    String str;

    Equal(String str) {
        this.str = str;
    }
    public String[] execute(String[] data) {
        int count = 0;
        for(String num: data) {
            if(Integer.parseInt(num)==Integer.parseInt(str)) {
                count = count + 1;
            }
            else {
                count = count + 0;
            }
        }
        String[] output = new String[count];
        if(count>0) {
            int index = 0;
            for(String num: data) {
                if(Integer.parseInt(num)==Integer.parseInt(str)) {
                    output[index] = num;
                    index = index + 1;
                }
                else {
                    index = index + 0;
                }
            }
        }
        return output;    
    }
}
class CmdList implements Command {
    Command[] list;

    CmdList(Command[] list) {
        this.list = list;
    }
    public String[] execute(String[] data) {
        String[] result = data;
        for(int i=0; i<list.length; i++) {
            result = list[i].execute(result);
        }
        return result;
    }
}
class CmdTool {
    static void printArray(String[] array) {
        String output = "";
        for(int i = 0; i < array.length; i++) {
            if(i==array.length-1) {
                output = output + array[i]; 
            }
            else if(i<array.length) {
                output = output + array[i] + " ";
            }
        }
        System.out.println(output);
    }
    static int countCmds(String[] array) {
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if (array[i].equals("-l") || array[i].equals("-list")) {
                count = count + 0;
            } else if (Character.isLetter(array[i].charAt(0))) {
                count = count + 1;
            }
        }
        return count;
    }
  
    static String[] processCmdData(String[] array) {
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if((array[i].equals("greater") || array[i].equals("lesser") || array[i].equals("equal"))) {
                count = count - 1;
    
            }
            else if (Character.isLetter(array[i].charAt(0)) || array[i].equals("-list") || array[i].equals("-l")) {
                count = count + 0;
            } 
            else { 
                count = count + 1; 
            }
        }
        String[] nums = new String[count];
        int index = 0;
        for(int i = 0; i < array.length; i++) {
            if((array[i].equals("greater") || array[i].equals("lesser") || array[i].equals("equal"))) {
                index = index + 0;
                i = i+1;
            }
            else if (Character.isLetter(array[i].charAt(0)) || array[i].equals("-list") || array[i].equals("-l")) {
                index = index + 0;
            } 
            else { 
                nums[index] = array[i];
                index = index + 1; 
            }
        }
        return nums;
    }
    static Command[] processCmdList(String[] array) {
        Command[] args = new Command[countCmds(array)];
        int index = 0;
        if(array[0].equals("sum")) {
            args[0] = new Sum();
        }
        else if(array[0].equals("product")) {
            args[0] = new Product();
        }
        else if(array[0].equals("mean")) {
            args[0] = new Mean();
        }
        else if(array[0].equals("max")) {
            args[0] = new Max();
        }
        else if(array[0].equals("min")) {
            args[0] = new Min();
        }
        else if(array[0].equals("count")) {
            args[0] = new Count();
        }
        else if(array[0].equals("positive")) {
            args[0] = new Positive();
        }
        else if(array[0].equals("negative")) {
            args[0] = new Negative();
        }
        else if(array[0].equals("greater")) {
            args[0] = new Greater(array[1]);
        }
        else if(array[0].equals("lesser")) {
            args[0] = new Lesser(array[1]);
        }
        else if(array[0].equals("equal")) {
            args[0] = new Equal(array[1]);
        }
        else if(array[0].equals("-l") || array[0].equals("-list")) {
            for(int i = 1; i < array.length-1; i++) {
                if(array[i].equals("sum")) {
                    args[index] = new Sum();
                    index = index + 1;
                }
                else if(array[i].equals("product")) {
                    args[index] = new Product();
                    index = index + 1;
                }
                else if(array[i].equals("mean")) {
                    args[index] = new Mean();
                    index = index + 1;
                }
                else if(array[i].equals("max")) {
                    args[index] = new Max();
                    index = index + 1;
                }
                else if(array[i].equals("min")) {
                    args[index] = new Min();
                    index = index + 1;
                }
                else if(array[i].equals("count")) {
                    args[index] = new Count();
                    index = index + 1;
                }
                else if(array[i].equals("positive")) {
                    args[index] = new Positive();
                    index = index + 1;
                }
                else if(array[i].equals("negative")) {
                    args[index] = new Negative();
                    index = index + 1;
                }
                else if(array[i].equals("greater")) {
                    args[index] = new Greater(array[i + 1]);
                    index = index + 1;
                }
                else if(array[i].equals("lesser")) {
                    args[index] = new Lesser(array[i + 1]);
                    index = index + 1;
                }
                else if(array[i].equals("equal")) {
                    args[index] = new Equal(array[i + 1]);
                    index = index + 1;
                }
            }
        }
        return args;
    }
    public static void main(String[] args) {
        Command[] command = CmdTool.processCmdList(args);
        String[] nums = CmdTool.processCmdData(args);
        Command array = new CmdList(command);
        printArray(array.execute(nums));
    }
}