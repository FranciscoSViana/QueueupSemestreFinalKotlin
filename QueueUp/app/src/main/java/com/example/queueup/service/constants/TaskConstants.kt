package com.example.queueup.service.constants

class TaskConstants private constructor() {

    //SharedPreferences
    object SHARED {
        const val CPF_KEY = "cpf"
        const val PASSWORD_KEY = "senha"
        const val PERSON_NAME = "nome"
    }

    //Requisições API
    object HEADER {
        const val CPF_KEY = "cpf"
        const val PASSWORD_KEY = "senha"
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