/**
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
 */
package com.oracle.bmc.objectstorage.responses;

import java.io.*;
import java.util.*;

import com.oracle.bmc.model.*;
import javax.ws.rs.core.*;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

import com.oracle.bmc.objectstorage.model.*;

@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20160918")
@Builder(builderClassName = "Builder")
@Getter
public class CreateBucketResponse {

    /**
     * Echoes back the value passed in the opc-client-request-id header, for use by clients when debugging.
     */
    private String opcClientRequestId;

    /**
     * Unique Oracle-assigned identifier for the request. If you need to contact Oracle about a particular
     * request, please provide this request ID.
     *
     */
    private String opcRequestId;

    /**
     * The entity tag for the bucket that was created.
     */
    private String eTag;

    /**
     * The full path to the bucket that was created.
     */
    private String location;

    /**
     * The returned Bucket instance.
     */
    private Bucket bucket;

    public static class Builder {
        /**
         * Copy method to populate the builder with values from the given instance.
         * @return this builder instance
         */
        public Builder copy(CreateBucketResponse o) {
            opcClientRequestId(o.getOpcClientRequestId());
            opcRequestId(o.getOpcRequestId());
            eTag(o.getETag());
            location(o.getLocation());
            bucket(o.getBucket());

            return this;
        }
    }
}
