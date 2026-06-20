package problemsets;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ProblemClass {
    Difficulty difficulty();
    Topic topic() default Topic.UNCLASSIFIED;
    Tag[] tags() default {};
    String url() default "";
    int leetCodeNumber() default -1; // if leetcode problem
    enum Difficulty{
        EASY,
        MEDIUM,
        HARD,
        VERY_HARD,
    }
    enum Topic{
        ARRAYS,
        STRINGS,
        STACK,
        QUEUE,
        RECURSION_BACKTRACKING,
        GRAPHS,
        LINKED_LISTS,
        TREES,
        HEAPS,
        DP,
        COMPLEX,
        DESIGN,
        UNCLASSIFIED;
    }
    enum Tag {
        TWO_POINTER,
        SLIDING_WINDOW,
        PREFIX_SUM,
        HASHMAP,
        SORTING,
        BINARY_SEARCH,
        DIVIDE_AND_CONQUER,
        GREEDY,
        BFS,
        DFS,
        DYNAMIC_PROGRAMMING,
        MEMOIZATION,
        MONOTONIC_STACK,
        FAST_SLOW_POINTER,
        MISCELLANEOUS,

        // NAMED Algos.
        DUTCH_NATIONAL_FLAG,
        KADANE,
        BOYER_MOORE_VOTING_ALGORITHM
    }
}
