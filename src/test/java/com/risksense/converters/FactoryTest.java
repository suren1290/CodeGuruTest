package com.risksense.converters;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Pediredla on 11/24/16.
 */
public class FactoryTest {
    @Test
    public void testFactory(){
        XMLJSONConverterI imp = ConverterFactory.createXMLJSONConverter();
        Assert.assertNotNull(imp);
    }
}
