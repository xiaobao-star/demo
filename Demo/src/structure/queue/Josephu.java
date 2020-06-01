package structure.queue;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 * 约瑟夫问题
 */
public class Josephu {
    public static void main(String[] args) {
        JosephuSingleLinked josephuSingleLinked = new JosephuSingleLinked();
        josephuSingleLinked.addNode(25);
        josephuSingleLinked.showNode();
    }
}

//创建环形单向链表
    class  JosephuSingleLinked{
        Node2 head = new Node2(-1);

        //创建节点
        public void addNode(int nums){
            Node2 cur = null;
            for (int i = 1; i <= nums ; i++) {
                Node2 newNode = new Node2(i);
                if(i == 1){
                    head = newNode;
                    head.next = head;
                    cur = head;
                }else{
                    cur.next = newNode;
                    newNode.next = head;
                    cur = cur.next;
                }
            }
        }

        //约瑟夫问题解决   根据用户得输入，计算出节点出圈得顺序
        public void josephu(int num){
            //准备一个辅助指针helper指向链表得最后
            Node2 helper = null;
            Node2 temp = head;
            while(true){
                if(temp.next == head){
                    break;
                }
                temp = temp.next;
            }
            //将helper指向链表最后
            helper = temp;
            //让head节点和helper节点同时移动num-1位
            for(int i = 0;i < num-1 ;i++){
                head = head.next;
                helper = helper.next;
            }
            //让节点出圈，先让head节点后移一位，然后让helper节点指向后移以后得head节点
            head = head.next;
            helper.next = head;
        }

        public void  showNode(){
            Node2 temp = head;
            while(true){
                System.out.printf("小孩得编号为:%d \n",temp.getNo());
                if(temp.next == head){
                    break;
                }
                temp = temp.next;
            }

        }
    }

    class Node2{
        int no;
        Node2 next;

        public Node2(int no) {
            this.no = no;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public Node2 getNext() {
            return next;
        }

        public void setNext(Node2 next) {
            this.next = next;
        }
    }
