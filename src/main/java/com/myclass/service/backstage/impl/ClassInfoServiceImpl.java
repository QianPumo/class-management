package com.myclass.service.backstage.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.myclass.dao.backstage.ClassInfoMapper;
import com.myclass.entity.backstage.ClassInfo;
import com.myclass.service.backstage.ClassInfoService;
import com.myclass.tools.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 班级表(ClassInfo)(ClassInfo)表服务实现类
 *
 * @author makejava
 * @since 2019-07-29 16:23:08
 */
@Service("classInfoService")
public class ClassInfoServiceImpl implements ClassInfoService {
    @Resource
    private ClassInfoMapper classInfoMapper;

    /**
     * 功能描述:
     * 〈新增班级信息〉
     *
     * @param classInfo
     * @return boolean
     * @author 蜀山剑仙
     * @date 2019/7/30 上午11:26
     */
    @Override
    public boolean insertClassInfo(ClassInfo classInfo) {
        return classInfoMapper.insertClassInfo(classInfo) > 0;
    }

    /**
     * 功能描述:
     * 〈修改班级信息〉
     *
     * @param classInfo
     * @return boolean
     * @author 蜀山剑仙
     * @date 2019/7/31 下午1:40
     */
    @Override
    public boolean updateClassInfo(ClassInfo classInfo) {
        return classInfoMapper.updateClassInfo(classInfo) > 0;
    }

    /**
     * 功能描述:
     * 〈根据id获取classInfo数据〉
     *
     * @param id
     * @return com.myclass.entity.backstage.ClassInfo
     * @author 蜀山剑仙
     * @date 2019/7/31 下午1:52
     */
    @Override
    public ClassInfo getClassInfo(Integer id) {
        return classInfoMapper.getClassInfo(id);
    }

    /**
     * 功能描述:
     * 〈分页查询班级信息〉
     *
     * @param pageIndex
     * @param pageSize
     * @param orderCol
     * @param orderType
     * @param gradeID
     * @return com.myclass.tools.PageData<com.myclass.entity.backstage.ClassInfo>
     * @author 蜀山剑仙
     * @date 2019/7/31 上午10:38
     */
    @Override
    public PageData<ClassInfo> pageDataClassInfo(ClassInfo classInfo, int pageIndex, int pageSize, String orderCol, String orderType) {
        // 设置分页插件
        Page<ClassInfo> page = PageHelper.startPage(pageIndex, pageSize);
        //开始调用mapper查询
        List<ClassInfo> teacherInfoList = classInfoMapper.listClassInfo(classInfo, orderCol, orderType);
        PageData<ClassInfo> classInfoPageData = new PageData<>();
        //获取查询的总条数
        classInfoPageData.setTotal(page.getTotal());
        //获取当前页数据
        classInfoPageData.setRows(teacherInfoList);
        return classInfoPageData;
    }

    /**
     * 功能描述:
     * 〈根据ClassInfo查询〉
     *
     * @param classInfo
     * @return java.util.List<com.myclass.entity.backstage.ClassInfo>
     * @author 蜀山剑仙
     * @date 2019/7/31 下午4:46
     */
    @Override
    public List<ClassInfo> listClassInfo(ClassInfo classInfo) {
        return classInfoMapper.listClassInfo(classInfo, null, null);
    }
}