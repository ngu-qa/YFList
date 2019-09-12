public class MyLinkList implements MyList {

    public class Node{
        public Object data;
        public Node next;
    }

    private Node start;
    private Node end;
    private int count;

    public MyLinkList(){
        start = new Node();
        end = start;
        count = 0;
    }

    public int size(){ return count; }

    public boolean isEmpty(){
        if(count == 0){
            return true;
        }
        return false;
    }

    public boolean contains(Object o){
        Node node = start;
        boolean f = false;
        while(node != null){
            if(node.data == null){      //初创对象后，data为null，此处做处理
                break;
            }
            if(node.data.equals(o)){
                f = true;
                break;
            }
            node = node.next;
        }
        if(f){
            return true;
        }
        return false;
    }

    public boolean add(Object o){   //末尾插入
        if(count == 0){           //没有头时，先做头！
            start.data = o;
        }else{
            Node newNode = new Node();
            newNode.data = o;
            end.next = newNode;
            end = newNode;
        }
        count++;
        return true;
    }

    public boolean add(int index, Object o){
        Node newNode = new Node();
        newNode.data = o;

        if(index < 0){  //换头
            newNode.next = start;
            start = newNode;
            count++;
        }else if(index < count){    //中间插入
            Node prev = this._getNodeByIndex(index - 1);
            Node next = this._getNodeByIndex(index);  // !!!!!!!!!!!!!!!index + 1是不对的，这里逻辑要想清楚啊
            prev.next = newNode;
            newNode.next = next;
            count++;
        }else{      //末尾插入
            this.add(o);
        }
        // count++;  不能放在这里，因为 this.add(o); 中++了
        return true;
    }

    private Node _getNodeByIndex(int index){    //根据索引获得节点
        if(index <0 || index >= count){
            return null;
        }

        Node node = start;
        while(index > 0){
            node = node.next;
            index--;
        }
        return node;
    }

    private Node _getNodeByValue(Object o){ //根据值获得节点
    Node node = start;

    while(node != null){
        if(node.data.equals(o)){
            break;
        }
        node = node.next;
    }
    return node;
    }

    private int _getIndexByValue(Object o){   //根据值获得第一个节点的索引，找不到返回-1，注意头时为0
        Node node = start;

        int i = 0;
        while(node != null){
            if(node.data.equals(o)){
                break;
            }
            node = node.next;
            i++;
        }
        if(node != null){
            return i;
        }else{
            return -1;
        }
    }

    public boolean addAll(Object... os){
        for(Object o: os){
            this.add(o);
        }
        return true;
    }

    public boolean remove(Object o){
        int index= this._getIndexByValue(o);
        if(index != -1){
            if(index == 0){     //头节点
                Node next = this._getNodeByIndex(index + 1);
                start = next;
            }else if(index + 1 == count){      //尾节点
                Node prev = this._getNodeByIndex(index -1);
                prev.next = null;
                end = prev;
            }else{  //中间节点
                Node prev = this._getNodeByIndex(index - 1);
                prev.next = prev.next.next;
            }
            count--;
            return true;
        }else{
            return false;
        }
    }

    public boolean removeAll(Object... os){
        for(Object o: os){
            this.remove(o);
        }
        return true;
    }

    public void clear(){
        start.data = null;
        start.next = null;
        end = start;
        count = 0;
    }

    public Object get(int index){ //根据索引获得值
        if(index <0 || index >= count){
            System.out.printf("\n索引值越界: %d", index);
            return null;
        }

        Node node = start;
        while(index > 0){
            node = node.next;
            index--;
        }
        return node.data;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        Node node = start;
        while(node != null){
            if(node.data == null){   //初创对象后，data为null，此处做处理
                break;
            }

            sb.append(node.data);
            sb.append(",");

            node = node.next;
        }

        if(sb.length() > 0){
            sb.delete(sb.length()-1, sb.length());
        }

        return sb.toString();
    }
}
