package com.example.blockone.blocklist.model.pojo

import com.google.gson.annotations.SerializedName

data class Block(
    @SerializedName("header_extensions") val headerExtensions: List<Int?>? = null,
    @SerializedName("ref_block_prefix") val refBlockPrefix: Int? = null,
    @SerializedName("new_producers") val newProducers: NewProducers? = null,
    @SerializedName("previous") val previous: String? = null,
    @SerializedName("block_extensions") val blockExtensions: List<Int?>? = null,
    @SerializedName("schedule_version") val scheduleVersion: Int? = null,
    @SerializedName("producer_signature") val producerSignature: String? = null,
    @SerializedName("transactions") val transactions: List<TransactionsItem?>? = null,
    @SerializedName("confirmed") val confirmed: Int? = null,
    @SerializedName("new_protocol_features") val newProtocolFeatures: List<NewProtocolFeaturesItem?>? = null,
    @SerializedName("block_num") val blockNum: Int? = null,
    @SerializedName("producer") val producer: String? = null,
    @SerializedName("transaction_mroot") val transactionMroot: String? = null,
    @SerializedName("id") val id: String? = null,
    @SerializedName("action_mroot") val actionMroot: String? = null,
    @SerializedName("timestamp") val timestamp: String? = null
) {
    data class TransactionsItem(
        @SerializedName("net_usage_words") val netUsageWords: Int? = null,
        @SerializedName("trx") val trx: String? = null,
        @SerializedName("cpu_usage_us") val cpuUsageUs: Int? = null,
        @SerializedName("status") val status: String? = null
    )

    data class ProducersItem(
        @SerializedName("producer_name") val producerName: String? = null,
        @SerializedName("block_signing_key") val blockSigningKey: String? = null
    )

    data class NewProtocolFeaturesItem(
        @SerializedName("") val any: Any? = null
    )

    data class NewProducers(
        @SerializedName("version") val version: Int? = null,
        @SerializedName("producers") val producers: List<ProducersItem?>? = null
    )

    companion object {
        fun mock() = Block(blockNum = 123456, previous = "xxxxxxxxx", producer = "sethu")
    }


}