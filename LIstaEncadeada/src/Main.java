public class Main {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.insereFinal(10);
        lista.insereFinal(20);
        lista.insereFinal(30);
        lista.insereInicio(5);
        lista.insereInicio(2);
        lista.imprime();
    }
}

class Nodo {
    int elemento;
    Nodo proximo;

    public Nodo(int elemento) { // Construtor
        this.elemento = elemento;
        this.proximo = null;
    }
}

class ListaEncadeada { // Lista Encadeada
    private Nodo inicio;
    private Nodo ultimo;
    private int n_elementos;

    public ListaEncadeada() { // Construtor
        this.inicio = null;
        this.ultimo = null;
        this.n_elementos = 0;
    }

    public boolean estaVazia() { // Verifica se a lista está vazia
        return this.n_elementos == 0;
    }

    public void insereFinal(int elemento) { // Insere um elemento no final da lista
        Nodo novoNodo = new Nodo(elemento);
        if (estaVazia()) {
            inicio = novoNodo;
            ultimo = novoNodo;
        } else {
            ultimo.proximo = novoNodo;
            ultimo = novoNodo;
        }
        n_elementos++;
    }

    public void insereInicio(int elemento) { // Insere um elemento no início da lista
        Nodo novoNodo = new Nodo(elemento);
        if (estaVazia()) {
            inicio = novoNodo;
            ultimo = novoNodo;
        } else {
            novoNodo.proximo = inicio;
            inicio = novoNodo;
        }
        n_elementos++;
    }
    public void inserePosicao(int elemento, int posicao) {
        if (posicao < 0 || posicao > n_elementos) {
            System.out.println("Posição inválida");
        } else if (posicao == 0) {
            insereInicio(elemento);
        } else if (posicao == n_elementos) {
            insereFinal(elemento);
        }else{
            Nodo novoNodo = new Nodo(elemento);
            Nodo atual = inicio;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.proximo;
            }
            novoNodo.proximo = atual.proximo;
            atual.proximo = novoNodo;
            n_elementos++;
        }
    }
    public void imprime() { // Imprime a lista
        if (estaVazia()) {
            System.out.println("Lista vazia");
        } else {
            System.out.print("Lista: ");
            Nodo atual = inicio;
            while (atual != null) {
                System.out.print(atual.elemento + " ");
                atual = atual.proximo;
            }
            System.out.println();
        }
    }
}