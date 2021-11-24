package com.example.apitest.store;

import com.example.apitest.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StoreController {

    @Autowired
    StoreService storeService;

    @PostMapping("/storeSignUpRequest")
    @ResponseBody
    public Message storeRegister(@RequestBody StoreDTO storeDTO){
        storeService.JoinStore(storeDTO);
        Message message=new Message();
        message.setMessage("점주 회원가입 성공");
        return message;
    }

}
