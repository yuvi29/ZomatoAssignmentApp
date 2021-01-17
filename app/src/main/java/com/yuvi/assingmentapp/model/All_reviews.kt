import com.google.gson.annotations.SerializedName
import com.yuvi.assingmentapp.model.Reviews

data class All_reviews (

	@SerializedName("reviews") val reviews : List<Reviews>
)