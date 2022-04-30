package com.seckill.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    String getName(@Param("id") Long id);

}
