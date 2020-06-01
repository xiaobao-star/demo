package structure.Stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        StackDemo stackDemo = new StackDemo(10);
        stackDemo.push(1);
        stackDemo.push(2);
        stackDemo.push(3);
        stackDemo.push(4);

        stackDemo.showStack();
    }
}


class StackDemo{
        int [] arr ;
        int maxsize ;
        int top ;

        public StackDemo(int maxsize) {
        this.maxsize = maxsize;
        this.arr = new int [this.maxsize];
        this.top = -1;
    }

        public void push(int value){
            arr[++top] = value;
        }

        public int pop(){
            int value = arr[top];
            top--;
            return value;
        }
        //判断栈满
        public boolean isFull(){
            return top == maxsize - 1;
        }
        //判断栈空
        public boolean isEmpty(){
            return top == -1;
        }

        public void showStack(){
            for (int i = top; i >= 0; i--) {
                System.out.printf("元素arr[%d]是%d \n",i, arr[i]);
            }
        }
    }
