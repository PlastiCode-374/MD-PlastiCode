package com.dicoding.plasticode.response

import com.google.gson.annotations.SerializedName

data class PostRegisterResponse(

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String
)
