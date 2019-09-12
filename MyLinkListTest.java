public class MyLinkListTest {

    static void print(MyLinkList linkList){
        System.out.println("集合为: " + linkList + "\t" +
                "长度为: " + String.valueOf(linkList.size()) + "\t" +
                "是否为空: " + (linkList.isEmpty()? "是": "否")
        );
    }

    public static void main(String[] args) {
        System.out.println("-----链表集合测试-----");
        System.out.println("\n-----创建");
        MyLinkList linkList = new MyLinkList();
        print(linkList);
        System.out.println("是否包含1: " + (linkList.contains(1)? "是": "否"));

        System.out.println("\n-----添加1，此时创建头！");
        linkList.add(1);
        print(linkList);
        System.out.println("\n-----添加2");
        linkList.add(2);
        System.out.println("\n-----添加3");
        linkList.add(3);
        print(linkList);
        System.out.println("是否包含1: " + (linkList.contains(1)? "是": "否"));

        System.out.println("\n-----添加4");
        linkList.add(4);
        print(linkList);
        System.out.println("是否包含4: " + (linkList.contains(4)? "是": "否"));

        System.out.println("\n-----在下标-1处添加0.链表换头");
        linkList.add(-1, 0);
        print(linkList);
        System.out.println("是否包含0: " + (linkList.contains(0)? "是": "否"));

        System.out.println("\n-----在下标4处添加400");
        linkList.add(4, 400);
        print(linkList);
        System.out.println("是否包含400: " + (linkList.contains(400)? "是": "否"));

        System.out.println("\n-----在下标6处添加6，换尾");
        linkList.add(6, 6);
        print(linkList);
        System.out.println("是否包含6: " + (linkList.contains(6)? "是": "否"));

        System.out.println("\n-----在下标1000处添加1000，此时数组扩容");
        linkList.add(1000, 1000);
        print(linkList);
        System.out.println("是否包含1000: " + (linkList.contains(1000)? "是": "否"));

        System.out.println("\n-----批量添加10 11 12，此时数组扩容");
        linkList.addAll(10, 11, 12);
        print(linkList);
        System.out.println("是否包含12: " + (linkList.contains(12)? "是": "否"));

        System.out.println("\n-----删除第一个值为0的元素");
        linkList.remove(0);
        print(linkList);
        System.out.println("是否包含0: " + (linkList.contains(0)? "是": "否"));

        System.out.println("\n-----删除第一个值为400的元素");
        linkList.remove(400);
        print(linkList);
        System.out.println("是否包含400: " + (linkList.contains(400)? "是": "否"));

        System.out.println("\n-----删除第一个值为12的元素,换尾");
        linkList.remove(12);
        print(linkList);
        System.out.println("是否包含12: " + (linkList.contains(12)? "是": "否"));

        System.out.println("\n-----删除第一个值为666的元素(666不存在)");
        linkList.remove(666);
        print(linkList);
        System.out.println("是否包含666: " + (linkList.contains(666)? "是": "否"));

        System.out.println("\n-----批量删除500 1000(500本来也不存在)");
        linkList.removeAll(500, 1000);
        print(linkList);
        System.out.println("是否包含1000: " + (linkList.contains(1000)? "是": "否"));

        System.out.println("\n再次批量添加12 13 14 15 16");
        linkList.addAll(12, 13, 14, 15, 16);
        print(linkList);
        System.out.println("是否包含16: " + (linkList.contains(16)? "是": "否"));

        System.out.println("\n-----添加17");
        linkList.add(17);
        print(linkList);
        System.out.println("是否包含17: " + (linkList.contains(17)? "是": "否"));

        System.out.printf("\n索引0的值为; %d", linkList.get(0));
        System.out.printf("\n索引4的值为; %d", linkList.get(4));
        System.out.printf("\n索引11的值为; %d", linkList.get(11));
        System.out.printf("\n索引14(超标)的值为; %d", linkList.get(14));

        System.out.println("\n-----全清");
        linkList.clear();
        print(linkList);
        System.out.println("是否包含17: " + (linkList.contains(17)? "是": "否"));

        System.out.println("\n-----添加17");
        linkList.add(17);
        print(linkList);
        System.out.println("是否包含17: " + (linkList.contains(17)? "是": "否"));


    }
}
