class Prime {
    // Task 2: main method
    // your code here
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.print("");
        }
        String output = "";
        for(String num: args) {
            if(Prime.isInteger(num) == false) {
                System.out.print("");
                break;
            }
            else if(Prime.isInteger(num)) {
                if(Prime.isNumPrime(Integer.parseInt(num))) {
                    if(num == args[args.length-1]) {
                        output = output + num;
                    } 
                    else {
                        output = output + num + "\n";
                    }
                }
            }
        }
        if(output.length() > 0) {
            System.out.print(output);
        }
    }
    static boolean isInteger(String num) {
        try {
            Integer.parseInt(num);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    // isNumPrime helper method
    // Returns true for prime number, false otherwise
    static boolean isNumPrime(int num) {
        boolean isPrime = true;
        
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}