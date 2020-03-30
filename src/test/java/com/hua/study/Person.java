package com.hua.study;

/**
 * @author 倪勤华
 * @date 2019-12-27 22:26
 */
public class Person {
    public String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected Person() {

    }
    private Person(String name) {
        this.name = name;
    }
     Person( int age) {
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show(){
        System.out.println("我是个人");
    }

    private String showNation(String nation){
        System.out.println("我的国籍是："+nation);
        return nation;
    }
}
