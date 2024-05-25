package com.mypet.mungmoong.reserve.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypet.mungmoong.reserve.dto.Reserve;
import com.mypet.mungmoong.reserve.mapper.ReserveMapper;

@Service
public class ReserveServiceImple implements ReserveService {
    
    @Autowired
    public ReserveMapper reserveMapper;

    @Override
    public List<Reserve> list() throws Exception {
        List<Reserve> reserveList = reserveMapper.list();
        return reserveList;
    }

    @Override
    public Reserve select(int no) throws Exception {
        Reserve reserve = reserveMapper.select(no);
        return reserve;}

    @Override
    public int insert(Reserve reserve) throws Exception {
        int result = reserveMapper.insert(reserve);
        return result;
}

    @Override
    public int update(Reserve reserve) throws Exception {
        int result = reserveMapper.update(reserve);
        return result;
 }

    @Override
    public int delete(int no) throws Exception {
        int result = reserveMapper.delete(no);
        return result; }

    
}
