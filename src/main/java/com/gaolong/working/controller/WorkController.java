package com.gaolong.working.controller;

import com.gaolong.working.beans.ParisResultBean;
import com.gaolong.working.service.WorkService;
import com.gaolong.working.vo.ConferenceEmployeeVO;
import com.gaolong.working.vo.ReserveConferenceInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/conference")
public class WorkController {

    @Autowired
    private WorkService workService;

    /**
     * 模拟预定会议室接口
     */
    @RequestMapping(value = "/reserve", method = RequestMethod.POST)
    public ParisResultBean reserve(HttpServletRequest request, HttpSession session) {

//        //获取当前登录人 申请人就是会议的发起人
//        EmployeeInfo info = getEmployeeId(session,request);
//        reserveConferenceInfoVO.setConferenceOriginator(info.getId());
//        reserveConferenceInfoVO.setConferenceOriginatorName(info.getEmployeeName());
//        //会议发起人部门信息
//        DepartmentInfo departmentInfo = departService.getMainDepartmentByUserId(info.getId());
//        if (Objects.isNull(departmentInfo)){
//            return ParisResultBean.build(ParisExceptionEnum.DEFAULT_ERROR,"您没有主部门,请先设置主部门");
//        }
//        reserveConferenceInfoVO.setOriginatorDepartment(departmentInfo.getId());
//        reserveConferenceInfoVO.setOriginatorDepartmentName(departmentInfo.getDepartmentName());
//        reserveConferenceInfoVO= buildVO(reserveConferenceInfoVO);

//        return RpcClientHelper.getClient(ParisSOAService.class).reserve(reserveConferenceInfoVO);

        System.out.println("进入controller...");

        ReserveConferenceInfoVO reserveConferenceInfoVO = new ReserveConferenceInfoVO();
        reserveConferenceInfoVO.setConferenceId(200L);

        List<ConferenceEmployeeVO> list =  new ArrayList<ConferenceEmployeeVO>();

        ConferenceEmployeeVO vo1 = new ConferenceEmployeeVO();
        vo1.setUserId(1);
        vo1.setName("员工一号");
        ConferenceEmployeeVO vo2 = new ConferenceEmployeeVO();
        vo2.setUserId(2);
        vo2.setName("员工二号");
        list.add(vo1);
        list.add(vo2);

        reserveConferenceInfoVO.setConferenceEmployeeVOS(list);

        ParisResultBean parisResultBean = workService.reserve(reserveConferenceInfoVO);

        return parisResultBean;
    }


}
