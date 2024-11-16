package com.plcoding.cryptotracker.crypto.presentation.models.coin_list

import com.plcoding.cryptotracker.crypto.presentation.models.CoinUI

sealed interface CoinListAction {
    data class OnCoinClick(val coinUi: CoinUI): CoinListAction
}