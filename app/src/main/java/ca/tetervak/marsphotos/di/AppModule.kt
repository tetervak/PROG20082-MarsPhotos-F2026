package ca.tetervak.marsphotos.di

import ca.tetervak.marsphotos.data.MarsPhotosRepository
import ca.tetervak.marsphotos.data.NetworkMarsPhotosRepository
import ca.tetervak.marsphotos.network.MarsApiService
import ca.tetervak.marsphotos.ui.screens.MarsViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {
    single {
        val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/"
        Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(baseUrl)
            .build()
    }

    single<MarsApiService> {
        get<Retrofit>().create(MarsApiService::class.java)
    }

    singleOf(::NetworkMarsPhotosRepository) bind MarsPhotosRepository::class

    viewModelOf(::MarsViewModel)
}
