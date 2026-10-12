package ca.tetervak.marsphotos

import android.app.Application
import ca.tetervak.marsphotos.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarsPhotosApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MarsPhotosApplication)
            modules(appModule)
        }
    }
}
