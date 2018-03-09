package me.zhaoweihao.shopping.utils


import com.google.gson.Gson
import me.zhaoweihao.shopping.gson.*


/**
 * Created by Zhaoweihao on 2018/1/6.
 */

object Utility {
    fun handleGoodsResponse(response: String): Goods? {
        try {
            val gson = Gson()
            return gson.fromJson(response, Goods::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    fun handleGoodResponse(response: String): Good? {
        try {
            val gson = Gson()
            return gson.fromJson(response, Good::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    fun handleUserResponse(response: String): User? {
        try {
            val gson = Gson()
            return gson.fromJson(response, User::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    fun handleIsFollowResponse(response: String): IsFollow? {
        try {
            val gson = Gson()
            return gson.fromJson(response, IsFollow::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    fun handleFollowResponse(response: String): Follow? {
        try {
            val gson = Gson()
            return gson.fromJson(response, Follow::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    fun handleCollectionsResponse(response: String): Collections? {
        try {
            val gson = Gson()
            return gson.fromJson(response, Collections::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    fun handleConcernsResponse(response: String): Concerns? {
        try {
            val gson = Gson()
            return gson.fromJson(response, Concerns::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    fun handlePurchaserTradeResponse(response: String): PurchaserTrade? {
        try {
            val gson = Gson()
            return gson.fromJson(response, PurchaserTrade::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    fun handleSellerTradeResponse(response: String): SellerTrade? {
        try {
            val gson = Gson()
            return gson.fromJson(response, SellerTrade::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    fun handleUploadTradeResponse(response: String): Upload? {
        try {
            val gson = Gson()
            return gson.fromJson(response, Upload::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }







}
