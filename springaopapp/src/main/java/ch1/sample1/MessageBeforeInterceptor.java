package ch1.sample1;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by denys on 7/25/2017.
 */
public class MessageBeforeInterceptor implements MethodBeforeAdvice {

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("\tInterceptor.@Before");
    }
}
