package com.dicoding.plasticode.ui.deteksi

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.plasticode.response.PostImageResponse
import com.dicoding.plasticode.network.ApiConfig
import com.dicoding.plasticode.utils.reduceFileImage
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class DeteksiViewModel: ViewModel() {
    private val _postImage = MutableLiveData<PostImageResponse>()
    val postImage: LiveData<PostImageResponse> = _postImage

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun postImage(context: Context, image: File) {
        val fileCompressed = reduceFileImage(image)
        val imageFIle = fileCompressed.asRequestBody("image/jpeg".toMediaTypeOrNull())
        val imageFileMultipart = MultipartBody.Part.createFormData(
            "file",
            fileCompressed.name,
            imageFIle
        )

        _isLoading.value = true
        val client = ApiConfig.getApiService().postImage(imageFileMultipart)
        client.enqueue(object : Callback<PostImageResponse> {
            override fun onResponse(
                call: Call<PostImageResponse>,
                response: Response<PostImageResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _postImage.value = response.body()
                } else {
                    Toast.makeText(context, "Fail: ${response.message()}", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<PostImageResponse>, t: Throwable) {
                _isLoading.value = false
                Toast.makeText(context, "onFailure: ${t.message.toString()}", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}