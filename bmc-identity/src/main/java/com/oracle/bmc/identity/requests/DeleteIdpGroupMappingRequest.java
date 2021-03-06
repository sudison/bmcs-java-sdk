/**
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
 */
package com.oracle.bmc.identity.requests;

import java.io.*;
import java.util.*;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

import com.oracle.bmc.model.*;
import com.oracle.bmc.identity.model.*;

@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20160918")
@Builder(builderClassName = "Builder")
@Getter
public class DeleteIdpGroupMappingRequest {

    /**
     * The OCID of the identity provider.
     */
    private String identityProviderId;

    /**
     * The OCID of the group mapping.
     */
    private String mappingId;

    /**
     * For optimistic concurrency control. In the PUT or DELETE call for a resource, set the `if-match`
     * parameter to the value of the etag from a previous GET or POST response for that resource.  The resource
     * will be updated or deleted only if the etag you provide matches the resource's current etag value.
     *
     */
    private String ifMatch;

    public static class Builder {
        /**
         * Copy method to populate the builder with values from the given instance.
         * @return this builder instance
         */
        public Builder copy(DeleteIdpGroupMappingRequest o) {
            identityProviderId(o.getIdentityProviderId());
            mappingId(o.getMappingId());
            ifMatch(o.getIfMatch());
            return this;
        }
    }
}
