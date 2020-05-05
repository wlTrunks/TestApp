package com.lingdtkhe.domain.common

/**
 * This mapper needed if you have need map same objects in various places
 * example for Incident report screen and profile screen to map same objects
 */

interface Mapper<T, E> : MapperTo<T, E>, MapperFrom<T, E>

interface MapperTo<T, E> {
    fun mapTo(from: E): T

    fun mapListTo(from: List<E>): List<T> = from.map { mapTo(it) }
}

interface MapperFrom<T, E> {
    fun mapFrom(from: T): E
    fun mapListFrom(from: List<T>): List<E> = from.map { mapFrom(it) }
}

