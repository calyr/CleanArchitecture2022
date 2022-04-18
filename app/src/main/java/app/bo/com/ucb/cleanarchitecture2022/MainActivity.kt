package app.bo.com.ucb.cleanarchitecture2022

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import app.bo.com.ucb.data.MoviesRepository
import app.bo.com.ucb.domain.Movie
import app.bo.com.ucb.framework.MovieDataSource
import app.bo.com.ucb.framework.RetrofitBuilder
import app.bo.com.ucb.usecases.GetPopularMovie
import org.koin.androidx.scope.ScopeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : ScopeActivity() {

    private val mainViewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.model.observe(this, Observer(::updateUi))
        mainViewModel.loadMovies()
    }

    private fun updateUi(model: MainViewModel.UiModel?) {
        when ( model) {
            is MainViewModel.UiModel.Content -> showList(model.movies)
        }
    }

    fun showList(list: List<Movie>) {
        for ( i in list) {
            Toast.makeText(this, i.title, Toast.LENGTH_LONG ).show()
        }
        //recycler.adapter = MainAdapter(list)
    }
}

