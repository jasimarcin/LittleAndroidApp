package com.marcin.jasi.littleandroidapp.general.domain.mapper


abstract class DataMapper<in From, out To> {

    abstract fun transform(from: From): To

    fun transform(from: List<From>): List<To> {
        val list = ArrayList<To>()

        return from.run {
            mapTo(list) { transform(it) }
        }
    }

}