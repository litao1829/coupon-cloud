package com.litao.coupon.calculation.template.impl;

import com.litao.coupon.calculation.api.beans.ShoppingCart;
import com.litao.coupon.calculation.template.AbstractRuleTemplate;
import com.litao.coupon.calculation.template.RuleTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DummyTemplate extends AbstractRuleTemplate implements RuleTemplate {

    @Override
    public ShoppingCart calculate(ShoppingCart order) {
        //获取订单总价
        long orderTotalAmount =getTotalPrice(order.getProducts());
        order.setCost(orderTotalAmount);
        return order;
    }

    @Override
    protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota) {
        return orderTotalAmount;
    }
}
