package com.clone.inflearn.util.wrapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class PageWrapper<T> {
    public Long totalCount;
    public Integer totalPages;
    public List<T> list;

}
