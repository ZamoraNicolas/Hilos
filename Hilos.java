import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Hilos {
    public static void main(String[] args) {
        Proceso1 hilo1 = new Proceso1();
        Proceso2 hilo2 = new Proceso2();
        
        hilo1.start();
        hilo2.start();
    }
}

class Proceso1 extends Thread {
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Entrevista universitaria");
        System.out.println("Cual carrera escogio");
        String respuesta = scanner.nextLine();
        System.out.println("Porque escogio esta carrera");
        String respuestacarrera = scanner.nextLine();
        System.out.println("Defina en una palabra su carrera");
        String respuestadefinir = scanner.nextLine();
        System.out.println("Gracias por interesarse en nuestra universidad y por responder nuestras preguntas");
    }
}

class Proceso2 extends Thread {
    @Override
    public void run() {
        String filepath = "Dustep.wav";
	  PlayMusic(filepath);
    }

    public static void PlayMusic(String location) {
        try {
            File musicPath = new File(location);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } else {
                System.out.println("No se pudo encontrar el archivo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

