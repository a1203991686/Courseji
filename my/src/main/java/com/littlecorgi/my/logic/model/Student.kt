package com.littlecorgi.my.logic.model

/**
 * 学生用户信息 - 数据类
 *
 * @author littlecorgi-twk 2021/06/10
 */
data class Student(
    var id: Long? = null,
    var avatar: String? = null,
    var email: String? = null,
    var name: String? = null,
    var password: String? = null,
    var phone: String? = null,
    var picture: String? = null
)
