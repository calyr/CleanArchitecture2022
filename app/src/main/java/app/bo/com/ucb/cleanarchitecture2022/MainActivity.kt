package app.bo.com.ucb.cleanarchitecture2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import app.bo.com.ucb.data.MoviesRepository
import app.bo.com.ucb.domain.Movie
import app.bo.com.ucb.framework.MovieDataSource
import app.bo.com.ucb.framework.RetrofitBuilder
import app.bo.com.ucb.usecases.GetPopularMovie

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel(GetPopularMovie(MoviesRepository(MovieDataSource(RetrofitBuilder), getString(R.string.api_key))))

        mainViewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: MainViewModel.UiModel?) {
        when ( model) {
            is MainViewModel.UiModel.Content -> showList(model.movies)
        }
    }

    fun showList(list: List<Movie>) {
        //recycler.adapter = MainAdapter(list)
    }
}

