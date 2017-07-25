package ch1.sample1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by denys on 7/25/2017.
 */
public class MessageDataInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Aspect.@Before");
        long start = System.currentTimeMillis();
        Method method = methodInvocation.getMethod();
        Object[] params = methodInvocation.getArguments();
        System.out.println("Method="+method);
        System.out.println("Params="+ Arrays.toString(params));

        Object res=methodInvocation.proceed();

        long finish = System.currentTimeMillis()-start;
        System.out.println("Aspect.@After."+finish);
        //return res;
        return "Replaced result";
    }
}
