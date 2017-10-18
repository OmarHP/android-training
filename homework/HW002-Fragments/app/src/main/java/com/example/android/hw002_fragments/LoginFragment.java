package com.example.android.hw002_fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private Button btnLogin;
    private OnLoginActions onLoginActions;
    private EditText etUsername;
    private EditText etPassword;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.onLoginActions = (OnLoginActions) context;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnLogin = (Button) view.findViewById(R.id.f_login_btn_login);
        etUsername = (EditText) view.findViewById(R.id.f_login_et_user);
        etPassword = ((EditText) view.findViewById(R.id.f_login_et_password));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                if(username != null && password != null && !username.isEmpty() && !password.isEmpty()){
                    onLoginActions.onLoginClick(username);
                }else{
                    Toast.makeText(getContext(), "Username and password are required.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public interface OnLoginActions{
        void onLoginClick(String user);
    }

}
