package app.bo.com.ucb.framework

import app.bo.com.ucb.data.IRemoteDataSource
import app.bo.com.ucb.domain.Movie

class MovieDataSource(val api: RetrofitBuilder) : IRemoteDataSource {
    override suspend fun getPopularMovies(apiKey: String): List<Movie> {
        val resp = api.apiService.listPopularMovies(apiKey)
            .results.map {
                it.toDomainMovie()
            }
        return resp
    }
}