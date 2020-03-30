package Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author 倪勤华
 * @date 2020-02-11 1:08
 */
public class Test {
    public static void main(String[] args) {
        Person person1 = new Person("小明", 1, "123");
        Person person2 = new Person("小红", 3, "143");
        Person person3 = new Person("小蓝", 2, "142");
        List<Person> preList = new ArrayList();
        preList.add(person1);
        preList.add(person2);
        preList.add(person3);

        List<Person> postList = new ArrayList();
        postList.add(person2);
        postList.add(person3);
        postList.add(person1);
        List list = test(preList, postList);
        list.forEach(System.out::println);

    }

    private static List test(List<Person> preList, List<Person> postList) {
        List<Integer> result = new ArrayList();
        LinkedHashMap linkedHashMap =new LinkedHashMap();
        for (int i = 0; i < preList.size(); i++) {
            String preName = preList.get(i).getName();
            for (int j = 0; j < postList.size(); j++) {
                if (preName.equals(postList.get(j).getName())) {
                    result.add(i - j);
                }
            }
        }

        return result;
    }
}
