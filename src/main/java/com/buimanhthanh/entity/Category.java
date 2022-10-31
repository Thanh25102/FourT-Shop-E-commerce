package com.buimanhthanh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    @NotNull(message = "{null.err}")
    @Length(max = 50,message = "{access.code.err}")
    private String name;
    @Basic
    @Column(name = "code", nullable = false, length = 50)
    @NotNull(message = "{null.err}")
    @Length(max = 50,message = "{access.code.err}")
    private String code;
    @Basic
    @Column(name = "thumbnail", nullable = true, length = 50)
    @Length(max = 50,message = "{access.code.err}")
    private String thumbnail;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    @Length(max = 255,message = "{access.description.err}")
    private String description;
    @Basic
    @Column(name = "logo", nullable = true, length = 255)
    @Length(max = 255,message = "{access.description.err}")
    private String logo;
    @OneToMany(mappedBy = "categoryByCategoryId")
    private Collection<Product> productsById;
}
