package com.gaolong.aopdemo.service.impl;

import com.gaolong.aopdemo.annotation.OperationLogDetail;
import com.gaolong.aopdemo.enums.OperationType;
import com.gaolong.aopdemo.enums.OperationUnit;
import com.gaolong.aopdemo.service.UserService;
import com.gaolong.aopdemo.vo.QueryVO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @OperationLogDetail(detail = "通过手机号[{{tel}}]获取用户名",level = 3,operationUnit = OperationUnit.USER,operationType = OperationType.SELECT)
    @Override
    public String findUserName(String tel) {
        System.out.println("tel:" + tel);
        return "zhangsan";
    }

    @OperationLogDetail(detail = "updateUser",level = 3,operationUnit = OperationUnit.USER,operationType = OperationType.SELECT)
    @Override
    public String findUser(QueryVO queryVO) {
        System.out.println("-----执行方法findUser------");
        return "zhangsan";
    }

    @OperationLogDetail(detail = "updateUser",level = 3,operationUnit = OperationUnit.USER,operationType = OperationType.UPDATE)
    @Override
    public String updateUser(QueryVO queryVO) {
        System.out.println("-----updateUser------");
        return "zhangsan";
    }

}
