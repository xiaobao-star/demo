package structure.Stack;

public class LinkedStackDemo {
    public static void main(String[] args) {

    }
}

class LickedStackDemomo{
    Node4 top = null;
    public void push(int val){
        if(top == null){
            top = new Node4(val);
        }else{
            Node4 node4 = new Node4(val);
            node4.next = top;
            top = node4;
        }
    }
}

class Node4{
    public int no;
    public Node4 next;
    public Node4 prev;

    public Node4(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node4{" +
                "no=" + no +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }
}
