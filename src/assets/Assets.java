package assets;

import engine.Loader;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Assets {

    public static BufferedImage defaultTexture;

    public static BufferedImage frame;
    public static BufferedImage modoSerio;

    public final static HashMap<String, BufferedImage[]> unhappyAnimation = new HashMap<>(1);
    public final static HashMap<String, BufferedImage[]> eatingExAnimation = new HashMap<>(1);
    public final static HashMap<String, BufferedImage[]> eatingNeAnimation = new HashMap<>(1);
    public final static HashMap<String, BufferedImage[]> eatingDiAnimation = new HashMap<>(1);
    public final static HashMap<String, BufferedImage[]> eatingIceCreamAnimation = new HashMap<>(1);
    public final static HashMap<String, BufferedImage[]> eatingNoAnimation = new HashMap<>(1);
    public final static HashMap<String, BufferedImage[]> sadAnimation = new HashMap<>(1);
    public final static HashMap<String, BufferedImage[]> hoppingAnimation = new HashMap<>(1);
    public final static HashMap<String, BufferedImage[]> happy2Animation = new HashMap<>(1);
    public final static HashMap<String, BufferedImage> hapDownAnimation = new HashMap<>(1);
    public final static HashMap<String, BufferedImage> fullAnimation = new HashMap<>(1);
    public final static HashMap<String, BufferedImage> lobbyImgs = new HashMap<>(4);
    public final static HashMap<String, BufferedImage> icons = new HashMap<>(2);
    public final static HashMap<String, BufferedImage[]> efectos = new HashMap<>(6);
    public final static HashMap<String, BufferedImage> backgrounds = new HashMap<>(3);

    public static Font font;
    public static BufferedImage[] cuadroAnim;
    public static BufferedImage[] clockAnim;
    public final static BufferedImage[] iconShirobabytchi = new BufferedImage[2];
    public final static BufferedImage[] panAnim = new BufferedImage[3];
    public final static BufferedImage[] carneAnim  = new BufferedImage[3];
    public final static BufferedImage[] carrotAnim = new BufferedImage[3];
    public final static BufferedImage[] heladoAnim = new BufferedImage[3];
    public final static BufferedImage[] pastelAnim = new BufferedImage[3];


    public static void initAssets() {

        // Assets Interfaz
        frame = Loader.loadImage("/ui/backgrounds/frame.png");
        modoSerio = Loader.loadImage("/player/Shirobabytchi/comidaSeria.png");

        lobbyImgs.put("header", Loader.loadImage("/ui/header.png"));
        lobbyImgs.put("foodSelector", Loader.loadImage("/ui/foodSelector.png"));
        lobbyImgs.put("efectoAseo", Loader.loadImage("/ui/efectoAseo.png"));
        lobbyImgs.put("pared", Loader.loadImage("/ui/paredFalsa.png"));

        icons.put("corazon", Loader.loadImage("/ui/iconos/corazon.png"));
        icons.put("palo", Loader.loadImage("/ui/iconos/palo.png"));

        efectos.put("cosa", new BufferedImage[]{
            Loader.loadImage("/ui/efectos/cosa1.png"),
            Loader.loadImage("/ui/efectos/cosa2.png")
        });

        efectos.put("signo", new BufferedImage[]{
            Loader.loadImage("/ui/efectos/signo1.png"),
            Loader.loadImage("/ui/efectos/signo2.png")
        });

        efectos.put("sol", new BufferedImage[]{
            Loader.loadImage("/ui/efectos/sol1.png"),
            Loader.loadImage("/ui/efectos/sol2.png")
        });

        efectos.put("pancake", new BufferedImage[]{
            Loader.loadImage("/ui/efectos/pancake1.png"),
            Loader.loadImage("/ui/efectos/pancake2.png")
        });

        efectos.put("llenura", new BufferedImage[]{
            Loader.loadImage("/ui/efectos/llenura.png")
        });

        efectos.put("rayon", new BufferedImage[]{
            Loader.loadImage("/ui/efectos/rayon1.png"),
            Loader.loadImage("/ui/efectos/rayon2.png")
        });

        backgrounds.put("backgroundRoom", Loader.loadImage("/ui/backgrounds/backgroundRoom.png"));
        backgrounds.put("backgroundStats", Loader.loadImage("/ui/backgrounds/backgroundStats.png"));
        backgrounds.put("backgroundKitchen", Loader.loadImage("/ui/backgrounds/backgroundKitchen.png"));

        font = Loader.loadFont("/font/TamagotchiFont.ttf", 32);

        // Assets Player

        for (int i = 0; i < iconShirobabytchi.length; i++) {
            iconShirobabytchi[i] = Loader.loadImage("/player/Shirobabytchi/icono" + (i + 1) +  ".png");
        }

        unhappyAnimation.put("Shirobabytchi", new BufferedImage[]{
            Loader.loadImage("/player/Shirobabytchi/depre1.png"),
            Loader.loadImage("/player/Shirobabytchi/depre2.png")
        });

        eatingExAnimation.put("Shirobabytchi", new BufferedImage[]{
            Loader.loadImage("/player/Shirobabytchi/comidaRica1.png"),
            Loader.loadImage("/player/Shirobabytchi/comidaRica2.png"),
            Loader.loadImage("/player/Shirobabytchi/comidaRica3.png"),
            modoSerio
        });

        eatingNeAnimation.put("Shirobabytchi", new BufferedImage[]{
            modoSerio,
            Loader.loadImage("/player/Shirobabytchi/comidaNeutral1.png"),
            Loader.loadImage("/player/Shirobabytchi/comidaNeutral2.png")
        });

        eatingDiAnimation.put("Shirobabytchi", new BufferedImage[]{
            Loader.loadImage("/player/Shirobabytchi/comidaDislike1.png"),
            Loader.loadImage("/player/Shirobabytchi/comidaDislike2.png"),
            Loader.loadImage("/player/Shirobabytchi/comidaDislike3.png"),
            Loader.loadImage("/player/Shirobabytchi/comidaDislike4.png"),
            modoSerio
        });

        eatingIceCreamAnimation.put("Shirobabytchi", new BufferedImage[]{
            Loader.loadImage("/player/Shirobabytchi/comidaRica1.png"),
            Loader.loadImage("/player/Shirobabytchi/comidaRica2.png"),
            Loader.loadImage("/player/Shirobabytchi/helado1.png"),
            Loader.loadImage("/player/Shirobabytchi/helado2.png"),
            modoSerio
        });

        eatingNoAnimation.put("Shirobabytchi", new BufferedImage[]{
            Loader.loadImage("/player/Shirobabytchi/comidaRechazo1.png"),
            Loader.loadImage("/player/Shirobabytchi/comidaRechazo2.png")
        });

        sadAnimation.put("Shirobabytchi", new BufferedImage[]{
            Loader.loadImage("/player/Shirobabytchi/sad1.png"),
            Loader.loadImage("/player/Shirobabytchi/sad2.png")
        });

        hapDownAnimation.put("Shirobabytchi", Loader.loadImage("/player/Shirobabytchi/hapDown.png"));
        fullAnimation.put("Shirobabytchi", Loader.loadImage("/player/Shirobabytchi/full.png"));

        hoppingAnimation.put("Shirobabytchi", new BufferedImage[]{
            Loader.loadImage("/player/Shirobabytchi/hopping1.png"),
            Loader.loadImage("/player/Shirobabytchi/hopping2.png"),
            Loader.loadImage("/player/Shirobabytchi/hopping3.png")
        });

        happy2Animation.put("Shirobabytchi", new BufferedImage[]{
            Loader.loadImage("/player/Shirobabytchi/happy2-1.png"),
            Loader.loadImage("/player/Shirobabytchi/happy2-2.png")
        });

        cuadroAnim = new BufferedImage[]{
            Loader.loadImage("/ui/cuadro2.png"),
            Loader.loadImage("/ui/cuadro1.png")
        };

        clockAnim = new BufferedImage[]{
            Loader.loadImage("/ui/reloj0.png"),
            Loader.loadImage("/ui/reloj05.png"),
            Loader.loadImage("/ui/reloj1.png"),
            Loader.loadImage("/ui/reloj15.png"),
            Loader.loadImage("/ui/reloj2.png"),
            Loader.loadImage("/ui/reloj25.png"),
            Loader.loadImage("/ui/reloj3.png"),
            Loader.loadImage("/ui/reloj35.png")
        };

        clockAnim = new BufferedImage[]{
            Loader.loadImage("/ui/reloj0.png"),
            Loader.loadImage("/ui/reloj05.png"),
            Loader.loadImage("/ui/reloj1.png"),
            Loader.loadImage("/ui/reloj15.png"),
            Loader.loadImage("/ui/reloj2.png"),
            Loader.loadImage("/ui/reloj25.png"),
            Loader.loadImage("/ui/reloj3.png"),
            Loader.loadImage("/ui/reloj35.png")
        };

        // Comida

        for (int i = 0; i < 3; i++) {
            panAnim[i] = Loader.loadImage("/ui/food/pan" + (i + 1) + ".png");
            carneAnim[i] = Loader.loadImage("/ui/food/carne" + (i + 1) + ".png");
            carrotAnim[i] = Loader.loadImage("/ui/food/carrot" + (i + 1) + ".png");
            heladoAnim[i] = Loader.loadImage("/ui/food/helado" + (i + 1) + ".png");
            pastelAnim[i] = Loader.loadImage("/ui/food/pastel" + (i + 1) + ".png");
        }

        // Textura default

        defaultTexture = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
        Graphics g = defaultTexture.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 50, 50);
    }

    public static BufferedImage reflectHorizontal(BufferedImage originalImage) {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-originalImage.getWidth(null), 0);

        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        BufferedImage reflectedImage = op.filter(originalImage, null);

        return reflectedImage;
    }
}
