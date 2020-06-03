package structure.Stack;
import java.util.Stack;

public class CalculatorStackDemo {
    public static void main(String[] args) {
        String str = "1-2*2+1";
        Stack<Integer> numStack = new Stack();
        Stack<Character> opreStack = new Stack();

        for (int i = 0; i < str.length(); i++) {
            //如果是一个数字,直接入栈
            if(Character.isDigit(str.charAt(i))){
                numStack.push(Integer.parseInt(String.valueOf(str.charAt(i))));
            }else{
                //如果字符栈为空，直接入栈
                if(opreStack.size() == 0){
                    opreStack.push(str.charAt(i));
                }else{
                    //如果当前得操作符得优先级大于栈中得操作符就直接入栈
                    if(Ccc.getPolicy(str.charAt(i)) > Ccc.getPolicy(opreStack.peek())){
                        opreStack.push(str.charAt(i));
                    }else{
                        ////如果符号栈有操作符，就进行比较，如果当前得操作符小于或者等于栈中的操作符，就需要从数栈中pop出两个数，再
                        // 从符号栈中pop出一个符号，进行运算，将得到得结果重新入数栈，然后将当前得操作符入符号栈，
                        int val1 = numStack.pop();
                        int val2 = numStack.pop();
                        Character cc = opreStack.pop();

                        numStack.push(getResult(val1,val2,cc));
                        opreStack.push(str.charAt(i));
                    }
                }
            }
        }
            while(opreStack.size()>0){
                int val1 = numStack.pop();
                int val2 = numStack.pop();
                Character cc = opreStack.pop();

                numStack.push(getResult(val1,val2,cc));
            }

            System.out.println("结果为:"+numStack.pop());
    }

    private static String getType(Object a) {
        System.out.println(a.getClass().toString());
        return a.getClass().toString();
    }


    public static int getResult(int val1, int val2, Character c3){
        if(c3 == '+'){
            return val1 + val2;
        }
        if(c3 == '-'){
            return val2 - val1;
        }
        if(c3 == '*'){
            return val1 * val2;
        }
        if(c3 == '/'){
            return val1 / val2;
        }
        return -1;
    }
}
enum  Ccc{

    JIA(1,'+'),JIAN(1, '-'),CHENG(2,'*'),CHU(2,'/');

    private int policy;
    private Character oper;

    private Ccc(int policy, Character oper){
        this.policy = policy;
        this.oper = oper;
    }

    //根据字符返回对应得优先级
    public static  int getPolicy(Character character){
        for(Ccc c :Ccc.values()){
            if(character == c.oper){
                return c.policy;
            }
        }
        return -1;
    }

    public int getPolicy() {
        return policy;
    }

    public void setPolicy(int policy) {
        this.policy = policy;
    }

    public Character getOper() {
        return oper;
    }

    public void setOper(Character oper) {
        this.oper = oper;
    }
}

