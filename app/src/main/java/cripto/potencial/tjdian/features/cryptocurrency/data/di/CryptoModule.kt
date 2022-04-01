package cripto.potencial.tjdian.features.cryptocurrency.data.di

import cripto.potencial.tjdian.features.cryptocurrency.data.CryptoDataRepository
import cripto.potencial.tjdian.features.cryptocurrency.data.local.CryptoLocalSource
import cripto.potencial.tjdian.features.cryptocurrency.data.local.db.CryptoDbLocalSource
import cripto.potencial.tjdian.features.cryptocurrency.domain.CryptoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class CryptoModule {

    @Binds
    abstract fun bindEventRepository(repository: CryptoDataRepository): CryptoRepository

    @Binds

    abstract fun bindEventRemoteSource(remoteSource: CryptoDbLocalSource): CryptoLocalSource

}