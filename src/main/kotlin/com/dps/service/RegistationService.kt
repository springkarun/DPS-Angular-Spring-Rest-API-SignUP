package com.dps.service

import com.dps.model.RegistationModel


interface RegistationService {

      fun findByRollNo(rollNo: String): Any

      fun saveStudent(studentModel: RegistationModel):Any

      fun showAllStudent():Any


}
