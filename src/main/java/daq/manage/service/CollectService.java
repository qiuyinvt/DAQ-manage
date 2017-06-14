package daq.manage.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import daq.manage.dao.CollectMapper;
import daq.manage.model.Collect;

@Transactional
@Service
public class CollectService extends BaseService<Collect, Long> implements CollectMapper{

}
