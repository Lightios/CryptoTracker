package com.plcoding.cryptotracker.crypto.presentation.models

import android.icu.number.NumberFormatter
import android.icu.text.NumberFormat
import androidx.annotation.DrawableRes
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.util.getDrawableIdForCoin
import java.util.Locale

data class CoinUI(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCupUsd: DisplayableNumber,
    val priceUsd: DisplayableNumber,
    val changePercent24Hr: DisplayableNumber,
    @DrawableRes val iconRes: Int,
)


data class DisplayableNumber(
    val value: Double,
    val formatted: String
)


fun Coin.toCoinUi(): CoinUI {
     return CoinUI(
         id = id,
         rank = rank,
         name = name,
         symbol = symbol,
         marketCupUsd = marketCapUsd.toDisplayableNumber(),
         priceUsd = priceUsd.toDisplayableNumber(),
         changePercent24Hr = changePercent24Hr.toDisplayableNumber(),
         iconRes = getDrawableIdForCoin(symbol )
     )
}

fun Double.toDisplayableNumber(): DisplayableNumber {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }

    return DisplayableNumber(this, formatter.format(this))
}