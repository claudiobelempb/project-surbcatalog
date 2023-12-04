package br.com.surb.surbcatalog.shared.AppUtils;

import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppConstants.AppValidatorConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppIllegalArgumentException;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppInvalidRequestException;
import io.micrometer.common.util.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class AppPageUtils {
    private AppPageUtils() {
    }

    public static Pageable appPageable(
            Integer page,
            Integer size,
            int maxSize,
            String orderBy,
            List<String> sortFields
    ) {
        int definedPage = Objects.isNull(page) ? 0 : page;
        int definedSize = Objects.isNull(size) ? maxSize : Math.min(size, maxSize);
        Sort definedSort = parseOrderByFields(orderBy, sortFields);

        return PageRequest.of(definedPage, definedSize, definedSort);
    }

    private static Sort parseOrderByFields(String orderBy, List<String> sortFields) {

        if (Objects.isNull(sortFields) || sortFields.isEmpty()) {
            throw new AppIllegalArgumentException(AppExceptionConstants.VALID_SORT);
        }

        if (StringUtils.isBlank(orderBy)) {
            return Sort.unsorted();
        }

        return Sort.by(
                Stream
                        .of(orderBy.split(","))
                        .map((field) -> {
                                    String fieldName;
                                    Sort.Order order;

                                    if (field.startsWith("-")) {
                                        fieldName = field.substring(1);
                                        order = Sort.Order.desc(fieldName);
                                    } else {
                                        fieldName = field;
                                        order = Sort.Order.asc(fieldName);
                                    }

                                    if (!sortFields.contains(fieldName)) {
                                        throw new AppInvalidRequestException(AppValidatorConstants.ORDER_BY, AppValidatorConstants.ORDER_BY + AppValidatorConstants.INVALID);
                                    }

                                    return order;
                                }
                        ).collect(Collectors.toList()));


    }
}
