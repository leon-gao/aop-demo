package com.gaolong.working.service.impl;

import com.gaolong.aopdemo.enums.OperationType;
import com.gaolong.working.annotation.WorkInterceptorAnnotation;
import com.gaolong.working.beans.ParisResultBean;
import com.gaolong.working.enums.ParisExceptionEnum;
import com.gaolong.working.repository.ReserveConferenceRepository;
import com.gaolong.working.service.WorkService;
import com.gaolong.working.vo.ReserveConferenceInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    private ReserveConferenceRepository reserveConferenceRespository;

    @Override
    @WorkInterceptorAnnotation(detail = "预定会议室", bussinessType = OperationType.MEETING)
    @Transactional
    public ParisResultBean reserve(ReserveConferenceInfoVO reserveConferenceInfoVO) {

        // 判断系统报错回滚，拦截器是否可正确拦截
        if (reserveConferenceInfoVO.getConferenceId() == 400) {

            System.out.println("Throw Exception");

            int i = 100/0;

//            return ParisResultBean.build(ParisExceptionEnum.RESERVE_RULE_UNEXIXT_ERROR);
        }

        String id = reserveConferenceRespository.insertSelective();

        return ParisResultBean.build(id);
    }

}
