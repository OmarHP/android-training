package com.example.android.et020_mvp.ui.main;

import com.example.android.et020_mvp.data.FakeRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Aptivist-U001 on 10/25/2017.
 */
public class MainPresenterTest {
    private FakeRepository fakeRepository;
    private MainPresenter mainPresenter;

    @Before
    public void setUp() throws Exception {
        fakeRepository = new FakeRepository();
        mainPresenter = new MainPresenter(fakeRepository);
    }

    @After
    public void tearDown() throws Exception {
        fakeRepository = null;
        mainPresenter = null;
    }

    @Test
    public void mainPresenterNotNull() throws Exception {
        assertNotNull(mainPresenter);
    }

    @Test
    public void whenDataRequested_viewShouldBeUpdated() throws Exception {
        mainPresenter.attachView(new MainContract.View() {
            @Override
            public void showResults(List<String> results) {
                assertEquals(5, results.size());
            }

            @Override
            public void showError(String error) {

            }

            @Override
            public void showProgress() {

            }

            @Override
            public void hideProgress() {

            }
        });

        mainPresenter.loadData();
    }
}