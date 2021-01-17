import com.google.gson.annotations.SerializedName
import com.yuvi.assingmentapp.model.Bg_color


data class Rating_obj (

		@SerializedName("title") val title : Title,
		@SerializedName("bg_color") val bg_color : Bg_color
)