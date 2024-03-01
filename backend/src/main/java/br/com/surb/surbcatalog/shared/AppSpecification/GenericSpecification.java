package br.com.surb.surbcatalog.shared.AppSpecification;

import org.springframework.data.jpa.domain.Specification;

public class GenericSpecification {

    private GenericSpecification(){}

    public static <T>Specification<T> conjunction(){
        return (root, q, cb) -> cb.conjunction();
    }
}
