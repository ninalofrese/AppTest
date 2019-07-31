package com.example.apptest.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.apptest.repository.LoginRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> loginLiveData = new MutableLiveData<>();

    private CompositeDisposable disposable = new CompositeDisposable();

    private LoginRepository loginRepository = new LoginRepository();

    public LiveData<Boolean> getLoginLiveData() {
        return loginLiveData;
    }

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public void login(String email, String senha) {
        disposable.add(
                loginRepository.login(email, senha)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .subscribe(() -> loginLiveData.postValue(true),
                                throwable -> loginLiveData.postValue(false))
        );
    }

}
