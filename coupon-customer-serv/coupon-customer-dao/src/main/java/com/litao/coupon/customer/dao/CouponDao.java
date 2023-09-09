package com.litao.coupon.customer.dao;

import com.litao.coupon.customer.dao.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponDao extends JpaRepository<Coupon,Long> {

    long countByUserIdAAndTemplateId(Long userId,Long templateId);
}
