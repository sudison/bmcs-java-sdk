/**
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
 */
package com.oracle.bmc.core;

import com.oracle.bmc.ClientConfiguration;
import com.oracle.bmc.auth.*;
import com.oracle.bmc.http.ClientConfigurator;
import com.oracle.bmc.http.internal.*;
import com.oracle.bmc.http.signing.*;
import com.oracle.bmc.http.signing.internal.*;

import com.google.common.base.Function;
import com.google.common.base.Optional;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

import com.oracle.bmc.core.internal.http.*;
import com.oracle.bmc.core.requests.*;
import com.oracle.bmc.core.responses.*;

import com.oracle.bmc.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@javax.annotation.Generated(value = "OracleSDKGenerator", comments = "API Version: 20160918")
@Slf4j
public class VirtualNetworkClient implements VirtualNetwork {
    /**
     * Service instance for VirtualNetwork.
     */
    public static final Service SERVICE = Services.create("VIRTUALNETWORK", "iaas");

    private final ExecutorService executorService = Executors.newFixedThreadPool(50);
    private final VirtualNetworkWaiters waiters;

    @Getter(value = AccessLevel.PACKAGE)
    private final RestClient client;

    /**
     * Creates a new service instance using the given authentication provider.
     * @param authenticationDetailsProvider The authentication details provider, required.
     */
    public VirtualNetworkClient(BasicAuthenticationDetailsProvider authenticationDetailsProvider) {
        this(authenticationDetailsProvider, null);
    }

    /**
     * Creates a new service instance using the given authentication provider and client configuration.
     * @param authenticationDetailsProvider The authentication details provider, required.
     * @param configuration The client configuration, optional.
     */
    public VirtualNetworkClient(
            BasicAuthenticationDetailsProvider authenticationDetailsProvider,
            ClientConfiguration configuration) {
        this(authenticationDetailsProvider, configuration, null);
    }

    /**
     * Creates a new service instance using the given authentication provider and client configuration.  Additionally,
     * a Consumer can be provided that will be invoked whenever a REST Client is created to allow for additional configuration/customization.
     * @param authenticationDetailsProvider The authentication details provider, required.
     * @param configuration The client configuration, optional.
     * @param clientConfigurator ClientConfigurator that will be invoked for additional configuration of a REST client, optional.
     */
    public VirtualNetworkClient(
            BasicAuthenticationDetailsProvider authenticationDetailsProvider,
            ClientConfiguration configuration,
            ClientConfigurator clientConfigurator) {
        this(
                authenticationDetailsProvider,
                configuration,
                clientConfigurator,
                new DefaultRequestSignerFactory(SigningStrategy.STANDARD));
    }

    /**
     * Creates a new service instance using the given authentication provider and client configuration.  Additionally,
     * a Consumer can be provided that will be invoked whenever a REST Client is created to allow for additional configuration/customization.
     * <p>
     * This is an advanced constructor for clients that want to take control over how requests are signed.
     * @param authenticationDetailsProvider The authentication details provider, required.
     * @param configuration The client configuration, optional.
     * @param clientConfigurator ClientConfigurator that will be invoked for additional configuration of a REST client, optional.
     * @param requestSignerFactory The request signer factory used to create the request signer for this service.
     */
    public VirtualNetworkClient(
            AbstractAuthenticationDetailsProvider authenticationDetailsProvider,
            ClientConfiguration configuration,
            ClientConfigurator clientConfigurator,
            RequestSignerFactory requestSignerFactory) {
        RestClientFactory restClientFactory =
                RestClientFactoryBuilder.builder().clientConfigurator(clientConfigurator).build();
        RequestSigner requestSigner =
                requestSignerFactory.createRequestSigner(SERVICE, authenticationDetailsProvider);
        this.client = restClientFactory.create(requestSigner, configuration);

        this.waiters = new VirtualNetworkWaiters(executorService, this);
    }

    @Override
    public void setEndpoint(String endpoint) {
        LOG.info("Setting endpoint to {}", endpoint);
        client.setEndpoint(endpoint);
    }

    @Override
    public void setRegion(Region region) {
        Optional<String> endpoint = region.getEndpoint(SERVICE);
        if (endpoint.isPresent()) {
            setEndpoint(endpoint.get());
        } else {
            throw new IllegalArgumentException(
                    "Endpoint for " + SERVICE + " is not known in region " + region);
        }
    }

    @Override
    public void setRegion(String regionId) {
        regionId = regionId.toLowerCase();
        try {
            Region region = Region.fromRegionId(regionId);
            setRegion(region);
        } catch (IllegalArgumentException e) {
            LOG.info("Unknown regionId '{}', falling back to default endpoint format", regionId);
            String endpoint = Region.formatDefaultRegionEndpoint(SERVICE, regionId);
            setEndpoint(endpoint);
        }
    }

    @Override
    public void close() {
        client.close();
    }

