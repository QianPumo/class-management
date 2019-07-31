package com.myclass.dao;

import com.myclass.entity.ClassInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 班级表(ClassInfo)(ClassInfo)表数据库访问层
 *
 * @author makejava
 * @since 2019-07-29 16:23:08
 */
public interface ClassInfoMapper {

    /**
     * 功能描述:
     * 〈新增班级信息〉
     *
     * @param classInfo
     * @return int
     * @author 蜀山剑仙
     * @date 2019/7/30 上午11:17
     */
    int insertClassInfo(ClassInfo classInfo);

    /**
     * 功能描述:
     * 〈查询ClassInfo数据〉
     *
     * @param orderCol
     * @param orderType
     * @param classInfo
     * @return java.util.List<com.myclass.entity.ClassInfo>
     * @author 蜀山剑仙
     * @date 2019/7/31 上午10:41
     */
    List<ClassInfo> listClassInfo(@Param("classInfo") ClassInfo classInfo, @Param("orderCol") String orderCol, @Param("orderType") String orderType);
}