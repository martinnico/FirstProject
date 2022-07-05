package com.demo.firstproject.querys;

public class Querys {

    private Querys() {
    }
    public static final String GET_LIST_CANDIDATES_X_TECHNOLOGY =
            "SELECT c.name , c.last_name , c.document_number, c.date_of_birth, c.type_dni, cx.experience, t.name_technology\n" +
            "FROM CANDIDATE AS c\n" +
            "INNER JOIN  CANDIDATEXTECHNOLOGY cx ON\n" +
            "c.id = cx.candidate\n" +
            "INNER JOIN TECHNOLOGY t ON\n" +
            "cx.technology_model = t.id_technology\n" +
            "WHERE t.name_technology = ?1;";

}
