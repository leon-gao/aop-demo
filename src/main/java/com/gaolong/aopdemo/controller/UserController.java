package com.gaolong.aopdemo.controller;

import com.gaolong.aopdemo.service.UserService;
import com.gaolong.aopdemo.vo.QueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 访问路径 http://localhost:11000/user/findUserNameByTel?tel=1234567
     * @param tel 手机号
     * @return userName
     */
    @ResponseBody
    @RequestMapping("user/findUserNameByTel")
    public String findUserNameByTel(@RequestParam("tel") String tel){
        return userService.findUserName(tel);
    }

    @RequestMapping("user/findUser")
    public String findUser(@RequestBody QueryVO queryVO){
        return userService.findUser(queryVO);
    }

    @RequestMapping("user/updateUser")
    public String updateUser(@RequestBody QueryVO queryVO){
        return userService.updateUser(queryVO);
    }

}
