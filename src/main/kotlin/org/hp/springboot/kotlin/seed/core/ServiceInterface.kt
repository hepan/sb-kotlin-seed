package org.hp.springboot.kotlin.seed.core

import org.beetl.sql.core.engine.PageQuery
import java.util.*

interface ServiceInterface<T> {
    fun save(model: T)
    fun save(models: List<T>)
    fun deleteById(id: Any)
    fun update(model: T)
    fun findById(id: Any): T
    fun findByField(fieldName: String, value: Any): T
    fun findAll(): List<T>
    fun pageQuery(page: Long, size: Long): PageQuery<T>
}