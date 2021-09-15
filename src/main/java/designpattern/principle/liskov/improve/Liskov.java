package designpattern.principle.liskov.improve;

public class Liskov {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));
        System.out.println("===============================");

        //因为B类不在继承A类，因此调用者不会再认为func1是减法
        B b = new B();
        System.out.println("11+3=" + b.func1(11, 3));
        System.out.println("1+8=" + b.func1(1, 8));
        System.out.println("11+3+9=" + b.func2(11, 3));
        //使用组合仍然可以使用A的方法
        System.out.println("11-3=" + b.func3(11, 3));
    }
}

//创建一个更加基础的基类
class Base {

}

class A extends Base {
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

class B extends Base {
    //如果B类需要用到A类的方法，使用组合关系
    private A a = new A();

    public int func1(int a, int b) {
        return a + b;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }

    public int func3(int a, int b) {
        return this.a.func1(a, b);
    }
}
