import models.MP3;
import models.Mp4;

public class Main {
    public static void main(String[] args) {

        MP3 cancion = new MP3("mi_cancion_favorita.mp3", 5.4, 320);
        Mp4 video = new Mp4("mi_video_genial.mp4", 50.0, "1920x1080");

        cancion.reproducir();
        cancion.reproducir();
        video.reproducir();

        cancion.descargar();
        video.descargar();
    }
}