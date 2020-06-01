package structure.queue;


/**
 * 数组模拟环形队列
 */
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
        obj = new Object[maxSize];
    }

    //判断队列是否已满
    public boolean isFull(){
        return (rear+1)%maxSize == front;
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
        obj[rear] = object;
        rear = (rear + 1) % maxSize;
    }

    //获取数据
    public Object getQueue(){
        //判断队列是否为空
        if(isEampty()){
            throw new RuntimeException("队列为空,不能取出数据");
        }

        Object value = obj[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //展示数据
    public void  showList(){
        if(isEampty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front+((rear-front+maxSize)%maxSize); i++) {
            System.out.printf("arr[%s]=%s\n", i%maxSize, obj[i]);
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
