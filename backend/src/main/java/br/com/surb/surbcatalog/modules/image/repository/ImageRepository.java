package br.com.surb.surbcatalog.modules.image.repository;

import br.com.surb.surbcatalog.modules.image.entities.Image;
import br.com.surb.surbcatalog.modules.image.specification.ImageSpecification;
import br.com.surb.surbcatalog.shared.AppEnums.ImageExtensionType;
import br.com.surb.surbcatalog.shared.AppSpecification.GenericSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static br.com.surb.surbcatalog.modules.image.specification.ImageSpecification.*;
import static br.com.surb.surbcatalog.shared.AppSpecification.GenericSpecification.*;
import static org.springframework.data.jpa.domain.Specification.*;

@Repository
public interface ImageRepository extends JpaRepository<Image, UUID>, JpaSpecificationExecutor<Image> {
    Optional<Image> findByImageIdAndActive(UUID imageId, Boolean active);

    /*
    *
    * @param extencions
    * @param query
    * @return
    *
    * SELECT * FROM tb_image WHERE 1 = 1 AND extencion = 'PNG' AND (name LIKE 'query' OR tags LIKE 'query')
    */
    default List<Image> findByExtensionAndNameOrTagsLike(ImageExtensionType extension,  String query){
        /*SELECT * FROM tb_image WHERE 1 = 1*/
        Specification<Image> specification = where(conjunction());

        if(!Objects.isNull(extension)){
            /*AND extencion = 'PNG'*/
            specification = specification.and(extencionEqual(extension));
        }

        if(StringUtils.hasText(query)){
            /*AND (name LIKE 'query' OR tags LIKE 'query')*/
            specification = specification.and(nameOrTagsLike(query));
        }
        return findAll(specification);
    }
}
