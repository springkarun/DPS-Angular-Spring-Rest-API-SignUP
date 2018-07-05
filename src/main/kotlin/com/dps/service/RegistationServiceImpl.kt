package com.dps.service

import com.dps.utils.Constant.CONFLICT
import com.dps.utils.Constant.CREATED
import com.dps.utils.Constant.emptyArrays
import com.dps.utils.Constant.regExists
import com.dps.utils.Constant.regOK
import com.dps.model.RegistationModel
import com.dps.model.ResponseModel
import com.dps.repository.RegistationRepository
import com.dps.utils.Constant.OK
import com.dps.utils.Constant.dataEmpty
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service("registationService")
class RegistationServiceImpl : RegistationService {

    @Autowired
    private val regRepo: RegistationRepository? = null


    override fun saveStudent(studentModel: RegistationModel): Any {
        val id = regRepo!!.existsById(studentModel.rollNo!!)
        return if (!id) {
            regRepo.save(studentModel)
            val res=regRepo.findByRollNo(studentModel.rollNo!!)
            ResponseEntity(ResponseModel(true, regOK,res),CREATED )
        } else
            ResponseEntity(ResponseModel(false, regExists,emptyArrays),CONFLICT)
      }

    override fun findByRollNo(rollNo: String):Any {
        val res=regRepo!!.findByRollNo(rollNo)
        if(res.isNotEmpty())
            return  ResponseEntity(ResponseModel(true, "Total Size : ${res.size}",res),OK )
        else  return ResponseEntity(ResponseModel(false, dataEmpty,emptyArrays), OK)
    }


    override fun showAllStudent(): Any {
        val res=regRepo!!.findAll().reversed()
        if(res.isNotEmpty())
        return  ResponseEntity(ResponseModel(true, "Total Size : ${res.size}",res),OK )
        else  return ResponseEntity(ResponseModel(false, dataEmpty,emptyArrays), OK)
    }
}





    /*


     override fun findUserByEmail(email: String): RegistationModel {
         return regRepo!!.findByEmail(email)
     }*/


   /* fun saveUser(user: RegistationModel) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()))
        user.setActive(1)
        val userRole = roleRepository!!.findByRole("ADMIN")
        user.setRoles(HashSet<Role>(Arrays.asList<Any>(userRole)))
        userRepository!!.save(user)
    }*/


