package ca.tetervak.marsphotos.fake

import ca.tetervak.marsphotos.data.MarsPhotosRepository
import ca.tetervak.marsphotos.model.MarsPhoto

class FakeNetworkMarsPhotosRepository : MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }
}