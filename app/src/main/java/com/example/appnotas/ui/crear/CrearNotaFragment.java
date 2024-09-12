package com.example.appnotas.ui.crear;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.appnotas.MainActivity;
import com.example.appnotas.databinding.FragmentCrearNotaBinding;
import com.example.appnotas.modelos.Nota;

public class CrearNotaFragment extends Fragment {

    private CrearNotaFragmentViewModel mViewModel;
    private FragmentCrearNotaBinding binding;

    public static CrearNotaFragment newInstance() {
        return new CrearNotaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(CrearNotaFragmentViewModel.class);
        binding = FragmentCrearNotaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Toast.makeText(getContext(), "La nota DEBE contener un título", Toast.LENGTH_SHORT).show();
        mViewModel.getMConfirmado().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                binding.etTitulo.setText("");
                binding.etContenido.setText("");
                //Toast.makeText(getContext(), "Nota Creada", Toast.LENGTH_SHORT).show();
                //mViewModel.resetearMutableM();
            }
        });
/*
        mViewModel.getMNoConfirmado().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Toast.makeText(getContext(), "ERROR: La nota debe tener un título", Toast.LENGTH_SHORT).show();
                mViewModel.resetearMutableMNo();
            }
        });
*/
        binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = binding.etTitulo.getText().toString();
                String contenido = binding.etContenido.getText().toString();
                mViewModel.confirmarGuardado(titulo, contenido);
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CrearNotaFragmentViewModel.class);
        // TODO: Use the ViewModel
    }
}