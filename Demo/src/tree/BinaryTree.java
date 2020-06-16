package tree;

/**
 * 二叉树
 */
public class BinaryTree {
    public static void main(String[] args) {
        BinaryTreeDemo binaryTreeDemo = new BinaryTreeDemo();

        HeroNode root = new HeroNode(1,"张三");
        HeroNode left = new HeroNode(2,"李四");
        HeroNode right = new HeroNode(3,"王五");
        HeroNode left1 = new HeroNode(4,"赵六");
        HeroNode right1 = new HeroNode(5,"钱七");

        root.left = left;
        root.right = right;
        right.left = left1;
        right.right = right1;

        binaryTreeDemo.setRoot(root);

        binaryTreeDemo.preOrder();
        binaryTreeDemo.delNode(2);
        binaryTreeDemo.preOrder();
    }
}

class BinaryTreeDemo{
    public HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //调用前序遍历
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else{
            System.out.println("二叉树为空");
        }
    }

    //中序遍历
    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else{
            System.out.println("二叉树为空");
        }
    }

    //后续遍历
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空");
        }
    }

    //调用根据编号前序遍历查找树中的指定节点
    public HeroNode selectPreOrder(int no){
        if (this.root != null){
            return this.root.selectPreOrder(no);
        }else{
            return  null;
        }
    }

    //调用根据编号中序遍历查找树中的指定节点
    public HeroNode selectInfixOrder(int no){
        return this.root.selectInfixOrder(no);
    }

    //调用根据编号后续遍历查找树中的指定节点
    public HeroNode selectPostOrder(int no){
        return this.root.selectPostOrder(no);
    }

    //根据编号删除节点
    public void delNode(int no){
        if (this.root.no == no){
            this.root = null;
        }else{
            this.root.delNode(no);
        }
    }
}

class HeroNode{
    public int no;
    public String name;
    public HeroNode left;
    public HeroNode right;

    public HeroNode(int no, String name) {
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

    //根据编号删除结点
    public void delNode(int no){
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }

        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }

        if (this.left != null){
            this.left.delNode(no);
        }

        if (this.right != null){
            this.right.delNode(no);
        }
    }

    //二叉树的前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    //根据编号前序遍历查找树中的节点是否存在
    public HeroNode selectPreOrder(int no){
        System.out.println("前序遍历查找");
        if (this.no == no){
            return this;
        }

        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.selectPreOrder(no);
        }

        if (resNode != null){
            return resNode;
        }

        if (this.right != null){
            resNode = this.right.selectPreOrder(no);
        }

        return resNode;
    }

    //二叉树的中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }

        System.out.println(this);

        if (this.right != null){
            this.right.infixOrder();
        }
    }

    //中序遍历查找
    public HeroNode selectInfixOrder(int no){

        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.selectInfixOrder(no);
        }

        if (resNode != null){
            return resNode;
        }
        System.out.println("进行遍历");
        if (this.no == no){
            return this;
        }

        if (this.right != null){
            resNode = this.right.selectInfixOrder(no);
        }
        return  resNode;
    }

    //二叉树的后序遍历
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }

        if (this.right != null){
            this.right.postOrder();
        }

        System.out.println(this);
    }

    //后续遍历查找
    public HeroNode selectPostOrder(int no){
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.selectPostOrder(no);
        }
        if (resNode != null){
            return  resNode;
        }

        if (this.right != null){
            resNode = this.right.selectPostOrder(no);
        }

        if (resNode != null){
            return resNode;
        }

        System.out.println("进行遍历");

        if (this.no == no){
            return this;
        }

        return  resNode;
    }
}
