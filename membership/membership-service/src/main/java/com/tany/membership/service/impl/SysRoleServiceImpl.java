package com.tany.membership.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tany.membership.common.PagedResult;
import com.tany.membership.dao.SysRoleMapper;
import com.tany.membership.entity.SysRole;
import com.tany.membership.service.ISysRoleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tany
 * @since 2021-01-20
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    List<String> staticParams = Arrays.asList("pageIndex", "pageSize", "sortColumn", "sortMethod");

    @Override
    public List<SysRole> getRoleListByUser(long userId) {
        return this.baseMapper.getRoleListByUser(userId);
    }

    @Override
    public PagedResult query(long pageIndex, long pageSize, String sortColumn, String sortMethod, Map<String, Object> search) {
        Page<SysRole> page = new Page<>(pageIndex, pageSize); //查询第一页，查询1条数据


        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();

        //设置查询条件
        for (Map.Entry<String, Object> entry : search.entrySet()) {

            if (staticParams.contains(entry.getKey())) continue;
            wrapper.like(entry.getKey(), entry.getValue());
        }


        wrapper.eq("deleted", 0);

        if ("asc".equalsIgnoreCase(sortMethod)) {
            page.addOrder(OrderItem.asc(sortColumn));
        }
        if ("desc".equalsIgnoreCase(sortMethod)) {
            page.addOrder(OrderItem.desc(sortColumn));
        }


        IPage<SysRole> iPage = this.page(page, wrapper); //userService.page(page, wrapper);
//        System.out.println("数据总条数： " + iPage.getTotal());
//        System.out.println("数据总页数： " + iPage.getPages());
//        System.out.println("当前页数： " + iPage.getCurrent());


//        List<SIMPLE_BUSS_INFO> newList = new ArrayList<>();
//
//        for (BUSS_INFO originObj : iPage.getRecords()) {
//            newList.add(CommonUtils.entityMapping(SIMPLE_BUSS_INFO.class, originObj));
//        }

        PagedResult pagedResult = new PagedResult();
        pagedResult.setTotalPage(iPage.getPages());
        pagedResult.setTotalRecords(iPage.getTotal());
        pagedResult.setCurrentPage(iPage.getCurrent());
        pagedResult.setRows(iPage.getRecords());
        return pagedResult;
    }
}
