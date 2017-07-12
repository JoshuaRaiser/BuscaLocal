/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscalocal;

import java.util.ArrayList;

class Processador {

    private ArrayList<Tarefa> tarefas;
    private int makeSpan;

    public Processador() {
        tarefas = new ArrayList<Tarefa>();
    }

    public Processador(Processador proc) {
        tarefas = new ArrayList<Tarefa>();

        for (Tarefa tar : proc.getTarefas()) {
            tarefas.add(tar);
        }
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public float getTempoTotal() {
        makeSpan = 0;
        for (Tarefa tarefa : tarefas) {
            makeSpan += tarefa.getTempo();
        }
        return makeSpan;
    }

    public Tarefa getMelhorTarefa() {
        Tarefa t = tarefas.get(0);
        for (Tarefa tarefa : tarefas) {
            if (t.getTempo() > tarefa.getTempo()) {
                t = tarefa;
            }
        }
        return t;
    }
}
