package app.storeez.widget

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

data class Story(val id: String, val url: String, val title: String, val previewUrl: String)
data class WidgetData(val stories: List<Story>)

interface StoreezApiService {
    @GET("widget/{widgetId}")
    suspend fun getWidgetData(@Path("widgetId") widgetId: String): WidgetData
}

class StoreezApi {
    fun getApiService(): StoreezApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.storeez.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(StoreezApiService::class.java)
    }
}