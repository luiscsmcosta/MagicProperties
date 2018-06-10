package com.lc.magicproperties.ui.main

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.TextView
import com.lc.magicproperties.R
import com.lc.magicproperties.application.applicationComponent
import com.lc.magicproperties.model.daos.PropertiesDAO
import com.lc.magicproperties.ui.adapters.PropertiesRecyclerViewAdapter
import com.lc.magicproperties.ui.base.BaseActivity

class MainActivity : BaseActivity<MainContract.View, MainPresenter>(), MainContract.View {

    private var propertiesDAO: PropertiesDAO? = null

    private lateinit var progressView: View
    private lateinit var propertiesLocationTv: TextView
    private lateinit var lowestPriceOnLocationTv: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: PropertiesRecyclerViewAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressView = findViewById<View>(R.id.loadingLinearLayout)

        propertiesLocationTv = findViewById(R.id.propertiesLocationTv)
        lowestPriceOnLocationTv = findViewById(R.id.lowestPriceOnLocationTv)

        viewManager = LinearLayoutManager(this)
        viewAdapter = PropertiesRecyclerViewAdapter(this, null)

        recyclerView = findViewById<RecyclerView>(R.id.propertiesRv).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(false)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))

        }

        presenter.getProperties(progressView)
    }

    override fun injectPresenter() {
        applicationComponent.inject(this)
    }


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        presenter.saveInstance(outState, propertiesDAO, progressView.visibility)
    }

    override fun showInfo(propertiesDAO: PropertiesDAO) {
        this.propertiesDAO = propertiesDAO

        this.propertiesLocationTv.text = String.format(getString(R.string.cityString), propertiesDAO.location.city.name, propertiesDAO.location.city.country)
        this.lowestPriceOnLocationTv.text = String.format(getString(R.string.lowestPriceString), propertiesDAO.filterData.lowestPricePerNight.value, propertiesDAO.filterData.lowestPricePerNight.currency)

        this.viewAdapter.setProperties(propertiesDAO.properties)

        Log.d(MainActivity::class.java.name, "properties lowest price: " + propertiesDAO.filterData.lowestPricePerNight.value + " " + propertiesDAO.filterData.lowestPricePerNight.currency)
    }

    override fun setProgressViewVisibility(progressViewVisibility: Int) {
        progressView.visibility = progressViewVisibility
    }
}