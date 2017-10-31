package com.example.android.hw007_localbroadcastmanager;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlueFragment extends Fragment {

    private EditText etText;
    private Button btnSend;

    public BlueFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blue, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etText = view.findViewById(R.id.a_blue_et_text);
        btnSend = view.findViewById(R.id.f_blue_btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RedFragment.ACTION_MESAGGE);
                intent.putExtra(Intent.EXTRA_TEXT, etText.getText().toString());
                LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
            }
        });
    }
}
