package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.entity.Person;
import org.example.mapper.PersonMapper;
import org.example.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<Person> queryByPage() {
        PageHelper.startPage(1, 10);
        List<Person> personList = personMapper.selectByPage();
        long total = new PageInfo<>(personList).getTotal();
        return personList;
    }
}
