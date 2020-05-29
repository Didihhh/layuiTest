package com.aaa.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.biz.MenuBiz;
import com.aaa.dao.MenuMapper;
import com.aaa.entity.Dept;
import com.aaa.entity.LayUiTree;
import com.aaa.entity.Menu;
import com.aaa.util.TreeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class MenuBizImpl implements MenuBiz {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public int deleteByPrimaryKey(Integer menuId) {
        return 0;
    }

    @Override
    public int insert(Menu record) {
        return 0;
    }

    @Override
    public int insertSelective(Menu record) {
        return 0;
    }

    @Override
    public Menu selectByPrimaryKey(Integer menuId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return 0;
    }

    /**
     * 查询所有的菜单，并组装成tree格式的
     * @return
     */
    @Override
    public List<LayUiTree> selectAllMenu() {
        //查询所有的菜单
        List<Menu> menus = menuMapper.selectAllMenu();
        //并组装成tree格式的
        return TreeUtils.getChildPerms(menus, 0);
    }

	@Override
	public PageInfo<Menu> showMenuInfo(Integer page, Integer limit, Integer visible, String menuName) {
		 //开始分页,第一个参数是当前第几页，第二个参数是一页显示多少行
        PageHelper.startPage(page,limit);
        List<Menu> menuInfo = menuMapper.selectMenuInfo(visible,menuName);
        //结束分页,pageInfo封装了分页之后所有数据
        PageInfo<Menu> pageInfo = new PageInfo<Menu>(menuInfo);
        return pageInfo;
	}

	@Override
	public void addMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuMapper.insert(menu);
		
	}

	@Override
	public void deleteMenu(Integer menuID) {
		// TODO Auto-generated method stub
		menuMapper.deleteByPrimaryKey(menuID);
		
	}

	@Override
	public void updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuMapper.updateByPrimaryKey(menu);
	}
}
