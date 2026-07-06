package org.example;

public class Day2ControlFlow {
    public static void main(String[] args) {
        evenOddChecker();
       gradeCalculator();
        numLoop();
        sumNumLoop();
    }
    public static void evenOddChecker(){
        int num=12;
        if(num%2==0){
            System.out.println(num+" is even");

        }else{
            System.out.println(num+" is odd");

        }
    }
    public static void gradeCalculator(){
        int score=89;
        if(score>=90){
            System.out.println("A");
        }else if(score>=80 && score<=89){
            System.out.println("B");
        }else if(score>=70 && score<=79){
            System.out.println("C");
        }else if(score>=60 && score<=69){
            System.out.println("D");
        }else if(score<60){
            System.out.println("F");
        }
        else{
            System.out.println("invalid");

        }
    }
    public static void numLoop(){
        int num=10;
        for(int i = 1; i<= num; i++){
            System.out.println("the num loop is :"+i);

        }
    }
    public static void sumNumLoop(){
       int num=1;
       int sum=0;
       while(num<=100){
         sum=sum+num;
         num++;

       }
       System.out.println("The sum of the numbers are :"+sum);
    }
}
