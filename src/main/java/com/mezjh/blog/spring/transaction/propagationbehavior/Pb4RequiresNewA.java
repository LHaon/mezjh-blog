package com.mezjh.blog.spring.transaction.propagationbehavior;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZJH
 * @date 2021/7/6 17:54
 */
@Service
public class Pb4RequiresNewA {

    @Resource
    private PbUserMapper pbUserMapper;
    @Resource
    private Pb4RequiresNewB pb4RequiresNewB;

    @Transactional(rollbackFor = Exception.class)
    public void methodA1() {
        List<PbUser> allUser = pbUserMapper.getAllUser();
        allUser.forEach(x -> pbUserMapper.workAdd(x.getId()));
        pb4RequiresNewB.methodB1();
        //        throw new RuntimeException();
    }


    @Service
    public class Pb4RequiresNewB {

        @Resource
        private PbUserMapper pbUserMapper;

        @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
        public void methodB1() {
            List<PbUser> allUser = pbUserMapper.getAllUser();
            allUser.forEach(x -> pbUserMapper.ageAdd(x.getId()));
            //            throw new RuntimeException();
        }
    }
}
