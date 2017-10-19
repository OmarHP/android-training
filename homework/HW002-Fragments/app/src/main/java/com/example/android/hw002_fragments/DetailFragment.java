package com.example.android.hw002_fragments;


import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.support.v4.content.PermissionChecker.PERMISSION_GRANTED;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements View.OnClickListener {


    private static final String TAG = DetailFragment.class.getSimpleName() + "_TAG_";
    private static final int DOWNLOAD_FILE_REQUEST = 144;
    private TextView tvUsername;
    private Button btnStateList;
    private Button btnDownload;
    private DownloadManager downloadManager;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        tvUsername = (TextView) view.findViewById(R.id.f_detail_tv_username);
        btnStateList = (Button) view.findViewById(R.id.f_detail_btn_state);
        btnDownload = (Button) view.findViewById(R.id.f_detail_btn_download);
        Bundle bundle = getArguments();
        String username = bundle.getString("username");
        tvUsername.setText(username);

//        StateListDrawable drawable = new StateListDrawable();
//
//        drawable.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(Color.RED));
//        drawable.addState(new int[]{android.R.attr.state_hovered}, new ColorDrawable(Color.YELLOW));
//        drawable.addState(new int[]{}, new ColorDrawable(Color.BLUE));
//
//        btnStateList.setBackground(drawable);

        btnDownload.setOnClickListener(this);
        downloadManager = (DownloadManager) getContext().getSystemService(Context.DOWNLOAD_SERVICE);
    }

    @Override
    public void onClick(View v) {
        if( checkForPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            downloadFile();
        }else{
            requestPermissions(
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    DOWNLOAD_FILE_REQUEST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case DOWNLOAD_FILE_REQUEST:
                if(grantResults.length > 0 && grantResults[0] == PERMISSION_GRANTED){
                    downloadFile();
                }else{
                    Toast.makeText(getContext(), "No granted permission to write in external storage", Toast.LENGTH_SHORT).show();
                }
        }
    }

    private void downloadFile() {
        //http://lorempixel.com/400/200/sports/
        Uri resourceUri = Uri.parse("http://lorempixel.com/400/200/sports/");

        DownloadManager.Request request = new DownloadManager.Request(resourceUri);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setAllowedOverRoaming(false);
        request.setTitle("Dummy download ");
        request.setDescription("Downloading " + "sample" + ".png");
        request.setVisibleInDownloadsUi(true);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "/HW002/"  + "sample" + ".png");
        downloadManager.enqueue(request);
    }


    private boolean checkForPermission(String permission){
        return ContextCompat.checkSelfPermission(getContext(), permission) == PERMISSION_GRANTED;
    }

}
