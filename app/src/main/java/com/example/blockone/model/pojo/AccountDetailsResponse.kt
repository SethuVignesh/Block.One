package com.example.blockone.model.pojo

import com.google.gson.annotations.SerializedName

public data class AccountDetailsResponse(
	@SerializedName("head_block_num") val headBlockNum: Int? = null,
//	@SerializedName("") val refundRequest: RefundRequest? = null,
	@SerializedName("total_resources") val totalResources: TotalResources? = null,
//	@SerializedName("") val headBlockTime: String? = null,
//	@SerializedName("") val created: String? = null,
//	@SerializedName("") val ramQuota: String? = null,
//	@SerializedName("") val netLimit: NetLimit? = null,
//	@SerializedName("coreLiquidBalance") val coreLiquidBalance: String? = null,
//	@SerializedName("selfDelegatedBandwidth") val selfDelegatedBandwidth: SelfDelegatedBandwidth? = null,
//	@SerializedName("netWeight") val netWeight: String? = null,
//	@SerializedName("cpuWeight") val cpuWeight: String? = null,
//	@SerializedName("privileged") val privileged: Boolean? = null,
//	@SerializedName("ramUsage") val ramUsage: String? = null,
	@SerializedName("permissions") val permissions: List<PermissionsItem?>? = null,
	@SerializedName("account_name") val accountName: String? = null,
	@SerializedName("last_code_update") val lastCodeUpdate: String? = null
//	,
//	@SerializedName("cpuLimit") val cpuLimit: CpuLimit? = null,
//	@SerializedName("voterInfo") val voterInfo: VoterInfo? = null
){

//	data class WaitsItem(
//		    @SerializedName("") val waitSec: Int? = null,
//		    @SerializedName("") val weight: Int? = null
//	)

//	data class VoterInfo(
//		    @SerializedName("") val owner: String? = null,
//		    @SerializedName("") val proxy: String? = null,
//		    @SerializedName("") val lastVoteWeight: String? = null,
//		    @SerializedName("") val proxiedVoteWeight: String? = null,
//		    @SerializedName("") val staked: String? = null,
//		    @SerializedName("") val flags1: Int? = null,
//		    @SerializedName("") val reserved3: String? = null,
//		    @SerializedName("") val reserved2: Int? = null,
//		    @SerializedName("") val isProxy: Int? = null,
//		    @SerializedName("") val producers: List<String?>? = null
//	)

	data class TotalResources(
		    @SerializedName("owner") val owner: String? = null,
		    @SerializedName("ram_bytes") val ramBytes: String? = null,
		    @SerializedName("net_weight") val netWeight: String? = null,
		    @SerializedName("cpu_weight") val cpuWeight: String? = null
	)
//	data class SelfDelegatedBandwidth(
//		    @SerializedName("") val from: String? = null,
//		    @SerializedName("") val to: String? = null,
//		    @SerializedName("") val netWeight: String? = null,
//		    @SerializedName("") val cpuWeight: String? = null
//	)
	public data class RequiredAuth(
//		    @SerializedName("") val waits: List<WaitsItem?>? = null,
		    @SerializedName("keys") val keys: List<KeysItem?>? = null
//			,
//		    @SerializedName("") val threshold: Int? = null,
//		    @SerializedName("") val accounts: List<AccountsItem?>? = null
	)
//	data class RefundRequest(
//		    @SerializedName("") val owner: String? = null,
//		    @SerializedName("") val requestTime: String? = null,
//		    @SerializedName("") val cpuAmount: String? = null,
//		    @SerializedName("") val netAmount: String? = null
//	)
	public data class PermissionsItem(
		    @SerializedName("parent") val parent: String? = null,
		    @SerializedName("required_auth") val requiredAuth: RequiredAuth? = null,
		    @SerializedName("perm_name") val permName: String? = null
	)
//	data class Permission(
//		    @SerializedName("") val actor: String? = null,
//		    @SerializedName("") val permission: String? = null
//	)
//	data class NetLimit(
//		    @SerializedName("") val max: String? = null,
//		    @SerializedName("") val available: String? = null,
//		    @SerializedName("") val used: String? = null
//	)
	public data class KeysItem(
//		    @SerializedName("") val weight: Int? = null,
		    @SerializedName("key") val key: String? = null
	)
//	data class CpuLimit(
//		    @SerializedName("") val max: String? = null,
//		    @SerializedName("") val available: String? = null,
//		    @SerializedName("") val used: String? = null
//	)
//	data class AccountsItem(
//		    @SerializedName("") val weight: Int? = null,
//		    @SerializedName("") val permission: Permission? = null
//	)
}
