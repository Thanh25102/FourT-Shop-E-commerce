package com.buimanhthanh.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Discount {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    @NotNull(message = "{null.err}")
    private Integer id;
    @Basic
    @Column(name = "sale_percent", nullable = false)
    @NotNull(message = "{null.err}")
    private Integer salePercent;
    @Basic
    @Column(name = "start_day", nullable = false)

    private Date startDay;
    @Basic
    @Column(name = "end_day", nullable = false)
    @NotNull(message = "{null.err}")
    private Date endDay;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    @Length(max = 255,message = "{access.description.err}")
    private String description;
    @OneToMany(mappedBy = "discountByDiscountId")
    private Collection<Product> productsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(Integer salePercent) {
        this.salePercent = salePercent;
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

        Discount discount = (Discount) o;

        if (id != null ? !id.equals(discount.id) : discount.id != null) return false;
        if (salePercent != null ? !salePercent.equals(discount.salePercent) : discount.salePercent != null)
            return false;
        if (startDay != null ? !startDay.equals(discount.startDay) : discount.startDay != null) return false;
        if (endDay != null ? !endDay.equals(discount.endDay) : discount.endDay != null) return false;
        if (description != null ? !description.equals(discount.description) : discount.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (salePercent != null ? salePercent.hashCode() : 0);
        result = 31 * result + (startDay != null ? startDay.hashCode() : 0);
        result = 31 * result + (endDay != null ? endDay.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Collection<Product> getProductsById() {
        return productsById;
    }

    public void setProductsById(Collection<Product> productsById) {
        this.productsById = productsById;
    }
}
