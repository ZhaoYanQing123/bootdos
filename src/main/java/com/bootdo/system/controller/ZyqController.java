package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.system.domain.ZyqDO;
import com.bootdo.system.service.ZyqService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-13 15:48:40
 */
 
@Controller
@RequestMapping("/system/zyq")
public class ZyqController {
	@Autowired
	private ZyqService zyqService;
	
	@GetMapping()
	@RequiresPermissions("system:zyq:zyq")
	String Zyq(){
	    return "system/zyq/zyq";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:zyq:zyq")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ZyqDO> zyqList = zyqService.list(query);
		int total = zyqService.count(query);
		PageUtils pageUtils = new PageUtils(zyqList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:zyq:add")
	String add(){
	    return "system/zyq/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:zyq:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ZyqDO zyq = zyqService.get(id);
		model.addAttribute("zyq", zyq);
	    return "system/zyq/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:zyq:add")
	public R save( ZyqDO zyq){
		if(zyqService.save(zyq)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:zyq:edit")
	public R update( ZyqDO zyq){
		zyqService.update(zyq);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:zyq:remove")
	public R remove( Integer id){
		if(zyqService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:zyq:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		zyqService.batchRemove(ids);
		return R.ok();
	}
	
}
