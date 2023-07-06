package com.xiaobai.springbootbeansearcher.vo;

import cn.zhxu.bs.bean.DbField;
import cn.zhxu.bs.bean.SearchBean;
import lombok.Data;

import java.math.BigDecimal;

/**
 * description
 *
 * @author xiaobai 2023/07/06 11:06
 */
@SearchBean(tables = "purchase_order o, shop s, user u",  // 三表关联
        where = "o.shop_id = s.id and o.buyer_id = u.id",  // 关联关系
        autoMapTo = "o"  // 未被 @DbField 注解的字段都映射到 order 表
)
@Data
public class PurchaseOrder {

    private Long id;         // 订单ID   o.id

    private String orderNo;  // 订单号   o.order_no

    private BigDecimal amount;     // 订单金额 o.amount

    private Long shopId;

    private Long buyerId;

    @DbField("s.name")
    private String shop;     // 店铺名   s.name

    @DbField("u.name")
    private String buyer;    // 买家名   u.name

}
