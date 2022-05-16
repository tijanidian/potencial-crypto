package cripto.potencial.tjdian.features.login.di


import cripto.potencial.tjdian.features.login.data.SessionDataRepository
import cripto.potencial.tjdian.features.login.domain.SessionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class LoginModule {

    @Binds
    abstract fun bindSessionRepository(dataRepository: SessionDataRepository): SessionRepository
}