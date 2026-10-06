package ca.tetervak.marsphotos

import ca.tetervak.marsphotos.fake.FakeDataSource
import ca.tetervak.marsphotos.fake.FakeNetworkMarsPhotosRepository
import ca.tetervak.marsphotos.rules.TestDispatcherRule
import ca.tetervak.marsphotos.ui.screens.MarsUiState
import ca.tetervak.marsphotos.ui.screens.MarsViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MarsViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() =
        runTest {
            val marsViewModel = MarsViewModel(
                marsPhotosRepository = FakeNetworkMarsPhotosRepository()
            )
            assertEquals(
                MarsUiState.Success(FakeDataSource.photosList),
                marsViewModel.marsUiState
            )
        }
}