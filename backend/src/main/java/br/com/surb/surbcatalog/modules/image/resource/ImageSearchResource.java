package br.com.surb.surbcatalog.modules.image.resource;

import br.com.surb.surbcatalog.modules.image.dto.ImageUploadDTO;
import br.com.surb.surbcatalog.modules.image.entities.Image;
import br.com.surb.surbcatalog.modules.image.mapper.ImageMapper;
import br.com.surb.surbcatalog.modules.image.service.ImageSearchService;
import br.com.surb.surbcatalog.shared.AppEnums.ImageExtensionType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/images")
public class ImageSearchResource {
    private final ImageSearchService imageSearchService;
    private final Executor executor;

    public ImageSearchResource(ImageSearchService imageSearchService, Executor executor) {
        this.imageSearchService = imageSearchService;
        this.executor = executor;
    }
    /*localhost:8080/v1/images?extencion=PNG&query=Nature*/

    @GetMapping
    public CompletableFuture<ResponseEntity<List<ImageUploadDTO>>> handle(
            @RequestParam(value = "extension", required = false, defaultValue = "") String extension,
            @RequestParam(value = "query", required = false) String query){

        List<Image> result = imageSearchService.execute(ImageExtensionType.ofName(extension), query);

        List<ImageUploadDTO> images = result.stream().map(image -> {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/" + image.getImageId()).buildAndExpand(image.getImageId()).toUri();
            return ImageMapper.entityToDTO(image, uri.toString());
        }).collect(Collectors.toList());

        return supplyAsync(() -> images, executor).thenApply((__) -> ResponseEntity.ok(images));
    }
}
