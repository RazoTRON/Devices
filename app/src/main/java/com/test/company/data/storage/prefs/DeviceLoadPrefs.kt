package com.test.company.data.storage.prefs

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.firstOrNull

import androidx.datastore.preferences.core.booleanPreferencesKey

private val IS_DEVICES_LOADED = booleanPreferencesKey("is_devices_loaded")

class DeviceLoadPrefs(private val store: DataStore<Preferences>) {

    suspend fun setLoadStatus(isLoaded: Boolean) {
        store.edit { store ->
            store[IS_DEVICES_LOADED] = isLoaded
        }
    }

    suspend fun getLoadStatus(): Boolean {
        val data = store.data.firstOrNull() ?: return false

        return data[IS_DEVICES_LOADED] ?: false
    }
}