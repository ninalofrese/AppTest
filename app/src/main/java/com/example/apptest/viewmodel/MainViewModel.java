package com.example.apptest.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.apptest.repository.CalculoRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<Float> resultadoLiveData = new MutableLiveData<>();

    private CompositeDisposable disposable = new CompositeDisposable();

    private CalculoRepository calculoRepository = new CalculoRepository();

    public LiveData<Float> getResultadoLiveData() {
        return resultadoLiveData;
    }

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public void calcular(float peso, float altura) {
        disposable.add(
                calculoRepository.calcularIMC(peso, altura)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .subscribe(resultado -> resultadoLiveData.postValue(resultado),
                                Throwable::printStackTrace)
        );
    }

}
