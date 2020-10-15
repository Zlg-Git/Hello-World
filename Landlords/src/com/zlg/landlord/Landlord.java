package com.zlg.landlord;

import java.util.*;

/**
 * @PROJECT_NAME: Landlords
 * @PACKAGE_NAME: com.zlg.landlord
 * @USER: 33036
 * @DATE: 2020/10/15
 */
public class Landlord {
    public static void main(String[] args) {

        game("董志京", "李永华", "张斗");

    }

    //创建创建扑克牌
    private static HashMap<Integer, String> createCard(){
        /*
         * 1组装54张扑克牌
         */
        //创建Map集合存储
        HashMap<Integer, String> pokerMap = new HashMap<>();

        //创建 花色集合 与 数字集合
        ArrayList<String> color = new ArrayList<>();
        ArrayList<String> number = new ArrayList<>();

        //存储 花色 与数字
        Collections.addAll(color, "♦", "♣", "♥", "♠");
        Collections.addAll(number, "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        //设置 存储编号变量
        int count = 1;
        pokerMap.put(count++, "♚");//大王
        pokerMap.put(count++, "♔");//小王
        //创建牌 存储到map集合中
        //把通过 数字 给 花色 赋值，方便后面根据牌面排序
        for (String n : number) {
            for (String c : color) {
                String card = c + n;
                pokerMap.put(count++, card);
            }
        }

        System.out.println("查看所有牌：");
        for (String card: pokerMap.values()) {
            System.out.print(card+" ");
        }
        System.out.println();
        return pokerMap;
    }
    //打乱发牌
    private static void game(String name1, String name2, String name3){
        HashMap<Integer, String> pokerMap = createCard();
        /*
         * 2 将54张牌顺序打乱
         */
        //取出编号 集合
        Set<Integer> serialNumber = pokerMap.keySet();
        //因为要将编号打乱顺序 所以 应该先进行转换到 list集合中
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.addAll(serialNumber);

        //打乱顺序
        Collections.shuffle(numberList);



        //完成三个玩家交替摸牌，每人17张牌，最后三张留作底牌

        //发牌的编号
        //创建三个玩家编号集合 和一个 底牌编号集合
        ArrayList<Integer> key1 = new ArrayList<>();//角色1
        ArrayList<Integer> key2 = new ArrayList<>();//角色2
        ArrayList<Integer> key3 = new ArrayList<>();//角色3
        ArrayList<Integer> key4 = new ArrayList<>();//底牌

        //发牌的编号
        for (int i = 0; i < numberList.size(); i++) {
            //获取该编号
            Integer num = numberList.get(i);
            //发牌
            if (i >= 51) {//留下最后三张为底牌
                key4.add(num);
            } else {//按顺序给每个人发牌
                if (i % 3 == 0) {
                    key1.add(num);
                } else if (i % 3 == 1) {
                    key2.add(num);
                } else {
                    key3.add(num);
                }
            }
        }



        //查看三人各自手中的牌（按照牌的大小排序）、底牌
        //根据编号大小进行升序排序
        Collections.sort(key1);
        Collections.sort(key2);
        Collections.sort(key3);
        Collections.sort(key4);

        //进行牌面的转换
        //创建三个玩家牌面集合 以及底牌牌面集合
        ArrayList<String> player1 = new ArrayList<>();//角色1
        ArrayList<String> player2 = new ArrayList<>();//角色2
        ArrayList<String> player3 = new ArrayList<>();//角色3
        ArrayList<String> holeCards = new ArrayList<>();//底牌

        //转换
        for (Integer i : key1) {
            //根据编号找到 牌面 pokerMap
            String card = pokerMap.get(i);
            //添加到对应的 牌面集合中
            player1.add(card);
        }

        for (Integer i : key2) {
            String card = pokerMap.get(i);
            player2.add(card);
        }
        for (Integer i : key3) {
            String card = pokerMap.get(i);
            player3.add(card);
        }
        for (Integer i : key4) {
            String card = pokerMap.get(i);
            holeCards.add(card);
        }

        //查看
        System.out.println(name1 + "的牌为："+player1);
        System.out.println(name2 + "的牌为："+player2);
        System.out.println(name3 + "的牌为："+player3);
        System.out.println("底牌为："+holeCards);
    }
}
