package com.example.queueup.service.listener

interface TaskListener {

    fun onListClick(id: Int)

    ////Remoção
    fun onDeleteClick(id: Int)

    //Completa a tarefa
    fun onCompleteClick(id: Int)

    //Desfaz a tarefa
    fun onUndoClick(id: Int)
}