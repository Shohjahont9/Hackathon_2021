package uz.fizmasoft.xatlov.db.preferences

import android.content.Context
import androidx.preference.PreferenceManager

class PreferencesManager(
    private val context: Context
) {

    private val preferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(
            context
        )
    }


    var userToken by PreferencesDelegate(preferences, USER_TOKEN, "empty")
    var isPermission by PreferencesDelegate(preferences,PERMISSION, false)

    companion object {

        private const val USER_TOKEN = "user_token"
        private const val PERMISSION = "user_permission"

    }

}