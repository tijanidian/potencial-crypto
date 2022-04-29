package cripto.potencial.tjdian.app.di

import cripto.potencial.tjdian.features.cryptocurrency.data.CryptoDataRepository
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.CryptoRemoteSource
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.RemoteDataSource
import cripto.potencial.tjdian.features.cryptocurrency.domain.CryptoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class CryptoModule {

    @Binds
    abstract fun bindCryptoRepository(repository: CryptoDataRepository): CryptoRepository


    @Binds
    abstract fun bindCryptoRemoteSource(remoteSource: CryptoRemoteSource): RemoteDataSource
}