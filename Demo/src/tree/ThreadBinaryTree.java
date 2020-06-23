package tree;

/**
 * 线索化二叉树
 */


public class ThreadBinaryTree {


}

class ThreadBinaryTreeDemo {
    public ThreadNode root;
    public ThreadNode pre = null;

    public void threadBibaryTree(ThreadNode node){
        threadBibaryTree(node.left);

        if (node.left == null){
            //让当前结点的左指针指向前驱结点
            node.left = pre;
            //修改当前结点的左指针的类型
            node.LeftNodeType = 1;
        }

        if (node.right == null){
            //让前驱结点的右指针指向当前节点
            pre.right = node;
            //修改右指针类型
            pre.RightNodeType = 1;
        }

        pre = node;
        threadBibaryTree(node.right);
    }
}

class ThreadNode{
    public int no;
    public String name;
    public ThreadNode left;
    public ThreadNode right;

    //节点代表的类型，是前驱结点还是子节点
    public int LeftNodeType;
    public int RightNodeType;

    public ThreadNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

}
