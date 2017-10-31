package com.example.android.et022_dagger2easier;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by Aptivist-U001 on 10/26/2017.
 */

public class Another {

    @Inject
    Retrofit retrofit;

    @Inject
    OneMore oneMore;

    @Inject
    public Another() {
    }

    public void saySomething(){
        System.out.println(retrofit.baseUrl().toString());
        oneMore.sayOneMoreThing();
    }
}
