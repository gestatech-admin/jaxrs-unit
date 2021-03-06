/*
 * Copyright 2014 Benoît Prioux
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.binout.jaxrsunit.jersey;

import io.github.binout.jaxrsunit.JaxrsResource;
import io.github.binout.jaxrsunit.JaxrsResponse;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class JerseyResource implements JaxrsResource {

    private final WebTarget webResource;

    JerseyResource(WebTarget resource) {
        this.webResource = resource;
    }

    @Override
    public JaxrsResponse get() {
        return new JerseyResponse(webResource.request().get(Response.class));
    }

    @Override
    public JaxrsResponse get(MediaType mediaType) {
        return new JerseyResponse(webResource.request(mediaType).get(Response.class));
    }

    @Override
    public JaxrsResponse get(String mediaType) {
        return new JerseyResponse(webResource.request(mediaType).get(Response.class));
    }

    @Override
    public JaxrsResponse post(String body) {
        return new JerseyResponse(webResource.request().post(Entity.entity(body, MediaType.WILDCARD_TYPE), Response.class));
    }

    @Override
    public JaxrsResponse post(String mediaType, String body) {
        return new JerseyResponse(webResource.request().post(Entity.entity(body, mediaType), Response.class));
    }

    @Override
    public JaxrsResponse post(MediaType mediaType, String body) {
        return new JerseyResponse(webResource.request().post(Entity.entity(body, mediaType), Response.class));
    }

    @Override
    public JaxrsResponse put(String body) {
        return new JerseyResponse(webResource.request().put(Entity.entity(body, MediaType.WILDCARD_TYPE),Response.class));
    }

    @Override
    public JaxrsResponse put(String mediaType, String body) {
        return new JerseyResponse(webResource.request().put(Entity.entity(body, mediaType),Response.class));
    }

    @Override
    public JaxrsResponse put(MediaType mediaType, String body) {
        return new JerseyResponse(webResource.request().put(Entity.entity(body, mediaType), Response.class));
    }

    @Override
    public JaxrsResponse delete() {
        return new JerseyResponse(webResource.request().delete(Response.class));
    }

    @Override
    public JaxrsResponse head() {
        return new JerseyResponse(webResource.request().method("HEAD", Response.class));
    }
}
