package com.proyectos.BookGestion.service.tools;

public class ToolsMethodsService {
     public static Boolean IsEmptyOrBlankString(String param) {
        if (param.isEmpty() || param.isBlank()) {
            return true;
        }
        return false;
    }
}
