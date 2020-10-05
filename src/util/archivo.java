package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class archivo {
    
    private FileWriter archivoEscribir;
    private PrintWriter impresoraEscribir;
    
    private FileReader archivoLeer;
    private BufferedReader bufferReader;
    
    private String nombreArchivo = new String();
    private StringBuilder texto = new StringBuilder();
    
    public archivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    //Metodos
    public boolean crear() {
        try {
            setArchivoEscribir(new FileWriter(getNombreArchivo()));
            setImpresoraEscribir(new PrintWriter(getArchivoEscribir()));
        } catch (Exception e) {
            System.out.println("No se pudo crear el archivo...");
            return false;
        }
        return true;
    }
    
    public boolean abrir() {
        try {
            setArchivoLeer(new FileReader(getNombreArchivo()));
            setBufferReader(new BufferedReader(getArchivoLeer()));
        } catch (Exception e) {
            System.out.println("Archivo no encontrado...");
            return false;
        }
        return true;
    }
    
    public void leer(){
        String linea = new String();
        try {
            while((linea = getBufferReader().readLine()) != null){
                setTexto(linea);
            }
        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo...");
        }
    }
    
    public void escribir(){
        getImpresoraEscribir().println(getTexto());
    }

    public void cerrar(){
        try {
            if(getArchivoLeer() != null){
                if(getBufferReader() != null){
                    getBufferReader().close();
                }
                getArchivoLeer().close();
            }
            
            if(getArchivoEscribir() != null){
                if(getImpresoraEscribir() != null){
                    getImpresoraEscribir().close();
                }
                getArchivoEscribir().close();
            }
        } catch (Exception e) {
            System.out.println("No se pudo cerrar el archivo...");
        }
    }
    
    //Getter && Setters
    public FileWriter getArchivoEscribir() {
        return archivoEscribir;
    }
    
    public void setArchivoEscribir(FileWriter archivoEscribir) {
        this.archivoEscribir = archivoEscribir;
    }
    
    public PrintWriter getImpresoraEscribir() {
        return impresoraEscribir;
    }
    
    public void setImpresoraEscribir(PrintWriter impresoraEscribir) {
        this.impresoraEscribir = impresoraEscribir;
    }
    
    public FileReader getArchivoLeer() {
        return archivoLeer;
    }
    
    public void setArchivoLeer(FileReader archivoLeer) {
        this.archivoLeer = archivoLeer;
    }
    
    public BufferedReader getBufferReader() {
        return bufferReader;
    }
    
    public void setBufferReader(BufferedReader bufferReader) {
        this.bufferReader = bufferReader;
    }
    
    public String getNombreArchivo() {
        return nombreArchivo;
    }
    
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    public StringBuilder getTexto() {
        return texto;
    }
    
    public void setTexto(String linea) {
        this.texto.append(linea+"\n");
    }
    
}
