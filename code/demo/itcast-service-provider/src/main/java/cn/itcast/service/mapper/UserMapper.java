package cn.itcast.service.mapper;

import cn.itcast.service.pojo.User;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.spring.annotation.MapperScan;

public interface UserMapper extends Mapper<User> {
}
