package org.hp.springboot.kotlin.seed.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.beetl.sql.core.annotatoin.Table

/**
 * @author hepan
 * @create 2018-05-16 上午6:46
 */
@Table(name = "t_user")
@ApiModel
class User {

    @ApiModelProperty("id")
    var id: Int = 0
    @ApiModelProperty("userName")
    var userName: String? = null
    @ApiModelProperty("password")
    var password: String? = null
}
