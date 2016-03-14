package com.lixuan.rems.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lixuan.rems.dao.AccountDao;
import com.lixuan.rems.dao.impl.BaseDaoImpl;
import com.lixuan.rems.service.BaseService;
import com.lixuan.rems.util.PageBean;
import com.lixuan.rems.util.QueryHelper;

/************************************************************************************
 * @Title        : ServiceSupportImpl.java
  Date:     2016年1月20日 下午7:32:40  
 * @author   CAOPENG  
 * @version  1.0 
 * @since    JDK 1.7  
 * @right    Copyright (c) 2016, lixuan.com All Rights Reserved.   
 * @see   
 ************************************************************************************/
@Transactional
public class BaseSupportImpl<T> extends BaseDaoImpl<T> implements BaseService<T>
{

    @Resource 
    protected AccountDao accountDao;
    
    @Override
    public void save(T entity)
    {
        super.save(entity);
    }

    @Override
    public void delete(Long id) throws Exception
    {
        super.delete(id);
    }

    @Override
    public void update(T entity)
    {
        super.update(entity);
    }

    @Override @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public T getById(Long id)
    {
        return super.getById(id);
    }

    @Override @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<T> getByIds(Long[] ids)
    {
        return super.getByIds(ids);
    }

    @Override @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<T> findAll()
    {
        return super.findAll();
    }

    @Override @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper)
    {
        return super.getPageBean(pageNum, pageSize, queryHelper);
    }
    
    @Override @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<T> getByQueryHelper(QueryHelper queryHelper)
    {
        return super.getByQueryHelper(queryHelper);
    }

    @Override
    public void delete(Long[] ids) throws Exception
    {
        super.delete(ids);
    }

    @Override
    public void saveOrUpdate(T entity) 
    {
        super.saveOrUpdateEntity(entity);
    }
}