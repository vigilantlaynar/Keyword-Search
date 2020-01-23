/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.searchkeyword.common;

/**
 *
 * @author Euphern_Java
 */
import java.io.File;

import javax.xml.parsers.*;

//You may be surprised by the presence of org.* packages.
//But don't be afraid, you will not have to attach any
//additional libraries. These packages come with the
//standard Java 1.6.
import org.w3c.dom.*;

public class XMLRead {
    public static void main(String[] args) throws Exception  {

        //The two lines below are just for getting an
        //instance of DocumentBuilder which we use
        //for parsing XML data
        DocumentBuilderFactory factory =
            DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Here we do the actual parsing
        Document doc = builder.parse(new File("test2.xml"));

        //Here we get the root element of XML and print out
        //the value of its 'testAttr' attribute
        Element rootElement = doc.getDocumentElement();
        System.out.println("testAttr for root element: "
            + rootElement.getAttribute("testAttr"));

        //Here we get a list of all elements named 'child'
        NodeList list = rootElement.getElementsByTagName("child");

        //Traversing all the elements from the list and printing
        //out its data
        for (int i = 0; i < list.getLength(); i++) {
            //Getting one node from the list.
            //BTW, we used method getElementsByTagName so every entry
            //in the list is effectively of type 'Element', so you could
            //cast it directly to 'Element' if you needed to.
            Node childNode = list.item(i);
            System.out.println("data in child number "+
                i+": "+childNode.getTextContent());
        }
    }
}