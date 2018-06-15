package com.example.stwis.samplenavigation


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class SplashFragment : Fragment() {
    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val timerDisposable = Single.timer(1000, TimeUnit.MILLISECONDS)
                .subscribe { _ -> view.findNavController().navigate(R.id.action_splashFragment_to_loginFragment) }

        disposables.add(timerDisposable)
    }

    override fun onStop() {
        super.onStop()
        if (!disposables.isDisposed) disposables.dispose()
    }
}
