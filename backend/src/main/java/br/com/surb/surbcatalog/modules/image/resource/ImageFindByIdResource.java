package br.com.surb.surbcatalog.modules.image.resource;

import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.image.entities.Image;
import br.com.surb.surbcatalog.modules.image.service.ImageFindByIdService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/images")
public class ImageFindByIdResource {

    private final ImageFindByIdService imageFindByIdService;
    private final Executor executor;

    public ImageFindByIdResource(ImageFindByIdService imageFindByIdService, Executor executor) {
        this.imageFindByIdService = imageFindByIdService;
        this.executor = executor;
    }


    @GetMapping(value = "/{imageId}")
    public CompletableFuture<ResponseEntity<byte[]>> handle(@PathVariable UUID imageId) {
        Objects.isNull(imageId);
        Image image = imageFindByIdService.execute(imageId).orElseThrow();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(image.getExtension().getMediaType());
        headers.setContentLength(image.getSize());
        headers.setContentDispositionFormData("inline; filename=\"" + image.getFileName() + "\"", image.getFileName());

        return supplyAsync(() -> image, executor).thenApply((__) -> new ResponseEntity<>(image.getFile(), headers, HttpStatus.OK));
    }
}
