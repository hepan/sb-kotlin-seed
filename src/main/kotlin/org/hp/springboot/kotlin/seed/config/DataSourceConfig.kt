package org.hp.springboot.kotlin.seed.config

import com.alibaba.druid.pool.DruidDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.env.Environment
import javax.sql.DataSource

/**
 * @author hepan
 * @create 2018-05-15 下午6:19
 */
@Configuration
class DataSourceConfig {

    @Bean("dataSource")     //声明其为Bean实例
    @Primary
    fun datasource(env: Environment): DataSource {
        var ds = DruidDataSource()
        ds.url = env.getProperty("spring.datasource.url")
        ds.username = env.getProperty("spring.datasource.username")
        ds.password=env.getProperty("spring.datasource.password")
        ds.driverClassName=env.getProperty("spring.datasource.driver-class-name")

        return ds
    }
}


