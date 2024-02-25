package org.example.task1;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TangImplTest {

    public static Stream<Arguments> tanProvider() {
        return Stream.of(
                Arguments.of(1d, 20, Math.tan(1)),
                Arguments.of(0d, 30, Math.tan(0)),
                Arguments.of(-1d, 30, Math.tan(-1)),
                Arguments.of(2.4d, 30, Math.tan(2.4)),
                Arguments.of(Math.PI, 30, Math.tan(Math.PI)),
                Arguments.of(Math.PI/2, 30, Math.tan(Math.PI/2))
        );
    }
    public static Stream<Arguments> tanIncorrectProvider() {
        return Stream.of(
                Arguments.of(Double.POSITIVE_INFINITY, 30, Math.tan(Double.POSITIVE_INFINITY)),
                Arguments.of(Double.NEGATIVE_INFINITY, 30, Math.tan(Double.NEGATIVE_INFINITY))
        );
    }

    @ParameterizedTest(name = "Index {index}, arg {1} expected {2}")
    @MethodSource("tanProvider")
    public void tan_shouldCorrectlyCalculateTangens(Double x, Integer n, Double expectedAnswer) {
        double actualAnswer = TangImpl.tan(x, n);
        Assertions.assertTrue(Math.abs(expectedAnswer - actualAnswer) < 0.0001);
    }

    @ParameterizedTest
    @MethodSource("tanIncorrectProvider")
    public void tan_shouldCorrectlyCalculateTangensForIncorrectData(Double x, Integer n, Double expectedAnswer) {
        double actualAnswer = TangImpl.tan(x, n);
        Assertions.assertEquals(expectedAnswer, actualAnswer);
    }
}
