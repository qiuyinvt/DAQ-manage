package daq.manage.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import daq.manage.dao.CollectMapper;
import daq.manage.model.Collect;

@Transactional
@Service
public class CollectService extends BaseService<Collect, Long> implements CollectMapper{
	@Autowired
	private CollectMapper collectMapper;
	
	public List<Collect> getALLCollect(Map<String, String> map)
	{
		return collectMapper.getALLCollect(map);
	}
	 
	public Integer getTotal(Map<String, String> map)
	{
		return collectMapper.getTotal(map);
	}
}
