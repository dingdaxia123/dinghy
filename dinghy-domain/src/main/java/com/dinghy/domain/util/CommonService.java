package com.dinghy.domain.util;

/**
 * Created by dinghy on 2017/12/21.
 */
public interface CommonService {
    Pagination getPagination(String hql, Object[] props, int pageNo, int pageSize);
}
