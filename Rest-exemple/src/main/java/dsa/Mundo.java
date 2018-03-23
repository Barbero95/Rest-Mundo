package dsa;

import java.util.ArrayList;
import java.util.List;

public class Mundo {

   private List<Usuario> usuarioList = new ArrayList<Usuario>();

    public Mundo() {

    }

    public boolean crearUsuario(Usuario user) {
        int encontrado=0;
        for(int i=0; i<usuarioList.size();i++)
        {
            if (usuarioList.get(i)==user)
            encontrado=1;

        }

        if(encontrado==1)
            return false;
        else
        {
            usuarioList.add(user);
            return true;

        }

   }

    public boolean eliminarUsuario(String nombre) {

        for (int i = 0; i<usuarioList.size();i++) {
            if (usuarioList.get(i).getNom().equals(nombre)) {
                usuarioList.remove(i);
                return true;
            }

        }

        return false;

    }

    public Usuario consultarUsuario(String nombre) {
       int i=0;
       while(i<usuarioList.size())
        {
                if (usuarioList.get(i).getNom().equals(nombre)) {
                    return usuarioList.get(i);
                }
                i++;
        }
        return null;
    }

    public void añadirObjetoAUsuario(Usuario u, Mundo.Objeto o){

        /*
            for(int i=0;i<usuarioList.size();i++)
            {
                if(usuarioList.get(i) == u)
                {
                   usuarioList.get(i).objetoList.add(o);
                   return;
                }
            }*/
            u.objetoList.add(o);
    }

    /*public <?> consultarObjetosDeUsuario(Usuario u){

        No queda claro como hacerlo, de todas formas, si sabes hacer los demás, este es fácil

    }*/

    public Mundo.Objeto consultarObjetoDeUsuario(Usuario u, String nombreObjeto){

        for(int j=0;j<u.objetoList.size();j++) {
            if (u.objetoList.get(j).getNombre().equals(nombreObjeto)) {
                return u.objetoList.get(j);
            }
        }
        return null;
        //no hacer dos busquedas ya que tenemos el usuario, hacer u.objetoList.
        /*for(int i=0;i<usuarioList.size();i++)
        {
            if(usuarioList.get(i)==u)
            {
                for(int j=0;j<usuarioList.get(i).objetoList.size();j++)
                    if(usuarioList.get(i).objetoList.get(j).getNombre().equals(nombreObjeto))
                    {
                        return usuarioList.get(i).objetoList.get(j);
                    }
            }


        }
            return null;
            */
    }

    public boolean eliminarObjetosDeUsuario(Usuario u, String nombreObjeto){
        //Preguntar!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //Ahora poner mundo.objeto y no lo he puesto yo
        Mundo.Objeto o = consultarObjetoDeUsuario(u,nombreObjeto);
        u.objetoList.remove(o);
        return true;
        /*for(int i=0;i<usuarioList.size();i++)
        {
            if(usuarioList.get(i)==u)
            {
                for(int j=0;j<usuarioList.get(i).objetoList.size();j++) {
                    if(usuarioList.get(i).objetoList.get(j).getNombre().equals(nombreObjeto))
                    {
                        usuarioList.get(i).objetoList.remove(j);
                        return true;
                    }

                }
            }
        }
        return false;
        */
    }

    public void transferirObjetoEntreUsuarios(Usuario origen, Usuario destino, Mundo.Objeto o)
    {
        destino.objetoList.add(o);
        origen.objetoList.remove(o);
        /*
        //Cambiar el  void por el boolean para poder enviar un true o un false para ver si se ha transferido correctamente el objeto.
        int transf=0;
        for(int i=0;i<usuarioList.size();i++)
        {

            if(usuarioList.get(i)==origen)
            {
                for(int j=0;j<usuarioList.size();j++)
                {
                    if(usuarioList.get(j)==destino)
                    {
                        usuarioList.get(j).objetoList.add(o);
                        usuarioList.get(i).objetoList.remove(o);
                        transf=1;

                    }

                }

            }

        }
        if(transf==0)
            return false;
        else
            return true;
            */


    }
}

