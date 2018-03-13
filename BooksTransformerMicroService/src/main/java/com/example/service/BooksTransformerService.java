/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.service;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.SAXException;

/**
 * This is the Microservice resource class.
 * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
 * for the usage of annotations.
 *
 * @since 1.0.0
 */
@Path("/bookstransformerMS")
public class BooksTransformerService {

    @POST
    @Path("/convertToJSON")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String convertToJSON(String book) throws IOException, TransformerException, SAXException, ParserConfigurationException {
    	TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(getClass().getResourceAsStream("/transformations/books-convert-to-json.xsl"));
        StringWriter result = new StringWriter();
        factory.newTransformer(xslt).transform(new StreamSource(new StringReader(book)), new StreamResult(result));
        return result.toString();
    }

    @POST
    @Path("/collectAllTitles")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String collectAllTitles(String books) throws IOException, TransformerException, SAXException, ParserConfigurationException {
    	TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(getClass().getResourceAsStream("/transformations/books-collect-all-titles.xsl"));
        StringWriter result = new StringWriter();
        factory.newTransformer(xslt).transform(new StreamSource(new StringReader(books)), new StreamResult(result));
        return result.toString();
    }

    @POST
    @Path("/selectPublicDomainBooks")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String selectPublicDomainBooks(String books) throws IOException, TransformerException, SAXException, ParserConfigurationException {
    	TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(getClass().getResourceAsStream("/transformations/books-select-public-domain-books.xsl"));
        StringWriter result = new StringWriter();
        factory.newTransformer(xslt).transform(new StreamSource(new StringReader(books)), new StreamResult(result));
        return result.toString();
    }
}
