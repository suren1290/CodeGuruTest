package com.risksense.converters.impl;

import com.risksense.converters.ConverterFactory;
import com.risksense.converters.Impl.XMLJSONConverterImpl;
import com.risksense.converters.XMLJSONConverterI;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by pediredla on 11/22/16.
 */

public class TestXMLJSONConverterImpl {

    private File input;
    private File ouput;
    XMLJSONConverterI impl;
    @Before
    public void setUp(){
        input =  new File("/Users/Anil/IdeaProjects/Algorithms/src/main/resources/example.json");
        ouput = new File("/Users/Anil/IdeaProjects/Algorithms/src/main/resources/example.xml");
        impl = ConverterFactory.createXMLJSONConverter();
    }

    @Test
    public void convertJSONtoXML() throws IOException {
        impl.convertJSONtoXML(input, ouput);
    }

    @Test(expected = IOException.class)
    public void convertJSONtoXMLWithWrongFileName() throws IOException {
        impl.convertJSONtoXML(new File("wrong/input/location"), ouput);
    }

}
