package problemsets;

public interface ISolution<T> {
    T brute();

    default T better(){
        throw new UnsupportedOperationException("not implemented");
    }

    default T optimized(){
        throw new UnsupportedOperationException("not implemented");
    }
}
