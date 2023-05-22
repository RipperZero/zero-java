package com.zero.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Pager<T> {
    /**
     * 分页起始页
     */
    private Integer page;
    /**
     * 每页记录数
     */
    private Integer size;
    /**
     * 总记录条数
     */
    private Integer total;
    /**
     * 返回的记录集合
     */
    private List<T> results;

    private Integer offset;

    public Integer getOffset() {
        return ((this.page == null || this.page < 1 ? 1 : this.page) - 1) * (this.size == null ? 5 : this.size);
    }
}
