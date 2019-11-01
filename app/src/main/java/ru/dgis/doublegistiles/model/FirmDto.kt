package ru.dgis.doublegistiles.model

import com.google.gson.annotations.SerializedName

class FirmDto(@field:SerializedName("id")
              val id: Long, @field:SerializedName("name")
              val name: String, @field:SerializedName("floor")
              val floor: String, @field:SerializedName("main_rubric")
              val mainRubric: String)
