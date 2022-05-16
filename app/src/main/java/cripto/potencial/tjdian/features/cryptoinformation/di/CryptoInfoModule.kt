package cripto.potencial.tjdian.features.cryptoinformation.di

import cripto.potencial.tjdian.features.cryptoinformation.data.CryptoInfoDataRepository
import cripto.potencial.tjdian.features.cryptoinformation.data.remote.CryptoInfoRemoteSource
import cripto.potencial.tjdian.features.cryptoinformation.data.remote.firebase.CryptoInfoDbRemoteSource
import cripto.potencial.tjdian.features.cryptoinformation.domain.CryptoInfoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class CryptoInfoModule {

    @Binds
    abstract fun bindCryptoInfoRepository(repository: CryptoInfoDataRepository): CryptoInfoRepository

    @Binds
    @DbRemoteQualifiers
    abstract fun bindCryptoInfoRemoteSource(remoteSource: CryptoInfoDbRemoteSource): CryptoInfoRemoteSource


}