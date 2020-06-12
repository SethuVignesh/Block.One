package com.example.blockone.blocklist.model.pojo

import com.google.gson.annotations.SerializedName

data class EOSHeadBlockResponse(
	@SerializedName("head_block_num")val headBlockNum: Int? = null,
	@SerializedName("fork_db_head_block_num")val forkDbHeadBlockNum: Int? = null,
	@SerializedName("chain_id") val chainId: String? = null,
	@SerializedName("head_block_time") val headBlockTime: String? = null,
	@SerializedName("virtual_block_net_limit") val virtualBlockNetLimit: Int? = null,
	@SerializedName("virtual_block_cpu_limit") val virtualBlockCpuLimit: Int? = null,
	@SerializedName("last_irreversible_block_num") val lastIrreversibleBlockNum: Int? = null,
	@SerializedName("server_version") val serverVersion: String? = null,
	@SerializedName("block_cpu_limit") val blockCpuLimit: Int? = null,
	@SerializedName("head_block_producer") val headBlockProducer: String? = null,
	@SerializedName("fork_db_head_block_id") val forkDbHeadBlockId: String? = null,
	@SerializedName("last_irreversible_block_id") val lastIrreversibleBlockId: String? = null,
	@SerializedName("block_net_limit") val blockNetLimit: Int? = null,
	@SerializedName("head_block_id") val headBlockId: String? = null,
	@SerializedName("server_full_version_string") val serverFullVersionString: String? = null,
	@SerializedName("server_version_string") val serverVersionString: String? = null
)
