/**
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
 */
package com.oracle.bmc.objectstorage.internal.http;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

import com.oracle.bmc.http.internal.*;
import static com.oracle.bmc.util.internal.HttpUtils.*;
import com.oracle.bmc.model.*;
import com.oracle.bmc.objectstorage.model.*;
import com.oracle.bmc.objectstorage.requests.*;
import com.oracle.bmc.objectstorage.responses.*;

import com.google.common.base.Function;
import com.google.common.base.Optional;

import lombok.extern.slf4j.Slf4j;

@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20160918")
@Slf4j
public class ListBucketsConverter {
    private static final ResponseConversionFunctionFactory RESPONSE_CONVERSION_FACTORY =
            new ResponseConversionFunctionFactory();

    public static ListBucketsRequest interceptRequest(ListBucketsRequest request) {

        return request;
    }

    public static Invocation.Builder fromRequest(RestClient client, ListBucketsRequest request) {
        if (request == null) {
            throw new NullPointerException("request instance is required");
        }

        if (request.getNamespaceName() == null) {
            throw new NullPointerException("namespaceName is required");
        }

        if (request.getCompartmentId() == null) {
            throw new NullPointerException("compartmentId is required");
        }

        WebTarget target =
                client.getBaseTarget()
                        .path("/")
                        .path("n")
                        .path(encodePathSegment(request.getNamespaceName()))
                        .path("b");

        target =
                target.queryParam(
                        "compartmentId", attemptEncodeQueryParam(request.getCompartmentId()));

        if (request.getLimit() != null) {
            target = target.queryParam("limit", attemptEncodeQueryParam(request.getLimit()));
        }

        if (request.getPage() != null) {
            target = target.queryParam("page", attemptEncodeQueryParam(request.getPage()));
        }

        Invocation.Builder ib = target.request();

        ib.accept(MediaType.APPLICATION_JSON);

        if (request.getOpcClientRequestId() != null) {
            ib.header("opc-client-request-id", request.getOpcClientRequestId());
        }

        return ib;
    }

    public static Function<Response, ListBucketsResponse> fromResponse() {
        final Function<Response, ListBucketsResponse> transformer =
                new Function<Response, ListBucketsResponse>() {
                    @Override
                    public ListBucketsResponse apply(Response rawResponse) {
                        LOG.trace("Transform function invoked for ListBucketsResponse");
                        Function<Response, WithHeaders<List<BucketSummary>>> responseFn =
                                RESPONSE_CONVERSION_FACTORY.create(
                                        new GenericType<List<BucketSummary>>() {});

                        WithHeaders<List<BucketSummary>> response = responseFn.apply(rawResponse);
                        MultivaluedMap<String, String> headers = response.getHeaders();

                        ListBucketsResponse.Builder builder = ListBucketsResponse.builder();

                        builder.items(response.getItem());

                        Optional<List<String>> opcClientRequestIdHeader =
                                HeaderUtils.get(headers, "opc-client-request-id");
                        if (opcClientRequestIdHeader.isPresent()) {
                            builder.opcClientRequestId(
                                    HeaderUtils.toValue(
                                            "opc-client-request-id",
                                            opcClientRequestIdHeader.get().get(0),
                                            String.class));
                        }

                        Optional<List<String>> opcRequestIdHeader =
                                HeaderUtils.get(headers, "opc-request-id");
                        if (opcRequestIdHeader.isPresent()) {
                            builder.opcRequestId(
                                    HeaderUtils.toValue(
                                            "opc-request-id",
                                            opcRequestIdHeader.get().get(0),
                                            String.class));
                        }

                        Optional<List<String>> opcNextPageHeader =
                                HeaderUtils.get(headers, "opc-next-page");
                        if (opcNextPageHeader.isPresent()) {
                            builder.opcNextPage(
                                    HeaderUtils.toValue(
                                            "opc-next-page",
                                            opcNextPageHeader.get().get(0),
                                            String.class));
                        }

                        ListBucketsResponse responseWrapper = builder.build();

                        return responseWrapper;
                    }
                };
        return transformer;
    }
}
