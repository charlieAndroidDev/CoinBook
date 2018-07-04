package com.example.charlie.coinbook.ui


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.charlie.coinbook.R
import com.example.charlie.coinbook.di.Injectable
import javax.inject.Inject


class DashboardFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory

    lateinit var transactionViewModel : TransactionViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        transactionViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(TransactionViewModel::class.java)

        transactionViewModel.response.observe(this, Observer { response -> handleResponse(response?.data.toString()) })
        transactionViewModel.getTransactions()
    }

    private fun handleResponse(response : String) {

    }
}
