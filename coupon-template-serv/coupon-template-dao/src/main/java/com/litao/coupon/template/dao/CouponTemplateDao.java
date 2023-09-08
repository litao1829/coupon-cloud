package com.litao.coupon.template.dao;

import com.litao.coupon.template.dao.entity.CouponTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * CouponTemplateDao
 */

public interface CouponTemplateDao extends JpaRepository<CouponTemplate, Long> {

    /**
     * 根据Shop ID查询出所有券模板
     *
     * @param shopId 店铺id
     * @return {@link List<CouponTemplate>}
     */
    List<CouponTemplate> findAllByShopId(Long shopId);

    /**
     * IN查询 + 分页支持的语法
     *
     * @param id   优惠券id
     * @param page 分页
     * @return {@link Page<CouponTemplate>}
     */
    Page<CouponTemplate> findAllByIdIn(List<Long> id, Pageable page);

    /**
     * 根据shop ID + 可用状态查询店铺有多少券模板
     *
     * @param shopId    店铺id
     * @param available 是否可用
     * @return {@link Integer}
     */
    Integer countByShopIdAndAvailable(Long shopId, Boolean available);

    /**
     * 将优惠券设置为不可用
     *
     * @param id 优惠券id
     * @return {@link Integer}
     */
    @Modifying
    @Query(value = "update coupon_template c set c.available = 0 where c.id = :id",nativeQuery = true)
    int makeCouponUnavailable(@Param("id") Long id);
}
