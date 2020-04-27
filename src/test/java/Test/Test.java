package Test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author 倪勤华
 * @date 2020-02-11 1:08
 */
public class Test {
    public static void main(String[] args)  {
        A a = new A("d",1);
        te(a);
        System.out.println(a.toString());
    }
    public static void te(A a){
        a.setB(22);
        a.setI("ss");
    }

    @Data
    @Builder
    @AllArgsConstructor
public static class A{
        private  String i;
        private  int b;
}
}
