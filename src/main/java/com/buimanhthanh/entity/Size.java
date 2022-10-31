package com.buimanhthanh.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.Length;

import java.util.Collection;

@Entity
@Table(name = "size")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Size {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    @NotNull(message = "{null.err}")
    private String name;
    @Basic
    @Column(name = "code", nullable = false, length = 50)
    @NotNull(message = "{null.err}")
    private String code;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    @Length(max = 255,message = "{access.description.err}")
    private String description;
    @OneToMany(mappedBy = "sizeBySizeId")
    private Collection<ProductDetail> productDetailsById;
}
