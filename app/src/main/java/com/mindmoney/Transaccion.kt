package com.mindmoney

data class Transaccion(
    val titulo: String,
    val cantidad: Double,
    val categoria: String,
    val esIngreso: Boolean
)