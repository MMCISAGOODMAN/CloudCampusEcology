package com.service.thirdparty.mapper;

import com.service.thirdparty.model.ThirdpartyDeviceChangelog;
import com.service.thirdparty.model.ThirdpartyDeviceChangelogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThirdpartyDeviceChangelogMapper {
    long countByExample(ThirdpartyDeviceChangelogExample example);

    int deleteByExample(ThirdpartyDeviceChangelogExample example);

    int deleteByPrimaryKey(String id);

    int insert(ThirdpartyDeviceChangelog record);

    int insertSelective(ThirdpartyDeviceChangelog record);

    List<ThirdpartyDeviceChangelog> selectByExample(ThirdpartyDeviceChangelogExample example);

    ThirdpartyDeviceChangelog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ThirdpartyDeviceChangelog record, @Param("example") ThirdpartyDeviceChangelogExample example);

    int updateByExample(@Param("record") ThirdpartyDeviceChangelog record, @Param("example") ThirdpartyDeviceChangelogExample example);

    int updateByPrimaryKeySelective(ThirdpartyDeviceChangelog record);

    int updateByPrimaryKey(ThirdpartyDeviceChangelog record);
}