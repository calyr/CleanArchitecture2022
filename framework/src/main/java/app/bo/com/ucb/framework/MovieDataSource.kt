package app.bo.com.ucb.framework

import app.bo.com.ucb.data.IRemoteDataSource
import app.bo.com.ucb.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class MovieDataSource(val api: RetrofitBuilder) : IRemoteDataSource {
    override suspend fun getPopularMovies(apiKey: String): List<Movie> {
        return api.apiService.listPopularMovies(apiKey)
                .results.map {
                    it.toDomainMovie()
        }
    }
}