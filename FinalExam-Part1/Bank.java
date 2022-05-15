// Task 2: Customer class
// Your code here
class Customer {
  // Task 2: Fields in Customer class
  // Your code here
  int id;
    String name;
    String phone;
  
  // Task 2: Constructor for Customer class
  // Your code here
  Customer(int id, String name, String phone) {
    this.id = id;
    this.name = name;
    this.phone = phone;
  }
}
class Account {
  double balance;
  // Task 2: Add Customer field
  // Your code here
  Customer customer;
  // Task 2: Modify the constructor 
  // to account for Customer field
  Account(double balance, Customer customer) {
  this.balance = balance;
  // Your code here
  this.customer = customer;
  }

  // Task 2: deposit method
  // Your code here
  String deposit(double deposit) {
  this.balance = balance + deposit;
  String output = "Deposit successful";
  return output;
  }
  // Task 2: withdraw method
  // Your code here
  String withdraw(double subtract) { 
    if(this.balance > subtract) {
      this.balance = balance - subtract;
      String output = "Withdrawal successful";
      return output;
    }
    else {
      String output = "Insufficient balance";
      return output;
    }
  }
}

class Bank {
  // Task 2: At least 1 Customer object
  Customer c = new Customer(1,"Aditi","8583195497");
  Customer c2 = new Customer(2, "Rohan", "59253545");
  // Task 2: At least 1 Account object
  Account a = new Account(3500.0,c);
  Account a2 = new Account(200.0, c2); 
  // Task 2: At least 1 call of deposit method
  String example = a.deposit(100.0);
  // Task 2: At least 2 calls of withdraw method
  String example1 = a.withdraw(3000.0);
  String example2 = a.withdraw(4000.0);
  String example3 = a2.withdraw(100.0);
}