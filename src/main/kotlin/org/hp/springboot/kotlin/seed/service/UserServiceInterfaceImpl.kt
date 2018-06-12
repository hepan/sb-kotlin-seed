package org.hp.springboot.kotlin.seed.service

import org.hp.springboot.kotlin.seed.core.AbstractServiceInterface
import org.hp.springboot.kotlin.seed.model.User
import org.springframework.stereotype.Service

/**
 * @author hepan
 * @create 2018-05-16 上午6:24
 */
@Service
class UserServiceInterfaceImpl : AbstractServiceInterface<User>(), UserServiceInterface<User>
