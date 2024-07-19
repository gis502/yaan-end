package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.EqList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
@Mapper
public interface EqListMapper extends BaseMapper<EqList> {
    /*
    * 增
    * */
    int addEq(EqList eq);
    /*
     * 删
     * */
    int deleteEq(String eqid);
    /*
     * 改
     * */
    int updataEq(EqList eq);
    /*
     * 查
     * */
    List<EqList> selectAllEq();

    //导入表实用
    @Select("SELECT eqid FROM eqlist WHERE time LIKE CONCAT('%', #{time}, '%') AND position LIKE CONCAT('%', #{position}, '%')")
    String findEarthquakeIdByTimeAndPosition(@Param("time") String time, @Param("position") String position);


}
