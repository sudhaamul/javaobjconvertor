package sudha.pro.javaobjconvertor;

import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.w3c.dom.Document;

import entity.Checks;
import entity.Header;
import entity.P;
import entity.Smart;

// create a XML file from Java Object
public class JavaObjectToJson {

	public static void main(String[] args) throws Exception {
		
		// Property p instance - Property 1
		P p1 = new P();
		p1.setName("C1");
		p1.setP("Y");

		// Property p instance - Property 2
		P p2 = new P();
		p2.setName("C2");
		p2.setP("N");

		// List of properties
		List<P> propertyList = new LinkedList<P>();
		propertyList.add(p1);
		propertyList.add(p2);

		// Checks instance
		Checks checks = new Checks();
		checks.setP(propertyList);

		// Header instance
		Header header = new Header();
		header.setAppId(123);
		header.setName("SudhaApp");

		// Smart instance
		Smart smart = new Smart();
		smart.setHeader(header);
		smart.setChecks(checks);

		// Java object to JSON
		System.setProperty("javax.xml.bind.context.factory","org.eclipse.persistence.jaxb.JAXBContextFactory");
		
		JAXBContext contextObj = JAXBContext.newInstance(Smart.class);
		Marshaller marshallerObj = contextObj.createMarshaller();
//		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// Set JSON type
		marshallerObj.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
		marshallerObj.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);

		// Print JSON String to Console
		StringWriter sw = new StringWriter();
		marshallerObj.marshal(smart, sw); // sw.toString to be sent
		System.out.println(sw.toString());

	}

}
