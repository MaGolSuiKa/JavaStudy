package comm.geekaca.homework;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        Map<String,Integer> m1 = new HashMap<>();
        m1.put("张三",800);
        m1.put("李四",1500);
        m1.put("王五",3000);
        System.out.println(m1);

        System.out.println("==修改张三工资==");
        m1.put("张三",2600);
        System.out.println(m1);

        System.out.println("==所有工资增加==");
        m1.forEach((k,v)->{
            m1.put(k,v+100);
        });
        System.out.println(m1);

        System.out.println("遍历集合中所有的员工");
        m1.forEach((k,v)->{
            System.out.println(k);
        });
        System.out.println("遍历集合中所有的工资");
        m1.forEach((k,v)->{
            System.out.println(v);
        });
    }
}
