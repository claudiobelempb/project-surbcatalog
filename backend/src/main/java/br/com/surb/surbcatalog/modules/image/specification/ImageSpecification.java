package br.com.surb.surbcatalog.modules.image.specification;

import br.com.surb.surbcatalog.modules.image.entities.Image;
import br.com.surb.surbcatalog.shared.AppEnums.ImageExtensionType;
import org.springframework.data.jpa.domain.Specification;

public class ImageSpecification {

    private ImageSpecification(){}

    public static Specification<Image> extencionEqual(ImageExtensionType extension){
       return (root, q, cb) -> cb.equal(root.get("extension"), extension);
    }

    public static Specification<Image> nameLike(String query){
        return (root, q, cb) -> cb.like(cb.upper(root.get("name")), "%" + query.toUpperCase() + "%");
    }

    public static Specification<Image> tagsLike(String query){
        return (root, q, cb) -> cb.like(cb.upper(root.get("tags")), "%" + query.toUpperCase() + "%");
    }

    public static Specification<Image> nameOrTagsLike(String query){
        return Specification.anyOf(nameLike(query), tagsLike(query));
    }
}
