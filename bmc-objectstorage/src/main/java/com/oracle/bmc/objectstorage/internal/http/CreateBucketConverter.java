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
public class CreateBucketConverter {
    private static final ResponseConversionFunctionFactory RESPONSE_CONVERSION_FACTORY =
            new ResponseConversionFunctionFactory();

    public static CreateBucketRequest interceptRequest(CreateBucketRequest request) {

        return request;
    }

    public static Invocation.Builder fromRequest(RestClient client, CreateBucketRequest request) {
        if (request == null) {
            throw new NullPointerException("request instance is required");
        }

        if (request.getNamespaceName() == null) {
            throw new NullPointerException("namespaceName is required");
        }

        if (request.getCreateBucketDetails() == null) {
            throw new NullPointerException("createBucketDetails is required");
        }

        WebTarget target =
                client.getBaseTarget()
                        .path("/")
                        .path("n")
                        .path(encodePathSegment(request.getNamespaceName()))
                        .path("b");

        Invocation.Builder ib = target.request();

        ib.accept(MediaType.APPLICATION_JSON);

        if (request.getOpcClientRequestId() != null) {
            ib.header("opc-client-request-id", request.getOpcClientRequestId());
        }

        return ib;
    }

    public static Function<Response, CreateBucketResponse> fromResponse() {
        final Function<Response, CreateBucketResponse> transformer =
                new Function<Response, CreateBucketResponse>() {
                    @Override
                    public CreateBucketResponse apply(Response rawResponse) {
                        LOG.trace("Transform function invoked for CreateBucketResponse");
                        Function<Response, WithHeaders<Bucket>> responseFn =
                                RESPONSE_CONVERSION_FACTORY.create(Bucket.class);

                        WithHeaders<Bucket> response = responseFn.apply(rawResponse);
                        MultivaluedMap<String, String> headers = response.getHeaders();

                        CreateBucketResponse.Builder builder = CreateBucketResponse.builder();

                        builder.bucket(response.getItem());

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

                        Optional<List<String>> eTagHeader = HeaderUtils.get(headers, "eTag");
                        if (eTagHeader.isPresent()) {
                            builder.eTag(
                                    HeaderUtils.toValue(
                                            "eTag", eTagHeader.get().get(0), String.class));
                        }

                        Optional<List<String>> locationHeader =
                                HeaderUtils.get(headers, "location");
                        if (locationHeader.isPresent()) {
                            builder.location(
                                    HeaderUtils.toValue(
                                            "location", locationHeader.get().get(0), String.class));
                        }

                        CreateBucketResponse responseWrapper = builder.build();

                        return responseWrapper;
                    }
                };
        return transformer;
    }
}
