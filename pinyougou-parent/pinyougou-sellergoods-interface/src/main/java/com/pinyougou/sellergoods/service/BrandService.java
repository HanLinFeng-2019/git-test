package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

/**
 * 品牌接口
 * @author Administrator
 *
 */
public interface BrandService {

	public List<TbBrand> findAll();

	/**
	 *
	 * @param pageNum 当前页码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);

	/**
	 * 品牌添加
	 * @param tbBrand
	 */
	public void add(TbBrand tbBrand);

	/**
	 * 根据ID查找
	 * @param Id
	 * @return
	 */
	public TbBrand findOne(long Id);

	/**
	 * 修改
	 * @param tbBrand
	 */
	public void update(TbBrand tbBrand);

	/**
	 * 根据id删除
	 * @param ids
	 */
	public void dele(Long[] ids);

	/**
	 * 条件查询
	 * @param Brand 查询条件
	 * @param pageNum	当前页面
	 * @param pageSize	每页记录数
	 * @return
	 */
	public PageResult findPage(TbBrand Brand,int pageNum,int pageSize);

	/**
	 * 查询所有模板关联信息(品牌,规格)
	 * @return
	 */
	public List<Map> selectOptionList();

}
