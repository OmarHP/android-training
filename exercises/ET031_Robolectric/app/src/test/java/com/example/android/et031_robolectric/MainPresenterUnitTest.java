package com.example.android.et031_robolectric;

import com.example.android.et031_robolectric.data.MathModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Aptivist-U001 on 11/2/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterUnitTest {

    @Mock
    private MainContract.View view;
    @Mock
    private MathModel mathModel;

    private MainPresenter mainPresenter;

    @Before
    public void setUp() throws Exception {
        mainPresenter = new MainPresenter(mathModel);
    }

    @After
    public void tearDown() throws Exception {
        mainPresenter = null;
    }

    @Test
    public void init_viewShouldNotBeNull() throws Exception {
        //Setup stage
        mainPresenter.view = null;
        //Action stage
        mainPresenter.init(view);
        //Result stage
        assertNotNull(mainPresenter.view);
    }

    @Test
    public void destroy_viewShouldBeNull() throws Exception {
        //Setup stage
        mainPresenter.view = this.view;
        //Action stage
        mainPresenter.destroy();
        //Result stage
        assertNull(mainPresenter.view);
    }

    @Test
    public void doCalculation_shouldUpdateView() throws Exception {
        int value = 10;
        when(mathModel.calculate()).thenReturn(value);
        mainPresenter.init(view);

        mainPresenter.doCalculation();

        verify(view).incrementCounter(value);
    }
}
