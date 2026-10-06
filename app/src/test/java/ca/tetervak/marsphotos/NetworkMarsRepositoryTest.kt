package ca.tetervak.marsphotos

import ca.tetervak.marsphotos.data.NetworkMarsPhotosRepository
import ca.tetervak.marsphotos.fake.FakeDataSource
import ca.tetervak.marsphotos.fake.FakeMarsApiService
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class NetworkMarsRepositoryTest {

    @Test
    fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() =
        runTest {
            val repository = NetworkMarsPhotosRepository(
                marsApiService = FakeMarsApiService()
            )
            assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())
        }
}