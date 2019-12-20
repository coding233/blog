package com.hk.service;

import com.hk.Dao.TypeRepository;
import com.hk.NotFoundException;
import com.hk.pojo.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    private TypeRepository typeRepository;

    @Transactional //添加到事务
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional //添加到事务
    @Override
    public Type getType(Long id) {
        return typeRepository.findOne(id);
    }

    @Transactional //添加到事务
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Transactional //添加到事务
    @Override
    public Type updateType(Long id, Type type) {
        Type t=typeRepository.findOne(id);
        if(t==null){
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);
        return typeRepository.save(t);
    }

    @Transactional //添加到事务
    @Override
    public void deleteType(Long id) {
        typeRepository.delete(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC,"blogs.size");
        Pageable pageable=new PageRequest(0,size,sort);
        return typeRepository.findTop(pageable);
    }
}
