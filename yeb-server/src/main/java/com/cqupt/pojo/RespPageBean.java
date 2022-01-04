package com.cqupt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author jingdong
 * @description: 分页公共返回对象
 * @menu
 * @date 2022/1/2 15:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespPageBean {

    /**
     * 总条数
     */
    private Long total;

    /**
     * 数据List
     */
    private List<?> data;

}
