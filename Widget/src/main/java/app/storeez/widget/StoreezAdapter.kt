package app.storeez.widget

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class StoreezAdapter (
    private val context: Context,
    private val stories: List<Story>,
    private val layoutResId: Int = R.layout.storeez_story_item,
    private val titleResId: Int = R.id.storeezItemTitle,
    private val imageResId: Int = R.id.storeezItemImage,
) : RecyclerView.Adapter<StoreezAdapter.StoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        return StoryViewHolder(view, titleResId, imageResId)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val story = stories[position]
        holder.bind(story)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, StoreezWebViewActivity::class.java)
            intent.putExtra("url", story.url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return stories.size
    }

    class StoryViewHolder(itemView: View, titleResId: Int, imageResId: Int) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(titleResId)
        private val titleImageView: ImageView = itemView.findViewById(imageResId)

        fun bind(story: Story) {
            titleTextView.text = story.title
            Picasso.get().load(story.previewUrl).into(titleImageView)
        }
    }
}