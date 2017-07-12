package buscalocal;

import java.util.ArrayList;

public class Solucao {

    private float melhorMakeSpan;
    private ArrayList<Processador> processadores;

    private Solucao() {
    }

    public Solucao(Solucao sol) {
        processadores = new ArrayList<Processador>();
        for (Processador processador : sol.getProcessadores()) {
            processadores.add(new Processador(processador));
        }
    }

    public Solucao(int mProcessadores, int nTarefas) {

        int procIndex = 0;
        processadores = new ArrayList<Processador>();

        for (int i = 0; i < mProcessadores; i++) {
            processadores.add(new Processador());
        }
        procIndex = 0;
        for (int i = 0; i < nTarefas; i++) {
            procIndex = 0;//(int) (Math.random() * mProcessadores);
            processadores.get(procIndex).getTarefas().add(new Tarefa());
        }

    }

    public Processador getMaiorMakeSpan() {
        Processador processador = processadores.get(0);
        for (Processador proc : processadores) {
            if (processador.getTempoTotal() < proc.getTempoTotal()) {
                processador = proc;
            }
        }
        return processador;
    }

    public Processador getMenorMakeSpan() {
        Processador processador = processadores.get(0);
        for (Processador proc : processadores) {
            if (processador.getTempoTotal() > proc.getTempoTotal()) {
                processador = proc;
            }
        }
        return processador;
    }

    public float getMelhorMakeSpan() {
        return this.getMenorMakeSpan().getTempoTotal();
    }

    public void setMelhorMakeSpan(float melhorMakeSpan) {
        this.melhorMakeSpan = melhorMakeSpan;
    }

    public ArrayList<Processador> getProcessadores() {
        return processadores;
    }

    public void setProcessadores(ArrayList<Processador> processadores) {
        this.processadores = processadores;
    }

    @Override
    public String toString() {
        String retorno = "";
                    
        for (int i = 0; i < processadores.size(); i++) {
            retorno += "\n> Processador [" + i + "]\n";
            for (Tarefa tarefa : processadores.get(i).getTarefas()) {
                retorno += "- Tarefa ID: " + tarefa.getId();
                if(Main.exibirTempo)
                {
                    retorno += "\tTempo execução: " + tarefa.getTempo() + "\n";
                } 
                else 
                { 
                    retorno += "\n"; 
                }
            }
            retorno +=  "\nMakeSpan: " + processadores.get(i).getTempoTotal() + "\n";
        }
        retorno += "\n---------------------------||-------------------------------\n";
        return retorno;
    }
    
    public String toStringAntes()
    {
        String retorno = "";
                    
        for (int i = 0; i < processadores.size(); i++) {
            retorno += "\n> Processador [" + i + "]\n";
            for (Tarefa tarefa : processadores.get(i).getTarefas()) {
                retorno += "- Tarefa ID: " + tarefa.getId() + "\tTempo execução: " + tarefa.getTempo() + "\n";
            }
            retorno +=  "\nMakeSpan: " + processadores.get(i).getTempoTotal() + "\n";
        }
        retorno += "\n---------------------------||-------------------------------\n";
        return retorno;
    }

}
