package daq.manage.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import daq.manage.dao.BaseDao;


public class BaseService<T, PK extends Serializable> implements BaseDao<T, PK>{
	
	@Autowired
	protected BaseDao<T , PK>  baseDao;

	public List<T> queryPageList(Map<String, Object> param) {		
		if(param.get("PAGE_INDEX") == null){
			param.put("PAGE_INDEX", 1);
		}
		param.put("PAGE_START",(Integer.parseInt(param.get("PAGE_INDEX").toString()) - 1) *  Integer.parseInt(param.get("PAGE_LIMIT").toString()));
		return baseDao.queryPageList(param);
	}
	
	public void deleteByPrimaryKey(PK id) {
		baseDao.deleteByPrimaryKey(id);
	}

	public void insert(T record) {
		baseDao.insert(record);
	}

	public void insertSelective(T record) {
		baseDao.insertSelective(record);
	}

	public T selectByPrimaryKey(PK id) {
		return baseDao.selectByPrimaryKey(id);
	}

	public void updateByPrimaryKeySelective(T record) {
		baseDao.updateByPrimaryKeySelective(record);
	}

	public void updateByPrimaryKey(T record) {
		baseDao.updateByPrimaryKey(record);
	}

	public int count() {
		return baseDao.count();
	}
}
