package com.wen.service.impl;

import com.wen.dao.UserDao;
import com.wen.dao.impl.UserDaoImpl;
import com.wen.domain.PageBean;
import com.wen.domain.User;
import com.wen.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User Login(User user) {


        User qUser = userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        return qUser;
    }

    @Override
    public PageBean findUserByPage(String currentPage, String rows, Map<String,String[]> parameters) {

        int _currentpage = Integer.valueOf(currentPage);
        int _rows = Integer.valueOf(rows);

        if(_currentpage<=0){
            _currentpage=1;
        }
        //查总数
        int totalcount = userDao.findTotalCount(parameters);
        int pageCount = (int)Math.ceil((double)totalcount / (double)_rows);
        if(_currentpage>=pageCount){
            _currentpage=pageCount;
        }
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setCurrentPage(_currentpage);
        pageBean.setRows(_rows);

        pageBean.setTotalCount(totalcount);


        pageBean.setPageCount(pageCount);
        //算开始索引
        int start = (_currentpage-1)*_rows;
        //查分页数据
        List<User> userByPage = userDao.findUserByPage(start,_rows,parameters);
        pageBean.setList(userByPage);
        return pageBean;
    }

    @Override
    public void delUser(String id) {
        userDao.delUser(id);
    }

    @Override
    public void delUsers(String[] uids) {
        for (int i = 0; i < uids.length; i++) {
            delUser(uids[i]);
        }
    }


}
