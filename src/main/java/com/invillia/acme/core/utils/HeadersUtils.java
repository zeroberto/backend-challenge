package com.invillia.acme.core.utils;

import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpHeaders.LOCATION;

/**
 * Class to aid in the manipulation of HTTP headers.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
public class HeadersUtils {

    /**
     * Method to add the Location header.
     *
     * @param httpServletRequest Request.
     * @param id                 New object identifier.
     * @return The header itself.
     */
    public static HttpHeaders getLocationHeader(HttpHeaders httpHeaders, HttpServletRequest httpServletRequest, Long id) {
        httpHeaders.add(LOCATION, httpServletRequest.getRequestURI().replaceFirst("/[\\d]+$", "/" + id));
        return httpHeaders;
    }

}
