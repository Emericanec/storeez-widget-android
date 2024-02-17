package app.storeez.widget

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StoreezWidget(context: Context, attrs: AttributeSet) : RecyclerView(context) {
    init {
        // Custom initialization or setup
        this.adapter = StoreezAdapter(context, listOf())
        this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val widgetId = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "widgetId")
        val service = StoreezApi()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val widget = service.getApiService().getWidgetData(widgetId)
                val adapter = StoreezAdapter(context, widget.stories)
                withContext(Dispatchers.Main) {
                    this@StoreezWidget.adapter = adapter
                }
            } catch (e: Exception) {
                throw e
            }
        }
    }
}