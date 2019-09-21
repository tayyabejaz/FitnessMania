package com.example.starterproject.helper

import android.content.Context
import android.content.SharedPreferences
import com.example.starterproject.R


class SharedPreferencesManager private constructor() {

    private var sharedPreferences: SharedPreferences? = null

    fun removeKey(key: String) {
        if (sharedPreferences != null) {
            sharedPreferences!!.edit().remove(key).apply()
        }
    }

    fun clear() {
        if (sharedPreferences != null) {
            sharedPreferences!!.edit().clear().apply()
        }
    }

    operator fun contains(key: String): Boolean {
        return sharedPreferences!!.contains(key)
    }

    fun setString(key: String, value: String) {
        sharedPreferences!!.edit().putString(key, value).apply()
    }

    fun getString(key: String): String? {
        return sharedPreferences!!.getString(key, mContext!!.getString(R.string.key_not_found))
    }

    fun getString(key: String, defaultValue: String): String? {
        return sharedPreferences!!.getString(key, defaultValue)
    }

    fun setInt(key: String, value: Int) {
        sharedPreferences!!.edit().putInt(key, value).apply()
    }

    fun getInt(key: String): Int {
        return sharedPreferences!!.getInt(key, -1)
    }

    fun setLong(key: String, value: Long) {
        sharedPreferences!!.edit().putLong(key, value).apply()
    }

    fun getLong(key: String): Long {
        return sharedPreferences!!.getLong(key, -1)
    }

    fun setBoolean(key: String, value: Boolean) {
        sharedPreferences!!.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String, defaultvalue: Boolean): Boolean {
        return sharedPreferences!!.getBoolean(key, defaultvalue)
    }

    fun setFloat(key: String, value: Float) {
        sharedPreferences!!.edit().putFloat(key, value).apply()
    }

    fun getFloat(key: String): Float {
        return sharedPreferences!!.getFloat(key, 0f)
    }

    companion object {
        private var appPreferences: SharedPreferencesManager? = null
        private var mContext: Context? = null

        fun getInstance(context: Context): SharedPreferencesManager {
            mContext = context
            if (appPreferences == null) {
                appPreferences = SharedPreferencesManager()
                if (appPreferences!!.sharedPreferences == null) {
                    appPreferences!!.sharedPreferences =
                        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
                }
            }
            return appPreferences as SharedPreferencesManager
        }
    }
}
