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

import com.bootdo.system.domain.WebsiteDO;
import com.bootdo.system.service.WebsiteService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-20 15:44:15
 */
 
@Controller
@RequestMapping("/system/website")
public class WebsiteController {
	@Autowired
	private WebsiteService websiteService;
	
	@GetMapping()
	@RequiresPermissions("system:website:website")
	String Website(){
	    return "system/website/website";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:website:website")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WebsiteDO> websiteList = websiteService.list(query);
		int total = websiteService.count(query);
		PageUtils pageUtils = new PageUtils(websiteList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:website:add")
	String add(){
	    return "system/website/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:website:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		WebsiteDO website = websiteService.get(id);
		model.addAttribute("website", website);
	    return "system/website/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:website:add")
	public R save( WebsiteDO website){
		if(websiteService.save(website)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:website:edit")
	public R update( WebsiteDO website){
		websiteService.update(website);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:website:remove")
	public R remove( Integer id){
		if(websiteService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:website:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		websiteService.batchRemove(ids);
		return R.ok();
	}
	
}
