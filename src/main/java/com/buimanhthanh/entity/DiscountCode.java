package com.buimanhthanh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Collection;

@Entity
@Table(name="discount_code")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
