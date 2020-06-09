package com.example.queueup.service.constants

class TaskConstants private constructor() {

    //SharedPreferences
    object SHARED {
        const val CPF_KEY = "cpf"
        const val PASSWORD_KEY = "senha"
        const val PERSON_NAME = "nome"
    }

    object SHAREDRESTAURANT {

        const val RESTAURANT_NAME = "nome"
        const val CNPJ_KEY = "cnpj"
        const val RESTAURANT_CITY = "cidade"
        const val RESTAURANT_STATE = "estado"
        const val RESTAURANT_DISTRICT = "estado"
        const val RESTAURANT_STREET = "logradouro"
        const val RESTAURANT_NUMBER = "numEndereco"
        const val RESTAURANT_CEP = "cep"
        const val RESTAURANT_TELEPHONE = "telefoneRestaurante"
        const val PASSWORD_CNPJ = "senha"
        const val RESTAURANT_TYPE = "tipo"
        const val RESTAURANT_CAPACITY = "capacidade"
    }


    //Requisições API
    object HEADER {
        const val CPF_KEY = "cpf"
        const val PASSWORD_KEY = "senha"
    }

    object HEADERRESTAURANT {
        const val CNPJ_KEY = "cnpj"
        const val PASSWORD_CNPJ = "senha"
    }

    object HTTP {
        const val SUCCESS = 200
    }

    object BUNDLE {
        const val TASKID = "taskid"
        const val TASKFILTER = "taskfilter"
    }

    object FILTER {
        const val ALL = 0
        const val NEXT = 1
        const val EXPIRED = 2
    }
}