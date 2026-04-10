package com.javaKodCalismaKarti;

import com.javaKodCalismaKarti.ui.KartArayuzu; //önceki clasları entegre ettik
import javax.swing.SwingUtilities; //oluşturduğumuz ve işlem yaptığımız gui yi ekledik

public class Main {
    public static void main(String[] args) {
        // Swing arayüzünü oluşturduğumuz classa entegre edip yeni bir kartarayüzü oluşturduk
        SwingUtilities.invokeLater(() -> {
            new KartArayuzu();
        });
    }
}
