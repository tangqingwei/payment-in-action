package com.qige.transaction.pay.dto;

public class ScoreDTO {

    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;



    /**
     * 用户账号ID
     */
    private Integer userId;

    /**
     * 积分
     */
    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
