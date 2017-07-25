package ch2.sample2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by denys on 7/25/2017.
 */
public class MessageData2Interceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("@Before");
        Object res = methodInvocation.proceed();
        System.out.println("@After");
        return res;
    }
}
