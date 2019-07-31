package com.example.apptest.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.apptest.repository.CalculoRepository;
import com.example.apptest.repository.LoginRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<Integer> resultadoLiveData = new MutableLiveData<>();

    private CompositeDisposable disposable = new CompositeDisposable();

    private CalculoRepository calculoRepository = new CalculoRepository();

    public LiveData<Integer> getResultadoLiveData() {
        return resultadoLiveData;
    }

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public void calcular(int numero1, int numero2) {
        disposable.add(
                calculoRepository.multiplicacao(numero1, numero2)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .subscribe(resultado -> resultadoLiveData.postValue(resultado),
                                Throwable::printStackTrace)
        );
    }

}
