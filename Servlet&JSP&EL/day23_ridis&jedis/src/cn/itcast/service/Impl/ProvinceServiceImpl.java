package cn.itcast.service.Impl;

import cn.itcast.dao.Impl.ProvinceDaoImpl;
import cn.itcast.dao.ProvinceDao;
import cn.itcast.domain.Province;
import cn.itcast.service.ProvinceService;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao dao=new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }
}
