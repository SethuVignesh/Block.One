package com.example.blockone.model.pojo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import retrofit2.Response

@Parcelize
data class Block(
    @SerializedName("header_extensions") val headerExtensions: List<Int?>? = null,
//    @SerializedName("ref_block_prefix") val refBlockPrefix: Int? = null,
    @SerializedName("new_producers") val newProducers: NewProducers? = null,
    @SerializedName("previous") val previous: String? = null,
    @SerializedName("block_extensions") val blockExtensions: List<Int?>? = null,
    @SerializedName("schedule_version") val scheduleVersion: Int? = null,
    @SerializedName("producer_signature") val producerSignature: String? = null,
    @SerializedName("transactions") val transactions: List<TransactionsItem?>? = null,
    @SerializedName("confirmed") val confirmed: Int? = null,
    @SerializedName("block_num") val blockNum: Int? = null,
    @SerializedName("producer") val producer: String? = null,
    @SerializedName("transaction_mroot") val transactionMroot: String? = null,
    @SerializedName("id") val id: String? = null,
    @SerializedName("action_mroot") val actionMroot: String? = null,
    @SerializedName("raw") var rawResponse: String? = null,
    @SerializedName("timestamp") val timestamp: String? = null
) : Parcelable {
    @Parcelize
    data class TransactionsItem(
        @SerializedName("net_usage_words") val netUsageWords: Int? = null,
//        @SerializedName("trx") val trx: String? = null,
        @SerializedName("cpu_usage_us") val cpuUsageUs: Int? = null,
        @SerializedName("status") val status: String? = null
    ) : Parcelable

    @Parcelize
    data class ProducersItem(
        @SerializedName("producer_name") val producerName: String? = null,
        @SerializedName("block_signing_key") val blockSigningKey: String? = null
    ) : Parcelable

    @Parcelize
    data class NewProducers(
        @SerializedName("version") val version: Int? = null,
        @SerializedName("producers") val producers: List<ProducersItem?>? = null
    ) : Parcelable

    companion object {
        fun mock() = Block(
            blockNum = 125626920,
            id = "077ce8e3fee2de4d95265f623f91932f921bd8cec3b9f33aba97bd6527e9763e",
            previous = "077ce8e3fee2de4d95265f623f91932f921bd8cec3b9f33aba97bd6527e9763e",
            producer = "eosiomeetone"
        )
    }


}