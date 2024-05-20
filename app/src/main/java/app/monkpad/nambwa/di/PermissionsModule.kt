package app.monkpad.nambwa.di

import app.monkpad.nambwa.data.repositories.IScreenTimeRepository
import app.monkpad.nambwa.data.repositories.ScreenTimeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class PermissionsModule{

    @Binds
    abstract fun bindRepository(
        repository: ScreenTimeRepository
    ): IScreenTimeRepository
}
