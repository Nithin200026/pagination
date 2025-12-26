package com.pagination.first.pagination;

import ch.qos.logback.core.util.StringUtil;
import io.micrometer.common.util.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Objects;

public class PageableUtil {

    public static Pageable getPageableObject(GetEmployeePageRequest getEmployeePageRequest,String sortKey)
    {
        int page= Objects.nonNull(getEmployeePageRequest.getPage()) ? getEmployeePageRequest.getPage() : 0 ;
        int size= getEmployeePageRequest.getPageSize();
        String sort= StringUtils.isNotBlank(getEmployeePageRequest.getSort()) ? getEmployeePageRequest.getSort() :"asc";

        return PageRequest.of(page,size, Sort.by(new Sort.Order((Sort.Direction) getSortDirection(sort),sortKey)));
    }

    private static Object getSortDirection(String sort) {
        if(sort.equalsIgnoreCase("asc"))
        {
            return Sort.Direction.ASC;
        }
        else
        {
            return Sort.Direction.DESC;
        }
    }
}
