package com.bnw.taskcinema.converter;

import com.bnw.taskcinema.dto.common.SystemHeaderDto;
import com.bnw.taskcinema.exception.DevelopException;
import com.bnw.taskcinema.exception.HeaderParseException;
import com.bnw.taskcinema.exception.NotHeadersException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

import static com.bnw.taskcinema.utils.DefaultValueConst.*;
import static com.bnw.taskcinema.utils.ExceptionMsgConst.NO_SYSTEM_HEADERS_MSG;
import static com.bnw.taskcinema.utils.ExceptionMsgConst.VALID_ACCESS_DENIED_MSG;
import static com.bnw.taskcinema.utils.ResponseCodeConst.*;

@Component
public class HeaderToSystemHeaderConverter {
    private static final Logger LOG = LoggerFactory.getLogger(HeaderToSystemHeaderConverter.class);

    private final Map<String, String> HEADER_NAME_TO_CODES = Map.of(
            REQUEST_ID_HEADER, HEADER_ID_INVALID,
            PAGE_HEADER, HEADER_PAGE_INVALID,
            PAGE_SIZE_HEADER, HEADER_PAGE_SIZE_INVALID,
            REQUEST_DATE_HEADER, HEADER_DATE_INVALID);

    private final Map<String, Supplier<String>> HEADER_DEFAULT_VALUES = Map.of(
            REQUEST_ID_HEADER, () -> STRING_DEF_VAL,
            PAGE_HEADER, () -> PAGE_STR,
            PAGE_SIZE_HEADER, () -> PAGE_SIZE_STR,
            REQUEST_DATE_HEADER, () -> String.valueOf(System.currentTimeMillis()));

    private final Map<String, BiConsumer<SystemHeaderDto, String>> HEADER_CONSUMERS = Map.of(
            REQUEST_ID_HEADER, SystemHeaderDto::setId,
            PAGE_HEADER, (dto, val) -> dto.setPage(Integer.valueOf(val)),
            PAGE_SIZE_HEADER, (dto, val) -> dto.setPageSize(Integer.valueOf(val)),
            REQUEST_DATE_HEADER, (dto, val) -> dto.setTimestamp(Long.valueOf(val)));

    private final List<String> HEADER_NAMES = List.of(REQUEST_ID_HEADER, PAGE_HEADER, PAGE_SIZE_HEADER, REQUEST_DATE_HEADER);

    private final Map<String, BiConsumer<SystemHeaderDto, List<String>>> HEADER_SUPPLIERS;

    public HeaderToSystemHeaderConverter() {
//        long count = Stream.of(HEADER_NAME_TO_CODES.size(), HEADER_DEFAULT_VALUES.size(), HEADER_CONSUMERS.size(), HEADER_NAMES.size()).distinct().count();
//        if (count > 1) {
//            throw new DevelopException();//Эта ошибка из-за разработки.
//        }

        Map<String, BiConsumer<SystemHeaderDto, List<String>>> tmp = new LinkedHashMap<>();
        for (String headerName : HEADER_NAMES) {
            tmp.put(headerName, (dto, headerValue) -> {
                String valStr = getVal(headerName, headerValue);
                validValue(valStr, dto.getId(), headerName);

                BiConsumer<SystemHeaderDto, String> consumer = HEADER_CONSUMERS.get(headerName);
                if (Objects.nonNull(consumer)) {
                    try {
                        consumer.accept(dto, valStr);
                    } catch (NumberFormatException e) {
                        throw exception(dto.getId(), headerName);
                    } catch (Exception e) {
                        throw new DevelopException();//Эта ошибка из-за разработки.
                    }
                    return;
                }
                throw new DevelopException("");//Эта ошибка из-за разработки.
            });
        }
        HEADER_SUPPLIERS = Collections.unmodifiableMap(tmp);
    }


    public SystemHeaderDto converter(HttpHeaders headers) {
        if (Objects.isNull(headers)) {
            throw new NotHeadersException(STRING_DEF_VAL, HEADER_NOT_FOUND, NO_SYSTEM_HEADERS_MSG);//так некогда не должно быть
        }
        SystemHeaderDto dto = new SystemHeaderDto();
        dto.setId(STRING_DEF_VAL);//пустышка
        for (Map.Entry<String, BiConsumer<SystemHeaderDto, List<String>>> entry : HEADER_SUPPLIERS.entrySet()) {
            entry.getValue().accept(dto, headers.get(entry.getKey()));
        }
        return dto;
    }

    private String getVal(String nameHeader, List<String> vals) {
//        Supplier<String> defSupplier = HEADER_DEFAULT_VALUES.get(nameHeader);
//        if (Objects.isNull(defSupplier)) {
//            throw new DevelopException();//Эта ошибка из-за разработки.
//        }
        return (Objects.isNull(vals) || vals.isEmpty()) ? HEADER_DEFAULT_VALUES.get(nameHeader).get() : vals.getFirst();
    }

    private void validValue(String val, String reqId, String headerName) {
        if (Objects.equals(STRING_DEF_VAL, val) || Objects.isNull(val)) {
            throw exception(reqId, headerName);
        }
    }

    private HeaderParseException exception(String reqId, String headerName) {
//        String  errCode = HEADER_NAME_TO_CODES.get(headerName);
//        if (Objects.isNull(errCode)) {
//            throw new DevelopException();//Эта ошибка из-за разработки.
//        }
        return new HeaderParseException(reqId, HEADER_NAME_TO_CODES.get(headerName), VALID_ACCESS_DENIED_MSG);
    }

}
