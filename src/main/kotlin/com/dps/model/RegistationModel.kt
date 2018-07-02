package com.dps.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.io.Serializable


@Document(collection="student_registation")
data class RegistationModel(
        @Id
        @Field("rollNo")
        var rollNo:String? = null,
        @Field("passwords")
        var passwords:String? = null,
        @Field("full_name")
        var name:String? = null,
        var email:String? = null,
        var mobile:String? = null,
        var course:String? = null,
        var age:String? = null,
        var gender:String? = null,
        var addess:String? = null
):Serializable


