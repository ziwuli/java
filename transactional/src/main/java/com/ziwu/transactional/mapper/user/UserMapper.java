package com.ziwu.transactional.mapper.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    @Insert("INSERT INTO LOGIN_INFO VALUES (1,'ziwu')")
    int add(@Param("name") String name);
}
