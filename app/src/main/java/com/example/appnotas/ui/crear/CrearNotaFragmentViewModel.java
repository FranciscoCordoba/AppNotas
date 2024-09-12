package com.example.appnotas.ui.crear;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.appnotas.MainActivity;
import com.example.appnotas.modelos.Nota;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class CrearNotaFragmentViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> MConfirmado;
    //private MutableLiveData<Boolean> MNoConfirmado;

    public CrearNotaFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Boolean> getMConfirmado(){
        if(MConfirmado == null){
            MConfirmado = new MutableLiveData<>();
            //MConfirmado.setValue(false);
        }
        return MConfirmado;
    }
/*
    public LiveData<Boolean> getMNoConfirmado(){
        if(MNoConfirmado == null){
            MNoConfirmado = new MutableLiveData<>();
            //MNoConfirmado.setValue(false);
        }
        return MNoConfirmado;
    }

    public void resetearMutableMNo(){
        MNoConfirmado = new MutableLiveData<>();
    }

    public void resetearMutableM(){
        MConfirmado = new MutableLiveData<>();
    }
*/
    public void confirmarGuardado(String t, String c){
        if(!t.isEmpty()){
            Nota nota = new Nota(t,c);
            MainActivity.notas.add(nota);
            MainActivity.notas.sort(Comparator.comparing(Nota::getTitulo));
            MConfirmado.setValue(true);
        }/*else{
            MNoConfirmado.setValue(true);
        }*/
    }
    // TODO: Implement the ViewModel
}