package com.bnw.taskcinema.converter;

import com.bnw.taskcinema.dto.common.SystemHeaderDto;
import com.bnw.taskcinema.exception.DevelopException;
import com.bnw.taskcinema.exception.HeaderParseException;
import com.bnw.taskcinema.exception.NotHeadersException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;

import java.lang.reflect.Field;
import java.util.List;

import static com.bnw.taskcinema.utils.DefaultValueConst.*;
import static com.bnw.taskcinema.utils.ExceptionMsgConst.NO_SYSTEM_HEADERS_MSG;
import static com.bnw.taskcinema.utils.ExceptionMsgConst.VALID_ACCESS_DENIED_MSG;
import static com.bnw.taskcinema.utils.ResponseCodeConst.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HeaderToSystemHeaderConverterTest {

    private HeaderToSystemHeaderConverter converter = new HeaderToSystemHeaderConverter();

    @Test
    public void t_converter_01() {
        NotHeadersException exception = assertThrows(NotHeadersException.class, () -> converter.converter(null));
        assertEquals(STRING_DEF_VAL, exception.getId());
        assertEquals(HEADER_NOT_FOUND, exception.getCode());
        assertEquals(NO_SYSTEM_HEADERS_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_02() {
        HttpHeaders headers = new HttpHeaders();

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(STRING_DEF_VAL, exception.getId());
        assertEquals(HEADER_ID_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_03() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, STRING_DEF_VAL);

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(STRING_DEF_VAL, exception.getId());
        assertEquals(HEADER_ID_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_04() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, null);

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(STRING_DEF_VAL, exception.getId());
        assertEquals(HEADER_ID_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_05() {
        String reqId = "123";
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, null);

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_PAGE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_06() {
        String reqId = "123";
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, STRING_DEF_VAL);

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_PAGE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }


    @Test
    public void t_converter_07() {
        String reqId = "123";
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, "aaa");

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_PAGE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_08() {
        String reqId = "123";
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, " 1");

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_PAGE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_09() {
        String reqId = "123";
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, "1 1");

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_PAGE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_10() {
        String reqId = "123";
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, "1.1");

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_PAGE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }


    @Test
    public void t_converter_11() {
        String reqId = "123";
        Integer page = 1;
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, page.toString());
        headers.set(PAGE_SIZE_HEADER, null);

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_PAGE_SIZE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_12() {
        String reqId = "123";
        Integer page = 1;
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, page.toString());
        headers.set(PAGE_SIZE_HEADER, STRING_DEF_VAL);

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_PAGE_SIZE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }


    @Test
    public void t_converter_13() {
        String reqId = "123";
        Integer page = 1;
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, page.toString());
        headers.set(PAGE_SIZE_HEADER, "a");

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_PAGE_SIZE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_14() {
        String reqId = "123";
        Integer page = 1;
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, page.toString());
        headers.set(PAGE_SIZE_HEADER, " 1");

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_PAGE_SIZE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_15() {
        String reqId = "123";
        Integer page = 1;
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, page.toString());
        headers.set(PAGE_SIZE_HEADER, "1 2");

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));
        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_PAGE_SIZE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_16() {
        String reqId = "123";
        Integer page = 1;
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, page.toString());
        headers.set(PAGE_SIZE_HEADER, "1.2");

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));
        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_PAGE_SIZE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }


    @Test
    public void t_converter_1111117() {
        String reqId = "123";
        Integer page = 1;
        Integer pageSize = 1;
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, page.toString());
        headers.set(PAGE_SIZE_HEADER, pageSize.toString());

        SystemHeaderDto hDto = converter.converter(headers);

        assertNotNull(hDto);
        assertEquals(reqId, hDto.getId());
        assertEquals(page, hDto.getPage());
        assertEquals(pageSize, hDto.getPageSize());
        assertNotNull(hDto.getTimestamp());
    }


    @Test
    public void t_converter_17() {
        String reqId = "123";
        Integer page = 1;
        Integer pageSize = 1;
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, page.toString());
        headers.set(PAGE_SIZE_HEADER, pageSize.toString());
        headers.set(REQUEST_DATE_HEADER, null);

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_DATE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());

    }

    @Test
    public void t_converter_18() {
        String reqId = "123";
        Integer page = 1;
        Integer pageSize = 1;
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, page.toString());
        headers.set(PAGE_SIZE_HEADER, pageSize.toString());
        headers.set(REQUEST_DATE_HEADER, STRING_DEF_VAL);

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_DATE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_19() {
        String reqId = "123";
        Integer page = 1;
        Integer pageSize = 1;
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, page.toString());
        headers.set(PAGE_SIZE_HEADER, pageSize.toString());
        headers.set(REQUEST_DATE_HEADER, "a");

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_DATE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_20() {
        String reqId = "123";
        Integer page = 1;
        Integer pageSize = 1;
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, page.toString());
        headers.set(PAGE_SIZE_HEADER, pageSize.toString());
        headers.set(REQUEST_DATE_HEADER, " 1");

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_DATE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_21() {
        String reqId = "123";
        Integer page = 1;
        Integer pageSize = 1;
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, page.toString());
        headers.set(PAGE_SIZE_HEADER, pageSize.toString());
        headers.set(REQUEST_DATE_HEADER, "1 1");

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_DATE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_22() {
        String reqId = "123";
        Integer page = 1;
        Integer pageSize = 1;
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, page.toString());
        headers.set(PAGE_SIZE_HEADER, pageSize.toString());
        headers.set(REQUEST_DATE_HEADER, "1.1");

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_DATE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_23() {
        String reqId = "123123123";
        Long timestamp = System.currentTimeMillis();
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, PAGE_STR);
        headers.set(PAGE_SIZE_HEADER, PAGE_SIZE_STR);
        headers.set(REQUEST_DATE_HEADER, String.valueOf(timestamp));

        SystemHeaderDto hDto = converter.converter(headers);

        assertNotNull(hDto);
        assertEquals(reqId, hDto.getId());
        assertEquals(PAGE, hDto.getPage());
        assertEquals(PAGE_SIZE, hDto.getPageSize());
        assertEquals(timestamp, hDto.getTimestamp());
    }

    @Test
    public void t_converter_24() {
        String reqId = "123123123";
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);

        SystemHeaderDto hDto = converter.converter(headers);

        assertNotNull(hDto);
        assertEquals(reqId, hDto.getId());
        assertEquals(PAGE, hDto.getPage());
        assertEquals(PAGE_SIZE, hDto.getPageSize());
        assertNotNull(hDto.getTimestamp());
    }

    @Test
    public void t_converter_25() {
        String reqId = "123";
        Long timestamp = System.currentTimeMillis();
        Integer page = -1;
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, page.toString());
        headers.set(PAGE_SIZE_HEADER, PAGE_SIZE_STR);
        headers.set(REQUEST_DATE_HEADER, String.valueOf(timestamp));

        SystemHeaderDto hDto = converter.converter(headers);

        assertNotNull(hDto);
        assertEquals(reqId, hDto.getId());
        assertEquals(page, hDto.getPage());
        assertEquals(PAGE_SIZE, hDto.getPageSize());
        assertEquals(timestamp, hDto.getTimestamp());
    }

    @Test
    public void t_converter_26() {
        String reqId = "123";
        Long timestamp = System.currentTimeMillis();
        Integer page = 1;
        Integer pageSize = -1;
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, page.toString());
        headers.set(PAGE_SIZE_HEADER, pageSize.toString());
        headers.set(REQUEST_DATE_HEADER, String.valueOf(timestamp));

        SystemHeaderDto hDto = converter.converter(headers);

        assertNotNull(hDto);
        assertEquals(reqId, hDto.getId());
        assertEquals(page, hDto.getPage());
        assertEquals(pageSize, hDto.getPageSize());
        assertEquals(timestamp, hDto.getTimestamp());
    }

    @Test
    public void t_converter_27() {
        String reqId = "123";
        Long timestamp = -1L;
        Integer page = 1;
        Integer pageSize = 1;

        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, page.toString());
        headers.set(PAGE_SIZE_HEADER, pageSize.toString());
        headers.set(REQUEST_DATE_HEADER, String.valueOf(timestamp));

        SystemHeaderDto hDto = converter.converter(headers);

        assertNotNull(hDto);
        assertEquals(reqId, hDto.getId());
        assertEquals(page, hDto.getPage());
        assertEquals(pageSize, hDto.getPageSize());
        assertEquals(timestamp, hDto.getTimestamp());
    }

    @Test
    public void t_converter_28() {
        String reqId = "123123123";
        Integer page = 1;
        Integer pageSize = 1;
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, page.toString());
        headers.set(PAGE_SIZE_HEADER, pageSize.toString());
        headers.set(REQUEST_DATE_HEADER, null);

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_DATE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_29() {
        String reqId = "123";
        Integer pageSize = 1;
        Long timestamp = -1L;
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, String.valueOf(Long.MAX_VALUE));
        headers.set(PAGE_SIZE_HEADER, pageSize.toString());
        headers.set(REQUEST_DATE_HEADER, String.valueOf(timestamp));

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_PAGE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_30() {
        String reqId = "123";
        Integer page = 1;
        Long timestamp = -1L;
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, page.toString());
        headers.set(PAGE_SIZE_HEADER, String.valueOf(Long.MAX_VALUE));
        headers.set(REQUEST_DATE_HEADER, String.valueOf(timestamp));

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_PAGE_SIZE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }

    @Test
    public void t_converter_31() {
        String reqId = "123";
        Integer page = 1;
        Integer pageSize = 1;
        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, reqId);
        headers.set(PAGE_HEADER, page.toString());
        headers.set(PAGE_SIZE_HEADER, pageSize.toString());
        headers.set(REQUEST_DATE_HEADER, Long.MAX_VALUE + "0");

        HeaderParseException exception = assertThrows(HeaderParseException.class, () -> converter.converter(headers));

        assertEquals(reqId, exception.getId());
        assertEquals(HEADER_DATE_INVALID, exception.getCode());
        assertEquals(VALID_ACCESS_DENIED_MSG, exception.getMessage());
    }


    @Test
    public void t_converter_32() {
        HeaderToSystemHeaderConverter converter = new HeaderToSystemHeaderConverter();
        String header = "Cinema-Error-Test";

        Field privateField = null;
        try {
            privateField = converter.getClass().getDeclaredField("HEADER_NAMES");
            privateField.setAccessible(true); // Make it accessible
            privateField.set(converter, List.of(REQUEST_ID_HEADER, PAGE_HEADER, PAGE_SIZE_HEADER, REQUEST_DATE_HEADER, header));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        HttpHeaders headers = new HttpHeaders();
        headers.set(REQUEST_ID_HEADER, "123123");
        headers.set(header, "3333");

        DevelopException exception = assertThrows(DevelopException.class, () -> converter.converter(headers));

        assertEquals(DevelopException.MSG, exception.getMessage());


    }

}