package com.lc.magicproperties.ui.main

import junit.framework.TestCase
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MainPresenterTest: TestCase() {

    @Mock
    lateinit var mainPresenter: MainPresenter

    override fun setUp() {
        super.setUp()

        MockitoAnnotations.initMocks(this)
    }


}