package co.samtel.usuario.gen.utils;

public class ApplicationExeption extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ApplicationExeption(){
        super();
    }

    public ApplicationExeption(String msg){
        super(msg);
    }

    public ApplicationExeption(String msg, Exception e){
        super(msg, e);
    }
}
