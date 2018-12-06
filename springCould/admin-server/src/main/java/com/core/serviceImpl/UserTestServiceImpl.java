package com.core.serviceImpl;

import com.core.entity.UserTest;
import com.core.daoMapper.UserTestMapper;
import com.core.service.IUserTestService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author json
 * @since 2018-10-30
 */
@Service
@Primary
public class UserTestServiceImpl extends ServiceImpl<UserTestMapper, UserTest> implements IUserTestService {
	
}
