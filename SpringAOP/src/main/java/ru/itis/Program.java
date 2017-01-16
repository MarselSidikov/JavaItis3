package ru.itis;

import org.springframework.aop.framework.ProxyFactory;
import ru.itis.advice.AfterDisplayTimeInterceptor;
import ru.itis.advice.BeforeDisplayTimeInterceptor;
import ru.itis.advice.DisplayTimeInterceptor;
import ru.itis.advice.ThrowsAdviceImpl;

public class Program {
    public static void main(String[] args) {
        /**
        ContainingLongLoopRunningMethodClass target =
                new ContainingLongLoopRunningMethodClass();

        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new DisplayTimeInterceptor());

        ContainingLongLoopRunningMethodClass proxy =
                (ContainingLongLoopRunningMethodClass)proxyFactory.getProxy();


        proxy.longLoop();
        **/

        ContainingLongLoopRunningMethodClass target =
                new ContainingLongLoopRunningMethodClass();

        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new BeforeDisplayTimeInterceptor());
        proxyFactory.addAdvice(new AfterDisplayTimeInterceptor());
        proxyFactory.addAdvice(new DisplayTimeInterceptor());
        proxyFactory.addAdvice(new ThrowsAdviceImpl());
        ContainingLongLoopRunningMethodClass proxy =
                (ContainingLongLoopRunningMethodClass)proxyFactory.getProxy();


        // proxy.longLoop();
        proxy.smallLongLoop();
        // proxy.someError();
    }
}
