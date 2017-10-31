package com.example.android.et020_mvp.data;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Aptivist-U001 on 10/25/2017.
 */

public class FakeRepository {
    public List<String> getFakeDataFromRestService(){
        return Arrays.asList("Edwin", "Ham", "Pepe", "Isaias", "Al");
    }
}
