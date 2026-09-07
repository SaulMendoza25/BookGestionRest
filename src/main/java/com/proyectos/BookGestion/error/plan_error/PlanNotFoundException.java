package com.proyectos.BookGestion.error.plan_error;

public class PlanNotFoundException extends  RuntimeException{

    public PlanNotFoundException(String messages){
        super(messages);
    }
}
