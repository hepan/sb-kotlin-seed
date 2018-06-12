package org.hp.springboot.kotlin.seed.core

import org.beetl.sql.core.engine.PageQuery
import org.beetl.sql.core.mapper.BaseMapper
import org.springframework.beans.factory.annotation.Autowired
import java.lang.reflect.ParameterizedType
import java.util.*

abstract class AbstractServiceInterface<T> : ServiceInterface<T> {

    @Autowired
    lateinit var mapper: BaseMapper<T>

    var modelClass: Class<T>

    init {
        var pt = this.javaClass.genericSuperclass as ParameterizedType
        modelClass = pt.actualTypeArguments[0] as Class<T>
    }

    override fun save(model: T) {
        mapper.insert(model)
    }

    override fun save(models: List<T>) {
        mapper.insertBatch(models)
    }

    override fun deleteById(id: Any) {
        mapper.deleteById(id)
    }

    override fun update(model: T) {
        mapper.updateTemplateById(model)
    }

    override fun findById(id: Any): T {

        return mapper.unique(id)
    }

    override fun findByField(fieldName: String, value: Any): T {
        val model = modelClass.newInstance()
        val field = modelClass.getDeclaredField(fieldName)
        field.isAccessible = true
        field.set(model, value)
        return mapper.templateOne(model)
    }

    override fun findAll(): List<T> {

        return mapper.all()
    }

    override fun pageQuery(page: Long, size: Long): PageQuery<T> {
        val pq: PageQuery<T> = PageQuery(page, size)
        val className = modelClass.simpleName
        val sqlId = className.toLowerCase() + ".queryPage" + className
        return mapper.sqlManager.pageQuery(sqlId, modelClass, pq)
    }
}