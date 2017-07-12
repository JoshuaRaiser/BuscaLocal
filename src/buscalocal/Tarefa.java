package buscalocal;

class Tarefa {

    private static int autoId = 0;

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int aAutoId) {
        autoId = aAutoId;
    }

    private int id;
    private int tempo;

    public Tarefa() {
        id = ++autoId;
        tempo = 25 + (int) (Math.random() * 50);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

}
