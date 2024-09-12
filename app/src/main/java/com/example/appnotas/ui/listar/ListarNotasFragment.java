package com.example.appnotas.ui.listar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appnotas.MainActivity;
import com.example.appnotas.databinding.FragmentListarNotasBinding;

public class ListarNotasFragment extends Fragment {

    private ListarNotasFragmentViewModel mViewModel;
    private FragmentListarNotasBinding binding;

    public static ListarNotasFragment newInstance() {
        return new ListarNotasFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(ListarNotasFragmentViewModel.class);
        binding = FragmentListarNotasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        NotaAdapter na = new NotaAdapter(MainActivity.notas,inflater);
        GridLayoutManager glm = new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
        binding.rv.setAdapter(na);
        binding.rv.setLayoutManager(glm);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ListarNotasFragmentViewModel.class);
        // TODO: Use the ViewModel
    }

}