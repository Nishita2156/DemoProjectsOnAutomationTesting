package org.example;

import java.util.ArrayList;

public class Day3MethArrayList {
    public static void main(String[] args) {
        simpleAddMethod(3,4);
        greetMethod("John");
        int []arr={2,3,4,5,6};
        sumArray(arr);
        array();
        arrayList();
        maxAndMinNum(arr);
        reversedArray(arr);

    }
    public static  int  simpleAddMethod(int a,int b){
        System.out.println("The addition of two numbers are:"+(a+b));
        return a+b;
    }
    public static String greetMethod(String Name){
        System.out.println("Hello "+Name+" !!!");
        return Name;

    }
    public static int sumArray(int[]arr){

        int sum=0;
        for(int a:arr){
            sum=sum+a;

        }
        return sum;
    }
    public static void array(){
        int numbers[]={10,20,30,40,50};
        for(int i=0;i<numbers.length;i++){
            System.out.println("the numbers in an array is :"+numbers[i]);

        }
    }
    public static void arrayList(){
        ArrayList<String> list=new ArrayList<String>();
        list.add("Apple");
        list.add("Banana");
        list.add("Mango");
        for(String fruit:list){
            System.out.println("The list items are :"+fruit);
            System.out.println("The  total list items are :"+list.size());


        }
    }
    public static void maxAndMinNum(int []arr){
        int max=arr[0];
        int min=arr[0];
        for(int num:arr){
          if(max<num){
            max=num;
          }
          if(min>num){
            min=num ;
          }

        }
      System.out.println("The Max and min number is :"+max+ " and "+min);
    }
    public static  void reversedArray(int []arr){
        int []reversed=new int [arr.length];
        for(int i=0;i<arr.length;i++){
            reversed[i]=arr[arr.length-1-i];


        }
        System.out.println("The reversed array is :");
          for(int num:reversed){
             System.out.println(num+" ");

          }
          System.out.println("\n");
    }
}
