/**
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
 */
package com.oracle.bmc.identity.internal.http;

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
import com.oracle.bmc.identity.model.*;
import com.oracle.bmc.identity.requests.*;
import com.oracle.bmc.identity.responses.*;

import com.google.common.base.Function;
import com.google.common.base.Optional;

import lombok.extern.slf4j.Slf4j;

@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20160918")
@Slf4j
public class GetUserGroupMembershipConverter {
    private static final ResponseConversionFunctionFactory RESPONSE_CONVERSION_FACTORY =
            new ResponseConversionFunctionFactory();

    public static GetUserGroupMembershipRequest interceptRequest(
            GetUserGroupMembershipRequest request) {

        return request;
    }

    public static Invocation.Builder fromRequest(
            RestClient client, GetUserGroupMembershipRequest request) {
        if (request == null) {
            throw new NullPointerException("request instance is required");
        }

        if (request.getUserGroupMembershipId() == null) {
            throw new NullPointerException("userGroupMembershipId is required");
        }

        WebTarget target =
                client.getBaseTarget()
                        .path("/20160918")
                        .path("userGroupMemberships")
                        .path(encodePathSegment(request.getUserGroupMembershipId()));

        Invocation.Builder ib = target.request();

        ib.accept(MediaType.APPLICATION_JSON);

        return ib;
    }

    public static Function<Response, GetUserGroupMembershipResponse> fromResponse() {
        final Function<Response, GetUserGroupMembershipResponse> transformer =
                new Function<Response, GetUserGroupMembershipResponse>() {
                    @Override
                    public GetUserGroupMembershipResponse apply(Response rawResponse) {
                        LOG.trace("Transform function invoked for GetUserGroupMembershipResponse");
                        Function<Response, WithHeaders<UserGroupMembership>> responseFn =
                                RESPONSE_CONVERSION_FACTORY.create(UserGroupMembership.class);

                        WithHeaders<UserGroupMembership> response = responseFn.apply(rawResponse);
                        MultivaluedMap<String, String> headers = response.getHeaders();

                        GetUserGroupMembershipResponse.Builder builder =
                                GetUserGroupMembershipResponse.builder();

                        builder.userGroupMembership(response.getItem());

                        Optional<List<String>> opcRequestIdHeader =
                                HeaderUtils.get(headers, "opc-request-id");
                        if (opcRequestIdHeader.isPresent()) {
                            builder.opcRequestId(
                                    HeaderUtils.toValue(
                                            "opc-request-id",
                                            opcRequestIdHeader.get().get(0),
                                            String.class));
                        }

                        Optional<List<String>> etagHeader = HeaderUtils.get(headers, "etag");
                        if (etagHeader.isPresent()) {
                            builder.etag(
                                    HeaderUtils.toValue(
                                            "etag", etagHeader.get().get(0), String.class));
                        }

                        GetUserGroupMembershipResponse responseWrapper = builder.build();

                        return responseWrapper;
                    }
                };
        return transformer;
    }
}
