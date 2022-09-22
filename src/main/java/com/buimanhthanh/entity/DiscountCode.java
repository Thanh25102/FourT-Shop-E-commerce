package com.buimanhthanh.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "discount_code", schema = "buimanhthanhecormmercespringmvc", catalog = "")
public class DiscountCode {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "code", nullable = false, length = 50)
    @NotNull(message = "{null.err}")
    @Length(max = 50,message = "{access.code.err}")
    private String code;
    @Basic
    @Column(name = "sale_percent", nullable = false)
    @NotNull(message = "{null.err}")
    private Integer salePercent;
    @Basic
    @Column(name = "sale_money", nullable = false)
    @NotNull(message = "{null.err}")
    private Long saleMoney;
    @Basic
    @Column(name = "start_day", nullable = false)
    @NotNull(message = "{null.err}")
    private Date startDay;
    @Basic
    @Column(name = "end_day", nullable = false)
    @NotNull(message = "{null.err}")
    private Date endDay;
    @Basic
    @Column(name = "max_discount", nullable = false)
    @NotNull(message = "{null.err}")
    private Long maxDiscount;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    @Length(max = 255,message = "{access.description.err}")
    private String description; 
    @OneToMany(mappedBy = "discountCodeByDiscountCodeId")
    private Collection<Order> ordersById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(Integer salePercent) {
        this.salePercent = salePercent;
    }

    public Long getSaleMoney() {
        return saleMoney;
    }

    public void setSaleMoney(Long saleMoney) {
        this.saleMoney = saleMoney;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public Long getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(Long maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiscountCode that = (DiscountCode) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (salePercent != null ? !salePercent.equals(that.salePercent) : that.salePercent != null) return false;
        if (saleMoney != null ? !saleMoney.equals(that.saleMoney) : that.saleMoney != null) return false;
        if (startDay != null ? !startDay.equals(that.startDay) : that.startDay != null) return false;
        if (endDay != null ? !endDay.equals(that.endDay) : that.endDay != null) return false;
        if (maxDiscount != null ? !maxDiscount.equals(that.maxDiscount) : that.maxDiscount != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (salePercent != null ? salePercent.hashCode() : 0);
        result = 31 * result + (saleMoney != null ? saleMoney.hashCode() : 0);
        result = 31 * result + (startDay != null ? startDay.hashCode() : 0);
        result = 31 * result + (endDay != null ? endDay.hashCode() : 0);
        result = 31 * result + (maxDiscount != null ? maxDiscount.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Collection<Order> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<Order> ordersById) {
        this.ordersById = ordersById;
    }
}
