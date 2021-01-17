import com.google.gson.annotations.SerializedName
import com.yuvi.assingmentapp.model.Bg_color
import com.yuvi.assingmentapp.model.Title


data class Rating_obj (

	@SerializedName("title") val title : Title,
	@SerializedName("bg_color") val bg_color : Bg_color
)