package com.dinghy.dao.hibernate;

import com.dinghy.domain.util.CommonService;
import com.dinghy.domain.util.Pagination;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dinghy on 2017/12/21.
 */
@Transactional
@Service
public class CommonServiceImpl extends Hibernate implements CommonService {
    @Resource
    private SessionFactory sessionFactory;

    @Override
    public Pagination getPagination(String hql, Object[] props, int pageNo, int pageSize) {
        Pagination page = new Pagination();
        if (pageNo < 1)
            pageNo = 1;
        if (pageSize < 1)
            pageSize = 10;
        page.setPageSize(pageSize);
        page.setPageNo(pageNo);
        hql = formatHql(hql);
        Query q = null;
        if (hql.contains("<from>")) {
            q = sessionFactory.getCurrentSession().createQuery(hql.replaceFirst("<from>", "from"));
        } else {
            q = sessionFactory.getCurrentSession().createQuery(hql);
        }

        if (props != null) {
            for (int i = 0; i < props.length; i++) {
                q.setParameter(i, props[i]);
            }
        }
        q.setFirstResult((pageNo - 1) * pageSize);
        q.setMaxResults(pageSize);
//        if (transformer != null) {
//            q.setResultTransformer(transformer);
//        }
        List list = q.list();
        page.setList(list);
        // 若查询语句中包含子查询，则主查询的from使用<from>标示主查询的from，防止from识别，解析错误，例如：
        // select a,(select b from t_b where id=xxx) as b <from> t_a where ...
        // ...
        // 使用hql却总是当做sql来用，没有用到对应的面向对象的思想，悲哀呀。
        if (hql.contains("<from>")) {
            hql = hql.substring(hql.indexOf("<from>"));
        } else {
            hql = hql.substring(hql.indexOf("from"));
        }
        hql = hql.replaceFirst("<from>", "from");
        hql = hql.replaceFirst("(?s)(?i)order\\s+by.*", "");
        hql = hql.replaceFirst("(?s)(?i)group\\s+by.*", "");
        hql = "select count(*) " + hql;
        hql = hql.replaceAll("(?i)\\s+fetch\\s+", " ");
        q = sessionFactory.getCurrentSession().createQuery(hql);
        if (props != null) {
            for (int i = 0; i < props.length; i++) {
                q.setParameter(i, props[i]);
            }
        }
        long totalRecord = ((Number) q.uniqueResult()).longValue();
        int pageCount = (int) ((totalRecord - 1) / pageSize + 1);
        page.setTotalPage(pageCount);
        page.setTotalCount(totalRecord);
        return page;
    }

    private String formatHql(String hql) {
        return (" " + hql).replaceFirst("(?i)\\s+from\\s+", " from ").replaceFirst("(?i)\\s+order\\s+by\\s+", " order by ");
    }
}
