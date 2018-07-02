package com.dps.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class WebController {

    @RequestMapping("/")
    internal fun login(modelAndView: ModelAndView): ModelAndView {
        modelAndView.viewName = "login"
        return modelAndView
    }


    @RequestMapping("home")
    internal fun home(modelAndView11: ModelAndView): ModelAndView {
        modelAndView11.viewName = "home"
        return modelAndView11
    }
}