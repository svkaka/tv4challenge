package com.ovrbach.tv4challenge.data.stubs

import com.ovrbach.tv4challenge.data.ui.CategoryItem
import com.ovrbach.tv4challenge.data.ui.ShowItem

object Stubs {

    val show1 = ShowItem(
        id = 1,
        title = "Efter fem",
        image = "https://img-cdn.b17g.net/25848a9c-1a94-4796-90f2-9c11a0543031/100.jpg",
        description = "Dagsfärskt aktualitetsprogram med Tilde de Paula Eby, Anna Brolin och Axel Pileby i spetsen. Fokus ligger på heta ämnen och intressanta gäster.",
    )

    val show2 = ShowItem(
        id = 2,
        title = "Malou efter tio",
        image = "https://img-cdn.b17g.net/25848a9c-1a94-4796-90f2-9c11a0543031/100.jpg",
        description = "Malou von Sivers bjuder in gäster till långa intervjuer, nyfikna frågor och engagerande diskussioner. Varje dag har ett aktuellt huvudtema och programmen avhandlar allt från forskning av olika slag till relationer och livsöden.",
    )

    val show3 = ShowItem(
        id = 3,
        title = "Bingolotto",
        image = "https://asset-images.b17g.net/api/v2/img/5b6d3c51e4b09101b4674e65-1533885521683-.jpg",
        description = "Inrikesminister Mikael Damberg (S) diskuterar det rådande läget och Markiz Tainton bjuder in till Thanksgiving-middag. Musiksduon Junior Brielle berättar hur det är att jobba ihop och vi får en uppdatering om hur det ser ut på landets sjukhus.",
    )

    val show4 = ShowItem(
        id = 4,
        title = "V75 Direkt",
        image = "https://img-cdn.b17g.net/32587cde-2936-4585-88d1-3761a362fbdb/100.jpg",
        description = "Nyhetssändning från TV4.",
    )

    val show5 = ShowItem(
        id = 5,
        title = "Efter fem",
        image = "https://img-cdn.b17g.net/7bcce57b-6332-4629-9a7f-6741c29e27ce/100.jpg",
        description = "V75 Direkt",
    )

    val show6 = ShowItem(
        id = 5,
        title = "Efter fem",
        image = "https://img-cdn.b17g.net/f0282a1b-6671-4537-be94-940afad37359/100.jpg",
        description = "V75 Direkt",
    )

    val show7 = ShowItem(
        id = 5,
        title = "Some show",
        image = "https://img-cdn.b17g.net/7bcce57b-6332-4629-9a7f-6741c29e27ce/100.jpg",
        description = "V75 Direkt",
    )

    val categoryA = CategoryItem(
        name = "hockeylördag-med-shl",
        shows = listOf(show1, show2, show3, show4, show5, show6, show7)
    )
    val categoryB = CategoryItem(
        name = "tv4-play-3",
        shows = listOf(show5, show4, show3, show2, show1)
    )
    val categories = listOf(categoryA, categoryB)
}