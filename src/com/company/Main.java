package com.company;

public class Main {

    public static void main(String[] args) {
	    Animals dog = new Dog();
        Animals cat = new Cat();
        dog.doJob(new ConcreteVisitor());
        cat.doJob(new ConcreteVisitor());
    }
}

//Допустим у нас на сервере есть 2 объекта кот и собака
// но необходимо что-бы выполнялся код который придёт со станции,
// для этого и нужен паттерн (визитёр)

interface Animals{
    void doJob(Visitor visitor);
}

class Dog implements Animals{
    @Override
    public void doJob(Visitor visitor) {
        // приняли и выполнили код
        visitor.doDog();
    }
}

class Cat implements Animals{
    @Override
    public void doJob(Visitor visitor) {
        visitor.doCat();
    }
}

// здесь мы пишем свой код который отправим на сервер
interface Visitor{
    void doDog();
    void doCat();
}

class ConcreteVisitor implements Visitor{
    @Override
    public void doDog() {
        System.out.println("haw");
    }

    @Override
    public void doCat() {
        System.out.println("mau");
    }
}