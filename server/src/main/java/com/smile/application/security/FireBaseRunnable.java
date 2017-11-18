package com.smile.application.security;

import java.util.function.Consumer;

import com.google.api.core.ApiFuture;
/**
 * Created by agulshan on 12/11/17.
 */
public class FireBaseRunnable<T> implements Runnable {

    private ApiFuture<T> future;
    private Consumer<T> consumer;
    private Consumer<Throwable> onFailure;

    public FireBaseRunnable(ApiFuture<T> future, Consumer<T> consumer, Consumer<Throwable> onFailure) {
        this.future = future;
        this.consumer = consumer;
        this.onFailure = onFailure;
    }

    @Override
    public void run() {
        if(future.isDone()){
            try {
                consumer.accept(future.get());
            } catch (Exception e) {
                onFailure.accept(e);
            }
        }else{
            onFailure.accept(new IllegalStateException("future is called before completion"));
        }
    }
}
