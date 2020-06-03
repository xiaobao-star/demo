package structure.Stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式实现计算器
 */
public class PolandNotation {
    public static void main(String[] args) {
        String suffix = "1 2 3 + 4 * + 5 -";
        List<String> list = Arrays.asList(suffix.split(" "));
        int res = calculate(list);
        System.out.println(res);
    }

    private static int calculate(List<String> list) {
        Stack<Integer> stack = new Stack();
        for(String s : list){
            if(s.matches("\\d+")){
                stack.push(Integer.parseInt(s));
            }else{
                int num1 = stack.pop();
                int num2 = stack.pop();
                int res = 0;
                if(s.equals("+")){
                    res = num1+num2;
                }
                if(s.equals("-")){
                    res = num2 - num1;
                }
                if(s.equals("*")){
                    res = num1 * num2;
                }
                if(s.equals("/")){
                    res = num1 / num2;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }


}
