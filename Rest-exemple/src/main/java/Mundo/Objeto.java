package Mundo;

public class Objeto {



    private String Nombre;

    private String Tipo;

    private String Descripcion;

    private int Valor;

    private int Coste;



    public Objeto(String nombre, String tipo, String descripcion, int valor, int coste) {

        this.Nombre = nombre;

        this.Tipo = tipo;

        this.Descripcion = descripcion;

        this.Valor = valor;

        this.Coste = coste;



    }

    public void mostrarPorPantalaObjeto() {
        System.out.println("NOMBRE: "+getNombre());
        System.out.println("Tipo: "+getTipo());
        System.out.println("Descripcion: "+getDescripcion());
        System.out.println("Valor: "+getValor());
        System.out.println("Coste: "+getCoste());


    }

    public String getNombre() {



        return Nombre;

    }



    public void setNombre(String Nom) {



        this.Nombre = Nom;

    }



    public String getTipo() {



        return Tipo;

    }



    public void setTipo(String Tip) {



        this.Tipo = Tip;

    }



    public String getDescripcion() {



        return Descripcion;

    }



    public void setDescripcion(String Des) {



        this.Descripcion = Des;

    }



    public double getValor() {



        return Valor;

    }



    public void setValor(int valor) {



        this.Valor = valor;

    }



    public double getCoste() {



        return Coste;

    }



    public void setCoste(int coste) {



        this.Coste = coste;

    }

}
