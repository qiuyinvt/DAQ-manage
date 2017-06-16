package daq.manage.dao;

import java.util.List;
import java.util.Map;

import daq.manage.model.Collect;

public interface CollectMapper extends BaseDao<Collect, Long>{

	public List<Collect> getALLCollect(Map<String, String> map);

	public Integer getTotal(Map<String, String> map); 
   
}