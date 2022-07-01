package model.album;

public class albumVo {
    private int idAlbum;
    private String nombreAlbum;
    private boolean estadoAlbum;
    private String fePubAlbum;


    public albumVo(){
    }

    public albumVo(int idAlbum, String nombreAlbum, boolean estadoAlbum){
        this.idAlbum = idAlbum;
        this.nombreAlbum = nombreAlbum;
        this.estadoAlbum = estadoAlbum;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }
    public String getFePubAlbum() {
        return fePubAlbum;
    }

    public void setFePubAlbum(String fePubAlbum) {
        this.fePubAlbum = fePubAlbum;
    }

    public boolean getEstadoAlbum() {
        return estadoAlbum;
    }

    public void setEstadoAlbum(boolean estadoAlbum) {
        this.estadoAlbum = estadoAlbum;
    }
    
}