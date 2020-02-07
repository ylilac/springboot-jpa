package com.yy.jpa.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_user")
@ApiModel
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键")
    private int id;

    @Column(name="username")
    @ApiModelProperty(value = "用户名")
    private String userName;

    @Column(name="password")
    @ApiModelProperty(value = "密码")
    private String password;

    @Column(name="birthday")
    @ApiModelProperty(value = "出生年月")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date birthday;

    @Column(name="createtime")
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
