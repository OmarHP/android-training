package com.example.android.hw003_twofragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.hw003_twofragments.databinding.FragmentDetailBinding;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private ImageView ivProfileImage;
    private TextView tvName;
    private TextView tvLastname;
    FragmentDetailBinding fragmentDetailBinding;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_detail, container, false);
        fragmentDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
        return  fragmentDetailBinding.getRoot();

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivProfileImage = (ImageView) view.findViewById(R.id.f_detail_iv_image);
    }

    public void setUserData(User user){
        Picasso.with(getContext()).load("http://lorempixel.com/200/200/sports/")
                .placeholder(R.drawable.progress_animation)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .memoryPolicy(MemoryPolicy.NO_CACHE).into(ivProfileImage);
        fragmentDetailBinding.setUser(user);
    }
}
