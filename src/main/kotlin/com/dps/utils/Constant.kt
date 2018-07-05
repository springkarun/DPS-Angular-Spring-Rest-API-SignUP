package com.dps.utils

import org.springframework.http.HttpStatus


object Constant{



   const val regOK="Registation is create successfully."
   const val regExists="Roll No already exists !!."
   const val dataEmpty="Data is Empty."
         val OK= HttpStatus.OK
         val CREATED= HttpStatus.CREATED
         val CONFLICT= HttpStatus.CONFLICT
         val emptyArrays=  arrayOf<String>()


}