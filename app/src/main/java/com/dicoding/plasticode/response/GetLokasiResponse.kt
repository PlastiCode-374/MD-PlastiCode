package com.dicoding.plasticode.response

import android.location.Location
import com.google.gson.annotations.SerializedName

data class GetLokasiResponse(

    @field:SerializedName("html_attributions")
	val htmlAttributions: List<Any>,

    @field:SerializedName("results")
	val results: List<ResultsItem>,

    @field:SerializedName("status")
	val status: String? = null
) {
	data class PlusCode(

		@field:SerializedName("errors")
		val errors: String? = null,

		@field:SerializedName("compound_code")
		val compoundCode: String? = null,

		@field:SerializedName("global_code")
		val globalCode: String? = null
	)

	data class PhotosItem(

		@field:SerializedName("errors")
		val errors: String? = null,

		@field:SerializedName("photo_reference")
		val photoReference: String? = null,

		@field:SerializedName("width")
		val width: Int? = null,

		@field:SerializedName("html_attributions")
		val htmlAttributions: List<String?>? = null,

		@field:SerializedName("height")
		val height: Int? = null
	)

	data class Geometry(

        @field:SerializedName("errors")
		val errors: String? = null,

        @field:SerializedName("viewport")
		val viewport: Viewport? = null,

        @field:SerializedName("location")
		val location: Location? = null
	) {
		data class Location(

			@field:SerializedName("errors")
			val errors: String? = null,

			@field:SerializedName("lng")
			val lng: Any? = null,

			@field:SerializedName("lat")
			val lat: Any? = null
		)

		data class Viewport(

            @field:SerializedName("errors")
			val errors: String? = null,

            @field:SerializedName("southwest")
			val southwest: Southwest? = null,

            @field:SerializedName("northeast")
			val northeast: Northeast? = null
		) {
			data class Northeast(

				@field:SerializedName("errors")
				val errors: String? = null,

				@field:SerializedName("lng")
				val lng: Any? = null,

				@field:SerializedName("lat")
				val lat: Any? = null
			)

			data class Southwest(

				@field:SerializedName("errors")
				val errors: String? = null,

				@field:SerializedName("lng")
				val lng: Any? = null,

				@field:SerializedName("lat")
				val lat: Any? = null
			)
		}
	}

	data class ResultsItem(

        @field:SerializedName("errors")
		val errors: String? = null,

        @field:SerializedName("types")
		val types: List<String?>? = null,

        @field:SerializedName("business_status")
		val businessStatus: String? = null,

        @field:SerializedName("icon")
		val icon: String? = null,

        @field:SerializedName("rating")
		val rating: Double? = null,

        @field:SerializedName("icon_background_color")
		val iconBackgroundColor: String? = null,

        @field:SerializedName("photos")
		val photos: List<PhotosItem?>? = null,

        @field:SerializedName("reference")
		val reference: String? = null,

        @field:SerializedName("user_ratings_total")
		val userRatingsTotal: Int? = null,

        @field:SerializedName("price_level")
		val priceLevel: Int? = null,

        @field:SerializedName("scope")
		val scope: String? = null,

        @field:SerializedName("name")
		val name: String? = null,

        @field:SerializedName("opening_hours")
		val openingHours: OpeningHours? = null,

        @field:SerializedName("geometry")
		val geometry: Geometry? = null,

        @field:SerializedName("icon_mask_base_uri")
		val iconMaskBaseUri: String? = null,

        @field:SerializedName("vicinity")
		val vicinity: String? = null,

        @field:SerializedName("plus_code")
		val plusCode: PlusCode? = null,

        @field:SerializedName("place_id")
		val placeId: String? = null
	)

	data class OpeningHours(

		@field:SerializedName("open_now")
		val openNow: Boolean? = null
	)
}


