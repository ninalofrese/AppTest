package com.example.apptest.repository;

import io.reactivex.Completable;

public class LoginRepository {

    public Completable login(String email, String senha){
        return Completable.create(emitter -> {

            if(validateLogin(email, senha)){
                emitter.onComplete();
            }else {
                emitter.onError(new Exception("Login inválido"));
            }

        });
    }

    private boolean validateLogin(String email, String senha) {
        return "admin@digitalhouse.com".equals(email) && "senha123".equals(senha);
    }

}
