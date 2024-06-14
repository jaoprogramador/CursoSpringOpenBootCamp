package com.jao.ws.validadni.test;
//import javax.xml.soap.*;//CON LA OPCION CHATGPT

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

public class TestValidaDNI {
	private static final String SOAP_ENDPOINT = "http://localhost:8080/17ValidaDNIWSSOAP/services/ValidarDNIWS?wsdl"; // URL del servicio SOAP

	public static void main(String[] args) {
/*FORMA CHATGPT*/
		/*try {
		// Crear una conexión SOAP
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        // Crear una solicitud SOAP
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("soap", "http://schemas.xmlsoap.org/soap/envelope/");
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("validarDNI", "", "http://service.validardni.soap.ws.jao.com");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("numeroDNI");
        soapBodyElem1.addTextNode("36090188Z");

        // Enviar la solicitud SOAP y obtener la respuesta
        SOAPMessage soapResponse = soapConnection.call(soapMessage, SOAP_ENDPOINT);

        // Convertir la respuesta SOAP a un objeto Java utilizando JAXB
        JAXBContext jaxbContext = JAXBContext.newInstance(YourResponseType.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        YourResponseType response = (YourResponseType) unmarshaller.unmarshal(soapResponse.getSOAPBody().extractContentAsDocument());

        // Aquí puedes trabajar con el objeto Java 'response'

        // Cerrar la conexión SOAP
        soapConnection.close();
    } catch (Exception e) {
        System.err.println("Error al enviar la solicitud SOAP: " + e);
        e.printStackTrace();
    }*/
		try {
	        // Crear una conexión SOAP
	        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
	        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
	
	        // URL del servicio web SOAP
	        String url = "http://localhost:8080/17ValidaDNIWSSOAP/services/ValidarDNIWS?wsdl";
	        
	        // Crear una solicitud SOAP
	        MessageFactory messageFactory = MessageFactory.newInstance();
	        SOAPMessage soapMessage = messageFactory.createMessage();
	        SOAPPart soapPart = soapMessage.getSOAPPart();
	        SOAPEnvelope envelope = soapPart.getEnvelope();
	        envelope.addNamespaceDeclaration("soap", "http://schemas.xmlsoap.org/soap/envelope/");
	        SOAPBody soapBody = envelope.getBody();
	        SOAPElement soapBodyElem = soapBody.addChildElement("validarDNI", "", "http://service.validardni.soap.ws.jao.com");
	        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("numeroDNI");
	        soapBodyElem1.addTextNode("36090188Z");
	
	        // Imprimir la solicitud SOAP
	        System.out.println("Request SOAP Message:");
	        soapMessage.writeTo(System.out);
	        System.out.println();
	
	        // Enviar la solicitud SOAP y obtener la respuesta
	        SOAPMessage soapResponse = soapConnection.call(soapMessage, url);
	
	        // Imprimir la respuesta SOAP
	        System.out.println("Response SOAP Message:");
	        soapResponse.writeTo(System.out);
	        System.out.println();
	
	        // Cerrar la conexión SOAP
	        soapConnection.close();
	    } catch (Exception e) {
	        System.err.println("Error al enviar la solicitud SOAP: " + e);
	        e.printStackTrace();
	    }
		/*FORMA POSTMAN*/
		/*OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				MediaType mediaType = MediaType.parse("text/xml; charset=utf-8");
				RequestBody body = RequestBody.create(mediaType, "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n  <soap:Body>\n    <validarDNI xmlns=\"http://service.validardni.soap.ws.jao.com\">\n      <numeroDNI>36090188Z</numeroDNI>\n    </validarDNI>\n  </soap:Body>\n</soap:Envelope>\n");
				Request request = new Request.Builder()
				  .url("http://localhost:8080/17ValidaDNIWSSOAP/services/ValidarDNIWS?wsdl")
				  .method("POST", body)
				  .addHeader("Content-Type", "text/xml; charset=utf-8")
				  .addHeader("SOAPAction", "validarDNI")
				  .build();
				Response response = client.newCall(request).execute();*/
		/*
		OkHttpClient client = new OkHttpClient();

        // Cuerpo de la solicitud SOAP
        String soapEnvelope = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://example.com/service\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <ser:YourSoapRequest>\n" +
                "         <arg0>Value</arg0>\n" +
                "      </ser:YourSoapRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        // Crear el cuerpo de la solicitud HTTP
        RequestBody requestBody = RequestBody.create(soapEnvelope, MediaType.parse("text/xml; charset=utf-8"));
        
        // Crear la solicitud HTTP
        Request request = new Request.Builder()
                .url(SOAP_ENDPOINT)
                .post(requestBody)
                .build();

        // Ejecutar la solicitud y procesar la respuesta
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                System.out.println("Respuesta del servicio:");
                System.out.println(responseBody);
            } else {
                System.err.println("Error al llamar al servicio: " + response.code() + " - " + response.message());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}


