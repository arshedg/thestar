package com.smile.application.security;

import java.util.function.Consumer;

/**
 * Created by agulshan on 14/11/17.
 */
@FunctionalInterface
public interface ConsumerWithErrorHandler<T> extends Consumer<T> {
    default void onError(T element){

    }

}
