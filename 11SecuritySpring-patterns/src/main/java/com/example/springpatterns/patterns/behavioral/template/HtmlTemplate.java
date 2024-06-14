package com.example.springpatterns.patterns.behavioral.template;

// tipo abstracto
public abstract class HtmlTemplate {

    public String render(){
    	//forma 1
        // return head() + body() + footer();
    	//forma 2
        /*return String.format("""
                %s
                %s
                %s
                """, head(), body(), footer());*/
    	//forma 3
    	return String.format("%s %n %s %n %s %n", head(), body(), footer());
    }

    public abstract String head();
    public abstract String body();

    public String footer(){
        return 
               " <footer> %n"+
               "     Copyright 2021 %n"+
               " </footer> </body></html> %n";
               
    };
}
