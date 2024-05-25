package com.mypet.mungmoong.reserve.service;

import java.util.List;

import com.mypet.mungmoong.reserve.dto.Reserve;

public interface ReserveService {
    public List<Reserve> list() throws Exception;
    public Reserve select(int no) throws Exception;
    public int insert(Reserve reserve) throws Exception;
    public int update(Reserve reserve) throws Exception;
    public int delete(int no) throws Exception; 
}
