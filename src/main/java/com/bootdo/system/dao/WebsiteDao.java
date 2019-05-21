package com.bootdo.system.dao;

import com.bootdo.system.domain.WebsiteDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-20 15:44:15
 */
@Mapper
public interface WebsiteDao {

	WebsiteDO get(Integer id);
	
	List<WebsiteDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WebsiteDO website);
	
	int update(WebsiteDO website);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
