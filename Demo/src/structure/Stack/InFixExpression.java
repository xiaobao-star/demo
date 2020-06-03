package structure.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式转后缀表达式
 */
public class InFixExpression {
    public static void main(String[] args) {
        String expression = "1+((222+369)*4)-55577";
        System.out.println(InFixExpressionMethod(expression));
        parseSuffixExpression(InFixExpressionMethod(expression));
    }

    //中缀转后缀表达式
    private static void parseSuffixExpression(List<String> inFixExpressionMethod) {
        Stack<String> s1 = new Stack<>();
        List<String> list = new ArrayList<>();
        for (String s : inFixExpressionMethod) {
            //如果是数字直接入list
            if(s.matches("\\d+")){
                list.add(s);
            }else{
                /**
                 * //遇到运算符时
                 * 1.比较与s1栈顶元素得优先级
                 * 2.如果s1为空，或者栈顶元素为左括号“（”，直接入s1
                 * 3.如果优先级大于栈顶元素直接入s1
                 * 4.如果优先级低于栈顶元素，将栈顶元素弹出并压入到list中，再次与s1中新的栈顶元素进行比较
                 * //遇到括号得时候
                 * 1.如果是左括号“（”，直接入栈
                 * 2.如果是右括号，将s1中得元素依次弹出，并压入s2，直到遇到左括号为止，此时将左括号丢弃
                 */
            }
        }
        //接着将s1中剩余得元素依次弹出并压入list
    }

    //中缀表达式对应得list
    private static List<String> InFixExpressionMethod(String expression) {
        List<String> list = new ArrayList<>();
        String str = "";
        for (int i = 0; i < expression.length(); i++) {
            //如果是字符，直接加进去list
            if(expression.charAt(i) < 48 || expression.charAt(i) > 57){
                list.add(expression.charAt(i)+"");
                //如果是数字,考虑多数字得情况
            }else{
                str = "";
                int index = 0;
                index = i;
                while(index < expression.length() && expression.charAt(index) >= 48 && expression.charAt(index) <= 57){
                    str += expression.charAt(index);
                    if(str.length()>1){
                        i = index;
                    }
                    index++;
                }
                list.add(str);
            }
        }
        return list;
    }
}
