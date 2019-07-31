package com.example.apptest.repository;

import io.reactivex.Observable;

public class CalculoRepository {

    public Observable<Float> calcularIMC(float peso, float altura) {
        return Observable.create(emitter -> {
            float imc = peso / (altura * altura);
            emitter.onNext(imc);
            emitter.onComplete();
        });
    }

}
