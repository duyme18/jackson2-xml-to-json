package com.hdd;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlToJson
{
    public static void main(String[] args)
    {
        String data = "<?xml version='1.0' encoding='UTF-8'?>"+
                "<student>"+
                "<age>11</age>"+
                "<id>12</id>"+
                "<name>hocspringboot.net</name>"+
             "</student>";
        
        try
        {
            // Create a new XmlMapper to read XML tags
            XmlMapper xmlMapper = new XmlMapper();
            
            //Reading the XML
            JsonNode jsonNode = xmlMapper.readTree(data.getBytes());
            
            //Create a new ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            
            //Get JSON as a string
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