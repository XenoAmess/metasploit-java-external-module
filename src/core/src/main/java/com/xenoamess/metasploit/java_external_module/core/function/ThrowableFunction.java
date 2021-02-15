package com.xenoamess.metasploit.java_external_module.core.function;

public interface ThrowableFunction<T, R> {

    /**
     * Applies this function to the given argument.
     *
     * @param t the function argument
     * @return the function result
     */
    R apply(T t) throws Throwable;
}
