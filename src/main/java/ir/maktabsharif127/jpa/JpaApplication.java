package ir.maktabsharif127.jpa;

import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

public class JpaApplication {
    public static void main(String[] args) {

        Service service = getService();
        service.test();

        System.out.println(service.heavyFunction());
        System.out.println(service.heavyFunction());
    }

    private static Service getService() {
        return new ProxyServiceImpl(
                new RealServiceImpl()
        );
    }
}

interface Service {
    void test();

    String heavyFunction();
}

class RealServiceImpl implements Service {
    @Override
    public void test() {
        System.out.println("inside service");
    }

    @Override
    public String heavyFunction() {
        System.out.println("in real heavyFunction");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Heavy";
    }
}

@RequiredArgsConstructor
class ProxyServiceImpl implements Service {

    private final RealServiceImpl service;

    private HeavyCash cash;

    @Override
    public void test() {
        System.out.println("before");
        service.test();
        System.out.println("after");
    }

    @Override
    public String heavyFunction() {
        System.out.println("in proxy heavyFunction");
        if (cash == null || Duration.between(LocalDateTime.now(), cash.lastCall).toMinutes() > 10) {
            callAndCashHeavyFunction();
        }
        return cash.value;
    }

    private void callAndCashHeavyFunction() {
        String data = service.heavyFunction();
        cash = new HeavyCash();
        cash.value = data;
        cash.lastCall = LocalDateTime.now();
    }

    private static class HeavyCash {
        private String value;
        private LocalDateTime lastCall;
    }
}

