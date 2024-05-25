package com.mypet.mungmoong.reserve.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mypet.mungmoong.reserve.dto.Reserve;

@Mapper
public interface ReserveMapper {
    public List<Reserve> list() throws Exception;
    public Reserve select(int no) throws Exception;
    public int insert(Reserve reserve) throws Exception;
    public int update(Reserve reserve) throws Exception;
    public int delete(int no) throws Exception;    
} 