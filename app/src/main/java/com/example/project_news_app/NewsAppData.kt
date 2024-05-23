package com.example.project_news_app

import java.util.Date
import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

data class LoginRequest(
    val login: String,
    val password: String,
)
data class LoginResponse(
    val success: Boolean,
    val message: String?,
    val user: MemberData?
)

data class MemberData(
    @SerializedName("Mem_Id") val memId: Int,
    @SerializedName("Mem_Fname") val memFname: String,
    @SerializedName("Mem_Lname") val memLname: String,
    @SerializedName("Mem_Username") val memUsername: String,
    @SerializedName("Mem_Password") val memPassword: String,
    @SerializedName("Mem_Email") val memEmail: String,
    @SerializedName("Mem_Phone") val memPhone: String,
    @SerializedName("Mem_Status") val memStatus: Int
)

data class CategoryData(
    @SerializedName("Cat_Id") val catId: Int,
    @SerializedName("Cat_Name") val catName: String
)

data class Sub_CategoryData(
    @SerializedName("Sub_Cat_Id") val subCatId: Int,
    @SerializedName("Sub_Cat_Name") val subCatName: String,
    @SerializedName("Cat_Id") val catId: Int
)

data class MajorData(
    @SerializedName("Major_Id") val majorId: Int,
    @SerializedName("Major_Level") val majorLevel: Int,
)

data class NewsData(
    @SerializedName("News_Id") val newsId: Int,
    @SerializedName("News_Name") val newsName: String,
    @SerializedName("News_Details") val newsDetails: String,
    @SerializedName("Date_Added") val dateAdded: Date,
    @SerializedName("Cat_Id") val catId: Int,
    @SerializedName("Major_Id") val majorId: Int
)

data class PictureData(
    @SerializedName("News_Id") val newsId: Int,
    @SerializedName("News_Pic") val newsPic: String
)

data class Favorite_CategoryData(
    @SerializedName("Mem_Id") val memId: Int,
    @SerializedName("Cat_Id") val catId: Int
)

data class Read_LaterData(
    @SerializedName("Mem_Id") val memId: Int,
    @SerializedName("News_Id") val newsId: Int
)

data class News_RatingData(
    @SerializedName("Mem_Id") val memId: Int,
    @SerializedName("News_Id") val newsId: Int,
    @SerializedName("Rating_Score") val ratingScore: Float
)

data class Read_HistoryData(
    @SerializedName("Mem_Id") val memId: Int,
    @SerializedName("News_Id") val newsId: Int,
    @SerializedName("Read_Date") val readDate: Timestamp
)

data class Total_ReadData(
    @SerializedName("Count_Id") val countId: Int,
    @SerializedName("News_Id") val newsId: Int
)

data class News_Sub_CateData(
    @SerializedName("News_Id") val newsId: Int,
    @SerializedName("Sub_Cat_Id") val subCatId: Int
)




