package com.kaka.kakaapibackend.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName rustic_word
 */
@TableName(value ="rustic_word")
@Data
public class RusticWord implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer wid;

    /**
     * 情话内容
     */
    private String context;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}