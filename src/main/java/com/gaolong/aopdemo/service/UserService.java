package com.gaolong.aopdemo.service;

import com.gaolong.aopdemo.vo.QueryVO;

public interface UserService {

    /**
     * 获取用户信息
     * @return
     * @param tel
     */
    String findUserName(String tel);

    String findUser(QueryVO queryVO);

    String updateUser(QueryVO queryVO);
}
