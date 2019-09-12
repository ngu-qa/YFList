public class MyArrayListTest {

    static void print(MyArrayList arrayList){
        System.out.println("集合为: " + arrayList + "\t" +
                        "长度为: " + String.valueOf(arrayList.size()) + "\t" +
                        "是否为空: " + (arrayList.isEmpty()? "是": "否")
                        );
    }

    public static void main(String[] args) {
        System.out.println("-----数组集合测试-----");
        System.out.println("\n-----创建");
        MyArrayList arrayList = new MyArrayList();
        print(arrayList);
        System.out.println("是否包含1: " + (arrayList.contains(1)? "是": "否"));

        System.out.println("\n-----添加1");
        System.out.println("\n-----添加2");
        System.out.println("\n-----添加3");
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        print(arrayList);
        System.out.println("是否包含1: " + (arrayList.contains(1)? "是": "否"));

        System.out.println("\n-----添加4，此时数组扩容");
        arrayList.add(4);
        print(arrayList);
        System.out.println("是否包含4: " + (arrayList.contains(4)? "是": "否"));

        System.out.println("\n-----在下标0处添加0，此时数组扩容");
        arrayList.add(0, 0);
        print(arrayList);
        System.out.println("是否包含0: " + (arrayList.contains(0)? "是": "否"));

        System.out.println("\n-----在下标4处添加400，此时数组扩容");
        arrayList.add(4, 400);
        print(arrayList);
        System.out.println("是否包含400: " + (arrayList.contains(400)? "是": "否"));

        System.out.println("\n-----在下标5处添加500，此时数组扩容");
        arrayList.add(5, 500);
        print(arrayList);
        System.out.println("是否包含500: " + (arrayList.contains(500)? "是": "否"));

        System.out.println("\n-----在下标1000处添加1000，此时数组扩容");
        arrayList.add(1000, 1000);
        print(arrayList);
        System.out.println("是否包含1000: " + (arrayList.contains(1000)? "是": "否"));

        System.out.println("\n-----批量添加10 11 12，此时数组扩容");
        arrayList.addAll(10, 11, 12);
        print(arrayList);
        System.out.println("是否包含12: " + (arrayList.contains(12)? "是": "否"));

        System.out.println("\n-----删除第一个值为0的元素");
        arrayList.remove(0);
        print(arrayList);
        System.out.println("是否包含0: " + (arrayList.contains(0)? "是": "否"));

        System.out.println("\n-----删除第一个值为400的元素");
        arrayList.remove(400);
        print(arrayList);
        System.out.println("是否包含400: " + (arrayList.contains(400)? "是": "否"));

        System.out.println("\n-----删除第一个值为12的元素");
        arrayList.remove(12);
        print(arrayList);
        System.out.println("是否包含12: " + (arrayList.contains(12)? "是": "否"));

        System.out.println("\n-----删除第一个值为666的元素(666不存在)");
        arrayList.remove(666);
        print(arrayList);
        System.out.println("是否包含666: " + (arrayList.contains(666)? "是": "否"));

        System.out.println("\n-----批量删除500 1000");
        arrayList.removeAll(500, 1000);
        print(arrayList);
        System.out.println("是否包含500: " + (arrayList.contains(500)? "是": "否"));

        System.out.println("\n再次批量添加12 13 14 15 16，数组不会扩容");
        arrayList.addAll(12, 13, 14, 15, 16);
        print(arrayList);
        System.out.println("是否包含16: " + (arrayList.contains(16)? "是": "否"));

        System.out.println("\n-----添加17，此时数组扩容");
        arrayList.add(17);
        print(arrayList);
        System.out.println("是否包含17: " + (arrayList.contains(17)? "是": "否"));

        System.out.printf("\n索引0的值为; %d", arrayList.get(0));
        System.out.printf("\n索引4的值为; %d", arrayList.get(4));
        System.out.printf("\n索引11的值为; %d", arrayList.get(11));
        System.out.printf("\n索引12(超标)的值为; %d", arrayList.get(12));

        System.out.println("\n-----全清");
        arrayList.clear();
        print(arrayList);
        System.out.println("是否包含17: " + (arrayList.contains(17)? "是": "否"));

        System.out.println("\n-----添加17，此时数组不会扩容");
        arrayList.add(17);
        print(arrayList);
        System.out.println("是否包含17: " + (arrayList.contains(17)? "是": "否"));
    }
}
