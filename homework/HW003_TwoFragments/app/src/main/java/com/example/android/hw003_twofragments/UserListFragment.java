package com.example.android.hw003_twofragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserListFragment extends Fragment {

    private ListView lvUsers;
    private UserListAdapter userListAdapter;
    private List<User> users;
    private OnUserListFragmentActions onUserListFragmentActions;

    public UserListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_list, container, false);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onUserListFragmentActions = (OnUserListFragmentActions) context;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        users = UserUtils.getUsersFakeData(15);
        lvUsers = (ListView) view.findViewById(R.id.f_userlist_lv_users);
        userListAdapter = new UserListAdapter(getContext(), users);
        lvUsers.setAdapter(userListAdapter);

        lvUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onUserListFragmentActions.onItemSelected(users.get(position));
            }
        });

        lvUsers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Item selected event", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public interface OnUserListFragmentActions{
        public void onItemSelected(User user);

    }

}
