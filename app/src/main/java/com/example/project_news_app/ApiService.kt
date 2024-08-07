package com.example.project_news_app

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    //LoginRequest
    @POST("api/loginMember/login")
    fun loginMember(@Body request: LoginRequest): Call<LoginResponse>
//    @POST("api/loginAdmin/login")
//    fun loginAdmin(@Body request: LoginRequest): Call<AdminLoginResponse>

    //OTP Request/Verify + ResetPassword
    @POST("api/recovery_member/request-otp")
    fun requestOtp(@Body phoneNumber: PhoneNumberRequest): Call<OtpResponse>
    @POST("api/recovery_member/verify-otp")
    fun verifyOtp(@Body otpRequest: OtpRequest): Call<OtpResponse>
    @POST("api/reset_password_member/reset-password")
    fun resetPassword(@Body request: ResetPasswordRequest): Call<ResetPasswordResponse>

    //MemberData
    @GET("api/member/{id}")
    fun getMemberById(@Path("id") memId: Int): Call<MemberData>
    @POST("api/member")
    fun postMember(@Body member: MemberData): Call<MemberData>
    @PUT("api/member/{id}")
    fun updateMember(@Path("id") memId: Int, @Body memberData: MemberData): Call<MemberData>

    //CategoryData
    @GET("api/category")
    fun getCategory(): Call<List<CategoryData>>
    @GET("api/category/{id}")
    fun getCategoryById(@Path("id") catId: Int): Call<CategoryData>

    //NewsData
    @GET("api/news")
    fun getAllNews(): Call<List<NewsData>>
    @GET("api/news/category/{id}")
    fun getNewsByCategory(@Path("id") catId: Int): Call<List<NewsData>>
    @GET("api/news/category/{id}")
    fun getNewsByCategoryPaged(
        @Path("id") catId: Int,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Call<List<NewsData>>
    @GET("api/news/{id}")
    fun getNewsById(@Path("id") newsId: Int): Call<NewsData>
    @GET("api/news/ids")
    fun getNewsByIds(@Query("ids") ids: List<Int>): Call<List<NewsData>>



    //PictureData
    @GET("api/picture/news/{newsId}")
    fun getCoverImage(@Path("newsId") newsId: Int): Call<List<PictureData>>

    //News_RatingData
    @GET("api/news_rating")
    fun getNewsRating(): Call<List<News_RatingData>>
    @GET("api/news_rating/{id}")
    fun getNewsRatingByNewsId(@Path("id") newsId: Int): Call<News_RatingData>
    @PUT("api/news_rating/{memId}/{newsId}")
    fun putNewsRatingByMemId(
        @Path("memId") memId: Int,
        @Path("newsId") newsId: Int,
        @Body newsRating: News_RatingData
    ): Call<ResponseBody>

    //Total_ReadData
    @GET("api/total_read")
    fun getTotalRead(): Call<List<Total_ReadData>>
    @GET("api/total_read/{id}")
    fun getTotalReadById(@Path("id") countId: Int): Call<Total_ReadData>
    @POST("api/total_read")
    fun postTotalRead(@Body totalRead: Total_ReadData): Call<Total_ReadData>

    //Sub_CategoryData
    @GET("api/sub_category")
    fun getSubcategory(): Call<List<Sub_CategoryData>>
    @GET("api/sub_category/ids")
    fun getSubcategoriesByIds(@Query("ids") ids: List<Int>): Call<List<Sub_CategoryData>>

    //News_Sub_CateData
    @GET("api/news_sub_cate")
    fun getNewsSubCate(): Call<List<News_Sub_CateData>>
    @GET("api/news_sub_cate/{newsId}")
    fun getNewsSubCateByNewsId(@Path("newsId") newsId: Int): Call<List<News_Sub_CateData>>

    //MajorData
    @GET("api/major")
    fun getMajor(): Call<List<MajorData>>
    @GET("api/major/{id}")
    fun getMajorById(@Path("id") majorId: Int): Call<MajorData>

    //Favorite_CategoryData
    @GET("api/favorite_category")
    fun getFavoriteCategory(): Call<List<Favorite_CategoryData>>
    @GET("api/favorite_category/{id}")
    fun getFavoriteCategoryByMemId(@Path("id") memId: Int): Call<Favorite_CategoryData>
    @POST("api/favorite_category")
    fun postFavoriteCategory(@Body favorite: Favorite_CategoryData): Call<Favorite_CategoryData>
    @DELETE("api/favorite_category/{id}")
    fun deleteFavoriteCategory(@Path("id") memId: Int): Call<Void>

    //Read_LaterData
    @GET("api/read_later/{memId}")
    fun getReadLaterByMemId(@Path("memId") memId: Int): Call<List<Read_LaterData>>
    @POST("api/read_later")
    fun postReadLater(@Body readLater: Read_LaterData): Call<Void>

    @DELETE("api/read_later/{memId}/{newsId}")
    fun deleteReadLater(@Path("memId") memId: Int, @Path("newsId") newsId: Int): Call<Void>


    //Read_HistoryData
    @GET("api/read_history/{memId}")
    fun getReadHistoryByMemId(@Path("memId") memId: Int): Call<List<Read_HistoryData>>
    @POST("api/read_history")
    fun addReadHistory(@Body readHistory: Read_HistoryData): Call<Void>
    @DELETE("api/read_history/{memId}/{newsId}")
    fun deleteReadHistory(@Path("memId") memId: Int, @Path("newsId") newsId: Int): Call<Void>


}

