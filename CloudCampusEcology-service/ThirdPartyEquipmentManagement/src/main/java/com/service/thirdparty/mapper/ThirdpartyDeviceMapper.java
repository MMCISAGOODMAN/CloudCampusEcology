package com.service.thirdparty.mapper;

import com.service.thirdparty.model.ThirdpartyDevice;
import com.service.thirdparty.model.ThirdpartyDeviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThirdpartyDeviceMapper {
    long countByExample(ThirdpartyDeviceExample example);

    int deleteByExample(ThirdpartyDeviceExample example);

    int deleteByPrimaryKey(String id);

    int insert(ThirdpartyDevice record);

    int insertSelective(ThirdpartyDevice record);

    List<ThirdpartyDevice> selectByExample(ThirdpartyDeviceExample example);

    ThirdpartyDevice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ThirdpartyDevice record, @Param("example") ThirdpartyDeviceExample example);

    int updateByExample(@Param("record") ThirdpartyDevice record, @Param("example") ThirdpartyDeviceExample example);

    int updateByPrimaryKeySelective(ThirdpartyDevice record);

    int updateByPrimaryKey(ThirdpartyDevice record);
}