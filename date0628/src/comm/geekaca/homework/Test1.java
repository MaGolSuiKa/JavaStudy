package comm.geekaca.homework;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        String[] sheng = {"黑龙江省","浙江省","江西省","广东省","福建省"};
        String[] shi = {"哈尔滨","杭州","南昌","广州","福州"};

        Map<String,String> shengshiMap = new HashMap<>();
        for (int i = 0; i < sheng.length; i++) {
            shengshiMap.put(sheng[i],shi[i]);
        }

        System.out.println(shengshiMap);
    }
}
