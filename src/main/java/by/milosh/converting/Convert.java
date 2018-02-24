package by.milosh.converting;

public interface Convert<T, R> {
    R execute(T from);
}
