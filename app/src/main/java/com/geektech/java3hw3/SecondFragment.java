package com.geektech.java3hw3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    private TextView txtOne;
    private Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtOne = view.findViewById(R.id.text_change_one);
        btn = view.findViewById(R.id.btn_send_one);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String text = bundle.getString("key1");
            if (text != null) {
                txtOne.setText(text);
            }

        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle1 = new Bundle();
                bundle1.putString("key2", txtOne.getText().toString());
                Fragment fragment = new ThirdFragment();
                fragment.setArguments(bundle1);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.first, fragment).commit();
            }
        });




    }
}