package com.example.apitest.signup.user;

import com.example.apitest.Role;
import com.example.apitest.exception.EmptyFieldFoundException;
import com.example.apitest.exception.SameSignUpInfoFoundException;
import com.example.apitest.signup.Message;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserSignUpController {

    @Autowired
    UserSignUpService signUpService;

    @PostMapping("userSignUp")
    @ResponseBody
    public Message register(@RequestBody UserDTO userDTO){
        System.out.println(userDTO.toString());
        signUpService.userRegister(userDTO);
        Message message=new Message();
        message.setMessage("사용자 회원가입 성공");
        return message;
    }

    @ExceptionHandler({EmptyFieldFoundException.class, SameSignUpInfoFoundException.class})
    public void handleSignUpException(Exception e) {
        Message message = new Message();
        message.setMessage(e.getMessage());
    }

}