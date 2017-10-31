package com.example.android.et020_mvp.ui.main;

import com.example.android.et020_mvp.data.FakeRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Aptivist-U001 on 10/26/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterMockedTest {
    @Mock
    private FakeRepository fakeRepository;
    @Mock
    private MainContract.View view;

    private MainPresenter mainPresenter;

    @Before
    public void setUp() throws Exception {
        mainPresenter = new MainPresenter(fakeRepository);
    }

    @Test
    public void whenInstancePresenter_shouldNotBeNull() throws Exception {
        assertNotNull(mainPresenter);
    }

    @Test
    public void whenPresenterLoadsResults_viewShouldShowProgress() throws Exception {
        List<String> fakeList = Arrays.asList("Hello", "Hello");
        when(fakeRepository.getFakeDataFromRestService()).thenReturn(fakeList);

        mainPresenter.attachView(view);
        mainPresenter.loadData();
        verify(view).showProgress();
        //verify(view).showResults(Arrays.asList("Another", "list"));
        verify(view).showResults(fakeList);
        verify(view).hideProgress();
    }

    @Test
    public void whenPresenterLoadsDataCatchesEception_viewShouldShowError() throws Exception {
        String message = "Fake exception";
        when(fakeRepository.getFakeDataFromRestService()).thenThrow(new RuntimeException(message));
        mainPresenter.attachView(view);
        mainPresenter.loadData();
        verify(view).showProgress();
        verify(view).showError(message);
        verify(view).hideProgress();
    }
}
