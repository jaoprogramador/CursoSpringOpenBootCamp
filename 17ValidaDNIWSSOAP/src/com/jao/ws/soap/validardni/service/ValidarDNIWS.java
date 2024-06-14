package com.jao.ws.soap.validardni.service;

import java.util.Arrays;
import java.util.regex.Pattern;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ValidarDNIWS {
	@WebMethod 
	public RespuestaVO validarDNI(String numeroDNI) {
        // L�gica para validar el n�mero de DNI
        // Por ejemplo, podr�as verificar si el n�mero de DNI tiene el formato correcto
        // o si est� presente en una base de datos, etc.
        // Aqu� deber�as implementar la l�gica espec�fica de validaci�n del DNI
		RespuestaVO respuesta= null;
		boolean res= valDNI(numeroDNI);
		if(res== true){
			System.out.println("El DNI " + numeroDNI + " es v�lido.");
			respuesta = new RespuestaVO(numeroDNI,"El DNI " + numeroDNI + " es v�lido.",true); 
		} else{
			System.out.println("El DNI introducido es incorrecto, por favor introduzca un DNI v�lido.");
			respuesta = new RespuestaVO(numeroDNI,"El DNI introducido es incorrecto, por favor introduzca un DNI v�lido.",false);
		}
			
		
		return respuesta;
	}
	private static final Pattern REGEXP = Pattern.compile("[0-9]{8}[A-Z]");
	  private static final String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
	  private static final String[] INVALIDOS = new String[] { "00000000T", "00000001R", "99999999R" };

	  public static boolean valDNI(String dni) {
	    return Arrays.binarySearch(INVALIDOS, dni) < 0 // (1)
		    && REGEXP.matcher(dni).matches() // (2)
	        && dni.charAt(8) == DIGITO_CONTROL.charAt(Integer.parseInt(dni.substring(0, 8)) % 23); // (3)
	  }
}
