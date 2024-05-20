package app.monkpad.nambwa.ui.viewmodel

import androidx.lifecycle.ViewModel
import app.monkpad.nambwa.data.repositories.IScreenTimeRepository
import app.monkpad.nambwa.framework.permissions.Permissions
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: IScreenTimeRepository) :
    ViewModel() {
    fun hasPermissions(permissions: Permissions): Boolean {
        return repository.hasPermissions(permissions)
    }
}