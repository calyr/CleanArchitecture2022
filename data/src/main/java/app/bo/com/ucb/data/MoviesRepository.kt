package app.bo.com.ucb.data

import app.bo.com.ucb.domain.Movie

class MoviesRepository(
    val remoteDataSource: IRemoteDataSource, val apiKey: String) {
    suspend fun getPopularMovies() = remoteDataSource.getPopularMovies(apiKey)

}