package com.shu.data.api.model

import com.google.gson.annotations.SerializedName
import com.shu.entity.ICondition


data class Condition (

  @SerializedName("text" ) override  var text : String? = null,
  @SerializedName("icon" ) override  var icon : String? = null,
  @SerializedName("code" ) override  var code : Int? = null

) : ICondition