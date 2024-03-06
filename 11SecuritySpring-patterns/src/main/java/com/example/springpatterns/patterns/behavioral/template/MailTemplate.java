package com.example.springpatterns.patterns.behavioral.template;

public abstract class MailTemplate {
	public String render(){
		return String.format("%s %n %s %n %s %n %s %n %s %n %s %n ", to(), from(), header(), issue() , body(), footer());
	}
	public abstract String to();
	public abstract String from();
	public abstract String header();
	public abstract String issue();
	public abstract String body();
	public abstract String footer();

}
