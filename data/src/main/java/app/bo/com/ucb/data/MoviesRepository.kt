package app.bo.com.ucb.data

import app.bo.com.ucb.domain.Movie

class MoviesRepository(
    val remoteDataSource: IRemoteDataSource, val apiKey: String, val localDataSource: ILocalDataSource) {
    fun getPopularMovies() = remoteDataSource.getPopularMovies(apiKey)

}