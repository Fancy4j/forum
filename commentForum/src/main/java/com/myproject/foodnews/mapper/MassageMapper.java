package com.myproject.foodnews.mapper;

import com.myproject.foodnews.bean.Massage;

public interface MassageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Massage record);

    int insertSelective(Massage record);

    Massage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Massage record);

    int updateByPrimaryKeyWithBLOBs(Massage record);

    int updateByPrimaryKey(Massage record);
}