package mx.edu.utez.model.pelicula;

public class BeanPelicula {

    private long id;
    private  String nombre; 
    private String descripcion; 
    private String fechaEstreno;
    private Double recaudacion;
    private int estado; 

    public BeanPelicula(long id, String nombre, String descripcion, String fechaEstreno, Double recaudacion, int estado) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.fechaEstreno = fechaEstreno;
    this.recaudacion = recaudacion;
    this.estado = estado;
    }

    public BeanPelicula() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public Double getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(Double recaudacion) {
        this.recaudacion = recaudacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}