package com.example.demo.MapperP;



import com.example.demo.pojo.Bill;
import com.example.demo.pojo.student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface map {
    @Select("select count(*) from admin where username= #{username} and password= #{password}")
    int select(@Param("username") String username,@Param("password") String password);
    @Select("select * from student where name=#{name}")
    student selectstudent(@Param("name") String name);
    @Select("select * from bill where name=#{name}")
    List<Bill>selectbill(@Param("name") String name);
    @Delete("delete  from bill where  id=#{id}")
    Boolean delectbill(@Param("id") int id);
}
