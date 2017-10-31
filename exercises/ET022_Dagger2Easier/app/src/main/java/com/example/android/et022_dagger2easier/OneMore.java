package com.example.android.et022_dagger2easier;

import javax.inject.Inject;

/**
 * Created by Aptivist-U001 on 10/26/2017.
 */

public class OneMore {
    @Inject
    public OneMore() {
    }

    public void sayOneMoreThing(){
        System.out.println("One more thing");
    }
}
