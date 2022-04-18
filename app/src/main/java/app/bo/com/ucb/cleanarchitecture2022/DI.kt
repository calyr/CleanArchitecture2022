package app.bo.com.ucb.cleanarchitecture2022

import app.bo.com.ucb.data.IRemoteDataSource
import app.bo.com.ucb.data.MoviesRepository
import app.bo.com.ucb.framework.MovieDataSource
import app.bo.com.ucb.framework.RetrofitBuilder
import app.bo.com.ucb.usecases.GetPopularMovie
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun AndroidApplication.initDI() {
    startKoin {
        androidLogger()
        androidContext(this@initDI)
        modules(listOf(appModule, framework, dataModule, scopeModule))
    }
}

private val appModule = module {
    single( named("apiKey")) {
        androidApplication().getString(R.string.api_key)
    }
}
private val framework = module {
    factory { RetrofitBuilder }
}

private val dataModule = module {
    factory<IRemoteDataSource> {
        MovieDataSource(get())
    }
    factory {
        MoviesRepository(get(), get( named("apiKey")))
    }
}

private val scopeModule = module {
    scope( named<MainActivity>()){
        viewModel { MainViewModel(get()) }
        scoped { GetPopularMovie(get()) }
    }
}


