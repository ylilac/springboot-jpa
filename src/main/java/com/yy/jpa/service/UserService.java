package com.yy.jpa.service;

import com.yy.jpa.Repository.UserRepository;
import com.yy.jpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 删除
     *
     * @param id
     */
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    /**
     * 增加
     *
     * @param user
     */
    public void insert(User user) {
        userRepository.save(user);
    }

    /**
     * 更新
     *
     * @param user
     */
    public int update(User user) {
        userRepository.save(user);
        return 1;
    }

    /**
     * 查询单个
     *
     * @param id
     */
    public User selectById(int id) {
        Optional<User> optional = userRepository.findById(id);
        User user = optional.get();
        return user;
    }

    /**
     * 查询全部列表,并做分页
     *  @param pageNum 开始页数
     * @param pageSize 每页显示的数据条数
     */
    public Iterator<User> selectAll(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(Sort.Direction.DESC, "id"));
        Page<User> users = userRepository.findAll(pageable);
        Iterator<User> userIterator =  users.iterator();
        return  userIterator;
    }
}
