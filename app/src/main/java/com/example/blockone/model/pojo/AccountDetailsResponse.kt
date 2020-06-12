package com.example.blockone.model.pojo

import com.google.gson.annotations.SerializedName

data class AccountDetailsResponse(
	@SerializedName("") val headBlockNum: Int? = null,
	@SerializedName("") val refundRequest: RefundRequest? = null,
	@SerializedName("") val totalResources: TotalResources? = null,
	@SerializedName("") val headBlockTime: String? = null,
	@SerializedName("") val created: String? = null,
	@SerializedName("") val ramQuota: String? = null,
	@SerializedName("") val netLimit: NetLimit? = null,
	@SerializedName("") val coreLiquidBalance: String? = null,
	@SerializedName("") val selfDelegatedBandwidth: SelfDelegatedBandwidth? = null,
	@SerializedName("") val netWeight: String? = null,
	@SerializedName("") val cpuWeight: String? = null,
	@SerializedName("") val privileged: Boolean? = null,
	@SerializedName("") val ramUsage: String? = null,
	@SerializedName("") val permissions: List<PermissionsItem?>? = null,
	@SerializedName("") val accountName: String? = null,
	@SerializedName("") val lastCodeUpdate: String? = null,
	@SerializedName("") val cpuLimit: CpuLimit? = null,
	@SerializedName("") val voterInfo: VoterInfo? = null
){

	data class WaitsItem(
		    @SerializedName("") val waitSec: Int? = null,
		    @SerializedName("") val weight: Int? = null
	)

	data class VoterInfo(
		    @SerializedName("") val owner: String? = null,
		    @SerializedName("") val proxy: String? = null,
		    @SerializedName("") val lastVoteWeight: String? = null,
		    @SerializedName("") val proxiedVoteWeight: String? = null,
		    @SerializedName("") val staked: String? = null,
		    @SerializedName("") val flags1: Int? = null,
		    @SerializedName("") val reserved3: String? = null,
		    @SerializedName("") val reserved2: Int? = null,
		    @SerializedName("") val isProxy: Int? = null,
		    @SerializedName("") val producers: List<String?>? = null
	)

	data class TotalResources(
		    @SerializedName("") val owner: String? = null,
		    @SerializedName("") val ramBytes: String? = null,
		    @SerializedName("") val netWeight: String? = null,
		    @SerializedName("") val cpuWeight: String? = null
	)
	data class SelfDelegatedBandwidth(
		    @SerializedName("") val from: String? = null,
		    @SerializedName("") val to: String? = null,
		    @SerializedName("") val netWeight: String? = null,
		    @SerializedName("") val cpuWeight: String? = null
	)
	data class RequiredAuth(
		    @SerializedName("") val waits: List<WaitsItem?>? = null,
		    @SerializedName("") val keys: List<KeysItem?>? = null,
		    @SerializedName("") val threshold: Int? = null,
		    @SerializedName("") val accounts: List<AccountsItem?>? = null
	)
	data class RefundRequest(
		    @SerializedName("") val owner: String? = null,
		    @SerializedName("") val requestTime: String? = null,
		    @SerializedName("") val cpuAmount: String? = null,
		    @SerializedName("") val netAmount: String? = null
	)
	data class PermissionsItem(
		    @SerializedName("") val parent: String? = null,
		    @SerializedName("") val requiredAuth: RequiredAuth? = null,
		    @SerializedName("") val permName: String? = null
	)
	data class Permission(
		    @SerializedName("") val actor: String? = null,
		    @SerializedName("") val permission: String? = null
	)
	data class NetLimit(
		    @SerializedName("") val max: String? = null,
		    @SerializedName("") val available: String? = null,
		    @SerializedName("") val used: String? = null
	)
	data class KeysItem(
		    @SerializedName("") val weight: Int? = null,
		    @SerializedName("") val key: String? = null
	)
	data class CpuLimit(
		    @SerializedName("") val max: String? = null,
		    @SerializedName("") val available: String? = null,
		    @SerializedName("") val used: String? = null
	)
	data class AccountsItem(
		    @SerializedName("") val weight: Int? = null,
		    @SerializedName("") val permission: Permission? = null
	)
}
