package comm.geekaca.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        String[] winners = {"第一届   1930年  乌拉圭 乌拉圭",
                "第二届   1934年	意大利 意大利",
                "第三届   1938年	法国	  意大利",
                "第四届   1950年	巴西	  乌拉圭",
                "第五届   1954年	瑞士	  西德",
                "第六届   1958年	瑞典	  巴西",
                "第七届   1962年	智利	  巴西",
                "第八届   1966年	英格兰 英格兰",
                "第九届   1970年	墨西哥 巴西",
                "第十届   1974年	前西德 西德",
                "第十一届 1978年	阿根廷 阿根廷",
                "第十二届 1982年	西班牙 意大利",
                "第十三届 1986年	墨西哥 阿根廷",
                "第十四届 1990年	意大利 西德",
                "第十五届 1994年	美国	  巴西",
                "第十六届 1998年	法国	  法国",
                "第十七届 2002年	韩日	  巴西",
                "第十八届 2006年	德国	  意大利",
                "第十九届 2010年	南非	  西班牙",
                "第二十届 2014年	巴西	  德国"
        };

        Map<String, String> worldCup = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            String[] year = winners[i].split("[^\\d]+");
            String champion = winners[i].substring(winners[i].length() - 3);
            worldCup.put(year[1], champion);
        }
        System.out.println("请输入年份：");
        Scanner scanner = new Scanner(System.in);
        String yearInput = scanner.next();
        if (worldCup.containsKey(yearInput)) {
            System.out.println(yearInput + "年世界杯的冠军是：" + worldCup.get(yearInput));
        } else {
            System.out.println("没有举办世界杯");
        }
    }
}