    @Override
    public CreateCpeResponse createCpe(CreateCpeRequest request) {
        LOG.trace("Called createCpe");
        request = CreateCpeConverter.interceptRequest(request);
        Invocation.Builder ib = CreateCpeConverter.fromRequest(client, request);
        Function<Response, CreateCpeResponse> transformer = CreateCpeConverter.fromResponse();

        Response response = client.post(ib, request.getCreateCpeDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public CreateCrossConnectResponse createCrossConnect(CreateCrossConnectRequest request) {
        LOG.trace("Called createCrossConnect");
        request = CreateCrossConnectConverter.interceptRequest(request);
        Invocation.Builder ib = CreateCrossConnectConverter.fromRequest(client, request);
        Function<Response, CreateCrossConnectResponse> transformer =
                CreateCrossConnectConverter.fromResponse();

        Response response = client.post(ib, request.getCreateCrossConnectDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public CreateCrossConnectGroupResponse createCrossConnectGroup(
            CreateCrossConnectGroupRequest request) {
        LOG.trace("Called createCrossConnectGroup");
        request = CreateCrossConnectGroupConverter.interceptRequest(request);
        Invocation.Builder ib = CreateCrossConnectGroupConverter.fromRequest(client, request);
        Function<Response, CreateCrossConnectGroupResponse> transformer =
                CreateCrossConnectGroupConverter.fromResponse();

        Response response = client.post(ib, request.getCreateCrossConnectGroupDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public CreateDhcpOptionsResponse createDhcpOptions(CreateDhcpOptionsRequest request) {
        LOG.trace("Called createDhcpOptions");
        request = CreateDhcpOptionsConverter.interceptRequest(request);
        Invocation.Builder ib = CreateDhcpOptionsConverter.fromRequest(client, request);
        Function<Response, CreateDhcpOptionsResponse> transformer =
                CreateDhcpOptionsConverter.fromResponse();

        Response response = client.post(ib, request.getCreateDhcpDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public CreateDrgResponse createDrg(CreateDrgRequest request) {
        LOG.trace("Called createDrg");
        request = CreateDrgConverter.interceptRequest(request);
        Invocation.Builder ib = CreateDrgConverter.fromRequest(client, request);
        Function<Response, CreateDrgResponse> transformer = CreateDrgConverter.fromResponse();

        Response response = client.post(ib, request.getCreateDrgDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public CreateDrgAttachmentResponse createDrgAttachment(CreateDrgAttachmentRequest request) {
        LOG.trace("Called createDrgAttachment");
        request = CreateDrgAttachmentConverter.interceptRequest(request);
        Invocation.Builder ib = CreateDrgAttachmentConverter.fromRequest(client, request);
        Function<Response, CreateDrgAttachmentResponse> transformer =
                CreateDrgAttachmentConverter.fromResponse();

        Response response = client.post(ib, request.getCreateDrgAttachmentDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public CreateIPSecConnectionResponse createIPSecConnection(
            CreateIPSecConnectionRequest request) {
        LOG.trace("Called createIPSecConnection");
        request = CreateIPSecConnectionConverter.interceptRequest(request);
        Invocation.Builder ib = CreateIPSecConnectionConverter.fromRequest(client, request);
        Function<Response, CreateIPSecConnectionResponse> transformer =
                CreateIPSecConnectionConverter.fromResponse();

        Response response = client.post(ib, request.getCreateIPSecConnectionDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public CreateInternetGatewayResponse createInternetGateway(
            CreateInternetGatewayRequest request) {
        LOG.trace("Called createInternetGateway");
        request = CreateInternetGatewayConverter.interceptRequest(request);
        Invocation.Builder ib = CreateInternetGatewayConverter.fromRequest(client, request);
        Function<Response, CreateInternetGatewayResponse> transformer =
                CreateInternetGatewayConverter.fromResponse();

        Response response = client.post(ib, request.getCreateInternetGatewayDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public CreateRouteTableResponse createRouteTable(CreateRouteTableRequest request) {
        LOG.trace("Called createRouteTable");
        request = CreateRouteTableConverter.interceptRequest(request);
        Invocation.Builder ib = CreateRouteTableConverter.fromRequest(client, request);
        Function<Response, CreateRouteTableResponse> transformer =
                CreateRouteTableConverter.fromResponse();

        Response response = client.post(ib, request.getCreateRouteTableDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public CreateSecurityListResponse createSecurityList(CreateSecurityListRequest request) {
        LOG.trace("Called createSecurityList");
        request = CreateSecurityListConverter.interceptRequest(request);
        Invocation.Builder ib = CreateSecurityListConverter.fromRequest(client, request);
        Function<Response, CreateSecurityListResponse> transformer =
                CreateSecurityListConverter.fromResponse();

        Response response = client.post(ib, request.getCreateSecurityListDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public CreateSubnetResponse createSubnet(CreateSubnetRequest request) {
        LOG.trace("Called createSubnet");
        request = CreateSubnetConverter.interceptRequest(request);
        Invocation.Builder ib = CreateSubnetConverter.fromRequest(client, request);
        Function<Response, CreateSubnetResponse> transformer = CreateSubnetConverter.fromResponse();

        Response response = client.post(ib, request.getCreateSubnetDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public CreateVcnResponse createVcn(CreateVcnRequest request) {
        LOG.trace("Called createVcn");
        request = CreateVcnConverter.interceptRequest(request);
        Invocation.Builder ib = CreateVcnConverter.fromRequest(client, request);
        Function<Response, CreateVcnResponse> transformer = CreateVcnConverter.fromResponse();

        Response response = client.post(ib, request.getCreateVcnDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public CreateVirtualCircuitResponse createVirtualCircuit(CreateVirtualCircuitRequest request) {
        LOG.trace("Called createVirtualCircuit");
        request = CreateVirtualCircuitConverter.interceptRequest(request);
        Invocation.Builder ib = CreateVirtualCircuitConverter.fromRequest(client, request);
        Function<Response, CreateVirtualCircuitResponse> transformer =
                CreateVirtualCircuitConverter.fromResponse();

        Response response = client.post(ib, request.getCreateVirtualCircuitDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public DeleteCpeResponse deleteCpe(DeleteCpeRequest request) {
        LOG.trace("Called deleteCpe");
        request = DeleteCpeConverter.interceptRequest(request);
        Invocation.Builder ib = DeleteCpeConverter.fromRequest(client, request);
        Function<Response, DeleteCpeResponse> transformer = DeleteCpeConverter.fromResponse();

        Response response = client.delete(ib, request);
        return transformer.apply(response);
    }

    @Override
    public DeleteCrossConnectResponse deleteCrossConnect(DeleteCrossConnectRequest request) {
        LOG.trace("Called deleteCrossConnect");
        request = DeleteCrossConnectConverter.interceptRequest(request);
        Invocation.Builder ib = DeleteCrossConnectConverter.fromRequest(client, request);
        Function<Response, DeleteCrossConnectResponse> transformer =
                DeleteCrossConnectConverter.fromResponse();

        Response response = client.delete(ib, request);
        return transformer.apply(response);
    }

    @Override
    public DeleteCrossConnectGroupResponse deleteCrossConnectGroup(
            DeleteCrossConnectGroupRequest request) {
        LOG.trace("Called deleteCrossConnectGroup");
        request = DeleteCrossConnectGroupConverter.interceptRequest(request);
        Invocation.Builder ib = DeleteCrossConnectGroupConverter.fromRequest(client, request);
        Function<Response, DeleteCrossConnectGroupResponse> transformer =
                DeleteCrossConnectGroupConverter.fromResponse();

        Response response = client.delete(ib, request);
        return transformer.apply(response);
    }

    @Override
    public DeleteDhcpOptionsResponse deleteDhcpOptions(DeleteDhcpOptionsRequest request) {
        LOG.trace("Called deleteDhcpOptions");
        request = DeleteDhcpOptionsConverter.interceptRequest(request);
        Invocation.Builder ib = DeleteDhcpOptionsConverter.fromRequest(client, request);
        Function<Response, DeleteDhcpOptionsResponse> transformer =
                DeleteDhcpOptionsConverter.fromResponse();

        Response response = client.delete(ib, request);
        return transformer.apply(response);
    }

    @Override
    public DeleteDrgResponse deleteDrg(DeleteDrgRequest request) {
        LOG.trace("Called deleteDrg");
        request = DeleteDrgConverter.interceptRequest(request);
        Invocation.Builder ib = DeleteDrgConverter.fromRequest(client, request);
        Function<Response, DeleteDrgResponse> transformer = DeleteDrgConverter.fromResponse();

        Response response = client.delete(ib, request);
        return transformer.apply(response);
    }

    @Override
    public DeleteDrgAttachmentResponse deleteDrgAttachment(DeleteDrgAttachmentRequest request) {
        LOG.trace("Called deleteDrgAttachment");
        request = DeleteDrgAttachmentConverter.interceptRequest(request);
        Invocation.Builder ib = DeleteDrgAttachmentConverter.fromRequest(client, request);
        Function<Response, DeleteDrgAttachmentResponse> transformer =
                DeleteDrgAttachmentConverter.fromResponse();

        Response response = client.delete(ib, request);
        return transformer.apply(response);
    }

    @Override
    public DeleteIPSecConnectionResponse deleteIPSecConnection(
            DeleteIPSecConnectionRequest request) {
        LOG.trace("Called deleteIPSecConnection");
        request = DeleteIPSecConnectionConverter.interceptRequest(request);
        Invocation.Builder ib = DeleteIPSecConnectionConverter.fromRequest(client, request);
        Function<Response, DeleteIPSecConnectionResponse> transformer =
                DeleteIPSecConnectionConverter.fromResponse();

        Response response = client.delete(ib, request);
        return transformer.apply(response);
    }

    @Override
    public DeleteInternetGatewayResponse deleteInternetGateway(
            DeleteInternetGatewayRequest request) {
        LOG.trace("Called deleteInternetGateway");
        request = DeleteInternetGatewayConverter.interceptRequest(request);
        Invocation.Builder ib = DeleteInternetGatewayConverter.fromRequest(client, request);
        Function<Response, DeleteInternetGatewayResponse> transformer =
                DeleteInternetGatewayConverter.fromResponse();

        Response response = client.delete(ib, request);
        return transformer.apply(response);
    }

    @Override
    public DeleteRouteTableResponse deleteRouteTable(DeleteRouteTableRequest request) {
        LOG.trace("Called deleteRouteTable");
        request = DeleteRouteTableConverter.interceptRequest(request);
        Invocation.Builder ib = DeleteRouteTableConverter.fromRequest(client, request);
        Function<Response, DeleteRouteTableResponse> transformer =
                DeleteRouteTableConverter.fromResponse();

        Response response = client.delete(ib, request);
        return transformer.apply(response);
    }

    @Override
    public DeleteSecurityListResponse deleteSecurityList(DeleteSecurityListRequest request) {
        LOG.trace("Called deleteSecurityList");
        request = DeleteSecurityListConverter.interceptRequest(request);
        Invocation.Builder ib = DeleteSecurityListConverter.fromRequest(client, request);
        Function<Response, DeleteSecurityListResponse> transformer =
                DeleteSecurityListConverter.fromResponse();

        Response response = client.delete(ib, request);
        return transformer.apply(response);
    }

    @Override
    public DeleteSubnetResponse deleteSubnet(DeleteSubnetRequest request) {
        LOG.trace("Called deleteSubnet");
        request = DeleteSubnetConverter.interceptRequest(request);
        Invocation.Builder ib = DeleteSubnetConverter.fromRequest(client, request);
        Function<Response, DeleteSubnetResponse> transformer = DeleteSubnetConverter.fromResponse();

        Response response = client.delete(ib, request);
        return transformer.apply(response);
    }

    @Override
    public DeleteVcnResponse deleteVcn(DeleteVcnRequest request) {
        LOG.trace("Called deleteVcn");
        request = DeleteVcnConverter.interceptRequest(request);
        Invocation.Builder ib = DeleteVcnConverter.fromRequest(client, request);
        Function<Response, DeleteVcnResponse> transformer = DeleteVcnConverter.fromResponse();

        Response response = client.delete(ib, request);
        return transformer.apply(response);
    }

    @Override
    public DeleteVirtualCircuitResponse deleteVirtualCircuit(DeleteVirtualCircuitRequest request) {
        LOG.trace("Called deleteVirtualCircuit");
        request = DeleteVirtualCircuitConverter.interceptRequest(request);
        Invocation.Builder ib = DeleteVirtualCircuitConverter.fromRequest(client, request);
        Function<Response, DeleteVirtualCircuitResponse> transformer =
                DeleteVirtualCircuitConverter.fromResponse();

        Response response = client.delete(ib, request);
        return transformer.apply(response);
    }

    @Override
    public GetCpeResponse getCpe(GetCpeRequest request) {
        LOG.trace("Called getCpe");
        request = GetCpeConverter.interceptRequest(request);
        Invocation.Builder ib = GetCpeConverter.fromRequest(client, request);
        Function<Response, GetCpeResponse> transformer = GetCpeConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public GetCrossConnectResponse getCrossConnect(GetCrossConnectRequest request) {
        LOG.trace("Called getCrossConnect");
        request = GetCrossConnectConverter.interceptRequest(request);
        Invocation.Builder ib = GetCrossConnectConverter.fromRequest(client, request);
        Function<Response, GetCrossConnectResponse> transformer =
                GetCrossConnectConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public GetCrossConnectGroupResponse getCrossConnectGroup(GetCrossConnectGroupRequest request) {
        LOG.trace("Called getCrossConnectGroup");
        request = GetCrossConnectGroupConverter.interceptRequest(request);
        Invocation.Builder ib = GetCrossConnectGroupConverter.fromRequest(client, request);
        Function<Response, GetCrossConnectGroupResponse> transformer =
                GetCrossConnectGroupConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public GetCrossConnectLetterOfAuthorityResponse getCrossConnectLetterOfAuthority(
            GetCrossConnectLetterOfAuthorityRequest request) {
        LOG.trace("Called getCrossConnectLetterOfAuthority");
        request = GetCrossConnectLetterOfAuthorityConverter.interceptRequest(request);
        Invocation.Builder ib =
                GetCrossConnectLetterOfAuthorityConverter.fromRequest(client, request);
        Function<Response, GetCrossConnectLetterOfAuthorityResponse> transformer =
                GetCrossConnectLetterOfAuthorityConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public GetCrossConnectStatusResponse getCrossConnectStatus(
            GetCrossConnectStatusRequest request) {
        LOG.trace("Called getCrossConnectStatus");
        request = GetCrossConnectStatusConverter.interceptRequest(request);
        Invocation.Builder ib = GetCrossConnectStatusConverter.fromRequest(client, request);
        Function<Response, GetCrossConnectStatusResponse> transformer =
                GetCrossConnectStatusConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public GetDhcpOptionsResponse getDhcpOptions(GetDhcpOptionsRequest request) {
        LOG.trace("Called getDhcpOptions");
        request = GetDhcpOptionsConverter.interceptRequest(request);
        Invocation.Builder ib = GetDhcpOptionsConverter.fromRequest(client, request);
        Function<Response, GetDhcpOptionsResponse> transformer =
                GetDhcpOptionsConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public GetDrgResponse getDrg(GetDrgRequest request) {
        LOG.trace("Called getDrg");
        request = GetDrgConverter.interceptRequest(request);
        Invocation.Builder ib = GetDrgConverter.fromRequest(client, request);
        Function<Response, GetDrgResponse> transformer = GetDrgConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public GetDrgAttachmentResponse getDrgAttachment(GetDrgAttachmentRequest request) {
        LOG.trace("Called getDrgAttachment");
        request = GetDrgAttachmentConverter.interceptRequest(request);
        Invocation.Builder ib = GetDrgAttachmentConverter.fromRequest(client, request);
        Function<Response, GetDrgAttachmentResponse> transformer =
                GetDrgAttachmentConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public GetIPSecConnectionResponse getIPSecConnection(GetIPSecConnectionRequest request) {
        LOG.trace("Called getIPSecConnection");
        request = GetIPSecConnectionConverter.interceptRequest(request);
        Invocation.Builder ib = GetIPSecConnectionConverter.fromRequest(client, request);
        Function<Response, GetIPSecConnectionResponse> transformer =
                GetIPSecConnectionConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public GetIPSecConnectionDeviceConfigResponse getIPSecConnectionDeviceConfig(
            GetIPSecConnectionDeviceConfigRequest request) {
        LOG.trace("Called getIPSecConnectionDeviceConfig");
        request = GetIPSecConnectionDeviceConfigConverter.interceptRequest(request);
        Invocation.Builder ib =
                GetIPSecConnectionDeviceConfigConverter.fromRequest(client, request);
        Function<Response, GetIPSecConnectionDeviceConfigResponse> transformer =
                GetIPSecConnectionDeviceConfigConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public GetIPSecConnectionDeviceStatusResponse getIPSecConnectionDeviceStatus(
            GetIPSecConnectionDeviceStatusRequest request) {
        LOG.trace("Called getIPSecConnectionDeviceStatus");
        request = GetIPSecConnectionDeviceStatusConverter.interceptRequest(request);
        Invocation.Builder ib =
                GetIPSecConnectionDeviceStatusConverter.fromRequest(client, request);
        Function<Response, GetIPSecConnectionDeviceStatusResponse> transformer =
                GetIPSecConnectionDeviceStatusConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public GetInternetGatewayResponse getInternetGateway(GetInternetGatewayRequest request) {
        LOG.trace("Called getInternetGateway");
        request = GetInternetGatewayConverter.interceptRequest(request);
        Invocation.Builder ib = GetInternetGatewayConverter.fromRequest(client, request);
        Function<Response, GetInternetGatewayResponse> transformer =
                GetInternetGatewayConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public GetRouteTableResponse getRouteTable(GetRouteTableRequest request) {
        LOG.trace("Called getRouteTable");
        request = GetRouteTableConverter.interceptRequest(request);
        Invocation.Builder ib = GetRouteTableConverter.fromRequest(client, request);
        Function<Response, GetRouteTableResponse> transformer =
                GetRouteTableConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public GetSecurityListResponse getSecurityList(GetSecurityListRequest request) {
        LOG.trace("Called getSecurityList");
        request = GetSecurityListConverter.interceptRequest(request);
        Invocation.Builder ib = GetSecurityListConverter.fromRequest(client, request);
        Function<Response, GetSecurityListResponse> transformer =
                GetSecurityListConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public GetSubnetResponse getSubnet(GetSubnetRequest request) {
        LOG.trace("Called getSubnet");
        request = GetSubnetConverter.interceptRequest(request);
        Invocation.Builder ib = GetSubnetConverter.fromRequest(client, request);
        Function<Response, GetSubnetResponse> transformer = GetSubnetConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public GetVcnResponse getVcn(GetVcnRequest request) {
        LOG.trace("Called getVcn");
        request = GetVcnConverter.interceptRequest(request);
        Invocation.Builder ib = GetVcnConverter.fromRequest(client, request);
        Function<Response, GetVcnResponse> transformer = GetVcnConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public GetVirtualCircuitResponse getVirtualCircuit(GetVirtualCircuitRequest request) {
        LOG.trace("Called getVirtualCircuit");
        request = GetVirtualCircuitConverter.interceptRequest(request);
        Invocation.Builder ib = GetVirtualCircuitConverter.fromRequest(client, request);
        Function<Response, GetVirtualCircuitResponse> transformer =
                GetVirtualCircuitConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public GetVnicResponse getVnic(GetVnicRequest request) {
        LOG.trace("Called getVnic");
        request = GetVnicConverter.interceptRequest(request);
        Invocation.Builder ib = GetVnicConverter.fromRequest(client, request);
        Function<Response, GetVnicResponse> transformer = GetVnicConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public ListCpesResponse listCpes(ListCpesRequest request) {
        LOG.trace("Called listCpes");
        request = ListCpesConverter.interceptRequest(request);
        Invocation.Builder ib = ListCpesConverter.fromRequest(client, request);
        Function<Response, ListCpesResponse> transformer = ListCpesConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public ListCrossConnectGroupsResponse listCrossConnectGroups(
            ListCrossConnectGroupsRequest request) {
        LOG.trace("Called listCrossConnectGroups");
        request = ListCrossConnectGroupsConverter.interceptRequest(request);
        Invocation.Builder ib = ListCrossConnectGroupsConverter.fromRequest(client, request);
        Function<Response, ListCrossConnectGroupsResponse> transformer =
                ListCrossConnectGroupsConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public ListCrossConnectLocationsResponse listCrossConnectLocations(
            ListCrossConnectLocationsRequest request) {
        LOG.trace("Called listCrossConnectLocations");
        request = ListCrossConnectLocationsConverter.interceptRequest(request);
        Invocation.Builder ib = ListCrossConnectLocationsConverter.fromRequest(client, request);
        Function<Response, ListCrossConnectLocationsResponse> transformer =
                ListCrossConnectLocationsConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public ListCrossConnectsResponse listCrossConnects(ListCrossConnectsRequest request) {
        LOG.trace("Called listCrossConnects");
        request = ListCrossConnectsConverter.interceptRequest(request);
        Invocation.Builder ib = ListCrossConnectsConverter.fromRequest(client, request);
        Function<Response, ListCrossConnectsResponse> transformer =
                ListCrossConnectsConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public ListCrossconnectPortSpeedShapesResponse listCrossconnectPortSpeedShapes(
            ListCrossconnectPortSpeedShapesRequest request) {
        LOG.trace("Called listCrossconnectPortSpeedShapes");
        request = ListCrossconnectPortSpeedShapesConverter.interceptRequest(request);
        Invocation.Builder ib =
                ListCrossconnectPortSpeedShapesConverter.fromRequest(client, request);
        Function<Response, ListCrossconnectPortSpeedShapesResponse> transformer =
                ListCrossconnectPortSpeedShapesConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public ListDhcpOptionsResponse listDhcpOptions(ListDhcpOptionsRequest request) {
        LOG.trace("Called listDhcpOptions");
        request = ListDhcpOptionsConverter.interceptRequest(request);
        Invocation.Builder ib = ListDhcpOptionsConverter.fromRequest(client, request);
        Function<Response, ListDhcpOptionsResponse> transformer =
                ListDhcpOptionsConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public ListDrgAttachmentsResponse listDrgAttachments(ListDrgAttachmentsRequest request) {
        LOG.trace("Called listDrgAttachments");
        request = ListDrgAttachmentsConverter.interceptRequest(request);
        Invocation.Builder ib = ListDrgAttachmentsConverter.fromRequest(client, request);
        Function<Response, ListDrgAttachmentsResponse> transformer =
                ListDrgAttachmentsConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public ListDrgsResponse listDrgs(ListDrgsRequest request) {
        LOG.trace("Called listDrgs");
        request = ListDrgsConverter.interceptRequest(request);
        Invocation.Builder ib = ListDrgsConverter.fromRequest(client, request);
        Function<Response, ListDrgsResponse> transformer = ListDrgsConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public ListFastConnectProviderServicesResponse listFastConnectProviderServices(
            ListFastConnectProviderServicesRequest request) {
        LOG.trace("Called listFastConnectProviderServices");
        request = ListFastConnectProviderServicesConverter.interceptRequest(request);
        Invocation.Builder ib =
                ListFastConnectProviderServicesConverter.fromRequest(client, request);
        Function<Response, ListFastConnectProviderServicesResponse> transformer =
                ListFastConnectProviderServicesConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public ListIPSecConnectionsResponse listIPSecConnections(ListIPSecConnectionsRequest request) {
        LOG.trace("Called listIPSecConnections");
        request = ListIPSecConnectionsConverter.interceptRequest(request);
        Invocation.Builder ib = ListIPSecConnectionsConverter.fromRequest(client, request);
        Function<Response, ListIPSecConnectionsResponse> transformer =
                ListIPSecConnectionsConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public ListInternetGatewaysResponse listInternetGateways(ListInternetGatewaysRequest request) {
        LOG.trace("Called listInternetGateways");
        request = ListInternetGatewaysConverter.interceptRequest(request);
        Invocation.Builder ib = ListInternetGatewaysConverter.fromRequest(client, request);
        Function<Response, ListInternetGatewaysResponse> transformer =
                ListInternetGatewaysConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public ListRouteTablesResponse listRouteTables(ListRouteTablesRequest request) {
        LOG.trace("Called listRouteTables");
        request = ListRouteTablesConverter.interceptRequest(request);
        Invocation.Builder ib = ListRouteTablesConverter.fromRequest(client, request);
        Function<Response, ListRouteTablesResponse> transformer =
                ListRouteTablesConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public ListSecurityListsResponse listSecurityLists(ListSecurityListsRequest request) {
        LOG.trace("Called listSecurityLists");
        request = ListSecurityListsConverter.interceptRequest(request);
        Invocation.Builder ib = ListSecurityListsConverter.fromRequest(client, request);
        Function<Response, ListSecurityListsResponse> transformer =
                ListSecurityListsConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public ListSubnetsResponse listSubnets(ListSubnetsRequest request) {
        LOG.trace("Called listSubnets");
        request = ListSubnetsConverter.interceptRequest(request);
        Invocation.Builder ib = ListSubnetsConverter.fromRequest(client, request);
        Function<Response, ListSubnetsResponse> transformer = ListSubnetsConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public ListVcnsResponse listVcns(ListVcnsRequest request) {
        LOG.trace("Called listVcns");
        request = ListVcnsConverter.interceptRequest(request);
        Invocation.Builder ib = ListVcnsConverter.fromRequest(client, request);
        Function<Response, ListVcnsResponse> transformer = ListVcnsConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public ListVirtualCircuitBandwidthShapesResponse listVirtualCircuitBandwidthShapes(
            ListVirtualCircuitBandwidthShapesRequest request) {
        LOG.trace("Called listVirtualCircuitBandwidthShapes");
        request = ListVirtualCircuitBandwidthShapesConverter.interceptRequest(request);
        Invocation.Builder ib =
                ListVirtualCircuitBandwidthShapesConverter.fromRequest(client, request);
        Function<Response, ListVirtualCircuitBandwidthShapesResponse> transformer =
                ListVirtualCircuitBandwidthShapesConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public ListVirtualCircuitsResponse listVirtualCircuits(ListVirtualCircuitsRequest request) {
        LOG.trace("Called listVirtualCircuits");
        request = ListVirtualCircuitsConverter.interceptRequest(request);
        Invocation.Builder ib = ListVirtualCircuitsConverter.fromRequest(client, request);
        Function<Response, ListVirtualCircuitsResponse> transformer =
                ListVirtualCircuitsConverter.fromResponse();

        Response response = client.get(ib, request);
        return transformer.apply(response);
    }

    @Override
    public UpdateCpeResponse updateCpe(UpdateCpeRequest request) {
        LOG.trace("Called updateCpe");
        request = UpdateCpeConverter.interceptRequest(request);
        Invocation.Builder ib = UpdateCpeConverter.fromRequest(client, request);
        Function<Response, UpdateCpeResponse> transformer = UpdateCpeConverter.fromResponse();

        Response response = client.put(ib, request.getUpdateCpeDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public UpdateCrossConnectResponse updateCrossConnect(UpdateCrossConnectRequest request) {
        LOG.trace("Called updateCrossConnect");
        request = UpdateCrossConnectConverter.interceptRequest(request);
        Invocation.Builder ib = UpdateCrossConnectConverter.fromRequest(client, request);
        Function<Response, UpdateCrossConnectResponse> transformer =
                UpdateCrossConnectConverter.fromResponse();

        Response response = client.put(ib, request.getUpdateCrossConnectDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public UpdateCrossConnectGroupResponse updateCrossConnectGroup(
            UpdateCrossConnectGroupRequest request) {
        LOG.trace("Called updateCrossConnectGroup");
        request = UpdateCrossConnectGroupConverter.interceptRequest(request);
        Invocation.Builder ib = UpdateCrossConnectGroupConverter.fromRequest(client, request);
        Function<Response, UpdateCrossConnectGroupResponse> transformer =
                UpdateCrossConnectGroupConverter.fromResponse();

        Response response = client.put(ib, request.getUpdateCrossConnectGroupDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public UpdateDhcpOptionsResponse updateDhcpOptions(UpdateDhcpOptionsRequest request) {
        LOG.trace("Called updateDhcpOptions");
        request = UpdateDhcpOptionsConverter.interceptRequest(request);
        Invocation.Builder ib = UpdateDhcpOptionsConverter.fromRequest(client, request);
        Function<Response, UpdateDhcpOptionsResponse> transformer =
                UpdateDhcpOptionsConverter.fromResponse();

        Response response = client.put(ib, request.getUpdateDhcpDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public UpdateDrgResponse updateDrg(UpdateDrgRequest request) {
        LOG.trace("Called updateDrg");
        request = UpdateDrgConverter.interceptRequest(request);
        Invocation.Builder ib = UpdateDrgConverter.fromRequest(client, request);
        Function<Response, UpdateDrgResponse> transformer = UpdateDrgConverter.fromResponse();

        Response response = client.put(ib, request.getUpdateDrgDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public UpdateDrgAttachmentResponse updateDrgAttachment(UpdateDrgAttachmentRequest request) {
        LOG.trace("Called updateDrgAttachment");
        request = UpdateDrgAttachmentConverter.interceptRequest(request);
        Invocation.Builder ib = UpdateDrgAttachmentConverter.fromRequest(client, request);
        Function<Response, UpdateDrgAttachmentResponse> transformer =
                UpdateDrgAttachmentConverter.fromResponse();

        Response response = client.put(ib, request.getUpdateDrgAttachmentDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public UpdateIPSecConnectionResponse updateIPSecConnection(
            UpdateIPSecConnectionRequest request) {
        LOG.trace("Called updateIPSecConnection");
        request = UpdateIPSecConnectionConverter.interceptRequest(request);
        Invocation.Builder ib = UpdateIPSecConnectionConverter.fromRequest(client, request);
        Function<Response, UpdateIPSecConnectionResponse> transformer =
                UpdateIPSecConnectionConverter.fromResponse();

        Response response = client.put(ib, request.getUpdateIPSecConnectionDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public UpdateInternetGatewayResponse updateInternetGateway(
            UpdateInternetGatewayRequest request) {
        LOG.trace("Called updateInternetGateway");
        request = UpdateInternetGatewayConverter.interceptRequest(request);
        Invocation.Builder ib = UpdateInternetGatewayConverter.fromRequest(client, request);
        Function<Response, UpdateInternetGatewayResponse> transformer =
                UpdateInternetGatewayConverter.fromResponse();

        Response response = client.put(ib, request.getUpdateInternetGatewayDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public UpdateRouteTableResponse updateRouteTable(UpdateRouteTableRequest request) {
        LOG.trace("Called updateRouteTable");
        request = UpdateRouteTableConverter.interceptRequest(request);
        Invocation.Builder ib = UpdateRouteTableConverter.fromRequest(client, request);
        Function<Response, UpdateRouteTableResponse> transformer =
                UpdateRouteTableConverter.fromResponse();

        Response response = client.put(ib, request.getUpdateRouteTableDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public UpdateSecurityListResponse updateSecurityList(UpdateSecurityListRequest request) {
        LOG.trace("Called updateSecurityList");
        request = UpdateSecurityListConverter.interceptRequest(request);
        Invocation.Builder ib = UpdateSecurityListConverter.fromRequest(client, request);
        Function<Response, UpdateSecurityListResponse> transformer =
                UpdateSecurityListConverter.fromResponse();

        Response response = client.put(ib, request.getUpdateSecurityListDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public UpdateSubnetResponse updateSubnet(UpdateSubnetRequest request) {
        LOG.trace("Called updateSubnet");
        request = UpdateSubnetConverter.interceptRequest(request);
        Invocation.Builder ib = UpdateSubnetConverter.fromRequest(client, request);
        Function<Response, UpdateSubnetResponse> transformer = UpdateSubnetConverter.fromResponse();

        Response response = client.put(ib, request.getUpdateSubnetDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public UpdateVcnResponse updateVcn(UpdateVcnRequest request) {
        LOG.trace("Called updateVcn");
        request = UpdateVcnConverter.interceptRequest(request);
        Invocation.Builder ib = UpdateVcnConverter.fromRequest(client, request);
        Function<Response, UpdateVcnResponse> transformer = UpdateVcnConverter.fromResponse();

        Response response = client.put(ib, request.getUpdateVcnDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public UpdateVirtualCircuitResponse updateVirtualCircuit(UpdateVirtualCircuitRequest request) {
        LOG.trace("Called updateVirtualCircuit");
        request = UpdateVirtualCircuitConverter.interceptRequest(request);
        Invocation.Builder ib = UpdateVirtualCircuitConverter.fromRequest(client, request);
        Function<Response, UpdateVirtualCircuitResponse> transformer =
                UpdateVirtualCircuitConverter.fromResponse();

        Response response = client.put(ib, request.getUpdateVirtualCircuitDetails(), request);
        return transformer.apply(response);
    }

    @Override
    public VirtualNetworkWaiters getWaiters() {
        return waiters;
    }
}
