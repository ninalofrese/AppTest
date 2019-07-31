package com.example.apptest.repository;

import io.reactivex.Observable;

public class CalculoRepository {

    public Observable<Integer> multiplicacao(int numero, int numero2) {
        return Observable.create(emitter -> {
            emitter.onNext(multiplicar(numero, numero2));
            emitter.onComplete();
        });
    }

    private Integer multiplicar(int numero, int numero2) {
        int produto = 0;

        for (int i = 0; i < numero2; i++) {
            produto += numero2;
        }
        return produto;
    }


}
