package structure.queue;

import com.sun.corba.se.spi.ior.ObjectKey;

import java.util.Stack;

public class SingleLinked {
    public static void main(String[] args) {
        Node head1 = new Node(1, "1", "11");
        Node head2 = new Node(2, "2", "22");
        Node head3 = new Node(3, "3", "33");
        Node head4 = new Node(4, "4", "44");
        Node head5 = new Node(4, "5", "55");

        LinkedQueue linkedQueue = new LinkedQueue();

        linkedQueue.add(head2);
        linkedQueue.add(head4);
        linkedQueue.add(head3);
        linkedQueue.add(head1);

        linkedQueue.update(head5);
        linkedQueue.show();
    }
}

    class LinkedQueue{
        private Node head = new Node(0, "", "");


        public Node getHead() {
            return head;
        }
        //添加
        public void add(Node node){
            Node temp = head;
            //遍历链表，找到比node节点的no小的节点,让前一个节点的next指向node，node的next指向比他的no大的节点

            while(true) {
                if(temp.next == null){
                    break;
                }
                if (temp.next.no > node.no) {
                    break;
                }
                temp = temp.next;
            }

                node.next = temp.next;
                temp.next = node;
        }

        //修改链表节点
        public void update(Node node){
            if(head.next == null){
                //链表为空
                System.out.println("链表为空");
                return ;
            }

            Node temp = head;
            boolean flag = false;
            while(true){
                if(temp == null){
                    System.out.println("链表遍历结束");
                    break;
                }
                if(temp.no == node.no){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if(flag){
                temp.name = node.name;
                temp.nickname = node.nickname;
            }else{
                System.out.println("没有找到这个节点");
            }
        }

        //删除节点
        public void remove(int no){
            if(head.next == null){
                System.out.println("链表为空，无法删除");
                return;
            }

            Node temp = head.next;
            boolean flag = false;
            while(true){
                if(temp.next == null){
                    break;
                }
                if(no == temp.next.no){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }

            if(flag){
                temp.next = temp.next.next;
            }else{
                System.out.println("没有这个节点");
            }
        }

        //显示链表
        public void show(){
            if(head.next == null){
                //链表为空
                return ;
            }
            //因为头节点不能动，所以需要一个辅助变量
            Node temp = head.next;
            while(true){
                if(temp == null){
                    //到了最后一个位置
                    break;
                }
                System.out.println(temp);
                temp = temp.next;
            }
        }

        //统计链表中有效节点得个数
        public int getLength(Node node){
            int count = 0;
            Node temp = node.next;

            if(node.next == null){
                return 0;
            }

            while(true){
                count++;
                temp = temp.next;
            }
        }

        //反转链表
        public void reverse(Node node){
            Node temp = node.next;
            Node reverseNode = new Node(0, "", "");
            Node next = null;

            if(node.next == null){
                return ;
            }
            while (temp != null){
                next = temp.next;
                temp.next = reverseNode.next;
                reverseNode.next = temp;
                temp = next;
            }
            node.next = reverseNode.next;
        }

        public void rever(Node node){
            if(node.next == null ){
                return ;
            }

            Node temp = node.next;
            Node newNode = new Node(0,"","");
            Node next = null;

            while(temp != null){
                next = temp.next;
                temp.next = newNode.next;
                newNode.next = temp;
                temp = next;
            }
            node.next = newNode.next;
        }

        //逆序打印单链表得数据
        public void re(Node node){
            if(node.next == null){
                return;
            }

            Node temp = node.next;
            Node next = null;
            Stack<Node> stack = new Stack();
            while(temp != null){
                next = temp.next;
                stack.push(temp);
                temp = next;
            }

            while(stack.size()>0){
                System.out.println(stack.pop());
            }
        }
    }

    class Node{
        public int no;
        public String name;
        public String nickname;
        public Node next;

        public Node(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }
