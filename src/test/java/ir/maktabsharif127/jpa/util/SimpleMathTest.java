package ir.maktabsharif127.jpa.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleMathTest {

    private final SimpleMath simpleMath = new SimpleMath();

    @Test
    void add() {
        Assertions.assertEquals(10, simpleMath.add(5, 5));
        Assertions.assertEquals(10, simpleMath.add(2, 8));
        Assertions.assertEquals(10, simpleMath.add(8, 2));
        Assertions.assertEquals(0, simpleMath.add(10, -10));
    }

    @Test
    void divide() {
    }
}