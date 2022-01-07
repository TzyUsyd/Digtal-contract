package com.comp5619.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.comp5619.entity.User;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {


}
