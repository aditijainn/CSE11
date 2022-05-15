class Filter {
    // Task 3: Filter
    // Your code here
    public static void main(String[] args) {
        if (args.length == 1) {
            System.out.print("");
        }
        if (args[0].equals("odd")) {
            for (int i = 1; i < args.length; i++) {
                if (Integer.parseInt(args[i])%2 != 0) {
                    System.out.print(args[i] + " ");
                }
            }
        }
        else if (args[0].equals("even")) {
            for (int i = 1; i < args.length; i++) {
                if (Integer.parseInt(args[i])%2 == 0) {
                    System.out.print(args[i] + " ");
                }
            }
        }
    }
}