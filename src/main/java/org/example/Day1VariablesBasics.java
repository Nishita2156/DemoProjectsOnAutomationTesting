package org.example;

public class Day1VariablesBasics {
    public static void main(String[] args) {
        simpleProgram();
        calculatorProgram();
        stringConcat();
    }
    public static void simpleProgram(){
        String name="John Doe";
        int age=30;
        double salary=5000.50;
        boolean isActive=true;
        System.out.println("the name is :"+name+" , age is :"+age+" , salary is :"+salary+" , status is :"+isActive);

    }
    public static void calculatorProgram(){
        int a=10;
        int b=20;
        int sum=a+b;
        int differ=a-b;
        int mul=a*b;
        int div=a%b;
        System.out.println(+sum+" , "+differ+ ","+mul+","+div);


    }
 public static void stringConcat(){
        String firstName="John";
        String lastName="Doe";
        String city="New York";
        System.out.println(firstName+" "+lastName+ " lives in "+city);
 }
}
