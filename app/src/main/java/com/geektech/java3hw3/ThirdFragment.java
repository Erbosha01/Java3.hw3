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

public class ThirdFragment extends Fragment {

    private TextView txt;
    private Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txt = view.findViewById(R.id.text_change_two);
        btn = view.findViewById(R.id.btn_send_two);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle1 = new Bundle();
                bundle1.putString("key3", txt.getText().toString());
                Fragment fragment = new FourthFragment();
                fragment.setArguments(bundle1);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.first, fragment).commit();
            }
        });
        Bundle bundle = getArguments();
        String text = bundle.getString("key2");
        if (text != null) {
            txt.setText(text);
        }



    }
}