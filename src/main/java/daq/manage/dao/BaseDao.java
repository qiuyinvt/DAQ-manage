package daq.manage.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T, PK extends Serializable> {
	
	void deleteByPrimaryKey(PK id);

	void insert(T record);

	void insertSelective(T record);

	T selectByPrimaryKey(PK id);

	void updateByPrimaryKeySelective(T record);

	void updateByPrimaryKey(T record);
	
	List<T> queryPageList(Map<String, Object> param);
	
	int count();
}
