package com.bootdo.system.dao;

import com.bootdo.system.domain.ZyqDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-13 15:48:40
 */
@Mapper
public interface ZyqDao {

	ZyqDO get(Integer id);
	
	List<ZyqDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ZyqDO zyq);
	
	int update(ZyqDO zyq);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
