package ru.yandex.repinanr.data.remote

import retrofit2.http.GET
import ru.yandex.repinanr.data.model.address.AddressResponse
import ru.yandex.repinanr.data.model.bank.BankResponse
import ru.yandex.repinanr.data.model.card.CreditCardResponse
import ru.yandex.repinanr.data.model.user.ResponseUserModel

interface RandomDataService {

    @GET("users")
    suspend fun getUser(): ResponseUserModel

    @GET("addresses")
    suspend fun getAddresses(): AddressResponse

    @GET("banks")
    suspend fun getBank(): BankResponse

    @GET("credit_cards")
    suspend fun getCreditCard(): CreditCardResponse
}