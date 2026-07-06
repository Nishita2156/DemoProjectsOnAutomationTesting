package org.example;

public class Day5Inheritance {
    //parent class Animal
    public static class Animal {
        protected String name;
        protected String color;

        //constructor
        public Animal(String name, String color) {
            this.name = name;
            this.color = color;

        }

        public void displayInfo() {
            System.out.println("Animal name is :" + name + " Color is :" + color);
        }

        public void makeSound() {
            System.out.println("Some Animals sounds like >>>>>>>");

        }
    }

    //child Class Dog
    public static class Dog extends Animal {
        public Dog(String name, String color) {
            super(name, color);
        }

        public void makeSound() {
            System.out.println("Some make sounds like :Woof! woof!" + name);
        }

        public void fetch() {
            System.out.println("Some can fetch:" + name);
        }
    }

    //child class Cat
    public static class Cat extends Animal {
        public Cat(String name, String color) {
            super(name, color);
        }

        public void makeSound() {
            System.out.println(name + " some says .....meow, meow");
        }

        public void scratch() {
            System.out.println(name + " is scratching the furniture!!!");
        }

    }

    //parent class Shape
    public static class Shape {
        protected String name;

        public Shape(String name) {
            this.name = name;
        }

        public double calculateArea() {
            return 0;
        }

        public void displayShape() {
            System.out.println("Shape name is :" + name + " Area is " + calculateArea());
        }
    }

    //child class circle
    public static class Circle extends Shape {
        private double radius;

        public Circle(String name, double radius) {
            super(name);
            this.radius = radius;
        }

        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }

    //child class rectangle
    public static class Rectangle extends Shape {
        private double length;
        private double width;

        public Rectangle(String name, double length, double width) {
            super(name);
            this.length = length;
            this.width = width;
        }

        public double calculateArea() {
            return length * width;
        }
    }

    //child class triangle
    public static class Triangle extends Shape {
        private double base;
        private double height;

        public Triangle(String name, double base, double height) {
            super(name);
            this.base = base;
            this.height = height;

        }

        public double calculateArea() {
            return (base * height) / 2;
        }
    }

    //parent class Vehicle
    public static class Vehicle {
        protected String VehicleName;
        protected String brand;
        protected int speed;

        public Vehicle(String VehicleName, String brand, int speed) {
            this.VehicleName = VehicleName;
            this.brand = brand;
            this.speed = speed;
        }

        public void start() {
            System.out.println(brand + " " + VehicleName + " is starting");
        }

        public void drive() {
            System.out.println(VehicleName + "is gonna driving at" + speed + " km per hour");
        }

        public void stop() {
            System.out.println(VehicleName + " has Stopped");
        }

    }

    //child class Car
    public static class Car extends Vehicle {
        public Car(String VehicleName, String brand, int speed) {
            super(VehicleName, brand, speed);
        }

        public void drive() {
            System.out.println(VehicleName + " is driving at " + speed + " km per hour");
        }

        public void openTrunk() {
            System.out.println(VehicleName + " trunk is open now");
        }
    }

    //child class bike
    public static class Bike extends Vehicle {
        public Bike(String VehicleName, String brand, int speed) {
            super(VehicleName, brand, speed);
        }

        public void drive() {
            System.out.println(VehicleName + "is zzoming with the speeding limit of " + speed + " km per hour");
        }

        public void doWheel() {
            System.out.println(VehicleName + "is doing wheelieee!!");
        }


    }

    public static void main(String[] args) {
        System.out.println("---Animal hierarchy----");
        Dog dog = new Dog("Martha", "brown");
        Cat cat = new Cat("Whisky", "golden");

        dog.displayInfo();
        dog.fetch();
        dog.makeSound();
        System.out.println();

        cat.makeSound();
        cat.displayInfo();
        cat.scratch();
        System.out.println();

        //Polymorphism in action---
        System.out.println("Polymorphism in animal array---");
        Animal[] animals = {dog, cat};
        for (Animal animal : animals) {
            animal.displayInfo();
            animal.makeSound();

        }
        System.out.println();

    System.out.println("---shape hierarchy----");
    Circle circle = new Circle("Circle", 4);
    Rectangle rectangle = new Rectangle("Rectangle", 5, 6);
    Triangle triangle = new Triangle("Triangle", 6, 7);
     System.out.println("Individual shapes----:");
     circle.displayShape();
     rectangle.displayShape();
     triangle.displayShape();
     System.out.println();
     //Polymorphism with shapes---
        Shape[] shapes={circle,rectangle,triangle};
        double totalArea=0;
        for(Shape shape:shapes){
           shape.displayShape();
           totalArea=totalArea+shape.calculateArea();
        }
        System.out.println("Total area of all the shapes :"+totalArea);
        System.out.println();

        System.out.println("---Vehicle hierarchy------");
        Car car=new Car("Tesla Model 3","Tesla",300);
        Bike bike =new Bike("Ninja Warrior","Nagasaki",300);
        System.out.println("***Car Operations****");
        car.start();
        car.drive();
        car.openTrunk();
        car.stop();
        System.out.println();
        System.out.println("----Bike operations------");
        bike.start();
        bike.drive();
        bike.doWheel();
        bike.stop();
        System.out.println();
        //polymorphism with vehicles---
        System.out.println("----Polymorphism---Vehicle Array---");
        Vehicle[] vehicles={car,bike};
        for (Vehicle vehicle: vehicles){
             vehicle.start();
             vehicle.drive();
             vehicle.stop();
            System.out.println();

        }
        System.out.println("Day 05 complete------");


}

}

