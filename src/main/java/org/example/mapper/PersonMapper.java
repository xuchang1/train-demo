package org.example.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Person;

import java.util.List;

@Mapper
public interface PersonMapper {
    Person selectById(@Param("id") String id);

    List<Person> selectByPage();
}