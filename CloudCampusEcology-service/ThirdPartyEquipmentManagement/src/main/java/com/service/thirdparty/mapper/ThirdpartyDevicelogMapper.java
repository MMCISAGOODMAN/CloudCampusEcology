package com.service.thirdparty.mapper;

import com.service.thirdparty.model.ThirdpartyDevicelog;
import com.service.thirdparty.model.ThirdpartyDevicelogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThirdpartyDevicelogMapper {
    long countByExample(ThirdpartyDevicelogExample example);

    int deleteByExample(ThirdpartyDevicelogExample example);

    int deleteByPrimaryKey(String id);

    int insert(ThirdpartyDevicelog record);

    int insertSelective(ThirdpartyDevicelog record);

    List<ThirdpartyDevicelog> selectByExample(ThirdpartyDevicelogExample example);

    ThirdpartyDevicelog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ThirdpartyDevicelog record, @Param("example") ThirdpartyDevicelogExample example);

    int updateByExample(@Param("record") ThirdpartyDevicelog record, @Param("example") ThirdpartyDevicelogExample example);

    int updateByPrimaryKeySelective(ThirdpartyDevicelog record);

    int updateByPrimaryKey(ThirdpartyDevicelog record);
}