package com.pinyougou.sellergoods.service.impl;
import java.util.List;

import com.pinyougou.mapper.TbSpecificationOptionMapper;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.pojo.TbSpecificationOptionExample;
import com.pinyougou.specification.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationExample;
import com.pinyougou.pojo.TbSpecificationExample.Criteria;
import com.pinyougou.sellergoods.service.SpecificationService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private TbSpecificationMapper specificationMapper;
	@Autowired
	private TbSpecificationOptionMapper tbSpecificationOptionMapper;
	/**
	 * 查询全部
	 */
	@Override
	public List<TbSpecification> findAll() {
		return specificationMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbSpecification> page=   (Page<TbSpecification>) specificationMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Specification specification) {
		//取出前端传递过来的tbSpecification信息
        TbSpecification tbspecification = specification.getSpecification();
        specificationMapper.insert(tbspecification);

        //取出前端传递过来的tbSpecificationOption信息(集合,需要遍历存储)
        List<TbSpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
        for(TbSpecificationOption option:specificationOptionList){
            option.setSpecId(specification.getSpecification().getId());
            tbSpecificationOptionMapper.insert(option);
        }
    }

	
	/**
	 * 修改
	 */
	@Override
	public void update(Specification specification){
        TbSpecification tbspecification = specification.getSpecification();
        specificationMapper.updateByPrimaryKey(tbspecification);
        //因为不知道前台修改是增加/删除条数还是修改原有内容,所以最好删除原有规格选项,重新全部添加

        TbSpecificationOptionExample example=new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(specification.getSpecification().getId());
        tbSpecificationOptionMapper.deleteByExample(example);
        //重新添加
        List<TbSpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
        for(TbSpecificationOption option:specificationOptionList){
            option.setSpecId(specification.getSpecification().getId());
            tbSpecificationOptionMapper.insert(option);
        }

	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Specification findOne(Long id){
		Specification specification = new Specification();
		specification.setSpecification(specificationMapper.selectByPrimaryKey(id));

		TbSpecificationOptionExample example=new TbSpecificationOptionExample();
		TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(id);

		List<TbSpecificationOption> tbSpecificationOptionList = tbSpecificationOptionMapper.selectByExample(example);
		specification.setSpecificationOptionList(tbSpecificationOptionList);

		return specification;
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			TbSpecificationOptionExample example=new TbSpecificationOptionExample();
			TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
			criteria.andSpecIdEqualTo(id);
			tbSpecificationOptionMapper.deleteByExample(example);

			specificationMapper.deleteByPrimaryKey(id);

		}		
	}
	
	
		@Override
	public PageResult findPage(TbSpecification specification, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbSpecificationExample example=new TbSpecificationExample();
		Criteria criteria = example.createCriteria();
		
		if(specification!=null){			
						if(specification.getSpecName()!=null && specification.getSpecName().length()>0){
				criteria.andSpecNameLike("%"+specification.getSpecName()+"%");
			}
	
		}
		
		Page<TbSpecification> page= (Page<TbSpecification>)specificationMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
