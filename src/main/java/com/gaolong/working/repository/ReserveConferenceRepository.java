package com.gaolong.working.repository;

import org.springframework.stereotype.Repository;

import java.util.UUID;


/**
 * @author: zl
 * @date: 2019-02-28T19:11:04.492
 * @since: 1.0-SNAPSHOT
 */
@Repository
public class ReserveConferenceRepository  {

//	@Autowired
//	private ReserveConferenceMapper reserveConferenceMapper;

	public String insertSelective() {

		// 向t_hello_reserve_conference表中插入预定信息
		// 向t_hello_approval_record表中查询审批信息
		// 遍历 conferenceEmployeeVOS 向t_hello_conference_sign表中插入数据，通知参会人

		// 1：返回insert的ID，根据ID查询数据库表，返回relatedId
		// 2：不保存返回relatedId，直接根据参数保存到任务表中

		return UUID.randomUUID().toString();
	}


}

