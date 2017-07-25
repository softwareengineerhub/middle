package ch1.sample1;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by denys on 7/25/2017.
 */
public class Sample1 {

    public static void main(String[] args) {
        MessageData target = new MessageData();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new MessageDataInterceptor());
        proxyFactory.addAdvice(new MessageBeforeInterceptor());


        String res=target.makeAction();
        System.out.println(res);

        MessageData proxyMessageData = (MessageData) proxyFactory.getProxy();
        System.out.println("------After Proxy factory---------------");
        res=proxyMessageData.makeAction();
        System.out.println(res);

        /*ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new MessageDataInterceptor());
        MessageData proxyMessageData = (MessageData) proxyFactory.getProxy();

        String res=target.makeAction();
        System.out.println(res);
        System.out.println("---------------------");
        res=proxyMessageData.makeAction();
        System.out.println(res);*/

    }
}
