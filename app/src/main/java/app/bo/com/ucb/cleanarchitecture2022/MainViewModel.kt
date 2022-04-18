package app.bo.com.ucb.cleanarchitecture2022

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.bo.com.ucb.domain.Movie
import app.bo.com.ucb.usecases.GetPopularMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val popularMovies: GetPopularMovie): ScopedViewModel() {
    init {
        initScope()
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() = _model

    sealed class UiModel() {
        class Content(val movies: List<Movie>) : UiModel()
    }
    fun loadMovies() {
        launch(Dispatchers.IO) {
            _model.postValue(UiModel.Content(popularMovies.invoke()))
    }}
}

