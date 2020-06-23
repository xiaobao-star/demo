package proxy;

import javax.jws.soap.SOAPBinding;

/**
 * 静态代理
 */
interface UserService{
    public void sayHello();
}

class UserProxy implements UserService {
    UserService userService;

    public UserProxy(UserService userService){
        this.userService = userService;
    }

    @Override
    public void sayHello() {
        System.out.println("之前");
        this.userService.sayHello();
        System.out.println("之后");
    }
}

public class JingtaiProxy implements UserService{

    public void sayHello(){
        System.out.println("调用静态代理");
    }
}

class Proxy{
    public static void main(String[] args) {
        JingtaiProxy jingtaiProxy = new JingtaiProxy();
        UserService userService = new UserProxy(jingtaiProxy);
        userService.sayHello();
    }
}


