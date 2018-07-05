package com.dps.controller

import com.dps.model.RegistationModel
import com.dps.service.RegistationService
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = ["/api"])
class RestAPIController {


    @Autowired
    private var registationService: RegistationService? = null


    @PostMapping("/student_registation")
    private fun studentRegistation(@RequestBody studentModel: RegistationModel): Any {
       return registationService!!.saveStudent(studentModel)
    }


    @GetMapping("/showAllStudent" )
    fun showAllStudent():Any=registationService!!.showAllStudent()


    @GetMapping("/findByRollNo/{rollNo}" )
    fun findByRollNo(@PathVariable("rollNo") rollNo:String):Any=registationService!!.findByRollNo(rollNo)


}

/*


    @Autowired
    internal var customerRepository: RegistationRepository? = null


    //Create RegistationModel for student
    @PostMapping("/student_registation")
    private fun studentRegistation(@RequestBody studentModel: RegistationModel): Any {
        val id = customerRepository!!.existsById(studentModel.rollNo!!)
        if (!id) {
            customerRepository!!.save(studentModel)

            return ResponseEntity(ResponseModel(true, "Registation is create successfully.", customerRepository!!.findByRollNo(studentModel.rollNo!!)), HttpStatus.CREATED)
        } else
            return ResponseEntity(ResponseModel(false, "Roll No already exists !!.", arrayOf<String>()), HttpStatus.CONFLICT)
    }


    //Login for student
    @PostMapping("/student_login")
    private fun studentLogin(@RequestBody studentModel: HashMap<String, String>): Any {
        val roll_no = studentModel["rollNo"]
        val pass = studentModel["passwords"]

        val s=RegistationModel()

        s.rollNo = roll_no!!
        s.passwords = pass!!


        var isCheck:Boolean?=false

        val id = customerRepository!!.existsById(s.rollNo!!)
        val p = customerRepository!!.findByPassword(s.passwords!!)
        for(a in p) {
              if(pass==a.passwords ){
                  isCheck=true
              }
        }
        if (id && isCheck!!) {
            return ResponseEntity(ResponseModel(true, "login successfully.", customerRepository!!.findByRollNo(roll_no)), HttpStatus.OK)

        } else
            return ResponseEntity(ResponseModel(false, "Invalid roll no or password.", arrayOf<String>()), HttpStatus.UNAUTHORIZED)
    }




    @GetMapping("/all_student")
     fun getAll():Any{
        return ResponseEntity(ResponseModel(true, "Registation is create successfully.", customerRepository!!.findAll()), HttpStatus.CREATED)
    }

*/





/* @GetMapping(value = ["/customer"])
 fun getData(): MutableList<RegistationModel>{

   val s= customerRepository!!.findAll()

     val li=ArrayList<RegistationModel>()
     for(d in s){
        val ss=  "http://localhost:8080/api/images/"+d.avatar
         li.add(RegistationModel(d.id,d.name,d.location,ss))
     }
     return li
 }*/


/*

    //Create RegistationModel
    @PostMapping("/studentModel")
    private fun createCustomer(@RequestBody studentModel: RegistationModel): Any {

        val id=customerRepository!!.existsById(studentModel.id)
        if(!id) { customerRepository!!.save(studentModel)
            return ResponseEntity(responseMessage(true,"RegistationModel is  create successfully."),HttpStatus.CREATED)
        }else
        return ResponseEntity(responseMessage(false,"This studentModel already exist !!."),HttpStatus.CONFLICT)
    }

*/


/*


    @GetMapping("/customer/{location}")
      fun findByLocation(@PathVariable("location") location:String):RegistationModel{
        return customerRepository!!.findByLocation(location)
    }


    @DeleteMapping("/customer")
       fun deleteCustomer():Any{
        customerRepository!!.deleteAll()
        return responseMessage(true,"RegistationModel are deleted successfully.")
    }




    //create profile
    private val UPLOADED_FOLDER = "E:\\Spring\\api\\mongodb\\imagesUpload\\"
    @PostMapping("/upload",consumes = arrayOf("multipart/form-data"))
    fun singleFileUpload(@RequestParam("file") file: MultipartFile,
                         @RequestParam("id") id :String,
                         @RequestParam("name") name :String,
                         @RequestParam("location") location :String): Any {
        if (file.isEmpty) {
            return ResponseEntity(responseMessage(false,"Please select a file to upload."),HttpStatus.NOT_FOUND)
        }

        val avatarPath=file.originalFilename
        try {
            val bytes = file.bytes
            val path = Paths.get(UPLOADED_FOLDER + avatarPath)
            Files.write(path, bytes)
           // customerRepository!!.save(RegistationModel(id,name,location,"http://localhost:8080/api/images/"+avatarPath!!))
            customerRepository!!.save(RegistationModel(id,name,location,avatarPath!!))
            return responseMessage(true,"RegistationModel is uploaded successfully. ${path.toAbsolutePath()}")
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return ""
    }





    // uploadMultiple File
    @PostMapping("/uploadMulti")
    fun multiFileUpload(@RequestParam("files") files: Array<MultipartFile>, redirectAttributes: RedirectAttributes): String {

        val sj = StringJoiner(" , ")

        for (file in files) {

            if (file.isEmpty) {
                continue //next pls
            }

            try {

                val bytes = file.bytes
                val path = Paths.get(UPLOADED_FOLDER + file.originalFilename)
                Files.write(path, bytes)

                sj.add(file.originalFilename)

            } catch (e: IOException) {
                e.printStackTrace()
            }

        }

        val uploadedFileName = sj.toString()
        if (StringUtils.isEmpty(uploadedFileName)) {
            redirectAttributes.addFlashAttribute("message",
                    "Please select a file to upload")
        } else {
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '$uploadedFileName'")
        }

        return "redirect:/uploadStatus"

    }

    @GetMapping("/images/{path}")
    @ResponseBody
    @Throws(IOException::class)
    fun getPhoto(@PathVariable ("path") path:String): ResponseEntity<ByteArray> {
        val imgPath = File("E:\\\\temp\\\\$path")

        val image = Files.readAllBytes(imgPath.toPath())
        val headers = HttpHeaders()
        headers.contentType = MediaType.IMAGE_JPEG
        headers.contentLength = image.size.toLong()
        return ResponseEntity(image, headers, HttpStatus.OK)
    }





}
*/
