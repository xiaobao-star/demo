package structure.queue;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addQueue("123");
        arrayQueue.addQueue("456");
        arrayQueue.addQueue("789");
        arrayQueue.showList();
    }
}

//使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue{
     private int maxSize; //数组最大容量
     private int front;   //队首指针
     private int rear;    //队尾指针
     private Object [] obj;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;//队首指针的前一个位置
        this.rear = -1;//队尾指针（就是队列最后一个数据）
        obj = new Object[maxSize];
    }

    //判断队列是否已满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //判断队列是否为空
    public boolean isEampty(){
        return rear == front;
    }

    //添加数据
    public void addQueue(Object object){
        if(isFull()){
            System.out.println("队列满，不能加入数据");
            return ;
        }
        rear++;
        obj[rear] = object;
    }

    //获取数据
    public Object getQueue(){
        //判断队列是否为空
        if(isEampty()){
            throw new RuntimeException("队列为空,不能取出数据");
        }
        return obj[++front];
    }

    //展示数据
    public void  showList(){
        if(isEampty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < obj.length; i++) {
            System.out.printf("arr[%s]=%s\n", i, obj[i]);
        }
    }

    //展示头部数据
    public Object peek(){
        if(isEampty()){
            throw  new RuntimeException("队列为空");
        }
        return obj[front+1];
    }
}
