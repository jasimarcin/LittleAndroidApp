package com.marcin.jasi.littleandroidapp.general.domain.mapper


abstract class DataMapper<From, To>{

    abstract fun transform(from: From): To

    fun transform(from: List<From>): List<To> {
        val list = ArrayList<To>()

        for (item in from)
            list.add(transform(item))

        return list
    }

}