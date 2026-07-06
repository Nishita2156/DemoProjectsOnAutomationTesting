package org.example;

public class Day4OOP {
    public static void main(String[] args) {
         Student student1=new Student("Alice",30,3.80);
        Student student2=new Student("Bob",31,3.82);
        Student student3=new Student("Marley",29,3.75);
        student1.displayStudentInfo();
        student2.displayStudentInfo();
        student3.displayStudentInfo();

          BankAccount ba1=new BankAccount("RT6789", 50000);
          BankAccount ba2=new BankAccount("RT6789", 55000);
          System.out.println("First account created");
          ba1.displayBankAccountInfo();
          System.out.println();
          System.out.println("Deposit Operations :");
          ba1.deposit(1000);
          ba1.deposit(3000);
          System.out.println();
        System.out.println("Withdraw operations:");
        ba1.withdraw(5000);
        ba1.withdraw(100000);


    }
    public  static class Student{
        //fields
        private String name;
        private int age;
        private double CGPA;
        //constructor
        public Student(String name, int age, double CGPA){
              this.name=name;
              this.age=age;
              this.CGPA=CGPA;

         }
         //method to display student info
        public void displayStudentInfo(){
            System.out.println("Student Name:" +name+ ", Age :"+age+ ", CGPA is :"+CGPA);
        }
        //getters and setters

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getCGPA() {
            return CGPA;
        }

        public void setCGPA(double CGPA) {
            this.CGPA = CGPA;
        }

    }
    public static class BankAccount{
        private String accountNumber;
        private double balance;
        public BankAccount(String accountNumber, double balance){
            this.accountNumber=accountNumber;
            this.balance=balance;

        }
        public void deposit(double amount){
               if (amount>0){
                   balance=balance+amount;
                   System.out.println("Deposited : $ "+amount+"New balance is $"+balance);

               }else{
                   System.out.println("Invalid deposit amount");
               }
        }
        public void withdraw(double amount){
            if(amount>0 && amount<=balance){
                balance=balance-amount;
                System.out.println("Withdraw amount $:"+amount+" New balance $ :"+balance);

            }else if (amount>balance){
                System.out.println("Insufficient funds!! Current balance $"+balance);
            }else{
                System.out.println("Invalid withdrawal amount");
            }
        }
        public double getBalance(){
            return balance;
        }
        public void displayBankAccountInfo(){
            System.out.println("Account No. "+accountNumber+" |Balance  $"+balance );

        }
    }
}
