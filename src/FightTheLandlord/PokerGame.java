package FightTheLandlord;

import java.util.ArrayList;
import java.util.Collections;

public class PokerGame {

    // 牌盒
    static ArrayList<String> list = new ArrayList<>();

    static {
        // 准备牌
        // 花色："♠","♥","♦","♣"
        // 数字："3","4","5","6","7","8","9","10","J","Q","K","A","2"
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //放入牌盒
        for (String c : color) {
            // c表示花色
            for (String n : number) {
                // n表示数字
                list.add(c + n);
            }
        }
        list.add("大王");
        list.add("小王");

    }


    public PokerGame() {

        // 洗牌
        Collections.shuffle(list);

        // 发牌
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();

        // 遍历每一张牌
        for (int i = 0; i < list.size(); i++) {
            String poker = list.get(i);

            // 存储三张底牌(将前面三张底牌发给lord存储)
            if (i <= 2) {
                lord.add(poker);
                continue;
            }

            // 给三个玩家轮流发牌
            if (i % 3 == 0) {
                player1.add(poker);
            } else if (i % 3 == 1) {
                player2.add(poker);
            } else {
                player3.add(poker);
            }
        }


        //看牌
        lookPoker("底牌", lord);
        lookPoker("玩家一", player1);
        lookPoker("玩家二", player2);
        lookPoker("玩家三", player3);
    }

    /*
        参数一：玩家的名字
        参数二：每位玩家的牌
     */
    public void lookPoker(String name, ArrayList<String> list) {
        System.out.println(name + "：");

        for (String poker : list) {
            System.out.print(poker + " ");
        }
        System.out.println();

    }

}
