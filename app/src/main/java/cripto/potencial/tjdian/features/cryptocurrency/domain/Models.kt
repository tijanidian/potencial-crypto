package cripto.potencial.tjdian.features.cryptocurrency.domain

import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.Description
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.Image
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.Links
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.detailremoteapimodel.MarketData
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.remoteapimodel.CurrentPrice
import cripto.potencial.tjdian.features.cryptocurrency.data.remote.remoteapimodel.MarketCap

data class CoinDetailModel(
    val block_time_in_minutes: Int,
    val categories: List<String>,
    val country_origin: String,
    val description: Description,
    val genesis_date: Any?,
    val hashing_algorithm: String?,
    val id: String,
    val image: Image,
    val last_updated: String,
    val links: Links,
    val market_data: MarketData,
    val name: String,
    val public_interest_score: Double,
    val symbol: String,
)


data class CoinModel(
    val block_time_in_minutes: Long?,
    val id: String,
    val image: ImageModel,
    val last_updated: String,
    val market_data: MarketDataModel,
    val name: String,
    val symbol: String
)

data class ImageModel(
    val large: String,
    val small: String,
    val thumb: String
)

data class MarketDataModel(
    val current_price: CurrentPriceModel?,
    val market_cap: MarketCapModel,
    val total_supply: String?

)

data class CurrentPriceModel(
    val aed: Float,
    val ars: Float,
    val aud: Float,
    val bch: Float,
    val bdt: Float,
    val bhd: Double,
    val bits: Float,
    val bmd: Float,
    val bnb: Double,
    val brl: Float,
    val btc: Double,
    val cad: Float,
    val chf: Float,
    val clp: Float,
    val cny: Float,
    val czk: Float,
    val dkk: Float,
    val dot: Float,
    val eos: Float,
    val eth: Double,
    val eur: Float?,
    val gbp: Float,
    val hkd: Float,
    val huf: Float,
    val idr: Float,
    val ils: Float,
    val inr: Float,
    val jpy: Float,
    val krw: Float,
    val kwd: Float,
    val link: Float,
    val lkr: Float,
    val ltc: Double,
    val mmk: Float,
    val mxn: Float,
    val myr: Float,
    val ngn: Float,
    val nok: Float,
    val nzd: Float,
    val php: Float,
    val pkr: Float,
    val pln: Float,
    val rub: Float,
    val sar: Float,
    val sats: Float,
    val sek: Float,
    val sgd: Float,
    val thb: Float,
    val `try`: Float,
    val twd: Float,
    val uah: Float,
    val usd: Float,
    val vef: Double,
    val vnd: Float,
    val xag: Double,
    val xau: Double,
    val xdr: Float,
    val xlm: Float,
    val xrp: Float,
    val yfi: Double,
    val zar: Any?
)

data class MarketCapModel(
    val aed: Long,
    val ars: Long,
    val aud: Long,
    val bch: Long,
    val bdt: Long,
    val bhd: Long,
    val bits: Long,
    val bmd: Long,
    val bnb: Int,
    val brl: Long,
    val btc: Int,
    val cad: Long,
    val chf: Long,
    val clp: Long,
    val cny: Long,
    val czk: Long,
    val dkk: Long,
    val dot: Long,
    val eos: Long,
    val eth: Int,
    val eur: Long,
    val gbp: Long,
    val hkd: Long,
    val huf: Long,
    val idr: Long,
    val ils: Long,
    val inr: Long,
    val jpy: Long,
    val krw: Long,
    val kwd: Long,
    val link: Long,
    val lkr: Long,
    val ltc: Long,
    val mmk: Long,
    val mxn: Long,
    val myr: Long,
    val ngn: Long,
    val nok: Long,
    val nzd: Long,
    val php: Long,
    val pkr: Long,
    val pln: Long,
    val rub: Long,
    val sar: Long,
    val sats: Long,
    val sek: Long,
    val sgd: Long,
    val thb: Long,
    val `try`: Long,
    val twd: Long,
    val uah: Long,
    val usd: Long,
    val vef: Long,
    val vnd: Long,
    val xag: Long,
    val xau: Int,
    val xdr: Long,
    val xlm: Long,
    val xrp: Long,
    val yfi: Int,
    val zar: Long
)









