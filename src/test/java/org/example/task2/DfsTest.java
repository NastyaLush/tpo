package org.example.task2;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DfsTest {
    private Dfs dfs;

    @BeforeEach
    public void setUp() {
        dfs = new Dfs(8);
        dfs.addEdge(0, 2);
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 4);
        dfs.addEdge(2, 1);
        dfs.addEdge(2, 6);
        dfs.addEdge(1, 0);
        dfs.addEdge(5, 1);
        dfs.addEdge(4, 6);
        dfs.addEdge(4, 7);
        dfs.addEdge(6, 7);
    }

    public static Stream<Arguments> dfsProvider() {
        return Stream.of(
                Arguments.of(0, List.of(0, 1, 2, 4, 6, 7)),
                Arguments.of(1, List.of(0, 1, 2, 4, 6, 7)),
                Arguments.of(2, List.of(0, 1, 2, 4, 6, 7)),
                Arguments.of(3, List.of(3)),
                Arguments.of(4, List.of(4, 6, 7)),
                Arguments.of(5, List.of(0, 1, 2, 4, 5, 6, 7)),
                Arguments.of(6, List.of(6, 7)),
                Arguments.of(7, List.of(7))

        );
    }

    @ParameterizedTest(name = "Index {index} vertex for check {0} expected answer {1}")
    @MethodSource("dfsProvider")
    public void dfs_shouldCorrectlySearchPath(Integer vertex, List<Integer> expectedResult) {
        dfs.dfs(vertex);
        Set<Integer> actualResult = dfs.getVisited();
        Assertions.assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }
}
