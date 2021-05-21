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

    companion object {

        private const val USER_TOKEN = "user_token"

    }

}