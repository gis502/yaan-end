package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysOperLog;
import org.apache.ibatis.annotations.Select;

/**
 * 操作日志 数据层
 *
 * @author ruoyi
 */
public interface SysOperLogMapper
{
    /**
     * 新增操作日志
     *
     * @param operLog 操作日志对象
     */
    public void insertOperlog(SysOperLog operLog);

    /**
     * 查询系统操作日志集合
     *
     * @param operLog 操作日志对象
     * @return 操作日志集合
     */
    public List<SysOperLog> selectOperLogList(SysOperLog operLog);

    /**
     * 批量删除系统操作日志
     *
     * @param operIds 需要删除的操作日志ID
     * @return 结果
     */
    public int deleteOperLogByIds(Long[] operIds);

    /**
     * 查询操作日志详细
     *
     * @param operId 操作ID
     * @return 操作日志对象
     */
    public SysOperLog selectOperLogById(Long operId);

    /**
     * 清空操作日志
     */
    public void cleanOperLog();


    @Select("SELECT " +
            "    sol.*, su.phonenumber " +
            "FROM " +
            "    sys_oper_log sol " +
            "JOIN " +
            "    sys_user su ON sol.oper_name = su.user_name " +
            "WHERE " +
            "    DATE_TRUNC('day', sol.oper_time) = CURRENT_DATE " +
            "AND " +
            "    sol.title LIKE '%导入数据%' " +
            "ORDER BY " +
            "    sol.oper_time DESC")
    List<SysOperLog> getMessageByDay();


    @Select("SELECT " +
            "    sol.*, su.phonenumber " +
            "FROM " +
            "    sys_oper_log sol " +
            "JOIN " +
            "    sys_user su ON sol.oper_name = su.user_name " +
            "WHERE " +
            "    sol.oper_time >= CURRENT_DATE - INTERVAL '7 days' " +
            "AND " +
            "    sol.title LIKE '%导入数据%' " +
            "ORDER BY " +
            "    sol.oper_time DESC")
    List<SysOperLog> getMessageByWeek();

    @Select("SELECT " +
            "    sol.*, su.phonenumber " +
            "FROM " +
            "    sys_oper_log sol " +
            "JOIN " +
            "    sys_user su ON sol.oper_name = su.user_name " +
            "WHERE " +
            "    sol.oper_time >= NOW() - INTERVAL '1 month' " +
            "AND " +
            "    sol.title LIKE '%导入数据%' " +
            "ORDER BY " +
            "    sol.oper_time DESC")
    List<SysOperLog> getMessageByMonth();

    @Select("SELECT " +
            "    sol.*, su.phonenumber " +
            "FROM " +
            "    sys_oper_log sol " +
            "JOIN " +
            "    sys_user su ON sol.oper_name = su.user_name " +
            "WHERE " +
            "    sol.oper_time >= NOW() - INTERVAL '3 months' " +
            "AND " +
            "    sol.title LIKE '%导入数据%' " +
            "ORDER BY " +
            "    sol.oper_time DESC")
    List<SysOperLog> getMessageByThreeMonth();

    @Select("SELECT " +
            "    sol.*, su.phonenumber " +
            "FROM " +
            "    sys_oper_log sol " +
            "JOIN " +
            "    sys_user su ON sol.oper_name = su.user_name " +
            "WHERE " +
            "    sol.oper_time >= NOW() - INTERVAL '1 year' " +
            "AND " +
            "    sol.title LIKE '%导入数据%' " +
            "ORDER BY " +
            "    sol.oper_time DESC")
    List<SysOperLog> getMessageByYear();

}
