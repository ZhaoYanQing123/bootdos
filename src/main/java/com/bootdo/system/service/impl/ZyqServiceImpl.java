package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.ZyqDao;
import com.bootdo.system.domain.ZyqDO;
import com.bootdo.system.service.ZyqService;



@Service
public class ZyqServiceImpl implements ZyqService {
	@Autowired
	private ZyqDao zyqDao;
	
	@Override
	public ZyqDO get(Integer id){
		return zyqDao.get(id);
	}
	
	@Override
	public List<ZyqDO> list(Map<String, Object> map){
		return zyqDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return zyqDao.count(map);
	}
	
	@Override
	public int save(ZyqDO zyq){
		return zyqDao.save(zyq);
	}
	
	@Override
	public int update(ZyqDO zyq){
		return zyqDao.update(zyq);
	}
	
	@Override
	public int remove(Integer id){
		return zyqDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return zyqDao.batchRemove(ids);
	}
	
}
