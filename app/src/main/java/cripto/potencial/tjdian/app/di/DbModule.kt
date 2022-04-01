package cripto.potencial.tjdian.app.di

import android.content.Context
import androidx.room.Room
import cripto.potencial.tjdian.app.di.db.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DbModule {

    @Singleton
    @Provides

    fun providesRoomDb(@ApplicationContext context: Context):AppDataBase{
        return Room.databaseBuilder(
            context,AppDataBase::class.java,"crypto-db"
        ).build()
    }

    @Singleton
    @Provides
    fun providesCoinDao(db:AppDataBase)=db.coinDao()

}