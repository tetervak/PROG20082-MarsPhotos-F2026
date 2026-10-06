package ca.tetervak.marsphotos.fake

import ca.tetervak.marsphotos.network.MarsApiService
import ca.tetervak.marsphotos.model.MarsPhoto

class FakeMarsApiService : MarsApiService {
    override suspend fun getPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }
}