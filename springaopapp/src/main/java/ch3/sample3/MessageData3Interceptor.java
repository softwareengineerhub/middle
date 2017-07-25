package ch3.sample3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by denys on 7/25/2017.
 */
@Aspect
public class MessageData3Interceptor {

    @After("execution(* ch3.sample3.MessageData3.makeAction(int))")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("@After. MessageData3Interceptor");
    }
}
