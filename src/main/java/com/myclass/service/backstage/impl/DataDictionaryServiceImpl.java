package com.myclass.service.backstage.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.myclass.dao.backstage.DataDictionaryMapper;
import com.myclass.entity.backstage.DataDictionary;
import com.myclass.service.backstage.DataDictionaryService;
import com.myclass.tools.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * DataDictionary
 * 数据字典SerivceImpl
 *
 * @author joe
 * @Date 19-7-18
 */
@Service("dataDictionaryService")
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Resource
    private DataDictionaryMapper dataDictionaryMapper;


    /**
     * 功能描述:
     * 〈数据字典分页查询〉
     *
     * @param pageIndex
     * @param pageSize
     * @param orderCol
     * @param orderType
     * @return : com.myclass.tools.PageData<com.myclass.entity.backstage.DataDictionary>
     * @author : 蜀山剑仙
     * @date : 19-7-18 下午3:32
     */
    @Override
    public PageData<DataDictionary> listDataDictionary(int pageIndex, int pageSize, String orderCol, String orderType) {
        // 设置分页插件
        Page<DataDictionary> page = PageHelper.startPage(pageIndex, pageSize);
        // 开始调用mapper查询
        List<DataDictionary> dataDictionaries = dataDictionaryMapper.listDataDictionary(null, orderCol, orderType);
        PageData<DataDictionary> dataDictionaryPageData = new PageData<>();
        dataDictionaryPageData.setTotal(page.getTotal());
        dataDictionaryPageData.setRows(dataDictionaries);
        return dataDictionaryPageData;
    }

    /**
     * 功能描述:
     * 〈新增数据字典数据〉
     *
     * @param dataDictionary
     * @return : boolean
     * @author : 蜀山剑仙
     * @date : 19-7-18 下午3:34
     */
    @Override
    public boolean insertDataDictionary(DataDictionary dataDictionary) {
        return dataDictionaryMapper.insertDataDictionary(dataDictionary) > 0;
    }

    /**
     * 功能描述:
     * 〈修改数据字典启用状态〉
     *
     * @param typeCode
     * @param valueId
     * @param enable
     * @return boolean
     * @author 蜀山剑仙
     * @date 19-7-19 上午10:44
     */
    @Override
    public boolean updateIsEnable(String typeCode,Integer valueId, boolean enable) {
        int oldStatus = (enable) ? 0 : 1;
        int statusValue = (enable) ? 1 : 0;
        return dataDictionaryMapper.updateIsEnable(typeCode, valueId, oldStatus, statusValue) > 0;
    }

    /**
     * 功能描述:
     * 〈根据ID查询数据字典〉
     *
     * @param typeCode
     * @param valueId
     * @return com.myclass.entity.backstage.DataDictionary
     * @author 蜀山剑仙
     * @date 19-7-19 上午11:29
     */
    @Override
    public DataDictionary getDataDictionaryByTypeCodeAndValueId(String typeCode, Integer valueId) {
        return dataDictionaryMapper.getDataDictionaryById(typeCode, valueId);
    }

    /**
     * 功能描述:
     * 〈修改数据字典数据〉
     *
     * @param dataDictionary
     * @return boolean
     * @author 蜀山剑仙
     * @date 19-7-19 上午11:30
     */
    @Override
    public boolean updateDataDictionary(DataDictionary dataDictionary) {
        return dataDictionaryMapper.updateDataDictionary(dataDictionary) > 0;
    }

    /**
     * 功能描述:
     * 〈根据dataDictionary查询此类型数据字典数据〉
     *
     * @param dataDictionary
     * @return java.util.List<com.myclass.entity.backstage.DataDictionary>
     * @author 蜀山剑仙
     * @date 2019/7/31 上午9:51
     */
    @Override
    public List<DataDictionary> listDataDictionaryByTypeCode(DataDictionary dataDictionary) {
        return dataDictionaryMapper.listDataDictionary(dataDictionary, "typeCode", "asc");
    }

}
