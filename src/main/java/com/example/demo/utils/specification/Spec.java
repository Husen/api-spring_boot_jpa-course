package com.example.demo.utils.specification;

import org.springframework.data.jpa.domain.Specification;

public class Spec<T> {
    public Specification<T> findBy(SearchCriteria searchCriteria) {
        switch (searchCriteria.getOperator()) {
            case LIKE:
                return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(searchCriteria.getKey()), "%" + searchCriteria.getValue() + "%"));
            default:
                throw new RuntimeException("Operator not supported");
        }
    }
}
