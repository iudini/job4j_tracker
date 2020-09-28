package ru.job4j.oop;

public class Battery {
    private int load;

    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery();
        Battery second = new Battery();
        first.load = 2;
        second.load = 5;
        System.out.println(first.load + "         " + second.load);
        first.exchange(second);
        System.out.println("first  second");
        System.out.println(first.load + "  ---->  " + second.load);
    }
}
