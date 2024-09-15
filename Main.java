
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main{

    static JFrame gameWindow;
    static GraphicsPanel canvas;
    static final int WIDTH = 1380;
    static final int HEIGHT = 740;
    static int tileX = 0;
    static int tileY = 0;
    static BufferedImage playerImage;
    static int counter =0;


    static int[][] map ={{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 9, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 4, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 0, 0, 0, 0},
                            {0, 0, 0, 0, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                         
    };  

    static int[][] updatedMap = new int[map.length][map[0].length];

    static BufferedImage[] tileID = new BufferedImage[10];

    static MyKeyListener keyListener = new MyKeyListener();
    static MyMouseListener mouseListener = new MyMouseListener();
    static MyMouseMotionListener mouseMotionListener = new MyMouseMotionListener(); 


 
    static final int RUN_SPEED = 2;
    
    static int ninjaH = 31;
    static int ninjaW = 31;
    static int ninjaX = 288;
    static int ninjaY = 288;
    static int ninjaVx = 0;
    static int ninjaVy = 0;
    static int ninjaPicNum = 0;
    static BufferedImage[] ninjaPic = new BufferedImage[17];
    static int[] nextLeftPic  = {1, 2, 3, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    static int[] nextRightPic = {5, 5, 5, 5, 5, 6, 7, 8, 5, 5, 5, 5, 5, 5, 5, 5, 5}; 
    static int[] nextUpPic = {9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 11, 12, 9, 9, 9, 9, 9};
    static int[] nextDownPic = {13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 15, 16, 13};

    static int[] downZombiePic = {1,2,3,0,0,0,0,0,0,0,0,0,0,0};
    static int[] leftZombiePic = {4,4,4,4,5,6,4,4,4,4,4,4,4,4};
    static int[] rightZombiePic = {7,7,7,7,7,7,7,8,9,7,7,7,7,7};
    static int[] upZombiePic =  {10,10,10,10,10,10,10,10,10,10,11,12,13,10};

    static BufferedImage[] zombiePic = new BufferedImage[14];
    static int[] zombiePicNum;
    static int zombieH = 40;
    static int zombieW = 30;
    static int[] zombieX ;
    static int[] zombieY;
    static int zombieVx = 0;
    static int zombieVy = 0;
    static Rectangle[] zombieBox;
    static int numZombie = 0;
    static int[][][] zombiePath;
    static int currentZombie;

    static double[] zombieHP;
    static double[] zombiePercentage;
    static int[] zombieBar;

    

    static double[] elapsedTimeZombie;  
    static long[] startZombie ;
    static long[] endZombie;

    static boolean goingLeft = false;
    static boolean goingRight = false;
    static boolean goingUp = false;
    static boolean goingDown = false;

    static boolean standLeft = false;
    static boolean standRight = false;
    static boolean standUp = false;
    static boolean standDown = false;

    static String[] move;

    static int wallH = 32;
    static int wallW = 32;

    static Rectangle playerBox = new Rectangle(ninjaX, ninjaY, ninjaW, ninjaH);
    static Rectangle futureLeftPlayerHitBox = new Rectangle(ninjaX, ninjaY, ninjaW, ninjaH);
    static Rectangle futureRightPlayerHitBox = new Rectangle(ninjaX, ninjaY, ninjaW, ninjaH);
    static Rectangle futureUpPlayerHitBox = new Rectangle(ninjaX, ninjaY, ninjaW, ninjaH);
    static Rectangle futureDownPlayerHitBox = new Rectangle(ninjaX, ninjaY, ninjaW, ninjaH);



    static Rectangle[] wallBox;
    
    static double elapsedTimeMario = 0.0;  
    static long start = System.currentTimeMillis();
    static long end = 0;

    static double elapsedTimeBullet = 0.0;  
    static long startBullet = System.currentTimeMillis();
    static long endBullet = 0;

    static int numBullets = 40;    
    static int[] bulletRightX = new int[numBullets];
    static int[] bulletRightY = new int[numBullets];
    static Rectangle[] bulletRightHitBox = new Rectangle[numBullets];
    static boolean[] bulletRightVisible = new boolean[numBullets];
    static int bulletW = 1;
    static int bulletH = 10;
    static int bulletSpeed = 10;
    static int currentBulletRight = 0;

    static int[] bulletLeftX = new int[numBullets];
    static int[] bulletLeftY = new int[numBullets];
    static Rectangle[] bulletLeftHitBox = new Rectangle[numBullets];
    static boolean[] bulletLeftVisible = new boolean[numBullets];
    static int currentBulletLeft = 0;

    static int[] bulletUpX = new int[numBullets];
    static int[] bulletUpY = new int[numBullets];
    static Rectangle[] bulletUpHitBox = new Rectangle[numBullets];
    static boolean[] bulletUpVisible = new boolean[numBullets];
    static int currentBulletUp = 0;

    static int[] bulletDownX = new int[numBullets];
    static int[] bulletDownY = new int[numBullets];
    static Rectangle[] bulletDownHitBox = new Rectangle[numBullets];
    static boolean[] bulletDownVisible = new boolean[numBullets];
    static int currentBulletDown = 0;

    static boolean shooting = false;

    static boolean placeWall = false;
    static int MAX_WALL_AMOUNT = 20;
    static Rectangle[] playerWall = new Rectangle[MAX_WALL_AMOUNT];
    static int[] playerWallX = new int[MAX_WALL_AMOUNT];
    static int[] playerWallY = new int[MAX_WALL_AMOUNT];
    static int[] wallHealth = new int[MAX_WALL_AMOUNT];
    static boolean[] playerWallVisible = new boolean[MAX_WALL_AMOUNT];
    static Rectangle futureWallDownHitBox = new Rectangle(0, 0, 2, 2);
    static Rectangle futureWallUpHitBox = new Rectangle(0, 0, 2, 2);
    static Rectangle futureWallLeftHitBox = new Rectangle(0, 0, 2, 2);
    static Rectangle futureWallRightHitBox = new Rectangle(0, 0, 2, 2);
    static int currentPlayerWall = 0;
    static int wallHit = 0;
    static int playerWallInventory = 0;
    static int playerWallOnBoard = 0;

    static boolean noBlocksDestroyed = true;

    static AudioInputStream audioFireBallStream;
    static AudioInputStream audioRunStream;
    static AudioInputStream audioWallStream;
    static AudioInputStream audioMusicStream;
    static AudioInputStream audioWallBreakStream;
    static AudioInputStream audioMenuStream;
    static AudioInputStream audioEndStream;
    static AudioInputStream audioZombieHitStream;
    static AudioInputStream audioPlayerHitStream;
    static AudioInputStream audioBuyStream;
    
    static Clip shot1Sound;
    static Clip runSound;
    static Clip wallSound;
    static Clip musicSound;
    static Clip wallBreakSound;
    static Clip menuSound;
    static Clip endSong;
    static Clip zombieHitSound;
    static Clip playerHitSound;
    static Clip buySound;

    static BufferedImage playerWallPic;
    static BufferedImage bullet1RightPic;
    static BufferedImage bullet1LeftPic;
    static BufferedImage bullet1DownPic;
    static BufferedImage bullet1UpPic;

    static BufferedImage menuPic;
    static BufferedImage instructionPic;
    static BufferedImage endPic;

    static BufferedImage shopPic;


    static int playerMoney = 0;
    static int bulletDmg = 10;

    static boolean autoFire = false;
    static boolean canShoot = false;
    static boolean hasShot = false;

    static int shootingSpeed = 300;

    static int[] rightZombieMove;
    static int[] leftZombieMove;
    static int[] upZombieMove;
    static int[] downZombieMove;
    
    static  int[] playerPos = new int[2];
    static int[][] zombiePos;

    static int[] freezeCounter;

    static int mouseX;
    static int mouseY;

    static int screen = 0;

    static boolean[] unfreeze;
    static int waveCount;

    static double playerHP = 100;

    static int[] zombieAttackPicNum;
    static BufferedImage[] zombieAttackPic = new BufferedImage[12];
    static int[] nextFrozenZombie = {3,3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};
    static int[] nextLeftZombieAttack  = {1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] nextRightZombieAttack  = {3, 3, 3, 4, 5, 3, 3, 3, 3, 3, 3, 3,};
    static int[] nextDownZombieAttack  = {6, 6, 6, 6, 6, 6, 7, 8, 6, 6, 6, 6};
    static int[] nextUpZombieAttack  = {9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 11, 9};

    static long[] startAttackTime;
    static long[] endAttackTime; 
    static double[] elapsedAttackTime; 

    static long[] startFreezeTime;
    static long[] endFreezeTime;
    static double[] elapsedFreezeTime;

    static boolean[] freezeZombie;

    static BufferedImage[] frozenZombiePic = new BufferedImage[4];

    static long[] startAttackPic;
    static long[] endAttackPic;
    static double[] elapsedAttackPic;

    

    static double playerPercentage;
    static int playerBar = 25;

    static int ammo = 0;
    static int speedAmmo = 0;

    static BufferedImage heartIcon;
    static BufferedImage rapidIcon;
    static BufferedImage bulletIcon;
    static BufferedImage wallIcon;
    static boolean newWave = true;

    static boolean useHolyWater = false;
    static boolean useFireBullet = false;
    static boolean useLavaBullet = false;
    static boolean useFreezeBullet = false;


    public static void main(String[] args){

        Arrays.fill(playerWallVisible, true);
        Arrays.fill(wallHealth, 50);
        


        

        int wallCount = 0;
        int wallBoxCount = 0;

        gameWindow = new JFrame("Game Window");
        gameWindow.setResizable(false);
        gameWindow.setSize(WIDTH,HEIGHT);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        canvas = new GraphicsPanel();
        canvas.addMouseListener(mouseListener);
        canvas.addMouseMotionListener(mouseMotionListener);
        canvas.addKeyListener(keyListener);
        gameWindow.add(canvas); 
       





        for(int i = 0; i < map.length; i++){

            wallCount = wallCount + amountInArray(map[i], 4) + amountInArray(map[i], 5) + amountInArray(map[i], 6) + amountInArray(map[i], 7) + amountInArray(map[i], 8) +  amountInArray(map[i], 9);
        }

        

        wallBox = new Rectangle[wallCount];


        for(int i = 0; i < map.length; i++){

            for(int count = 0; count < map[0].length; count++){
                
                if(map[i][count] == 4 || map[i][count] == 5 || map[i][count] == 6 || map[i][count] == 7 || map[i][count] == 8 || map[i][count] == 9){

                    wallBox[wallBoxCount] = new Rectangle(i*32, count*32, wallH, wallW);

                    wallBoxCount++;
                   
                    
                  
                }


            }


        }

        for(int i = 0; i < 10; i++){

            try{
                tileID[i] = ImageIO.read(new File("images/tile" + Integer.toString(i)+ ".png"));
            } catch (IOException ex){}


        }

        for (int i=0; i<17; i++){
            try {             
                ninjaPic[i] = ImageIO.read(new File("images/ninja" + Integer.toString(i)+ ".png"));
            } catch (IOException ex){} 
        }

        for(int i = 0; i < 14; i++){

            try {             
                zombiePic[i] = ImageIO.read(new File("images/zombie" + Integer.toString(i+1)+ ".png"));
            } catch (IOException ex){} 
        }

        for(int i  = 0; i < 4; i++){
                 try {             
                frozenZombiePic[i] = ImageIO.read(new File("images/Freeze" + Integer.toString(i)+ ".png"));
            } catch (IOException ex){
               
            } 


        }



        for(int i = 0; i < zombieAttackPic.length; i++){

            try {             
                zombieAttackPic[i] = ImageIO.read(new File("images/Attack" + Integer.toString(i+1)+ ".png"));
            } catch (IOException ex){} 
        }

        try {         
            
            heartIcon = ImageIO.read(new File("images/heartIcon.png"));
            bulletIcon = ImageIO.read(new File("images/bulletIcon.png"));
            wallIcon = ImageIO.read(new File("images/playerWall.png"));
            rapidIcon = ImageIO.read(new File("images/rapidIcon.png"));

            shopPic = ImageIO.read(new File("images/shop.png"));
            menuPic = ImageIO.read(new File("images/menu.png"));
            instructionPic = ImageIO.read(new File("images/instruction.png"));
            endPic = ImageIO.read(new File("images/endScreen.png"));

            playerWallPic = ImageIO.read(new File("images/playerWall.png"));
          
            bullet1RightPic = ImageIO.read(new File("images/bullet1right.png"));
            bullet1LeftPic = ImageIO.read(new File("images/bullet1left.png"));
            bullet1DownPic = ImageIO.read(new File("images/bullet1down.png"));          
            bullet1UpPic = ImageIO.read(new File("images/bullet1Up.png"));

            File audioFileShot1 = new File("Sounds/shot1.wav");
            audioFireBallStream = AudioSystem.getAudioInputStream(audioFileShot1);
            shot1Sound = AudioSystem.getClip();
            shot1Sound.open(audioFireBallStream);
            shot1Sound.addLineListener(new shot1Listener());

            File audioPlayerHit = new File("Sounds/playerHit.wav");
            audioPlayerHitStream = AudioSystem.getAudioInputStream(audioPlayerHit);
            playerHitSound = AudioSystem.getClip();
            playerHitSound.open(audioPlayerHitStream);
            playerHitSound.addLineListener(new shot1Listener());

            File audioBuy = new File("Sounds/buySound.wav");
            audioBuyStream = AudioSystem.getAudioInputStream(audioBuy);
            buySound = AudioSystem.getClip();
            buySound.open(audioBuyStream);
            buySound.addLineListener(new shot1Listener());

            File audioFileRun = new File("Sounds/running.wav");
            audioRunStream = AudioSystem.getAudioInputStream(audioFileRun);
            runSound = AudioSystem.getClip();
            runSound.open(audioRunStream);

            File audioFileWall = new File("Sounds/placeWall.wav");
            audioWallStream = AudioSystem.getAudioInputStream(audioFileWall);
            wallSound = AudioSystem.getClip();
            wallSound.open(audioWallStream);

            File audioFileZombieHit = new File("Sounds/zombieHit.wav");
            audioZombieHitStream = AudioSystem.getAudioInputStream(audioFileZombieHit);
            zombieHitSound = AudioSystem.getClip();
            zombieHitSound.open(audioZombieHitStream);

            File audioFileMusic = new File("Sounds/gameMusic.wav");
            audioMusicStream = AudioSystem.getAudioInputStream(audioFileMusic);
            musicSound = AudioSystem.getClip();
            musicSound.open(audioMusicStream);

            File audioFileWallBreak = new File("Sounds/wallBreak.wav");
            audioWallBreakStream = AudioSystem.getAudioInputStream(audioFileWallBreak);
            wallBreakSound = AudioSystem.getClip();
            wallBreakSound.open(audioWallBreakStream);

            File audioMenu = new File("Sounds/menuSong.wav");
            audioMenuStream = AudioSystem.getAudioInputStream(audioMenu);
            menuSound = AudioSystem.getClip();
            menuSound.open(audioMenuStream);

            File audioEnd = new File("Sounds/endSong.wav");
            audioEndStream = AudioSystem.getAudioInputStream(audioEnd);
            endSong = AudioSystem.getClip();
            endSong.open(audioEndStream);

        } catch (Exception ex){} 

        FloatControl volumeShot1Sound = (FloatControl) shot1Sound.getControl(FloatControl.Type.MASTER_GAIN); 
        volumeShot1Sound.setValue(-7.0f);

        FloatControl volumePlayerHitSound = (FloatControl) playerHitSound.getControl(FloatControl.Type.MASTER_GAIN); 
        volumePlayerHitSound.setValue(+5.0f);

        FloatControl volumeRunSound = (FloatControl) runSound.getControl(FloatControl.Type.MASTER_GAIN); 
        volumeRunSound.setValue(+6.0f);

        FloatControl volumeMusicSound = (FloatControl) musicSound.getControl(FloatControl.Type.MASTER_GAIN); 
        volumeMusicSound.setValue(-10.0f);

        FloatControl volumeMenuSound = (FloatControl) menuSound.getControl(FloatControl.Type.MASTER_GAIN); 
        volumeMenuSound.setValue(-15.0f);

        FloatControl volumeWallBreakSound = (FloatControl) wallBreakSound.getControl(FloatControl.Type.MASTER_GAIN); 
        volumeMenuSound.setValue(+5.0f);


        for(int i = 0; i < map.length; i++){

            for(int count = 0; count < map[0].length; count++){

                if(map[i][count] != 1 &&  map[i][count] != 2 && map[i][count] != 3){

                    updatedMap[i][count] = -1;

                }else{

                    updatedMap[i][count] = 0;
                }


            }

        }
        
        for(int i = 0; i < map.length; i++){

            for(int count = 0; count < map[0].length; count++){


            }

        }

        gameWindow.setVisible(true);
        runGameLoop();
    
    }

    
    public static void runGameLoop(){
  
        double elapsedTime = System.currentTimeMillis();
        double testTime;
        double endTime;
      
        int deadZombieCounter;
        int[] zombieSpawn;

        boolean update = true;
        
     

        playerPos[0] = getPlayerX();
        playerPos[1] = getPlayerY();

   
        
        

       while (true) {
            gameWindow.repaint();
            try  {Thread.sleep(15);} catch(Exception e){}

            if ((screen == 0) || (screen == 2)){
                menuSound.start();
                menuSound.loop(Clip.LOOP_CONTINUOUSLY);
            } else if (screen == 1){

                menuSound.stop();
                endSong.stop();
                endSong.setFramePosition(0); 
                musicSound.start();
                musicSound.loop(Clip.LOOP_CONTINUOUSLY);

                if(playerPos[0] != getPlayerX() ||playerPos[1] != getPlayerY() ){

                    update = true;
                }

                playerPos[0] = getPlayerX();
                playerPos[1] = getPlayerY();


                if(newWave){
                    waveCount++;

            

                    if(numZombie  < 6){


                        numZombie++;

                    }

                    zombiePicNum = new int[numZombie];
                    
                     startAttackTime = new long[numZombie];
                    endAttackTime = new long[numZombie];
                    elapsedAttackTime = new double[numZombie];
                    zombieAttackPicNum = new int[numZombie];
                    startFreezeTime =  new long[numZombie];
                    endFreezeTime =  new long[numZombie];
                    elapsedFreezeTime = new double[numZombie];
                    startAttackPic = new long[numZombie];
                    endAttackPic = new long[numZombie];
                    elapsedAttackPic = new double[numZombie];
                    zombiePos = new int[numZombie][2];
                    zombiePath = new int[numZombie][2][];
                    move = new String[numZombie];
                    rightZombieMove =new int[numZombie];
                    leftZombieMove =new int[numZombie];
                    upZombieMove = new int[numZombie];
                    downZombieMove = new int[numZombie];
                    zombieX = new int[numZombie];
                    zombieY = new int[numZombie];
                    elapsedTimeZombie= new double[numZombie];  
                    startZombie = new long[numZombie];
                    endZombie = new long[numZombie];
                    zombieBox = new Rectangle[numZombie];
                    zombieHP = new double[numZombie];
                    zombiePercentage = new double[numZombie];
                    zombieBar = new int[numZombie];
                    freezeCounter = new int[numZombie];
                    unfreeze = new boolean[numZombie];
                    freezeZombie = new boolean[numZombie];

                    for(int i = 0; i < numZombie; i++){

                        leftZombieMove[i] = 0;
                        rightZombieMove[i] = 0;
                        upZombieMove[i] = 0;
                        downZombieMove[i] = 0;
                        zombiePicNum[i] = 0;
                        zombieHP[i] = 100;
                        freezeCounter[i] = 0;
                        unfreeze[i] = false;
                        freezeZombie[i] = false;

                        zombieSpawn = findSpawnableArea();
                        zombieX[i] = zombieSpawn[0];
                        zombieY[i] = zombieSpawn[1];
                        zombieBox[i] = new Rectangle(zombieX[i], zombieY[i],zombieW,zombieH);

                        zombiePos[i][0] = (zombieX[i]+15)/32;
                        zombiePos[i][1] = (zombieY[i]+20)/32;
                        zombiePath[i] = pathfind(updatedMap,zombiePos[i],playerPos);
                        
                    
                        
                    }


                    newWave = false;
                }

                for(int i = 0; i < numZombie;i++){

                    if(zombieHP[i] > 0){

                        zombiePos[i][0] = (zombieX[i]+15)/32;
                        zombiePos[i][1] = (zombieY[i]+20)/32;

                          if(update){
                            zombiePath[i] = pathfind(updatedMap,zombiePos[i],playerPos);
                           

                        }

                        try{
                            move[i] = getNextMove(zombiePath[i], zombiePos[i]);

                        }catch(Exception e){}


                        if (( rightZombieMove[i] + upZombieMove[i] +  downZombieMove[i] == 0) && ((move[i] == "left") || (leftZombieMove[i] != 0)) && !checkZombiePos(zombiePos[i][0]- 1 ,zombiePos[i][1],"zombie") && !unfreeze[i]){

                            
                            zombieX[i] = zombieX[i] - 1;
                            leftZombieMove[i] ++;
                            
                            moveLeftZombie(i);
                            if (leftZombieMove[i] == 32){
                                    leftZombieMove[i] = 0;
                            }

                            freezeCounter[i] = 0;
                            
                            

                        }else if ((leftZombieMove[i]  + upZombieMove[i] +  downZombieMove[i] == 0) && ((move[i] == "right") || (rightZombieMove[i] != 0)) &&  !checkZombiePos(zombiePos[i][0]+ 1 ,zombiePos[i][1],"zombie") && !unfreeze[i]){
                            
                            zombieX[i] = zombieX[i] + 1;
                            rightZombieMove[i] ++;
                        
                        
                            moveRightZombie(i);
                            if (rightZombieMove[i] == 32){
                                    rightZombieMove[i] = 0;
                            }
                            
                            freezeCounter[i] = 0;


                        }else if ((leftZombieMove[i] + rightZombieMove[i] + downZombieMove[i] == 0) && ((move[i] == "up") || (upZombieMove[i] != 0)) && !checkZombiePos(zombiePos[i][0]  ,zombiePos[i][1]-1 ,"zombie") && !unfreeze[i]){

                            zombieY[i] = zombieY[i] - 1;
                            upZombieMove[i]++;
                        
                            moveUpZombie(i);

                            if (upZombieMove[i] == 32){
                                upZombieMove[i] = 0;
                            }
                            freezeCounter[i] = 0;

                        }else if ((leftZombieMove[i] + rightZombieMove[i] + upZombieMove[i]  == 0) && ((move[i] == "down") || (downZombieMove[i] != 0)) && !checkZombiePos(zombiePos[i][0] ,zombiePos[i][1]+1,"zombie")&& !unfreeze[i]){

                            zombieY[i] = zombieY[i] + 1;
                            downZombieMove[i] ++;
                        
                        
                            moveDownZombie(i);
                            if (downZombieMove[i] == 32){
                                downZombieMove[i] =0;
                         
                            }

                            freezeCounter[i] = 0;
                        }else{


                            freezeCounter[i]++;
                        }

                        if(freezeCounter[i] > 75 && !freezeZombie[i]){

                            if(rightZombieMove[i] > 0){

                               

                                zombieX[i] = zombieX[i] + 1;
                                moveLeftZombie(i);
                                unfreeze[i] = true;

                                rightZombieMove[i] -- ;

                                if(rightZombieMove[i] == 0){

                                    unfreeze[i] = false;
                                    zombiePath[i] = pathfind(updatedMap,zombiePos[i],playerPos);

                                    

                                    freezeCounter[i] = 0;
                                }
                         
                               


                            
                            }else if(leftZombieMove[i] > 0){

                            
                                    zombieX[i] = zombieX[i] - 1;
                                    moveRightZombie(i);
                                    unfreeze[i] = true;

                                    leftZombieMove[i] --;

                                    if(leftZombieMove[i] == 0){
                                        unfreeze[i] = false;
                                        zombiePath[i] = pathfind(updatedMap,zombiePos[i],playerPos);
                                        

                                        freezeCounter[i] = 0;
                                    }




                            }else if(downZombieMove[i] > 0){

                              

                                    zombieY[i] = zombieY[i] -1;
                                    moveUpZombie(i);
                                    unfreeze[i] = true;

                                    downZombieMove[i] --;

                                    if(downZombieMove[i] == 0){

                                        unfreeze[i] = false;
                                        zombiePath[i] = pathfind(updatedMap,zombiePos[i],playerPos);

                                        freezeCounter[i] = 0;
                                    }
                       

                               

                            }else if(upZombieMove[i] > 0){

                                

                                    zombieY[i] = zombieY[i] + 1;
                                    moveDownZombie(i);
                                    unfreeze[i] = true;

                                    upZombieMove[i]--;

                                    if(upZombieMove[i] == 0){
                                        zombiePath[i] = pathfind(updatedMap,zombiePos[i],playerPos);

                                        unfreeze[i] = false;
                                        freezeCounter[i] = 0;

                                    }
                                

                            }


                


                        }

                        zombiePos[i][0] = (zombieX[i]+15)/32;
                        zombiePos[i][1] = (zombieY[i]+20)/32;

                        zombieBox[i].setLocation(zombieX[i], zombieY[i]);
                        
                        zombiePercentage[i] = 25 * (zombieHP[i]/100);
                        zombieBar[i] = (int) zombiePercentage[i];


                        if(freezeZombie[i]){

                            endFreezeTime[i] =  System.currentTimeMillis();
                            elapsedFreezeTime[i] =  endFreezeTime[i] - startFreezeTime[i];

                            if(elapsedFreezeTime[i] > 4000){

                                freezeZombie[i] = false;

                            }
                        

                        }


                    }
                }
                update = false;

                deadZombieCounter = 0;
                    

                for(int count = 0; count < numZombie; count++){

                    if(zombieHP[count] <= 0){
                        
                        deadZombieCounter++;
                    }
                }

                if(deadZombieCounter  == numZombie){


                    newWave = true;
                }

                bulletMovement();
                wallPlacement();
                characterMovement();
                bulletShopSystem();

                playerPercentage = 25 * (playerHP/100);
                playerBar = (int) playerPercentage;

                

                for (int i = 0; i < numZombie; i++){
                    if (checkCollisionPlayer(zombieBox[i])){

                        if (startAttackTime[i] == 0){
                            playerHitSound.stop();
                            playerHitSound.flush();              
                            playerHitSound.setFramePosition(0);  
                            playerHitSound.start();
                            playerHP = playerHP - 10;
                            startAttackTime[i] = System.currentTimeMillis(); 
                        } 
                        
                        if (elapsedAttackTime[i]/1000 > 1){
                            playerHitSound.stop();
                            playerHitSound.flush();              
                            playerHitSound.setFramePosition(0);  
                            playerHitSound.start();
                            playerHP = playerHP - 10;
                            startAttackTime[i] = System.currentTimeMillis(); 
                        }

                        if (startAttackPic[i] == 0){
                            startAttackPic[i] = System.currentTimeMillis();
                        } 

                        if (elapsedAttackPic[i]/200 > 1){
                            if ((zombiePicNum[i] >= 7) && (zombiePicNum[i] <= 9)){

                                zombieAttackPicNum[i] = nextRightZombieAttack[zombieAttackPicNum[i]];
                            } else if ((zombiePicNum[i] >= 4) && (zombiePicNum[i] <= 6)){

                                zombieAttackPicNum[i] = nextLeftZombieAttack[zombieAttackPicNum[i]];
                            }  else if ((zombiePicNum[i] >= 0) && (zombiePicNum[i] <= 3)){

                                zombieAttackPicNum[i] = nextDownZombieAttack[zombieAttackPicNum[i]];
                            }  else if ((zombiePicNum[i] >= 10) && (zombiePicNum[i] <= 13)){

                                zombieAttackPicNum[i] = nextUpZombieAttack[zombieAttackPicNum[i]];
                            }
                            startAttackPic[i] = System.currentTimeMillis();
                        }
                        
                        endAttackPic[i] = System.currentTimeMillis();
                        elapsedAttackPic[i] = endAttackPic[i] - startAttackPic[i];
                        
                        endAttackTime[i] = System.currentTimeMillis();
                        elapsedAttackTime[i] = endAttackTime[i] - startAttackTime[i];
                        
                    } else {
                        startAttackTime[i] = 0;
                        startAttackPic[i] = 0;
                    }
                    
                }
                if(playerHP <= 0 ){
                    screen = 3;

                }

              
            } else if (screen == 3){
                musicSound.stop();
                musicSound.setFramePosition(0); 
                runSound.stop();
                endSong.start();
                endSong.loop(Clip.LOOP_CONTINUOUSLY);
            }
        }
    } // runGameLoop method end

    public static void bulletShopSystem(){
        if (useHolyWater){
            bulletDmg = 50;
            try {
                bullet1DownPic = ImageIO.read(new File("images/holyBulletDown.png"));
                bullet1UpPic = ImageIO.read(new File("images/holyBulletUp.png"));
                bullet1LeftPic = ImageIO.read(new File("images/holyBulletLeft.png"));
                bullet1RightPic = ImageIO.read(new File("images/holyBulletRight.png"));
            } catch (IOException ex){} 
        } else if (useFireBullet){
            bulletDmg = 15;
            try {
                bullet1DownPic = ImageIO.read(new File("images/fireBulletDown.png"));
                bullet1UpPic = ImageIO.read(new File("images/fireBulletUp.png"));
                bullet1LeftPic = ImageIO.read(new File("images/fireBulletLeft.png"));
                bullet1RightPic = ImageIO.read(new File("images/fireBulletRight.png"));
            } catch (IOException ex){} 
        } else if (useLavaBullet){
            bulletDmg = 25;
            try {
                bullet1DownPic = ImageIO.read(new File("images/lavaBullet.png"));
                bullet1UpPic = ImageIO.read(new File("images/lavaBullet.png"));
                bullet1LeftPic = ImageIO.read(new File("images/lavaBullet.png"));
                bullet1RightPic = ImageIO.read(new File("images/lavaBullet.png"));
            } catch (IOException ex){} 
        } else if (useFreezeBullet){
            bulletDmg = 20;
            try {
                bullet1DownPic = ImageIO.read(new File("images/snowBulletDown.png"));
                bullet1UpPic = ImageIO.read(new File("images/snowBulletUp.png"));
                bullet1LeftPic = ImageIO.read(new File("images/snowBulletLeft.png"));
                bullet1RightPic = ImageIO.read(new File("images/snowBulletRight.png"));
            } catch (IOException ex){} 
        }
        if ((ammo <= 0) && (useHolyWater)){
            useHolyWater = false;
        }
        if ((ammo <= 0) && (useFireBullet)){
            useFireBullet = false;
        }
        if ((ammo <= 0) && (useLavaBullet)){
            useLavaBullet = false;
        }
        if ((ammo <= 0) && (useFreezeBullet)){
            useFreezeBullet = false;
        }
        if ((ammo <= 0) && !(useHolyWater) && !(useFireBullet) && !(useLavaBullet) && !(useFreezeBullet)){
            bulletDmg = 10;
            try {
                bullet1RightPic = ImageIO.read(new File("images/bullet1right.png"));
                bullet1LeftPic = ImageIO.read(new File("images/bullet1left.png"));
                bullet1DownPic = ImageIO.read(new File("images/bullet1down.png"));          
                bullet1UpPic = ImageIO.read(new File("images/bullet1Up.png"));
            } catch (IOException ex){} 
        }
        if (speedAmmo <= 0){
            shootingSpeed = 300;
        }
    }
    public static void restartGame(){

        newWave = true;
        waveCount = 0;
        numZombie = 0;
        playerMoney = 0;
        ammo = 0;
        speedAmmo = 0;
        playerHP = 100;
        ninjaX = 288;
        ninjaY = 288;
        playerWallOnBoard = 0;
        playerWallInventory = 0;

        Arrays.fill(playerWall, null);
        Arrays.fill(wallHealth, 50);
        Arrays.fill(playerWallX, 0);
        Arrays.fill(playerWallY, 0);
        Arrays.fill(playerWallVisible, true);

    }

   public static void bulletMovement(){

        if ((elapsedTimeBullet/shootingSpeed > 1) && (canShoot)){
           
            if ((shooting) && (ninjaVy == 0) && ((ninjaPicNum == 6) || (goingRight))){
                if (ammo > 0){
                    ammo--;
                }  
                if (speedAmmo > 0){
                    speedAmmo--;
                }  
                bulletRightX[currentBulletRight] = ninjaX + ninjaW/2 - bulletW/2;
                bulletRightY[currentBulletRight] = ninjaY + 25;
                bulletRightVisible[currentBulletRight] = true;
                currentBulletRight = (currentBulletRight + 1)%numBullets;
                shot1Sound.stop();
                shot1Sound.flush();              
                shot1Sound.setFramePosition(0);  
                shot1Sound.start();
                if (!(autoFire)){
                    shooting = false;
                }
                hasShot = true;
            } else if ((shooting) && (ninjaVy == 0) && ((ninjaPicNum == 4) || (goingLeft))){
                if (ammo > 0){
                    ammo--;
                }  
                if (speedAmmo > 0){
                    speedAmmo--;
                }  
                bulletLeftX[currentBulletLeft] = ninjaX + ninjaW/2 - bulletW/2;
                bulletLeftY[currentBulletLeft] = ninjaY + 25;
                bulletLeftVisible[currentBulletLeft] = true;
                currentBulletLeft = (currentBulletLeft + 1)%numBullets;
                shot1Sound.stop();
                shot1Sound.flush();              // clear the buffer with audio data
                shot1Sound.setFramePosition(0);  // prepare to start from the beginning
                shot1Sound.start();
                if (!(autoFire)){
                    shooting = false;
                }
                hasShot = true;
            } else if ((shooting) && (ninjaVx == 0) && ((ninjaPicNum == 0) || (goingDown))){
                if (ammo > 0){
                    ammo--;
                }  
                if (speedAmmo > 0){
                    speedAmmo--;
                }  
                bulletDownX[currentBulletDown] = ninjaX + 10;
                bulletDownY[currentBulletDown] = ninjaY + ninjaH;
                bulletDownVisible[currentBulletDown] = true;
                currentBulletDown = (currentBulletDown + 1)%numBullets;
                shot1Sound.stop();
                shot1Sound.flush();              // clear the buffer with audio data
                shot1Sound.setFramePosition(0);  // prepare to start from the beginning
                shot1Sound.start();
                if (!(autoFire)){
                    shooting = false;
                }
                hasShot = true;
            } else if ((shooting) && (ninjaVx == 0) && ((ninjaPicNum == 10) || (goingUp))){
                if (ammo > 0){
                    ammo--;
                }  
                if (speedAmmo > 0){
                    speedAmmo--;
                }  
                bulletUpX[currentBulletUp] = ninjaX + ninjaW/2 - bulletW/2;
                bulletUpY[currentBulletUp] = ninjaY + 25;
                bulletUpVisible[currentBulletUp] = true;
                currentBulletUp = (currentBulletUp + 1)%numBullets;
                shot1Sound.stop();
                shot1Sound.flush();              // clear the buffer with audio data
                shot1Sound.setFramePosition(0);  // prepare to start from the beginning
                shot1Sound.start();
                if (!(autoFire)){
                    shooting = false;
                }
                hasShot = true;
            }    
            startBullet = System.currentTimeMillis();  
        }   
        endBullet = System.currentTimeMillis();
        elapsedTimeBullet = endBullet - startBullet; 


            for (int i=0; i<numBullets; i++){
                if (bulletRightVisible[i]){
                    bulletRightX[i] = bulletRightX[i] + bulletSpeed;
                    bulletRightHitBox[i] = new Rectangle(bulletRightX[i], bulletRightY[i], bulletH, bulletW);
                    if (checkCollisionPlayerWall(bulletRightHitBox[i])) {
                        wallHealth[wallHit] = wallHealth[wallHit] - 10;
                        bulletRightVisible[i] = false;
                        if (wallHealth[wallHit] <= 0){
                            playerWallOnBoard--;
                            wallBreakSound.stop();
                            wallBreakSound.flush();              
                            wallBreakSound.setFramePosition(0);  
                            wallBreakSound.start();
                            playerWallVisible[wallHit] = false;
                            updatedMap[playerWallX[wallHit]/32][playerWallY[wallHit]/32] =0 ;
                            playerWallX[wallHit] = 3000;
                            playerWallY[wallHit] = 3000;
                            playerWall[wallHit] = new Rectangle(playerWallX[wallHit],playerWallY[wallHit],wallH,wallW);
                        }
                    }
                    if (checkCollision(bulletRightHitBox[i])) {
                        bulletRightVisible[i] = false;
                    }
                      
                    currentZombie = checkCollisionZombie(bulletRightHitBox[i]);

                    if(currentZombie != -1){
 
                        zombieHitSound.stop();
                        zombieHitSound.flush();              
                        zombieHitSound.setFramePosition(0); 
                        zombieHitSound.start();

                        bulletRightVisible[i] = false;

                        if(bulletDmg == 20){

                            unfreeze[currentZombie] = true;
                            freezeZombie[currentZombie] = true;
                            startFreezeTime[currentZombie] =  System.currentTimeMillis(); 

                        }
                        
                        zombieHP[currentZombie] = zombieHP[currentZombie] - bulletDmg;
                        if(zombieHP[currentZombie] <= 0){
                            zombieBox[currentZombie].setLocation(3000, 3000);
                            zombiePos[currentZombie][0] = 0;
                            zombiePos[currentZombie][1] = 0;
                            playerMoney = playerMoney + 50;

                        }
                    }

          
                }
                if (bulletLeftVisible[i]){
                    bulletLeftX[i] = bulletLeftX[i] - bulletSpeed;
                    bulletLeftHitBox[i] = new Rectangle(bulletLeftX[i], bulletLeftY[i], bulletH, bulletW);
                    if (checkCollisionPlayerWall(bulletLeftHitBox[i])) {
                        wallHealth[wallHit] = wallHealth[wallHit] - 10;
                        bulletLeftVisible[i] = false;
                        if (wallHealth[wallHit] <= 0){
                            playerWallOnBoard--;
                            wallBreakSound.stop();
                            wallBreakSound.flush();              
                            wallBreakSound.setFramePosition(0);  
                            wallBreakSound.start();
                            playerWallVisible[wallHit] = false;
                            updatedMap[playerWallX[wallHit]/32][playerWallY[wallHit]/32] = 0 ;
                            playerWallX[wallHit] = 3000;
                            playerWallY[wallHit] = 3000;
                            playerWall[wallHit] = new Rectangle(playerWallX[wallHit],playerWallY[wallHit],wallH,wallW);
                        }
                    }
                    if (checkCollision(bulletLeftHitBox[i])) {
                        bulletLeftVisible[i] = false;
                    
                    }        

                    currentZombie =checkCollisionZombie(bulletLeftHitBox[i]);

                    if(currentZombie != -1){
                        zombieHitSound.stop();
                        zombieHitSound.flush();              
                        zombieHitSound.setFramePosition(0); 
                        zombieHitSound.start();

                        bulletLeftVisible[i] = false;

                        
                        if(bulletDmg == 20){

                            unfreeze[currentZombie] = true;
                            freezeZombie[currentZombie] = true;
                            startFreezeTime[currentZombie] =  System.currentTimeMillis(); 

                        }
                        
                        zombieHP[currentZombie] = zombieHP[currentZombie] - bulletDmg;

                           if(zombieHP[currentZombie] <= 0){
                                zombieBox[currentZombie].setLocation(3000, 3000);
                                zombiePos[currentZombie][0] = 0;
                                zombiePos[currentZombie][1] = 0;
                                playerMoney = playerMoney + 50;
                        }
                    }
            



                }
                if (bulletDownVisible[i]){
                    bulletDownY[i] = bulletDownY[i] + bulletSpeed;
                    bulletDownHitBox[i] = new Rectangle(bulletDownX[i], bulletDownY[i], bulletW, bulletH);
                    if (checkCollisionPlayerWall(bulletDownHitBox[i])) {
                        wallHealth[wallHit] = wallHealth[wallHit] - 10;
                        bulletDownVisible[i] = false;
                        if (wallHealth[wallHit] <= 0){
                            playerWallOnBoard--;
                            wallBreakSound.stop();
                            wallBreakSound.flush();              
                            wallBreakSound.setFramePosition(0);  
                            wallBreakSound.start();
                            playerWallVisible[wallHit] = false;
                            updatedMap[playerWallX[wallHit]/32][playerWallY[wallHit]/32] =0 ;
                            playerWallX[wallHit] = 3000;
                            playerWallY[wallHit] = 3000;
                            playerWall[wallHit] = new Rectangle(playerWallX[wallHit],playerWallY[wallHit],wallH,wallW);
                        }
                    }
                    if (checkCollision(bulletDownHitBox[i])) {
                        bulletDownVisible[i] = false;
                    }

                    currentZombie =checkCollisionZombie(bulletDownHitBox[i]);

                    if(currentZombie != -1){

                        zombieHitSound.stop();
                        zombieHitSound.flush();              
                        zombieHitSound.setFramePosition(0); 
                        zombieHitSound.start();
                        bulletDownVisible[i] = false;
                        zombieHP[currentZombie] = zombieHP[currentZombie] - bulletDmg;

                        
                        if(bulletDmg == 20){

                            unfreeze[currentZombie] = true;
                            freezeZombie[currentZombie] = true;
                            startFreezeTime[currentZombie] =  System.currentTimeMillis(); 

                        }
                        if(zombieHP[currentZombie] <= 0){
                            zombieBox[currentZombie].setLocation(3000, 3000);
                            zombiePos[currentZombie][0] = 0;
                            zombiePos[currentZombie][1] = 0;
                            playerMoney = playerMoney + 50;
                        }
                    }

                }
                if (bulletUpVisible[i]){
                    bulletUpY[i] = bulletUpY[i] - bulletSpeed;
                    bulletUpHitBox[i] = new Rectangle(bulletUpX[i], bulletUpY[i], bulletW, bulletH);

                    if (checkCollisionPlayerWall(bulletUpHitBox[i])) {
                        wallHealth[wallHit] = wallHealth[wallHit] - 10;
                        bulletUpVisible[i] = false;

                        if (wallHealth[wallHit] <= 0){
                            playerWallOnBoard--;
                            wallBreakSound.stop();
                            wallBreakSound.flush();              
                            wallBreakSound.setFramePosition(0);  
                            wallBreakSound.start();
                            playerWallVisible[wallHit] = false;
                            updatedMap[playerWallX[wallHit]/32][playerWallY[wallHit]/32] =0 ;
                            playerWallX[wallHit] = 3000;
                            playerWallY[wallHit] = 3000;
                            playerWall[wallHit] = new Rectangle(playerWallX[wallHit],playerWallY[wallHit],wallH,wallW);
                        }
                    }

                    if (checkCollision(bulletUpHitBox[i])) {
                        bulletUpVisible[i] = false;
                    }
                    
                    currentZombie =checkCollisionZombie(bulletUpHitBox[i]);

                    if(currentZombie != -1){
                        zombieHitSound.stop();
                        zombieHitSound.flush();              
                        zombieHitSound.setFramePosition(0); 
                        zombieHitSound.start();

                        bulletUpVisible[i] = false;
                        zombieHP[currentZombie] = zombieHP[currentZombie] - bulletDmg;
                        
                        if(bulletDmg == 20){

                            unfreeze[currentZombie] = true;
                            freezeZombie[currentZombie] = true;
                            startFreezeTime[currentZombie] =  System.currentTimeMillis(); 

                        }

                        if(zombieHP[currentZombie] <= 0){

                            zombieBox[currentZombie].setLocation(3000, 3000);
                            zombiePos[currentZombie][0] = 0;
                            zombiePos[currentZombie][1] = 0;
                            playerMoney = playerMoney + 50;
                        }
                    }

           
                }

       
            }     
    }
    public static void wallPlacement(){

        futureWallDownHitBox = new Rectangle(ninjaX + ninjaW/2, ninjaY + ninjaH + wallH-1, 2, 2);
        futureWallUpHitBox = new Rectangle(ninjaX + ninjaW/2, ninjaY - wallH, 2, 2);
        futureWallRightHitBox = new Rectangle(ninjaX + ninjaW + wallW-1, ninjaY + ninjaH/2, 2, 2);
        futureWallLeftHitBox = new Rectangle(ninjaX - wallW, ninjaY + ninjaH/2, 2, 2);        
        if ((playerWallOnBoard < 20) && (playerWallInventory !=0) && (placeWall) && ((ninjaPicNum == 0) || (goingDown)) && !(checkCollision(futureWallDownHitBox)) && (!(checkCollisionPlayerWall(futureWallDownHitBox)))){
            futureWallDownHitBox = new Rectangle(ninjaX + ninjaW/2, ninjaY + ninjaH + wallH-1, wallW, wallH);
            if ((checkCollisionZombie(futureWallDownHitBox) == -1)){
                for (int i=0; i<MAX_WALL_AMOUNT; i++){
                    if (playerWallX[i] == 3000){
                        playerWallInventory--;
                        playerWallOnBoard++;
                        wallSound.stop();
                        wallSound.flush();              
                        wallSound.setFramePosition(0); 
                        wallSound.start();
                        wallHealth[i] = 50;
                        playerWallX[i] = (ninjaX + ninjaW/2)/32;
                        playerWallX[i] = playerWallX[i]*32;
                        playerWallY[i] = (ninjaY + ninjaH)/32;
                        playerWallY[i] = (playerWallY[i]+1)*32;
                        updatedMap[playerWallX[i]/32][playerWallY[i]/32] = -1;
                    
                        playerWallVisible[i] = true;
                        playerWall[i] = new Rectangle(playerWallX[i],playerWallY[i],wallH,wallW);
                        noBlocksDestroyed = false;
                        i = MAX_WALL_AMOUNT;
                    } else {
                        noBlocksDestroyed = true;
                    }
                }
                if (noBlocksDestroyed){
                    playerWallInventory--;
                    playerWallOnBoard++;
                    wallSound.stop();
                    wallSound.flush();              // clear the buffer with audio data
                    wallSound.setFramePosition(0);  // prepare to start from the beginning
                    wallSound.start();
                    playerWallX[currentPlayerWall%MAX_WALL_AMOUNT] = (ninjaX + ninjaW/2)/32;
                    playerWallX[currentPlayerWall%MAX_WALL_AMOUNT] = playerWallX[currentPlayerWall%MAX_WALL_AMOUNT]*32;
                    playerWallY[currentPlayerWall%MAX_WALL_AMOUNT] = (ninjaY + ninjaH)/32;
                    playerWallY[currentPlayerWall%MAX_WALL_AMOUNT] = (playerWallY[currentPlayerWall%MAX_WALL_AMOUNT]+1)*32;

                    updatedMap[ playerWallX[currentPlayerWall%MAX_WALL_AMOUNT]/32][ playerWallY[currentPlayerWall%MAX_WALL_AMOUNT]/32] =-1;
                    playerWall[currentPlayerWall%MAX_WALL_AMOUNT] = new Rectangle(playerWallX[currentPlayerWall%MAX_WALL_AMOUNT],playerWallY[currentPlayerWall%MAX_WALL_AMOUNT],wallH,wallW);
                    currentPlayerWall++;
                }
            }
        } else if ((playerWallOnBoard < 20) && (playerWallInventory !=0) && (placeWall) && ((ninjaPicNum == 10) || (goingUp)) && !(checkCollision(futureWallUpHitBox)) && !(checkCollision(futureWallUpHitBox)) && !(checkCollisionPlayerWall(futureWallUpHitBox))){
            futureWallUpHitBox = new Rectangle(ninjaX + ninjaW/2, ninjaY - wallH, wallW, wallH);
            if ((checkCollisionZombie(futureWallUpHitBox) == -1)){
                for (int i=0; i<MAX_WALL_AMOUNT; i++){
                    if (playerWallX[i] == 3000){
                        playerWallInventory--;
                        playerWallOnBoard++;
                        wallSound.stop();
                        wallSound.flush();              // clear the buffer with audio data
                        wallSound.setFramePosition(0);  // prepare to start from the beginning
                        wallSound.start();
                        wallHealth[i] = 50;
                        playerWallX[i] = (ninjaX + ninjaW/2)/32;
                        playerWallX[i] = playerWallX[i]*32;
                        playerWallY[i] = ninjaY/32;
                        playerWallY[i] = (playerWallY[i]-1)*32;
                        updatedMap[playerWallX[i]/32][playerWallY[i]/32] =-1;
                        playerWallVisible[i] = true;
                        playerWall[i] = new Rectangle(playerWallX[i],playerWallY[i],wallH,wallW);
                        noBlocksDestroyed = false;
                        i = MAX_WALL_AMOUNT;
                    } else {
                        noBlocksDestroyed = true;
                    }
                }
                if (noBlocksDestroyed){
                    playerWallInventory--;
                    playerWallOnBoard++;
                    wallSound.stop();
                    wallSound.flush();              // clear the buffer with audio data
                    wallSound.setFramePosition(0);  // prepare to start from the beginning
                    wallSound.start();
                    playerWallX[currentPlayerWall%MAX_WALL_AMOUNT] = (ninjaX + ninjaW/2)/32;
                    playerWallX[currentPlayerWall%MAX_WALL_AMOUNT] = playerWallX[currentPlayerWall%MAX_WALL_AMOUNT]*32;
                    playerWallY[currentPlayerWall%MAX_WALL_AMOUNT] = ninjaY/32;
                    playerWallY[currentPlayerWall%MAX_WALL_AMOUNT] = (playerWallY[currentPlayerWall%MAX_WALL_AMOUNT]-1)*32;
                    updatedMap[ playerWallX[currentPlayerWall%MAX_WALL_AMOUNT]/32][ playerWallY[currentPlayerWall%MAX_WALL_AMOUNT]/32] =-1;
                    playerWall[currentPlayerWall%MAX_WALL_AMOUNT] = new Rectangle(playerWallX[currentPlayerWall%MAX_WALL_AMOUNT],playerWallY[currentPlayerWall%MAX_WALL_AMOUNT],wallH,wallW);
                    currentPlayerWall++;
                }
            }
        } else if ((playerWallOnBoard < 20) && (playerWallInventory > 0) && (placeWall) && ((ninjaPicNum == 6) || (goingRight)) && !(checkCollision(futureWallRightHitBox)) && !(checkCollisionPlayerWall(futureWallRightHitBox))){
            futureWallRightHitBox = new Rectangle(ninjaX + ninjaW + wallW-1, ninjaY + ninjaH/2, wallW, wallH); 

            if ((checkCollisionZombie(futureWallRightHitBox) == -1)){
                for (int i=0; i<MAX_WALL_AMOUNT; i++){
                    if (playerWallX[i] == 3000){
                        playerWallInventory--;
                        playerWallOnBoard++;
                        wallSound.stop();
                        wallSound.flush();              // clear the buffer with audio data
                        wallSound.setFramePosition(0);  // prepare to start from the beginning
                        wallSound.start();
                        wallHealth[i] = 50;
                        playerWallX[i] = (ninjaX + ninjaW)/32;
                        playerWallX[i] = (playerWallX[i]+1)*32;
                        playerWallY[i] = (ninjaY + ninjaH/2)/32;
                        playerWallY[i] = playerWallY[i]*32;
                        playerWallVisible[i] = true;
                        updatedMap[playerWallX[i]/32][playerWallY[i]/32] =-1;
                        playerWall[i] = new Rectangle(playerWallX[i],playerWallY[i],wallH,wallW);
                        noBlocksDestroyed = false;
                        i = MAX_WALL_AMOUNT;
                    } else {
                        noBlocksDestroyed = true;
                    }
                }
                if (noBlocksDestroyed){
                    playerWallInventory--;
                    playerWallOnBoard++;
                    wallSound.stop();
                    wallSound.flush();              // clear the buffer with audio data
                    wallSound.setFramePosition(0);  // prepare to start from the beginning
                    wallSound.start();
                    playerWallX[currentPlayerWall%MAX_WALL_AMOUNT] = (ninjaX + ninjaW)/32;
                    playerWallX[currentPlayerWall%MAX_WALL_AMOUNT] = (playerWallX[currentPlayerWall%MAX_WALL_AMOUNT]+1)*32;
                    playerWallY[currentPlayerWall%MAX_WALL_AMOUNT] = (ninjaY + ninjaH/2)/32;
                    playerWallY[currentPlayerWall%MAX_WALL_AMOUNT] = playerWallY[currentPlayerWall%MAX_WALL_AMOUNT]*32;
                    updatedMap[ playerWallX[currentPlayerWall%MAX_WALL_AMOUNT]/32][ playerWallY[currentPlayerWall%MAX_WALL_AMOUNT]/32] =-1;
                    playerWall[currentPlayerWall%MAX_WALL_AMOUNT] = new Rectangle(playerWallX[currentPlayerWall%MAX_WALL_AMOUNT],playerWallY[currentPlayerWall%MAX_WALL_AMOUNT],wallH,wallW);
                    currentPlayerWall++;
                }
            }
        } else if ((playerWallOnBoard < 20) && (playerWallInventory !=0) && (placeWall) && ((ninjaPicNum == 4) || (goingLeft)) && !(checkCollision(futureWallLeftHitBox)) && !(checkCollisionPlayerWall(futureWallLeftHitBox))){
            futureWallLeftHitBox = new Rectangle(ninjaX - wallW, ninjaY + ninjaH/2, 2, 2);        

            if ((checkCollisionZombie(futureWallLeftHitBox) == -1)){
                for (int i=0; i<MAX_WALL_AMOUNT; i++){
                    if (playerWallX[i] == 3000){
                        playerWallInventory--;
                        playerWallOnBoard++;
                        wallSound.stop();
                        wallSound.flush();              // clear the buffer with audio data
                        wallSound.setFramePosition(0);  // prepare to start from the beginning
                        wallSound.start();
                        wallHealth[i] = 50;
                        playerWallX[i] = ninjaX/32;
                        playerWallX[i] = (playerWallX[i]-1)*32;
                        playerWallY[i] = (ninjaY + ninjaH/2)/32;
                        playerWallY[i] = playerWallY[i]*32;
                        updatedMap[playerWallX[i]/32][playerWallY[i]/32] =-1;
                        playerWallVisible[i] = true;
                        playerWall[i] = new Rectangle(playerWallX[i],playerWallY[i],wallH,wallW);
                        noBlocksDestroyed = false;
                        i = MAX_WALL_AMOUNT;
                    } else {
                        noBlocksDestroyed = true;
                    }
                }
                if (noBlocksDestroyed){
                    playerWallInventory--;
                    playerWallOnBoard++;
                    wallSound.stop();
                    wallSound.flush();              // clear the buffer with audio data
                    wallSound.setFramePosition(0);  // prepare to start from the beginning
                    wallSound.start();
                    playerWallX[currentPlayerWall%MAX_WALL_AMOUNT] = ninjaX/32;
                    playerWallX[currentPlayerWall%MAX_WALL_AMOUNT] = (playerWallX[currentPlayerWall%MAX_WALL_AMOUNT]-1)*32;
                    playerWallY[currentPlayerWall%MAX_WALL_AMOUNT] = (ninjaY + ninjaH/2)/32;
                    playerWallY[currentPlayerWall%MAX_WALL_AMOUNT] = playerWallY[currentPlayerWall%MAX_WALL_AMOUNT]*32;
                    updatedMap[ playerWallX[currentPlayerWall%MAX_WALL_AMOUNT]/32][ playerWallY[currentPlayerWall%MAX_WALL_AMOUNT]/32] =-1;
                    playerWall[currentPlayerWall%MAX_WALL_AMOUNT] = new Rectangle(playerWallX[currentPlayerWall%MAX_WALL_AMOUNT],playerWallY[currentPlayerWall%MAX_WALL_AMOUNT],wallH,wallW);
                    currentPlayerWall++;
                }
            }
        }
        if (placeWall) {
            placeWall = false;
            
        }

    }

    public static void characterMovement(){

        
        if (goingLeft) {
            ninjaVx = -RUN_SPEED;
        } 
        if (goingRight) {
            ninjaVx = RUN_SPEED;
        } 
        if (goingUp) {
            ninjaVy = -RUN_SPEED;
        } 
        if (goingDown) {
            ninjaVy = RUN_SPEED;
        }
        
        futureLeftPlayerHitBox.setLocation(ninjaX - 2, ninjaY);
        futureRightPlayerHitBox.setLocation(ninjaX + 2, ninjaY);
        futureUpPlayerHitBox.setLocation(ninjaX, ninjaY - 2);
        futureDownPlayerHitBox.setLocation(ninjaX, ninjaY + 2);
        
        if ((checkCollision(futureLeftPlayerHitBox)) && (goingLeft)){
            ninjaVx = 0;
        }
        if ((checkCollisionPlayerWall(futureLeftPlayerHitBox)) && (goingLeft)){
            ninjaVx = 0;
        }

        

        if ((checkCollision(futureRightPlayerHitBox)) && (goingRight)){
            ninjaVx = 0;
        }
        if ((checkCollisionPlayerWall(futureRightPlayerHitBox)) && (goingRight)){
            ninjaVx = 0;
        }

        if ((checkCollision(futureUpPlayerHitBox)) && (goingUp)){
            ninjaVy = 0;
        }
        if ((checkCollisionPlayerWall(futureUpPlayerHitBox)) && (goingUp)){
            ninjaVy = 0;
        }

        

        if ((checkCollision(futureDownPlayerHitBox)) && (goingDown)){
            ninjaVy = 0;
        }
        if ((checkCollisionPlayerWall(futureDownPlayerHitBox)) && (goingDown)){
            ninjaVy = 0;
        }

        ninjaX = ninjaX + ninjaVx;
        ninjaY = ninjaY + ninjaVy;
        playerBox.setLocation(ninjaX,ninjaY);
        
        // select ninja's picture   
        if (elapsedTimeMario/80 > 1){
            if ((ninjaVx == 0) && (ninjaVy == 0)){
                if (standLeft) {
                    runSound.stop();
                    runSound.setFramePosition(0);
                    ninjaPicNum = 4;
                } else if (standRight) {
                    runSound.stop();
                    runSound.setFramePosition(0);
                    ninjaPicNum = 6;
                } else if (standUp) {
                    runSound.stop();
                    runSound.setFramePosition(0);
                    ninjaPicNum = 10;
                } else if (standDown) {
                    runSound.stop();
                    runSound.setFramePosition(0);
                    ninjaPicNum = 0;
                } 
            } else if (ninjaVx < 0){
                runSound.start();
                runSound.loop(Clip.LOOP_CONTINUOUSLY);
                ninjaPicNum = nextLeftPic[ninjaPicNum]; 
            } else if (ninjaVx > 0){                    
                runSound.start();
                runSound.loop(Clip.LOOP_CONTINUOUSLY);
                ninjaPicNum = nextRightPic[ninjaPicNum];  
            } else if (ninjaVy < 0){
                runSound.start();
                runSound.loop(Clip.LOOP_CONTINUOUSLY);
                ninjaPicNum = nextUpPic[ninjaPicNum];
            } else if (ninjaVy > 0){
                runSound.start();
                runSound.loop(Clip.LOOP_CONTINUOUSLY);
                ninjaPicNum = nextDownPic[ninjaPicNum];
            }    
            start = System.currentTimeMillis();  
        }   
        end = System.currentTimeMillis();
        elapsedTimeMario = end - start; 
    
    }

    static class GraphicsPanel extends JPanel{
        public GraphicsPanel(){
            setFocusable(true);
            requestFocusInWindow();
        }
        public void paintComponent(Graphics g){ 

            
            super.paintComponent(g);
            g.setColor(Color.red);

            Graphics2D g2 = (Graphics2D) g;
            int thickness = 4;
            g2.setColor(Color.green);
            Stroke oldStroke = g2.getStroke();
            g2.setStroke(new BasicStroke(thickness));

            Font font = new Font("Arial", Font.BOLD, 50);
            g.setFont(font);

            Font smallFont = new Font("Arial", Font.BOLD, 20);

            if (screen == 0){
                if ((mouseX >= 985) && (mouseX <= 1353) &&  (mouseY >= 519) && (mouseY <=565)){
                    try {             
                        menuPic = ImageIO.read(new File("images/menuStart.png"));
                    } catch (IOException ex){} 
                } else if ((mouseX >= 933) && (mouseX <= 1353) &&  (mouseY >= 622) && (mouseY <= 668)){
                    try {             
                        menuPic = ImageIO.read(new File("images/menuInstructions.png"));
                    } catch (IOException ex){} 
                } else {
                    try {             
                        menuPic = ImageIO.read(new File("images/menu.png"));
                    } catch (IOException ex){} 
                }
                g.drawImage(menuPic,0,0,this);
            } else if (screen == 1){

                for(int i = 0;i < map.length; i++ ){
                    tileX = i*32;
                    for(int count =0 ; count < map[0].length;count++){

        
                        tileY = count*32;
        
                        g.drawImage(tileID[map[i][count]],tileX, tileY,this);
                        

                    
                        
                    
                    }

                }


                for(int i = 0; i < map.length; i++){

                    for(int count = 0; count < map[0].length; count++){
                    
                        if(map[i][count] == 4 || map[i][count] == 5 || map[i][count] == 6 || map[i][count] == 7 || map[i][count] == 8 || map[i][count] == 9){

                            //g.drawRect(i*32,  count*32, wallH, wallW);

                        }


                    }
                }

                for (int i=0; i<MAX_WALL_AMOUNT; i++){
                    if ((playerWall[i] != null) && (playerWallVisible[i])){
                        g.drawImage(playerWallPic,playerWallX[i],playerWallY[i],this);
                    }
                }

                for (int i=0; i<numBullets; i++){
                    if (bulletRightVisible[i]) {
                        g.drawImage(bullet1RightPic,bulletRightX[i],bulletRightY[i],this);
                    }
                    if (bulletLeftVisible[i]) {
                        g.drawImage(bullet1LeftPic,bulletLeftX[i],bulletLeftY[i],this);
                    }
                    if (bulletDownVisible[i]) {
                        g.drawImage(bullet1DownPic,bulletDownX[i],bulletDownY[i],this);
                    }
                    if (bulletUpVisible[i]) {
                        g.drawImage(bullet1UpPic,bulletUpX[i],bulletUpY[i],this);
                    }
                }

                try {
                    
                    for(int i = 0; i < numZombie; i++){
                        
                  

                    
                        
                        if(zombieHP[i] > 0){

                            if (checkCollisionPlayer(zombieBox[i])){
                                g.drawImage(zombieAttackPic[zombieAttackPicNum[i]],zombieX[i],zombieY[i],this);
                            }

                      

                            if (!(checkCollisionPlayer(zombieBox[i]) && !freezeZombie[i])){
                                g.drawImage(zombiePic[zombiePicNum[i]],zombieX[i],zombieY[i],this);
                            }
                            g.setColor(Color.red);
                            g.fillRect(zombieX[i] , zombieY[i] - 10, 25,5);
                            g.setColor(Color.green);
                            g.fillRect(zombieX[i] , zombieY[i] - 10, zombieBar[i],5);

                        }
                       

                         if(freezeZombie[i] && zombieHP[i] > 0){

                            g.drawImage(frozenZombiePic[nextFrozenZombie[zombiePicNum[i]]], zombieX[i], zombieY[i], this);

                        }
                
                    }

                } catch (Exception ex){} 

                g.drawImage(ninjaPic[ninjaPicNum],ninjaX,ninjaY,this);
                g.setColor(Color.red);
                g.fillRect(ninjaX,ninjaY - 10, 25,5);
                g.setColor(Color.green);
                g.fillRect(ninjaX,ninjaY - 10, playerBar,5);
              
                g.drawImage(heartIcon,1065,10,this);
                g.drawImage(bulletIcon,1055,52,this);
                g.drawImage(rapidIcon,1060,90,this);
                g.drawImage(wallIcon,1060,130,this);

                g.setFont(smallFont);
                String displayPlayerHealth = Double.toString(playerHP);
                g.setColor(Color.red);
                g.drawString(": " + displayPlayerHealth, 1100, 30);

                String displayAmmo = Integer.toString(ammo);
  
                g.drawString(": " + displayAmmo, 1100, 70);

                String displaySpeedAmmo = Integer.toString(speedAmmo);

                g.drawString(": " + displaySpeedAmmo, 1100, 110);

                String displayWallCount = Integer.toString(playerWallInventory);

                g.drawString(": " + displayWallCount, 1100, 150);

                String displayWallOnBoard = Integer.toString(playerWallOnBoard);
                g.drawString("Walls On Board (Max 20): " + displayWallOnBoard, 900, 600);

                g.setFont(font);
                g.drawImage(shopPic,1170,0,this);

                String displayMoney = Integer.toString(playerMoney);
                g.setColor(Color.GREEN);
                g.drawString(displayMoney, 1235, 55);
                g.setColor(Color.WHITE);
                g.drawString("Wave: " + Integer.toString(waveCount),10,40);
                

                
                if ((mouseX >= 1175) && (mouseX <= 1260) &&  (mouseY >= 80) && (mouseY <=163)){

                    g2.setColor(Color.green);
                    g2.drawRect(1176, 80, 86, 85);
                    
                }  else if ((mouseX >= 1277) && (mouseX <= 1362) &&  (mouseY >= 80) && (mouseY <=163)){
                    g2.setColor(Color.green);
                    g2.drawRect(1277, 80, 86, 85);

                } else if ((mouseX >= 1175) && (mouseX <= 1260) &&  (mouseY >= 215) && (mouseY <=299)){
                    g2.setColor(Color.green);
                    g2.drawRect(1176, 215, 86, 85);
                } else if ((mouseX >= 1277) && (mouseX <= 1362) &&  (mouseY >= 215) && (mouseY <=299)){
                    g2.setColor(Color.green);
                    g2.drawRect(1277, 215, 86, 85);
                } else if ((mouseX >= 1175) && (mouseX <= 1260) &&  (mouseY >= 357) && (mouseY <=441)){
                    g2.setColor(Color.green);
                    g2.drawRect(1176, 357, 86, 85);
                } else if ((mouseX >= 1277) && (mouseX <= 1362) &&  (mouseY >= 357) && (mouseY <=441)){
                    g2.setColor(Color.green);
                    g2.drawRect(1277, 357, 86, 85);
                } else if ((mouseX >= 1175) && (mouseX <= 1260) &&  (mouseY >= 499) && (mouseY <=582)){
                    g2.setColor(Color.green);
                    g2.drawRect(1176, 499, 86, 85);
                } else if ((mouseX >= 1277) && (mouseX <= 1362) &&  (mouseY >= 499) && (mouseY <=582)){
                    g2.setColor(Color.green);
                    g2.drawRect(1277, 499, 86, 85);
                }
            } else if (screen == 2){
                if ((mouseX >= 31) && (mouseX <= 163) &&  (mouseY >= 40) && (mouseY <=77)){
                    try {             
                        instructionPic = ImageIO.read(new File("images/instructionBack.png"));
                    } catch (IOException ex){} 
                } else if ((mouseX >= 1056) && (mouseX <= 1353) &&  (mouseY >= 637) && (mouseY <=675)){
                    try {             
                        instructionPic = ImageIO.read(new File("images/instructionStart.png"));
                    } catch (IOException ex){} 
                } else {
                    try {             
                        instructionPic = ImageIO.read(new File("images/instruction.png"));
                    } catch (IOException ex){} 
                }
                g.drawImage(instructionPic,0,0,this);
            } else if (screen == 3){
                if ((mouseX >= 431) && (mouseX <= 938) &&  (mouseY >= 587) && (mouseY <=655)){
                    try {             
                        endPic = ImageIO.read(new File("images/endScreenAgain.png"));
                    } catch (IOException ex){} 
                } else {
                    try {             
                        endPic = ImageIO.read(new File("images/endScreen.png"));
                    } catch (IOException ex){} 
                }
                g.drawImage(endPic,0,0,this);
            }

        }

    }

    static class MyKeyListener implements KeyListener{      
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            if (screen == 1){
                if (key == KeyEvent.VK_A){
                    goingLeft = true;
                    goingRight = false;
                } else if (key == KeyEvent.VK_D){
                    goingRight = true;
                    goingLeft = false;

                }
                if (key == KeyEvent.VK_W){ 
                    goingUp = true;   
                    goingDown = false;

                } else if (key == KeyEvent.VK_S){
                    goingDown = true;
                    goingUp = false;
                } 
                
            }
        }
        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();
            if (screen == 1){
                if (key == KeyEvent.VK_A) {
                    ninjaVx = 0;
                    goingLeft = false;
                    standLeft = true;
                    standRight = false;
                    standUp = false;
                    standDown = false;
                    if (goingRight){
                        ninjaVx = RUN_SPEED;
                    }
                }
                if (key == KeyEvent.VK_D) {
                    ninjaVx = 0;
                    goingRight = false;
                    standRight = true;
                    standLeft = false;
                    standUp = false;
                    standDown = false;
                    if (goingLeft){
                        ninjaVx = -RUN_SPEED;
                    }
                }
                if (key == KeyEvent.VK_W) {
                    ninjaVy = 0;
                    goingUp = false;
                    standUp = true;
                    standRight = false;
                    standLeft = false;
                    standDown = false;
                    if (goingDown){
                        ninjaVy = RUN_SPEED;
                    } 
                }
                if (key == KeyEvent.VK_S) {
                    ninjaVy = 0;
                    goingDown = false;
                    standDown = true;
                    standRight = false;
                    standUp = false;
                    standLeft = false;
                    if (goingUp){
                        ninjaVy = -RUN_SPEED;
                    } 
                }
                if (key == KeyEvent.VK_F){
                    placeWall = true;
                    for(int i =0; i <numZombie; i++){

                        zombiePath[i] = pathfind(updatedMap,zombiePos[i],playerPos);
                    }
                }

            }

        }       
        public void keyTyped(KeyEvent e){
        }        
    }

    static class MyMouseListener implements MouseListener{
        public void mouseClicked(MouseEvent e){
        }
        public void mousePressed(MouseEvent e){   // changes box color and places the box at the mouse location
            if (screen == 1){
                if (mouseX < 1170){
                    if (!(canShoot)) {
                        shooting = true;
                        canShoot = true;
                    }
                    if (autoFire){
                        shooting = true;
                    }
                }
            }
            
        }
        public void mouseReleased(MouseEvent e){  // restores box color
            if (screen == 0){
                if ((mouseX >= 985) && (mouseX <= 1353) &&  (mouseY >= 519) && (mouseY <=565)){
                    screen = 1;
                } else if ((mouseX >= 933) && (mouseX <= 1353) &&  (mouseY >= 621) && (mouseY <=669)){
                    screen = 2;
                }
            } else if (screen == 1){
                if (mouseX < 1170){
                    canShoot = false;
                    if ((autoFire) && (hasShot)){
                        shooting = false;
                        hasShot = false;
                    }
                }
                if ((playerMoney >= 500) && (mouseX >= 1175) && (mouseX <= 1260) &&  (mouseY >= 80) && (mouseY <=163)){
                    playerMoney = playerMoney - 500;
                    autoFire = true;
                    buySound.stop();
                    buySound.flush();              
                    buySound.setFramePosition(0);  
                    buySound.start();
                    
                } else if ((playerMoney >= 50) && (mouseX >= 1277) && (mouseX <= 1362) &&  (mouseY >= 80) && (mouseY <=163)){
                    playerMoney = playerMoney - 50;
                    bulletDmg = 15;
                    ammo = 25;
                    useFireBullet = true;
                    buySound.stop();
                    buySound.flush();              
                    buySound.setFramePosition(0);  
                    buySound.start();
                } else if ((playerMoney >= 80) && (mouseX >= 1175) && (mouseX <= 1260) &&  (mouseY >= 215) && (mouseY <=299)){
                    playerMoney = playerMoney - 80;
                    bulletDmg = 25;
                    ammo = 25;
                    useLavaBullet = true;
                    buySound.stop();
                    buySound.flush();              
                    buySound.setFramePosition(0);  
                    buySound.start();
                } else if ((playerMoney >= 150) && (mouseX >= 1277) && (mouseX <= 1362) &&  (mouseY >= 215) && (mouseY <=299)){
                    playerMoney = playerMoney - 150;
                    ammo = 25;
                    useHolyWater = true;
                    buySound.stop();
                    buySound.flush();              
                    buySound.setFramePosition(0);  
                    buySound.start();
                } else if ((playerMoney >= 150) && (mouseX >= 1175) && (mouseX <= 1260) &&  (mouseY >= 357) && (mouseY <=441)){
                    playerMoney = playerMoney - 150;
                    ammo = 5;
                    useFreezeBullet = true;
                    buySound.stop();
                    buySound.flush();              
                    buySound.setFramePosition(0);  
                    buySound.start();
                } else if ((playerMoney >= 100) && (mouseX >= 1277) && (mouseX <= 1362) &&  (mouseY >= 357) && (mouseY <=441)){
                    playerMoney = playerMoney - 100;
                    shootingSpeed = 80;
                    speedAmmo = 100;
                    buySound.stop();
                    buySound.flush();              
                    buySound.setFramePosition(0);  
                    buySound.start();
                } else if ((playerMoney >= 100) && (playerWallOnBoard < MAX_WALL_AMOUNT) && (playerWallInventory < MAX_WALL_AMOUNT) && (mouseX >= 1175) && (mouseX <= 1260) &&  (mouseY >= 499) && (mouseY <=582)){
                    playerMoney = playerMoney - 100;
                    if (playerWallInventory >= MAX_WALL_AMOUNT-5){
                        playerWallInventory = MAX_WALL_AMOUNT;
                    } else if (playerWallOnBoard >= MAX_WALL_AMOUNT-5) {
                        playerWallInventory = playerWallInventory + (MAX_WALL_AMOUNT - playerWallOnBoard);
                    } else {
                        playerWallInventory = playerWallInventory + 5;
                    }
                    buySound.stop();
                    buySound.flush();              
                    buySound.setFramePosition(0);  
                    buySound.start();
                } else if ((playerMoney >= 1000) && (mouseX >= 1277) && (mouseX <= 1362) &&  (mouseY >= 499) && (mouseY <=582)){
                    playerMoney = playerMoney - 1000;
                    playerHP = playerHP + 100;
                    buySound.stop();
                    buySound.flush();              
                    buySound.setFramePosition(0);  
                    buySound.start();
                }
            
            } else if (screen == 2){
                if ((mouseX >= 31) && (mouseX <= 163) &&  (mouseY >= 40) && (mouseY <=77)){
                    screen = 0;
                } else if ((mouseX >= 1056) && (mouseX <= 1353) &&  (mouseY >= 637) && (mouseY <=675)){
                    screen = 1;
                }
            } else if (screen == 3){
                if ((mouseX >= 431) && (mouseX <= 938) &&  (mouseY >= 587) && (mouseY <=655)){
                    screen = 1;
                    restartGame();
                }
            }
        }
        public void mouseEntered(MouseEvent e){
        }
        public void mouseExited(MouseEvent e){
        }
    } // MyMouseListener class end

    static class MyMouseMotionListener implements MouseMotionListener{
        public void mouseMoved(MouseEvent e){
            mouseX = e.getX();
            mouseY = e.getY();
        }
        public void mouseDragged(MouseEvent e){   // drags the box with the mouse       
        }         
    }

    public static int amountInArray(int[] array, int value){
        int count = 0;

        for(int i = 0; i < array.length; i++){
            
            if(array[i] == value){
                count++;
            }


            
        }

        return count;



    }


    public static boolean checkCollision(Rectangle collisionObject){

        for (int i = 0; i < wallBox.length; i++){

            if (wallBox[i].intersects(collisionObject)){
                return true;
            }


        }

        return false;
    
    }

    public static boolean checkCollisionPlayer(Rectangle collisionObject){

        if (playerBox.intersects(collisionObject)){
            return true;
        }

        return false;
    
    }

    public static boolean checkCollisionPlayerWall(Rectangle collisionObject){

        for (int i = 0; i < MAX_WALL_AMOUNT; i++){

            if (playerWall[i] != null){
                if (playerWall[i].intersects(collisionObject)){
                    wallHit = i;
                    return true;
                }
            }


        } 

        return false;
    
    }
    
    static class shot1Listener implements LineListener {
        public void update(LineEvent event) {
            if (event.getType() == LineEvent.Type.STOP) {
                shot1Sound.flush();              // clear the buffer with audio data
                shot1Sound.setFramePosition(0);  // prepare to start from the beginning
            }
        }
    }   

    public static int getPlayerX(){

        return (ninjaX + 16) / 32;



    }

        public static int getPlayerY(){

        return (ninjaY + 16)/ 32;



    }


    

    public static int[] findSpawnableArea(){


        int[] spawn = new int[2];
        Random rand = new Random();
        int x,y;
        
        boolean validSpawn = false;

        while(!validSpawn){

            x = rand.nextInt(map[0].length);
            y = rand.nextInt(map.length);

            if(updatedMap[y][x] == 0){

                spawn[0] = y*32;
                spawn[1] = x*32;
                validSpawn = true;
            }

        } 

        return spawn;

    }   

    public static int checkCollisionZombie(Rectangle object){

        for(int i = 0; i < zombieBox.length; i++){

            if(zombieBox[i].intersects(object)){

                return i;
            }

        }

        return -1;
    }

  public static void moveDownZombie(int num){

    if (elapsedTimeZombie[num]/80 > 1){

        zombiePicNum[num] = downZombiePic[zombiePicNum[num]];

        startZombie[num] = System.currentTimeMillis();
        if (!(checkCollisionPlayer(zombieBox[num]))){
            zombieAttackPicNum[num] = 7;
        }
    }

    endZombie[num] = System.currentTimeMillis();
    elapsedTimeZombie[num] = endZombie[num] - startZombie[num];

  }

  public static void moveUpZombie(int num){

    if (elapsedTimeZombie[num]/80 > 1){

        zombiePicNum[num] = upZombiePic[zombiePicNum[num]];

        startZombie[num] = System.currentTimeMillis();

        if (!(checkCollisionPlayer(zombieBox[num]))){
            zombieAttackPicNum[num] = 9;
        }
    }

    endZombie[num] = System.currentTimeMillis();
    elapsedTimeZombie[num] = endZombie[num] - startZombie[num];

  }

  public static void moveLeftZombie(int num){

    if (elapsedTimeZombie[num]/80 > 1){

        zombiePicNum[num] = leftZombiePic[zombiePicNum[num]];

        startZombie[num] = System.currentTimeMillis();
        if (!(checkCollisionPlayer(zombieBox[num]))){
            zombieAttackPicNum[num] = 0;
        }
    }

    endZombie[num] = System.currentTimeMillis();
    elapsedTimeZombie[num] = endZombie[num] - startZombie[num];

  }

  public static void moveRightZombie(int num){
      
    if (elapsedTimeZombie[num]/80 > 1){
        zombiePicNum[num] = rightZombiePic[zombiePicNum[num]];
        startZombie[num] = System.currentTimeMillis();
        if (!(checkCollisionPlayer(zombieBox[num]))){
            zombieAttackPicNum[num] = 3;
        }

    }

    endZombie[num] = System.currentTimeMillis();
    elapsedTimeZombie[num] = endZombie[num] - startZombie[num];
 }

    public static boolean checkZombiePos(int posX, int posY,  String type){
        int count = 0;


        for(int i = 0; i < zombiePos.length;i++){

            if(zombiePos[i][0] == posX && zombiePos[i][1] == posY){
                
                count++;
            


            }

         
        
            
        }

        if(type == "zombie" &&  count > 0){


            return true;

        }else if(type == "wall" && count == 1){

            return true;


        }else{

            return false;

        }



        }






    

  public static int[][] pathfind(int[][] chart, int[]startPos, int[] endingPos){

        int[][] path;
        int mapSize = chart.length * chart[0].length;
        int nextMove = 0;
     

        int currentNum;
        int lowestFScore;
        int j = 0;
        boolean found = false;
    


        int[][] openList = new int[mapSize][3];
        int[][] closedList = new int[mapSize][3];
        int[][] listOfParents = new int[mapSize * 5][4];
        int[][] tempParentList = new int[mapSize * 5][4];

        for(int i = 0; i < openList.length; i++){

                for(int count = 0; count < openList[0].length; count++){

                    openList[i][count] = -1;
                    closedList[i][count] = -1;

                }
       ;
        }

        for(int i = 0; i < listOfParents.length; i++){

            for(int count = 0; count < listOfParents[0].length; count++){

                listOfParents[i][count] = -1;
            }
         
        }




        listOfParents[0][0] = startPos[0];
        listOfParents[0][1] = startPos[1];
        listOfParents[0][2] = -1;
        listOfParents[0][3] = -1;

       int[] currentNode = new int[2];

       openList[0][0] = startPos[0];
       openList[0][1] = startPos[1];
       openList[0][2] = hCost(startPos, endingPos);

       



        do{



        
            lowestFScore = openList[0][2];
            currentNode[0] = openList[0][0];
            currentNode[1] = openList[0][1];

        

            for(int i = 0; i < openList.length;i++){
               

                if(openList[i][2] < lowestFScore && openList[i][2] != - 1){
                     
                    currentNode[0] = openList[i][0];
                    currentNode[1] = openList[i][1];
                    lowestFScore = openList[i][2];              

                }
            }


            closedList[j][0] = currentNode[0];
            closedList[j][1] = currentNode[1];
            closedList[j][2] = lowestFScore;
            j++;
               
            openList = remove(openList, currentNode);

    
            if(currentNode[0] == endingPos[0] && currentNode[1] == endingPos[1]){

                found = true;

            
                break;
            }

            int[][] adjSquares =  new int[4][2];

            adjSquares[0][0] = currentNode[0] + 1;
            adjSquares[0][1] = currentNode[1];

            adjSquares[1][0] = currentNode[0]; 
            adjSquares[1][1] = currentNode[1] + 1; 

            adjSquares[2][0] = currentNode[0] -1; 
            adjSquares[2][1] = currentNode[1]; 

            adjSquares[3][0] = currentNode[0]; 
            adjSquares[3][1] = currentNode[1] -1 ; 

            
            for(int i = 0; i < adjSquares.length;i++){


                if(adjSquares[i][0] < 0 || adjSquares[i][1] < 0 || adjSquares[i][0] > chart.length  -1|| adjSquares[i][1] > chart[0].length -1 || containsSquare(closedList, adjSquares[i]) || adjSquares[i][0] == -2){

                    continue;
                }
            


                if(adjSquares[i][0] >= 0 && adjSquares[i][0] < chart.length  && adjSquares[i][1] < chart[0].length   && adjSquares[i][1] >= 0){


                    if(chart[adjSquares[i][0]][adjSquares[i][1]] == -1 ){

            
                        continue;
                    }
                }
            
                if(containsSquare(openList, adjSquares[i])){

                    tempParentList = listOfParents;


                    tempParentList[getLastNum(tempParentList,"parents")][0] = adjSquares[i][0];
                    tempParentList[getLastNum(tempParentList,"parents")][1] = adjSquares[i][1];
                    tempParentList[getLastNum(tempParentList,"parents")][2] = currentNode[0];
                    tempParentList[getLastNum(tempParentList,"parents")][3] =  currentNode[1];
                    

    
                    
        
                    if(openList[getNum(openList,adjSquares[i])][2] > fCost(startPos,tempParentList, adjSquares[i], endingPos)){

                        listOfParents = tempParentList;
                        openList[getLastNum(openList, "")][0] = adjSquares[i][0];
                        openList[getLastNum(openList, "")][1] = adjSquares[i][1];
                        openList[getLastNum(openList, "")][2] = fCost(startPos,listOfParents, adjSquares[i], endingPos);


                    }

                
            


                }else{

                     currentNum  = getLastNum(listOfParents, "parents");

             

                
            
                    listOfParents[currentNum][0] = adjSquares[i][0];
                    listOfParents[currentNum][1] = adjSquares[i][1];
                    listOfParents[currentNum][2] = currentNode[0];
                    listOfParents[currentNum][3] =  currentNode[1];

                    

                     
                    currentNum  = getLastNum(openList, "");
                    openList[currentNum][0] = adjSquares[i][0];
                    openList[currentNum][1] = adjSquares[i][1];
                    openList[currentNum][2] = fCost(startPos,listOfParents, adjSquares[i], endingPos);
                


                }
                

            }

        
        }while(openList[0][0] != -1 && openList[0][1] != -1 && openList[0][2] != -1);

            if(found){

                  path = tracePath(listOfParents, startPos, endingPos);

            return path;
   


            }else{

                path = new int[1][2];
                path[0][0] = -2;
                path[0][1] = -2;

                return path;

            }


          
    }
  

    public static String getNextMove(int[][] path, int[]startPos){
        int nextMove = 0;

        if(path[0][0] == -2 && path[0][1] == -2 ){

            return "noPath";
        }

          for(int i = 0; i < path.length;i++){
                

                if(path[i][0] == startPos[0] && path[i][1] == startPos[1]){

                    nextMove = i-1;

              
                  



                    break;
                }
            }

              if(nextMove == -1){

                  return "arrived";

                        
            }

        
            if(path[nextMove][0]  == startPos[0] -1 && path[nextMove][1] == startPos[1]){

                return "left";


            }else if(path[nextMove][0]  == startPos[0] + 1 && path[nextMove][1] == startPos[1]){

                return "right";

            }else if(path[nextMove][1] == startPos[1] + 1 && path[nextMove][0] == startPos[0]){

                return "down";

            }else if(path[nextMove][1]  == startPos[1] -1 && path[nextMove][0] == startPos[0]){

                return "up";

            }else if(path[nextMove][1]  == startPos[1]- 1 && path[nextMove][0] == startPos[0] + 1){

                return "NEdiag";

            }else if(path[nextMove][1]  == startPos[1]- 1 && path[nextMove][0]  == startPos[0]-1){

                return "NWdiag";

            }else if(path[nextMove][1]  == startPos[1] + 1 && path[nextMove][0]  == startPos[0]+ 1){

                return "SEdiag";

            }else if(path[nextMove][1] == startPos[1] + 1 && path[nextMove][0]  == startPos[0]- 1){

                return "SWdiag";

            }else{
              
                return "error";
                
            }





    }
    

    public static int fCost(int[] startPos, int[][] listOfParents, int[]currentPos, int[]endPos){
       


       int counter = gCost(startPos, listOfParents, currentPos) + hCost(currentPos,endPos);
       return counter;
        
        
    }


    public static int gCost(int[] startPos, int[][]listOfParents, int[] currentPos){

        int counter = 0;
        int[] location = new int[2];

        location[0] = currentPos[0];
        location[1] = currentPos[1];


        while(location[0] != -1 && location[1] != -1){




            for(int i = 0; i <
             listOfParents.length;i++){
                

                if(listOfParents[i][0] == location[0] && listOfParents[i][1] == location[1]){


                    location[0] = listOfParents[i][2];
                    location[1] = listOfParents[i][3];


                }


            }
            

            counter++;



        }        


        return counter -1;

    }


    public static int hCost(int[]currentPos, int[] endPos){

        int count = 0;
   
        count = count  + Math.abs( currentPos[0]  - endPos[0]);
     

        count = count + Math.abs(currentPos[1] - endPos[1]);
        
        
        return count;


    }

    public static int getLastNum(int[][] array, String type){

        
        if(type == "parents"){

            for(int i = 1; i < array.length; i++){

        

                    if(array[i][0] == -1 || array[i][1] == -1 || array[i][2] == -1 || array[i][3] == -1){
           
                        return i; 
                    
                    }

            }
        }else{
     

        
            for(int i = 0; i < array.length; i++){

                for(int count = 0; count < array[0].length; count++){

                    if(array[i][count] == -1){
                        return i;
                    }
                }

            }
        }

        return -1;
    }

    

        

    public static int[][] remove(int[][] array, int[] itemToRemove){

        for(int i = 0; i < array.length; i++){


            if(array[i][0] == itemToRemove[0] && array[i][1] == itemToRemove[1]){

              
                for(int count = i; count < array.length; count++){



                    if(count  == array.length -1){

                        array[count][0] = -1;
                        array[count][1] = -1;

                        return array;
                        }


               

                    if(array[count + 1][0] == -1){

                        array[count][0] = -1;
                        array[count][1] = -1;
                        array[count][2] = -1;               

                        return array;
                    }



                    array[count][0] = array[count + 1][0];
                    array[count][1] = array[count+ 1][1];
                    array[count][2] = array[count+ 1][2];



                }
            }
        }

        return array;
    }

    public static boolean containsSquare(int[][] list, int[] itemToCheck){

        int[][] array = list;

        for(int i = 0; i < array.length;i++){
            
            if(itemToCheck[0] == array[i][0] && itemToCheck[1] == array[i][1]){

                return true;
             
            }

        }

        return false;

    }

    public static int getNum(int[][] list , int[] itemToGetIndexOf){


        int[][] array = list;
        
        for(int i =0; i < array.length;i++){

            



            if(array[i][0] == itemToGetIndexOf[0] && array[i][1] == itemToGetIndexOf[1] ){

               
                

                return i;
            }
        }

        return -1;

        


    }

    public static int[][] tracePath(int[][] parentList, int startPos[], int endPos[]){

        int[][] path  = new int[parentList.length][2];
        int[] currentLocation = new int[2];
        int startTrace =0;
        int count = 0;

        currentLocation[0] = endPos[0];
        currentLocation[1] = endPos[1];

        
        
        

        while(currentLocation[0] != -1 && currentLocation[1] != -1){


            for(int i = 0; i < parentList.length;i++){
                
                if(parentList[i][0] == currentLocation[0] && parentList[i][1] == currentLocation[1]){

                    path[count][0]= currentLocation[0];
                    path[count][1] = currentLocation[1];


                    currentLocation[0] = parentList[i][2];
                    currentLocation[1] = parentList[i][3];

                    count++;


                }


            }


        }

        return path;

    }

}