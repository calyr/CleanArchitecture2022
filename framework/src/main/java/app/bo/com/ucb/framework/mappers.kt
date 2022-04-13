package app.bo.com.ucb.framework

import app.bo.com.ucb.framework.Movie as ServerMovie
import app.bo.com.ucb.domain.Movie as DomainMovie

fun ServerMovie.toDomainMovie() : DomainMovie {
    return DomainMovie(title, posterPath)
}
