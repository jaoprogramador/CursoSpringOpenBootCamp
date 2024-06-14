package com.example.springpatterns.patterns.behavioral.template;

public class NewUserMail extends MailTemplate{
	
	@Override
    public String issue() {
        return 
                "issue::Alta nuevo usuario";
	}
                
	@Override
    public String header() {
        return 
                "<!DOCTYPE html>"+
        		"<html lang='en' xmlns:th='http://www.thymeleaf.org'>"+
        			"<head>"+
                    "<meta charset='UTF-8'>"+
                    "<title>Nuestro equipo</title>"+
                    "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>"+
                "</head><body>"
                + "<h1>Buenos días, </h1>";
    }

    @Override
    public String body() {
        return "<h1> Gracías por confiar en nuestro servicio se ha dado de alta exitosamente </h1>";
    }
    @Override
    public String footer() {
        return 
                "Atentamente, Dpto de JAO";
	}
    @Override
	public String to() {		
		return "to::newUser@mail.com";
	}
	
	@Override
	public String from() {
		return "from::jao@mail.com";
	}
}