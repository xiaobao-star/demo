package thread;


import java.util.Arrays;
import java.util.List;

public class DemoStream {

    public static void main(String[] args){
        List<String> strs = Arrays.asList("a", "a", "a", "a", "b");
        boolean aa = strs.stream().anyMatch(str -> str.equals("a"));
        boolean bb = strs.stream().allMatch(str -> !str.equals("a"));
        boolean cc = strs.stream().noneMatch(str -> !str.equals("c"));
        long count = strs.stream().filter(str -> str.equals("a")).count();
        System.out.println(aa);// TRUE
        System.out.println(bb);// FALSE
        System.out.println(cc);// FALSE
        System.out.println(count);

        if(strs.stream().noneMatch(str -> str.equals("c"))){
            System.out.println("1");
        }
    }
}
