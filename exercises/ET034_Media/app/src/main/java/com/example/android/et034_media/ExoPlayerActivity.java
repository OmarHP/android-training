package com.example.android.et034_media;

import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveVideoTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Util;

public class ExoPlayerActivity extends AppCompatActivity {

    private static final Uri VIDEO_URI = Uri.parse("http://techslides.com/demos/sample-videos/small.mp4");
    private SimpleExoPlayerView simpleExoPlayerView;
    private SimpleExoPlayer simpleExoPlayer;
    private DefaultBandwidthMeter bandwidthMeter;
    private TrackSelection.Factory selectionFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_player);
        simpleExoPlayerView = findViewById(R.id.a_exo_simple);

        // First step: Set up the Bandwith Metter
        bandwidthMeter = new DefaultBandwidthMeter();

        //Second step: Setup the the TrackSelection
        selectionFactory = new AdaptiveVideoTrackSelection.Factory(bandwidthMeter);

        //Third step: Create the ExoPlayer with the SelectionFactory created
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this,
                new DefaultTrackSelector(selectionFactory),
                new DefaultLoadControl());

        //Fourth step: Setting the view for the ExoPlayer
        simpleExoPlayerView.setPlayer(simpleExoPlayer);

        //Fifth step: set data source
        String userAgent = Util.getUserAgent(this, getString(R.string.app_name));
        HttpDataSource.Factory httpDataSourceFactory = new DefaultHttpDataSourceFactory(userAgent);
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, bandwidthMeter, httpDataSourceFactory);

        //Sixth step: Setup the media extractor
        MediaSource mediaSource = new ExtractorMediaSource(VIDEO_URI,
                dataSourceFactory,
                new DefaultExtractorsFactory(),
                new Handler(),
                null);

        // Seventh step: prepare to play ExoPlayer
        simpleExoPlayer.prepare(mediaSource);
    }
}
