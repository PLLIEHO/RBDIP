package study.cursach;


public class Answers {
    public String getInfo() {
        return """
                {
                    "name": "a",
                    "surname": "a",
                    "lastname": "a",
                    "nationality": "rus",
                    "eyeColor": 1,
                    "fingerprint": 1,
                    "psname": "a",
                    "pssurname": "a",
                    "pslastname": "a",
                    "pseyeColor": 1,
                    "psnationality": "rus",
                    "enname": "a",
                    "ensurname": "a",
                    "enlastname": "a",
                    "endateGaned": "2024-11-12",
                    "endateExpired": "2024-11-11",
                    "enpurpose": "Туризм",
                    "workname": "a",
                    "worksurname": "a",
                    "worklastname": "a",
                    "workcompany": "Gazprom",
                    "lugsize": 1,
                    "lugweight": 1,
                    "lugcategory": "drugs",
                    "decname": "a",
                    "decsurname": "a",
                    "declastname": "a",
                    "decsize": 1,
                    "decweight": 1,
                    "deccat": "drugs"
                }
                """;
    }

    public String getCountries() {
        return """
                [
                    {
                        "id": 1,
                        "name": "Russia",
                        "_borders_open": true
                    },
                    {
                        "id": 2,
                        "name": "France",
                        "_borders_open": false
                    }
                ]
                """;
    }

    public String getJob() {
        return """
                [
                    {
                        "type": "Сварщик",
                        "capacity": 20,
                        "company": "Gazprom"
                    }
                ]
                """;
    }

    public String getCriminal() {
        return """
                [
                    {
                        "fingerprint": 1,
                        "name": "a",
                        "surname": "a",
                        "lastname": "a",
                        "nationality": "Russia",
                        "eye_color": 1
                    }
                ]
                """;
    }

    public String getInstruction() {
        return "[{\"date_of_order\":\"2024-11-11\",\"positive_negative_type\":true,\"name\":null,\"surname\":null,\"lastname\":\"ф\",\"nationality\":\"Illegal country id: null\",\"eye_color\":null,\"job_company\":\"Illegal job id: null\",\"job_type\":\"Illegal job type: null\"}]";
    }

    public String getCustoms_param() {
        return """
                [
                    {
                        "name": "drugs",
                        "max_size": 1,
                        "max_weight": 1,
                        "_importable": false
                    },
                    {
                        "name": "money",
                        "max_size": 2,
                        "max_weight": 2,
                        "_importable": true
                    }
                ]
                """;
    }

    public String getValidate() {
        return "{\"passport\":\"\",\"entry\":\"Entry permission is expired.\",\"work\":\"No work permission needed.\",\"declaration\":\"Luggage category can not be imported.\",\"criminal\":\"ITS A CRIMINAL KILL HIM.\"}";
    }

}
