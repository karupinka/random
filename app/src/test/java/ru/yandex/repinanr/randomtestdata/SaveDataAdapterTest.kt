package ru.yandex.repinanr.randomtestdata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import ru.yandex.repinanr.randomtestdata.data.model.common.AddressModel
import ru.yandex.repinanr.randomtestdata.data.model.common.BankModel
import ru.yandex.repinanr.randomtestdata.data.model.common.CreditCardModel
import ru.yandex.repinanr.randomtestdata.data.model.common.UserModel
import ru.yandex.repinanr.randomtestdata.presentation.data.detail.DataAdapter
import ru.yandex.repinanr.randomtestdata.presentation.data.detail.DataItemModel
import ru.yandex.repinanr.randomtestdata.presentation.data.detail.DataListener
import ru.yandex.repinanr.randomtestdata.presentation.data.detail.DataViewHolder
import ru.yandex.repinanr.randomtestdata.presentation.save.common.SaveDataAdapter

@RunWith(RobolectricTestRunner::class)
class SaveDataAdapterTest {
    private lateinit var adapter: SaveDataAdapter

    @Before
    fun setUp() {
        adapter = SaveDataAdapter()
    }

    @Test
    fun itemCount() {
        adapter.submitList(
            listOf(
                getUserModel(),
                getBankModel(),
                getUserModel(),
                getCreditCardModel(),
                getAddressModel()
            )
        )
        assertEquals(adapter.itemCount, 5)
    }

    @Test
    fun itemTypeUser() {
        adapter.submitList(listOf(getUserModel()))
        assertEquals(adapter.getItemViewType(0), 3)
    }

    @Test
    fun itemTypeBank() {
        adapter.submitList(listOf(getBankModel()))
        assertEquals(adapter.getItemViewType(0), 1)
    }

    @Test
    fun itemTypeCreditCard() {
        adapter.submitList(listOf(getCreditCardModel()))
        assertEquals(adapter.getItemViewType(0), 2)
    }

    @Test
    fun itemTypeAddress() {
        adapter.submitList(listOf(getAddressModel()))
        assertEquals(adapter.getItemViewType(0), 0)
    }

    companion object {
        fun getUserModel() = UserModel(
            id = 1L,
            password = "password",
            firstName = "Test",
            lastName = "Testov",
            username = "username",
            email = "email@mail.ru",
            avatar = "https://test.ru",
            gender = "male",
            phoneNumber = "+7 977 777 77 77",
            insuranceNumber = "23456",
            birthDate = "23.12.1976"
        )

        fun getBankModel() = BankModel(
            id = 1L,
            accountNumber = "4179357008",
            iban = "GB43UNLA29371043608077",
            bankName = "THE ROYAL BANK OF SCOTLAND PLC (FORMER RBS NV)",
            routingNumber = "680263762",
            swiftBic = "BOFAGB22SEC"
        )

        fun getCreditCardModel() = CreditCardModel(
            id = 1L,
            number = "1228-1221-1221-1431",
            expiryDate = "2026-12-14",
            type = "mastercard"
        )

        fun getAddressModel() = AddressModel(
            id = 1L,
            city = "Port Margarito",
            streetName = "Markus Route",
            streetAddress = "293 Bergstrom Road",
            secondaryAddress = "Apt. 75",
            buildingNumber = "18789",
            mailBox = "PO Box 4128",
            community = "Autumn Place",
            zipCode = "11417-3129",
            zip = "06729",
            postcode = "6319-8341",
            timeZone = "Europe/Sofia",
            streetSuffix = "Light",
            citySuffix = "fort",
            cityPrefix = "North",
            state = "Washington",
            stateAbbr = "WA",
            country = "Czech Republic",
            countryCode = "ER",
            latitude = -73.43818193805095,
            longitude = 131.19336546266555,
            fullAddress = "Apt. 849 9196 Batz Brooks, Laurihaven, UT 98084"
        )
    }
}