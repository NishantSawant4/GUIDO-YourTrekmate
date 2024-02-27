package com.project.guido_yourtrekmate;

import static android.content.Intent.getIntent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Detail extends Fragment {
    TextView tvDesc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        tvDesc = getView().findViewById(R.id.tv_desc);
        String str = tvDesc.getText().toString();
        tvDesc.setText(str);
        return view;
    }
}