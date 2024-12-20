package com.example.project_news_app

import android.content.Context
import org.json.JSONObject

object ConfigUtil {
    //เปิดไฟล์และอ่านค่า config
    fun getBaseUrl(context: Context): String {
        val assetManager = context.assets
        val inputStream = assetManager.open("config.json")
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        val jsonObject = JSONObject(jsonString)
        return jsonObject.getString("baseUrl") //แปลงเป็น string ให้ RetrofitClient

    }
}

