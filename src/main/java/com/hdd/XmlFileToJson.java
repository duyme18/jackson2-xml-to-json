package com.hdd;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlFileToJson
{
    public static void main(String[] args)
    {
        String data = "";
        try
        {
            // Read the student.xml
            data = FileUtils.readFileToString(new File("d:\\jackson\\student.xml"), "UTF-8");
            
            // Create a new XmlMapper to read XML tags
            XmlMapper xmlMapper = new XmlMapper();
            
            //Reading the XML
            JsonNode jsonNode = xmlMapper.readTree(data.getBytes());
            
            //Create a new ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            
            String value = objectMapper.writeValueAsString(jsonNode);
            
            System.out.println("*** Converting XML to JSON ***");
            System.out.println(value);
            

        } catch (JsonParseException e)
        {
            e.printStackTrace();
        } catch (JsonMappingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}