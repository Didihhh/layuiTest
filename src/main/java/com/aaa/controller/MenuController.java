package com.aaa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aaa.biz.MenuBiz;
import com.aaa.entity.LayUiTable;
import com.aaa.entity.Menu;
import com.aaa.util.ResultEntity;
import com.github.pagehelper.PageInfo;


@RestController
public class MenuController {
    @Autowired
    private MenuBiz menuBiz;
   
//	根据关键字查询数据并且分页显示
	@RequestMapping("/show/menu")
	public LayUiTable showmenuInfo(
			@RequestParam(value="page", defaultValue="1") Integer page,
			@RequestParam(value="limit", defaultValue="5") Integer limit,
			@RequestParam(value="visible", defaultValue="-1") Integer visible,
			@RequestParam(value="menuName", defaultValue="") String menuName
			) {
        //开始查询
        PageInfo<Menu> pageInfo = menuBiz.showMenuInfo(page, limit,visible,menuName);
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        //设置分页之后的返回值
        layUiTable.setCount(pageInfo.getTotal());
        layUiTable.setData(pageInfo.getList());
        return layUiTable;
    }
	@RequestMapping("/add/menu")
	public ResultEntity<Menu> addMenu(Menu menu)
	{
		menuBiz.addMenu(menu);
		return ResultEntity.successWithoutData();
	}
	
	@RequestMapping("/delete/menu")
	public ResultEntity<Menu> deleteMenu(@RequestParam(value="menuId") Integer menuID)
	{
		menuBiz.deleteMenu(menuID);
		return ResultEntity.successWithoutData();
	}
	
	@RequestMapping("/update/menu")
	public ResultEntity<Menu> updateMenu(Menu menu)
	{
		menuBiz.updateMenu(menu);
		return ResultEntity.successWithoutData();
	}
}
