package com.lehang.demo.demo01.token;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户Token实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_user_token")
public class AppUserToken {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String token;
}
