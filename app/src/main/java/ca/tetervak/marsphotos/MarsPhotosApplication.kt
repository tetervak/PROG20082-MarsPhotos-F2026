package ca.tetervak.marsphotos

import android.app.Application
import ca.tetervak.marsphotos.data.AppContainer
import ca.tetervak.marsphotos.data.DefaultAppContainer

class MarsPhotosApplication : Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
