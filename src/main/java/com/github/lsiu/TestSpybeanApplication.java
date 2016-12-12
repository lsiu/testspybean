package com.github.lsiu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class TestSpybeanApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSpybeanApplication.class, args);
    }

    public interface TheInterface {
        String giveMeAString();
    }

    @Primary
    @Component
    public static class ClassOne implements TheInterface {
        @Override
        public String giveMeAString() {
            return "fromClassOne";
        }
    }

    @Component
    public static class ClassTwo implements TheInterface {

        @Override
        public String giveMeAString() {
            return "fromClassTwo";
        }
    }

    @Component
    public static class InterfaceAConsumer {
        private final TheInterface theInterface;

        public InterfaceAConsumer(TheInterface interfaceA) {
            this.theInterface = interfaceA;
        }

        String getTheString() {
            return theInterface.giveMeAString();
        }
    }
}
