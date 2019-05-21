package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.WebsiteDao;
import com.bootdo.system.domain.WebsiteDO;
import com.bootdo.system.service.WebsiteService;



@Service
public class WebsiteServiceImpl implements WebsiteService {
	@Autowired
	private WebsiteDao websiteDao;
	
	@Override
	public WebsiteDO get(Integer id){
		return websiteDao.get(id);
	}
	
	@Override
	public List<WebsiteDO> list(Map<String, Object> map){
		return websiteDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return websiteDao.count(map);
	}
	
	@Override
	public int save(WebsiteDO website){
		return websiteDao.save(website);
	}
	
	@Override
	public int update(WebsiteDO website){
		return websiteDao.update(website);
	}
	
	@Override
	public int remove(Integer id){
		return websiteDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return websiteDao.batchRemove(ids);
	}
	
}
