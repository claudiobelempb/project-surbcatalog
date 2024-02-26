package br.com.surb.surbcatalog.modules.image.resource;

import br.com.surb.surbcatalog.modules.image.entities.Image;
import br.com.surb.surbcatalog.modules.image.service.ImageUploadService;
import br.com.surb.surbcatalog.shared.AppEnums.ImageExtensionType;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/images")
public class ImageUploadResource {

    private final ImageUploadService imageCreateService;
    private final Executor executor;

    public ImageUploadResource(ImageUploadService imageCreateService, Executor executor) {
        this.imageCreateService = imageCreateService;
        this.executor = executor;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<Image>> handle(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("tags") List<String> tags
    ) throws IOException {
        Image image = Image.builder()
                .name(name)
                .tags(String.join(",", tags))
                .size(file.getSize())
                .extension(ImageExtensionType.valueOf(MediaType.valueOf(Objects.requireNonNull(file.getContentType()))))
                .file(file.getBytes())
                .build();
        imageCreateService.execute(image);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{imageId}").buildAndExpand(image.getImageId()).toUri();
        return supplyAsync(() -> image, executor).thenApply((category) -> ResponseEntity.created(uri).body(image));
    }
}
