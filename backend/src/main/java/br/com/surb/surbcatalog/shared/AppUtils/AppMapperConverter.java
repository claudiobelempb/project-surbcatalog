package br.com.surb.surbcatalog.shared.AppUtils;

public abstract class AppMapperConverter<E> {
    public abstract Object fromDTO(E entity);
    public abstract E fromEntity(Object dto);
    public abstract Object fromCreateDTO(E entity);
    public abstract E fromCreateEntity(Object dto);
    public abstract Object fromUpdateDTO(E entity);
    public abstract E fromUpdateEntity(Object dto);
}
