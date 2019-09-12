import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;

public class MyArrayList implements MyList {
        private int count;
        private int lenth;
        private Object[] arr;

        public MyArrayList(){
            count = 0;
            lenth = 3;
            arr = new Object[lenth];
        }

        public int size(){
            return count;
        }

        public boolean isEmpty(){
            if(count == 0){
                return true;
            }
            return false;
        }

        public boolean contains(Object o){
            int i;
            for(i = 0; i < count; i++){
                if(arr[i].equals(o)){
                    break;
                }
            }
            if(i != count){
                return true;
            }
            return false;
        }

        public boolean add(Object o){  //末尾追加
            if(count != lenth){
                arr[count] = o;
                count++;
            }else{
                arr = Arrays.copyOf(arr, lenth + 1);
                arr[lenth] = o;
                lenth++;
                count++;
            }
            return true;
        }

    public boolean add(int index, Object o){
        if(index < 0){
            System.out.println("下标越界，添加失败！");
            return false;
        }else if(index < count){        //中间插入,后面右移,但需要扩容
            if(count == lenth){
                arr = Arrays.copyOf(arr, lenth+1);
                lenth++;
            }
            count++;
            for(int i = count-1; i > index; i--){
                arr[i] = arr[i-1];
            }
            arr[index] = o;
        }else{      //末尾追加
            this.add(o);
        }

        return true;
    }

    public boolean addAll(Object... os){
        int l = os.length;
        if(l > lenth - count){          //扩容
            int newLenth = l + count;
            arr = Arrays.copyOf(arr, newLenth);
            lenth = newLenth;
        }
        for(Object o: os){
            this.add(o);
        }
        return true;
    }

    public int getIndex(Object o){      //返回第一个值为o的元素的索引
        int i;
        for(i = 0; i < count; i++){
            if(arr[i].equals(o)){
                break;
            }
        }
        if(i != count){
            return i;
        }else{
//            System.out.printf("没有找到值为%s的元素", o);
            return -1;
        }
    }

    public boolean remove(Object o){
        int index = this.getIndex(o);
        if(index != -1){
            for(int i = index; i < count-1; i++){
                arr[i] = arr[i+1];
            }
            count--;
            return true;
        }
        return false;
    }

    public boolean removeAll(Object... os){
        for(Object o: os){
            this.remove(o);
        }
        return true;
    }

    public void clear(){ count = 0; }

    public Object get(int index){
        if(index < 0 || index >= count){
            System.out.printf("\n索引值越界: %d", index);
            return null;
        }

        return arr[index];
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++){
            sb.append(arr[i]);
            sb.append(",");
        }
        if(sb.length() > 0){
            sb.delete(sb.length()-1, sb.length());
        }
        return sb.toString();
    }
}
















