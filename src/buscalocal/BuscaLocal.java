package buscalocal;

public class BuscaLocal {

    public static String realizaBusca(Solucao sol) {
        String solucao = "";
        Solucao s;

        while (true) {
            s = melhorMexida(sol);
            if (s.getMelhorMakeSpan() >= sol.getMelhorMakeSpan()) {
                sol = s;
                solucao += sol.toString();
            } else {
                solucao += "\nResultados:\n----Melhor MakeSpan: "+sol.getMelhorMakeSpan();
                solucao += "\n----Maior MakeSpan:   "+sol.getMaiorMakeSpan().getTempoTotal()+"\n";
                return solucao;
            }
        }
    }

    private static Solucao melhorMexida(Solucao sol) {

        Solucao newSol = new Solucao(sol);

        Processador maior, menor;

        maior = newSol.getMaiorMakeSpan();
        menor = newSol.getMenorMakeSpan();

        menor.getTarefas().add(maior.getMelhorTarefa());
        maior.getTarefas().remove(maior.getMelhorTarefa());

        return newSol;
    }

}
