package org.example.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Person;

@Mapper
public interface PersonMapper {
    Person selectById(@Param("id") String id);
}