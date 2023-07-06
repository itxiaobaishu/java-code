package com.xiaobai.springbootbeansearcher.controller;

import cn.zhxu.bs.BeanSearcher;
import cn.zhxu.bs.SearchResult;
import com.xiaobai.springbootbeansearcher.vo.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * description
 *
 * @author xiaobai 2023/07/06 11:05
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private BeanSearcher beanSearcher;

    @GetMapping("/list")
    public SearchResult<PurchaseOrder> list(@RequestParam Map<String, Object> params) {
        // search 方法同时会返回满足条件的总条数
        return beanSearcher.search(PurchaseOrder.class, params);
    }


}
