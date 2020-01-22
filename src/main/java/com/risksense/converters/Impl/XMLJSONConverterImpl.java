package com.risksense.converters.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.risksense.converters.XMLJSONConverterI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author pediredla
 */
public class XMLJSONConverterImpl implements XMLJSONConverterI {

    /**
     * XML implementation of the converter
     *
     *
     * @param json {@link java.io.File} from which to read JSON data.
     * @param xml  {@link java.io.File} from which to write XML data.
     * @throws IOException
     */
    @Override
    public void convertJSONtoXML(File json, File xml) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = mapper.readValue(json, Map.class);
        StringBuilder sb = new StringBuilder();
        sb.append("<object>");
        Iterator it = data.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            fillData(pair, sb, mapper);
            it.remove();
        }
        sb.append("</object>");
        final String content = sb.toString();
        FileWriter fw = new FileWriter(xml.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();
    }

    private void fillData(Map.Entry obj, StringBuilder sb, ObjectMapper mapper) throws IOException {
        if (obj.getValue() != null && obj.getValue().getClass().equals(LinkedHashMap.class)) {
            Map<String, Object> next = mapper.convertValue(obj.getValue(), Map.class);
            Iterator it = next.entrySet().iterator();
            sb.append("<object name=\"" + obj.getKey() + "\">");
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                fillData(pair, sb, mapper);
                it.remove();
            }
            sb.append("</object>");
        } else if (obj.getValue() != null && obj.getValue().getClass().equals(ArrayList.class)) {
            ArrayList<Object> list = mapper.convertValue(obj.getValue(), ArrayList.class);
            sb.append("<array name=\"" + obj.getKey() + "\">");
            for (Object o : list) {
                if (o.getClass().equals(LinkedHashMap.class)) {
                    Map<String, Object> next = mapper.convertValue(o, Map.class);
                    Iterator it = next.entrySet().iterator();
                    sb.append("<object>");
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry) it.next();
                        fillData(pair, sb, mapper);
                        it.remove();
                    }
                    sb.append("</object>");
                } else if (o.getClass().equals(ArrayList.class)) {
                    sb.append("<array>");
                    sb.append("<object>");
                    fillListData(o, sb, mapper);
                    sb.append("</object>");
                    sb.append("</array>");
                } else {
                    fillListData(o, sb, mapper);
                }

            }
            sb.append("</array>");
        } else if (obj.getValue() != null && obj.getValue().getClass().equals(Boolean.class)) {
            sb.append("<boolean name=\"" + obj.getKey() + "\">");
            sb.append(obj.getValue());
            sb.append("</boolean>");
        } else if (obj.getValue() != null && obj.getValue().getClass().equals(Integer.class)) {
            if (obj.getKey() == null) {
                sb.append("<number>");
            } else {
                sb.append("<number name=\"" + obj.getKey() + "\">");
            }
            sb.append(obj.getValue());
            sb.append("</number>");
        } else if (obj.getValue() != null && obj.getValue().getClass().equals(Double.class)) {
            if (obj.getKey() == null) {
                sb.append("<number>");
            } else {
                sb.append("<number name=\"" + obj.getKey() + "\">");
            }
            sb.append(obj.getValue());
            sb.append("</number>");
        } else if (obj.getValue() != null && obj.getValue().getClass().equals(String.class)) {
            if (obj.getKey() == null) {
                sb.append("<string>");
            } else {
                sb.append("<string name=\"" + obj.getKey() + "\">");
            }
            sb.append(obj.getValue());
            sb.append("</string>");
        } else if (obj.getValue() == null) {
            sb.append("<null name=\"" + obj.getKey() + "\"/>");
        }
    }

    private void fillListData(Object obj, StringBuilder sb, ObjectMapper mapper) throws IOException {
        if (obj.getClass().equals(LinkedHashMap.class)) {
            Map<String, Object> next = mapper.convertValue(obj, LinkedHashMap.class);
            Iterator it = next.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                fillData(pair, sb, mapper);
                it.remove();
            }
        } else if (obj != null && obj.getClass().equals(ArrayList.class)) {
            ArrayList<Object> list = mapper.convertValue(obj, ArrayList.class);
            for (Object o : list) {
                fillListData(o, sb, mapper);
            }
        } else if (obj != null && obj.getClass().equals(Boolean.class)) {
            sb.append("<boolean>");
            sb.append(obj);
            sb.append("</boolean>");
        } else if (obj != null && (obj.getClass().equals(Integer.class) || obj.getClass().equals(Double.class))) {
            sb.append("<number>");
            sb.append(obj);
            sb.append("</number>");
        } else if (obj != null && obj.getClass().equals(String.class)) {
            sb.append("<string>");
            sb.append(obj);
            sb.append("</string>");
        } else if (obj == null) {
            sb.append("<null />");
        }
    }
}
