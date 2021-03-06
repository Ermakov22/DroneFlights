import com.company.*;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point3;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.company.Functions.*;
import static com.company.MathTransform.*;
import static com.company.Task23.BufferedImage2Mat;
import static com.company.Task23.*;
import static com.company.Task4.*;
import static com.company.Task5.*;

public class myGUI extends JFrame {
    private JPanel MyPanel;
    private JTabbedPane JTable;
    private JButton TestButt;
    private JPanel Task4;
    private JButton button1;
    private JButton buttonSolveTask23;
    private JButton buttonReadImages2;
    private JButton buttonSolveTask5;
    private JLabel task5Image;
    private JButton buttonNextTask5;
    private JLabel imageTask23;
    private JLabel imageTask6;
    private JButton task6btnChange;
    private JButton button2;
    private JLabel imageTask4;
    private JButton buttonTask4Next;
    private JButton buttonTask4Previous;
    private JButton buttonTask23FirstImage;
    private JButton buttonTask23SecondImage;
    private JButton buttonTask23FinalImage;
    private JButton button3;
    private JButton button4;
    private JLabel task6Color1;
    private JButton button5;
    private JButton button6;
    private JLabel task6Color2;
    private JButton інструкціяButton;
    private JButton інструкціяButton1;
    private JButton інструкціяButton3;
    private JButton інструкціяButton4;
    private JButton інструкціяButton2;
    private JButton взятиКолірПіпеткиButton;
    private JButton взятиКолірПіпеткиButton1;
    private JLabel pipetLabel;
    private JButton buttonPanorama;
    private JButton buttonSolve23;
    private JLabel label2;
    public static JFrame mainFrame = new JFrame();
    private Color pipetColor = null;
    boolean task5 = false, task6 = false;
    BufferedImage startImageTask6 = null, endImageTask6 = null,
            task23Imgage = null, task23ImageFirst = null, task23ImageSecond = null;
    int currIndex = 0;
    public static String pathToFile = new File("").getAbsolutePath();
    Functions functions = new Functions();
    private Color color1 = new Color(255, 34, 0), color2 = new Color(255, 149, 0);

    public myGUI() {
        {
            $$$setupUI$$$();
            try {
                loadOpenCV_Lib();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            mainFrame = new JFrame("Турнір Юних Інформатиків");
            mainFrame.setContentPane(this.MyPanel);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.pack();
            mainFrame.setSize(1200, 700);

            mainFrame.setResizable(false);
            int x, y;
            x = (Toolkit.getDefaultToolkit().getScreenSize().width - mainFrame.getWidth()) / 2;
            y = (Toolkit.getDefaultToolkit().getScreenSize().height - mainFrame.getHeight()) / 2;
            mainFrame.setLocation(x, y);
            mainFrame.setVisible(true);
            System.out.println(new File("").getAbsolutePath() + " ");
            BufferedImage img = null, img2 = null, img3 = null, img4 = null, img5 = null;
            JLabel lbl = new JLabel("<html>Побудова маршруту дрона</html>");
            JLabel lbl2 = new JLabel("<html>Найчіткіше зображення</html>");
            JLabel lbl3 = new JLabel("<html>Послідовність зображень</html>");
            JLabel lbl4 = new JLabel("<html>Знаходження відмінностей</html>");
            JLabel lbl5 = new JLabel("<html>Рекомендований полив</html>");
            Font bigFont = new Font("TimesRoman", Font.BOLD, 14);
            lbl.setFont(bigFont);
            lbl2.setFont(bigFont);
            lbl3.setFont(bigFont);
            lbl4.setFont(bigFont);
            lbl5.setFont(bigFont);
            ImageIcon icon, icon2, icon3, icon4, icon5;
            try {
                img = ImageIO.read(new File(pathToFile + "\\src\\first.png"));
                img2 = ImageIO.read(new File(pathToFile + "\\src\\secondthird.png"));
                img3 = ImageIO.read(new File(pathToFile + "\\src\\fourth.png"));
                img4 = ImageIO.read(new File(pathToFile + "\\src\\fifth.png"));
                img5 = ImageIO.read(new File(pathToFile + "\\src\\sixth.png"));
                BufferedImage currimg = ImageIO.read(new File(pathToFile + "\\src\\drone.png"));
                mainFrame.setIconImage(currimg);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            icon = new ImageIcon(img);
            icon2 = new ImageIcon(img2);
            icon3 = new ImageIcon(img3);
            icon4 = new ImageIcon(img4);
            icon5 = new ImageIcon(img5);
            lbl.setIcon(icon);
            lbl2.setIcon(icon2);
            lbl3.setIcon(icon3);
            lbl4.setIcon(icon4);
            lbl5.setIcon(icon5);
            JTable.setTabComponentAt(0, lbl3);
            //JTable.setTabComponentAt(1, lbl2);
            //JTable.setTabComponentAt(2, lbl3);
            //JTable.setTabComponentAt(3, lbl4);
            //JTable.setTabComponentAt(4, lbl5);
            drawColors();
        }
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);

            }
        });
        TestButt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        String browseTask1 = (pathToFile + "\\htdocs\\index.html").replace('\\', '/');
                        Desktop.getDesktop().browse(new URI(browseTask1));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                /*SwingUtilities.invokeLater(() -> {
                    Browser view = new Browser("file:///" + pathToFile + "/htdocs/index.html");
                    JFrame frame;
                    frame = new JFrame("Карта");
                    frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                    frame.setSize(1200, 775);
                    view.setSize(1200, 775);
                    frame.add(view);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    mainFrame.setVisible(false);
                    frame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            super.windowClosing(e);
                            mainFrame.setVisible(true);
                        }
                    });
                });*/
            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (startImageTask6 != null && color1 != null && color2 != null) {
                    Mat src = null;
                    try {
                        src = BufferedImage2Mat(startImageTask6);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    src = Functions.reSizeOnlyOne(src);
                    try {
                        startImageTask6 = Mat2BufferedImage(src);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    Mat hsv = new Mat(src.cols(), src.rows(), 3);
                    List<Mat> splitedHsv = new ArrayList<>();
                    Imgproc.cvtColor(src, hsv, Imgproc.COLOR_BGR2HSV);
                    Core.split(hsv, splitedHsv);
                    float[] hsv1 = null, hsv2 = null;
                    hsv1 = Color.RGBtoHSB(color1.getRed(), color1.getGreen(), color1.getBlue(), null);
                    hsv2 = Color.RGBtoHSB(color2.getRed(), color2.getGreen(), color2.getBlue(), null);
                    //System.out.println(hsv1[0] + " " + hsv2[0]);
                    int HUE_MIN = (int) Math.min(hsv1[0] * 180, hsv2[0] * 180);
                    int HUE_MAX = (int) Math.max(hsv1[0] * 180, hsv2[0] * 180);
                    final int SATURATION_MIN = 40;
                    for (int y = 0; y < hsv.cols(); y++) {
                        for (int x = 0; x < hsv.rows(); x++) {
                            int H = (int) splitedHsv.get(0).get(x, y)[0];
                            int S = (int) splitedHsv.get(1).get(x, y)[0];
                            if (H >= HUE_MIN && H <= HUE_MAX && S >= SATURATION_MIN) {
                                double a[] = {(double) (H - HUE_MIN) / (HUE_MAX - HUE_MIN) * 255, (double) (H - HUE_MIN) / (HUE_MAX - HUE_MIN) * 100, 0};
                                src.put(x, y, a);
                            }
                        }
                    }
                    try {
                        endImageTask6 = Mat2BufferedImage(src);
                        imageTask6.setIcon(new ImageIcon(endImageTask6));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    task6btnChange.setText("Стартове зображення");
                    task6 = false;
                    task6btnChange.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(myGUI.this,
                            new String[]{"Не коректні вхідні данні"},
                            "Помилка",
                            JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(myGUI.this,
                            new String[]{"Ви маєте вибрати одне зображення"},
                            "Вхідні дані",
                            JOptionPane.INFORMATION_MESSAGE);
                    task6btnChange.setEnabled(false);
                }
            }
        });
        buttonSolveTask23.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    readImages();

                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                if (Task23.isImageSet) {
                    buttonSolve23.setEnabled(true);
                    buttonTask23FirstImage.setEnabled(true);
                    buttonTask23SecondImage.setEnabled(true);
                    try {
                        task23ImageFirst = Mat2BufferedImage(reSizeOnlyOne(Task23.img));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    try {
                        task23ImageSecond = Mat2BufferedImage(reSizeOnlyOne(Task23.img2));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(myGUI.this,
                            new String[]{"Не коректні вхідні данні"},
                            "Помилка",
                            JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(myGUI.this,
                            new String[]{"Ви маєте вибрати два зображення однакового розміру"},
                            "Вхідні дані",
                            JOptionPane.INFORMATION_MESSAGE);
                    buttonTask23FirstImage.setEnabled(false);
                    buttonTask23SecondImage.setEnabled(false);
                    buttonTask23FinalImage.setEnabled(false);
                    buttonSolve23.setEnabled(false);
                }

            }
        });
        buttonReadImages2.addKeyListener(new KeyAdapter() {
        });
        buttonReadImages2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    readImages2();
                    task5 = false;
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                if (imageIsSet) {
                    BufferedImage currim = null;
                    try {
                        currim = Mat2BufferedImage(mat1);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    buttonNextTask5.setEnabled(true);
                    buttonSolveTask5.setEnabled(true);
                    task5Image.setIcon(new ImageIcon((currim)));
                } else {
                    JOptionPane.showMessageDialog(myGUI.this,
                            new String[]{"Не коректні вхідні данні"},
                            "Помилка",
                            JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(myGUI.this,
                            new String[]{"Ви маєте вибрати два зображення"},
                            "Вхідні дані",
                            JOptionPane.INFORMATION_MESSAGE);
                    buttonNextTask5.setEnabled(false);
                    buttonSolveTask5.setEnabled(false);
                }
            }
        });
        buttonSolveTask5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (imageIsSet) {
                    solvetask5();
                    BufferedImage currim = null;
                    try {
                        if (!task5)
                            currim = Mat2BufferedImage(mat1);
                        else currim = Mat2BufferedImage(mat2);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    task5Image.setIcon(new ImageIcon(currim));
                }

            }
        });
        buttonNextTask5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (imageIsSet) {
                    if (task5) {
                        task5 = false;
                        buttonNextTask5.setText("Друге зображення");
                        BufferedImage currim = null;
                        try {
                            currim = Mat2BufferedImage(mat1);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        task5Image.setIcon(new ImageIcon(currim));

                    } else {
                        task5 = true;
                        buttonNextTask5.setText("Перше зображення");
                        BufferedImage currim = null;
                        try {
                            currim = Mat2BufferedImage(mat2);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        task5Image.setIcon(new ImageIcon(currim));
                    }
                }
            }
        });
        task6btnChange.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (!task6) {
                    imageTask6.setIcon(new ImageIcon(startImageTask6));
                    task6btnChange.setText("Фінальне зображення");
                    task6 = true;
                } else {
                    task6 = false;
                    imageTask6.setIcon(new ImageIcon(endImageTask6));
                    task6btnChange.setText("Стартове зображення");
                }
            }
        });
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boolean verify = false;
                PhotosInfo.clearPhotos();
                JFileChooser fileopen = new JFileChooser();
                int ret;
                List<String> lines;
                ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    try {
                        String s = file.getPath();
                        int index = s.length() - 1;
                        pathToDocument = "";
                        while (index > 0 && s.charAt(index) != pathToFile.charAt(2))
                            index--;
                        for (int i = 0; i <= index; i++)
                            pathToDocument += s.charAt(i);

                        System.out.println(pathToDocument);
                        lines = Files.readAllLines(Paths.get(file.getPath()), Charset.defaultCharset());
                        System.out.println(lines.size() + " ");
                        functions.readInfo(lines);
                    } catch (IOException a) {
                        verify = true;
                    }

                }
                if (!verify) {
                    try {
                        if (check) {
                            listOfIndex.clear();
                        }
                        solveTask4();
                        if (listOfIndex.size() >= 2) {
                            buttonPanorama.setEnabled(true);
                            button3.setEnabled(true);
                            buttonTask4Next.setEnabled(true);
                            buttonTask4Previous.setEnabled(false);
                            try {
                                System.out.println(pathToDocument + "DronePhotos\\" + (PhotosInfo.photos.get(listOfIndex.get(0)).getImage() + ".JPG"));
                                BufferedImage img = ImageIO.read(new File(pathToDocument + "DronePhotos\\" + (PhotosInfo.photos.get(listOfIndex.get(0)).getImage() + ".JPG")));
                                img = Functions.Mat2BufferedImage(Functions.reSizeOnlyOne(Functions.BufferedImage2Mat(img)));
                                imageTask4.setIcon(new ImageIcon(img));
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            verify = true;
                        }

                        System.out.println(listOfIndex.size());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    currIndex = 0;

                }
                if (verify) {
                    JOptionPane.showMessageDialog(myGUI.this,
                            new String[]{"Не коректні вхідні данні"},
                            "Помилка",
                            JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(myGUI.this,
                            new String[]{"Ви маєте вибрати текстовий файл з данними",},
                            "Вхідні дані",
                            JOptionPane.INFORMATION_MESSAGE);
                    button3.setEnabled(false);
                    buttonTask4Next.setEnabled(false);
                    buttonTask4Previous.setEnabled(false);
                    buttonPanorama.setEnabled(false);
                }
            }
        });
        buttonTask4Previous.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (currIndex > 0) {
                    currIndex--;
                }
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File(pathToDocument + "DronePhotos\\" + (PhotosInfo.photos.get(listOfIndex.get(currIndex)).getImage() + ".JPG")));
                    img = Functions.Mat2BufferedImage(Functions.reSizeOnlyOne(Functions.BufferedImage2Mat(img)));
                    imageTask4.setIcon(new ImageIcon(img));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                if (currIndex == 0)
                    buttonTask4Previous.setEnabled(false);
                buttonTask4Next.setEnabled(true);
            }
        });
        buttonTask4Next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (currIndex + 1 < listOfIndex.size()) {
                    currIndex++;
                }
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File(pathToDocument + "DronePhotos\\" + (PhotosInfo.photos.get(listOfIndex.get(currIndex)).getImage() + ".JPG")));
                    img = Functions.Mat2BufferedImage(Functions.reSizeOnlyOne(Functions.BufferedImage2Mat(img)));
                    imageTask4.setIcon(new ImageIcon(img));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                if (currIndex == listOfIndex.size() - 1)
                    buttonTask4Next.setEnabled(false);
                buttonTask4Previous.setEnabled(true);
            }
        });
        buttonTask23FirstImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                buttonTask23FirstImage.setEnabled(false);
                buttonTask23SecondImage.setEnabled(true);
                buttonTask23FinalImage.setEnabled(true);
                imageTask23.setIcon(new ImageIcon(task23ImageFirst));
            }
        });
        buttonTask23SecondImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                buttonTask23FirstImage.setEnabled(true);
                buttonTask23SecondImage.setEnabled(false);
                buttonTask23FinalImage.setEnabled(true);
                imageTask23.setIcon(new ImageIcon(task23ImageSecond));
            }
        });
        buttonTask23FinalImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                buttonTask23FirstImage.setEnabled(true);
                buttonTask23SecondImage.setEnabled(true);
                buttonTask23FinalImage.setEnabled(false);
                imageTask23.setIcon(new ImageIcon(task23Imgage));
            }
        });
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        String browseTask4 = (pathToFile + "\\htdocs\\map.html").replace('\\', '/');
                        Desktop.getDesktop().browse(new URI(browseTask4));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    try {
                        BufferedImage img = ImageIO.read(new File(pathToDocument + "DronePhotos\\" + (PhotosInfo.photos.get(listOfIndex.get(0)).getImage() + ".JPG")));
                        img = Functions.Mat2BufferedImage(Functions.reSizeOnlyOne(Functions.BufferedImage2Mat(img)));
                        imageTask4.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    currIndex = 0;
                    button3.setEnabled(true);
                    buttonTask4Next.setEnabled(true);
                    buttonTask4Previous.setEnabled(false);
                }
            }
        });
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    String path1 = file.getPath();
                    try {
                        startImageTask6 = Mat2BufferedImage(Functions.reSizeOnlyOne(BufferedImage2Mat(ImageIO.read(new File(path1)))));
                        imageTask6.setIcon(new ImageIcon(startImageTask6));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                if (imageTask6 != null) button1.setEnabled(true);
                else button1.setEnabled(false);
            }
        });
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Color newColor = JColorChooser.showDialog(null, "Choose a color", color1);
                color1 = newColor;
                task6Color1.setIcon(createIcon(color1, 16, 16));
            }
        });
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Color newColor = JColorChooser.showDialog(null, "Choose a color", color2);
                color2 = newColor;
                task6Color2.setIcon(createIcon(color2, 16, 16));
            }
        });

        інструкціяButton3.addMouseMotionListener(new MouseMotionAdapter() {
        });
        інструкціяButton3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(myGUI.this,
                        new String[]{"У цьому завданні програма на вхід отримує два зображення для одного об’єкта,",
                                "після цього будується зображення найбільшої чіткості.",
                                "Щоб вибрати зображення треба натиснути на кнопку 'Вибрати зображення' та у діалоговому окні,",
                                "що відкрилось, вибрати спочатку перше, а потім друге зображення.",
                                "Після введення вхідних данних на формі з'явиться оброблене зображення.",
                                "Щоб побачити перше або друге зображення треба натиснути на відповідні кнопки."},
                        "Інструкція",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        інструкціяButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(myGUI.this,
                        new String[]{"У цьому завданні програма на вхід отримує два зображення однієї території, після цього",
                                "на зображеннях відзначаються зміни(нові об’єкти, відсутні об’єкти, об’єкти, що рухаються, тощо).",
                                "Щоб вибрати зобреження треба натиснути на кнопку 'Вибрати зображення' та у діалоговому окні,",
                                "що відкрилось, вибрати спочатку перше, а потім друге зображення",
                                "Щоб побачити результат треба натиснути на кнопку 'Виконати'",
                                "Щоб побачити перше або друге зображення треба натиснути на відповідну кнопку."},
                        "Інструкція",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        інструкціяButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(myGUI.this,
                        new String[]{"У цьому завданні програма рекомендує полив ділянок поля.",
                                "На вхід отримує одне зображення поля та діапозон кольору, який треба полити.",
                                "після цього на зображенні синім коліром відзначаються ділянки, які треба полити.",
                                "Чим темніший синій, тим більше треба полити поле",
                                "Щоб вибрати зобреження треба натиснути на кнопку 'Вибрати зображення' та у діалоговому окні,",
                                "що відкрилось, вибрати зображення.",
                                "Для вибору діпозону кольорів треба натиснути, відповідні кнопки",
                                "Щоб побачити результат треба натиснути на кнопку 'Обробити зображення'",
                                "Щоб побачити початкове зображення треба натиснути на відповідну кнопку."},
                        "Інструкція",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        взятиКолірПіпеткиButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (pipetColor != null) {
                    color1 = pipetColor;
                    task6Color1.setIcon(createIcon(color1, 16, 16));
                } else {
                    JOptionPane.showMessageDialog(myGUI.this,
                            new String[]{"Виберіть колір за допомогою піпетки"},
                            "Помилка",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        взятиКолірПіпеткиButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (pipetColor != null) {
                    color2 = pipetColor;
                    task6Color2.setIcon(createIcon(color2, 16, 16));
                } else {
                    JOptionPane.showMessageDialog(myGUI.this,
                            new String[]{"Виберіть колір за допомогою піпетки"},
                            "Помилка",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        imageTask6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (startImageTask6 != null) {
                    int intColor = startImageTask6.getRGB(e.getX(), e.getY());
                    pipetColor = new Color(intColor);
                    pipetLabel.setIcon(createIcon(pipetColor, 16, 16));
                }
            }
        });
        buttonPanorama.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                double mn_x = 10000, mn_y = 10000, mx_x = -10000, mx_y = -10000;
                int n = PhotosInfo.photos.size();
                for (int i = 0; i < n; ++i) {
                    mn_x = Math.min(mn_x, PhotosInfo.photos.get(i).getLeftBottomCorner().x);
                    mn_x = Math.min(mn_x, PhotosInfo.photos.get(i).getLeftTopCorner().x);
                    mn_x = Math.min(mn_x, PhotosInfo.photos.get(i).getRightBottomCorner().x);
                    mn_x = Math.min(mn_x, PhotosInfo.photos.get(i).getRightTopCorner().x);

                    mx_x = Math.max(mx_x, PhotosInfo.photos.get(i).getLeftBottomCorner().x);
                    mx_x = Math.max(mx_x, PhotosInfo.photos.get(i).getLeftTopCorner().x);
                    mx_x = Math.max(mx_x, PhotosInfo.photos.get(i).getRightBottomCorner().x);
                    mx_x = Math.max(mx_x, PhotosInfo.photos.get(i).getRightTopCorner().x);

                    mn_y = Math.min(mn_y, PhotosInfo.photos.get(i).getLeftBottomCorner().y);
                    mn_y = Math.min(mn_y, PhotosInfo.photos.get(i).getLeftTopCorner().y);
                    mn_y = Math.min(mn_y, PhotosInfo.photos.get(i).getRightBottomCorner().y);
                    mn_y = Math.min(mn_y, PhotosInfo.photos.get(i).getRightTopCorner().y);

                    mx_y = Math.max(mx_y, PhotosInfo.photos.get(i).getLeftBottomCorner().y);
                    mx_y = Math.max(mx_y, PhotosInfo.photos.get(i).getLeftTopCorner().y);
                    mx_y = Math.max(mx_y, PhotosInfo.photos.get(i).getRightBottomCorner().y);
                    mx_y = Math.max(mx_y, PhotosInfo.photos.get(i).getRightTopCorner().y);
                }
                double sz = 500;
                double dmx = mx_x - mn_x, dpx;
                double dmy = mx_y - mn_y, dpy;

                double rad = (mx_y * Math.PI) / 180;
                double dist = (40000 * Math.cos(rad) / 360) * 1000;

                dmy = dmy * 111320.0;
                dmx = dmx * dist;
                System.out.println(dmy + " !!! " + dmx);
                Mat res;
                if (dmx > dmy) {
                    dpy = (int) (sz * dmy / dmx);
                    dpx = sz;
                } else {
                    dpx = (int) (sz * dmx / dmy);
                    dpy = sz;
                }
                res = new Mat((int) dpy, (int) dpx, CvType.CV_8UC3);
                System.out.println(dpy + " !!! " + dpx);
                double[] len = new double[4];
                double[] to_write = new double[8];
                to_write[0] = mn_x;
                to_write[1] = mn_y;

                to_write[2] = mx_x;
                to_write[3] = mn_y;

                to_write[4] = mx_x;
                to_write[5] = mx_y;

                to_write[6] = mn_x;
                to_write[7] = mx_y;

                int cnt = 0;
                Plane plane;
                Point3 airPoint, focus, groundPoint;
                Mat image = null;
                BufferedImage img = null;
                //boolean[][] used = new boolean[(int) dpy][(int) dpx];
                double hh;
                byte[] pix = new byte[3];

                for (int x = 0; x < dpx; ++x) {
                    for (int y = 0; y < dpy; ++y) {
                        res.put(y, x, new byte[]{0, 0, 0});
                    }
                }
                for (int k = 0; k < n; ++k) {
                    try {
                        img = ImageIO.read(new File(pathToDocument + "DronePhotos\\" + PhotosInfo.photos.get(k).getImage() + ".JPG"));
                        image = Functions.BufferedImage2Mat(img);
                        image = Functions.reSizeOnlyOne(image);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    hh = -PhotosInfo.photos.get(k).startPoint.z;
                    plane = getPlane(new Point3(0, 0, hh), new Point3(0, 1, hh), new Point3(1, 0, hh));
                    Matrices.buildYawMatrix(MathTransform.degreeToRadian(PhotosInfo.photos.get(k).yaw));
                    Matrices.buildRollMatrix(MathTransform.degreeToRadian(PhotosInfo.photos.get(k).roll));
                    Matrices.buildPitchMatrix(MathTransform.degreeToRadian(PhotosInfo.photos.get(k).pitch));
                    double[][] resultMatrix = multiply(Matrices.yawMatrix, multiply(Matrices.rollMatrix, Matrices.pitchMatrix));
                    focus = PhotosInfo.photos.get(k).getFocusOnAir();
                    double[][] aa, bb, cc;
                    double X, Y, dx, dy;
                    for (int x = 0; x < image.width(); ++x) {
                        for (int y = 0; y < image.height(); ++y) {
                            //image.get(image.height() - y, image.width() - x, pix);
                            //image.get(image.height() - y, x, pix);
                            image.get(y, image.width() - x, pix);
                            //image.get(y, x, pix);

                            aa = getMatrixPointOnAir(new Point3(0, 0, 0), (x - image.width() / 2.0) / image.width(), (y - image.height() / 2.0) / image.height());
                            //System.out.println(aa[0][0] + " " + aa[1][0] + " " + aa[2][0] + " " + aa[3][0]);
                            //System.out.println(resultMatrix.toString());
                            bb = multiply(resultMatrix, aa);
                            airPoint = new Point3(bb[0][0], bb[1][0], bb[2][0]);
                            groundPoint = getIntersect(airPoint, focus, plane);
                            X = groundPoint.x / dist;
                            Y = groundPoint.y / 111320.0;
                            X = PhotosInfo.photos.get(k).startPoint.x + X;
                            Y = PhotosInfo.photos.get(k).startPoint.y + Y;
                            dx = X - mn_x;
                            dx = dx * dist;
                            dx = dx / dmx * dpx;
                            dy = mx_y - Y;
                            dy = dy * 111320.0;
                            dy = dy / dmy * dpy;
                            if (dx > 0 && dx < dpx && dy > 0 && dy < dpy)
                                res.put((int) dy, (int) dx, pix);
                        }
                    }
                }
                /*try (FileWriter writer = new FileWriter("notes2.txt", false)) {
                    for (int i = 0; i < to_write.length; ++i) {
                        writer.write(to_write[i] + " ");
                    }
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                */
                try {
                    img = Mat2BufferedImage(res);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                if (img != null)
                    imageTask4.setIcon(new ImageIcon(img));
            }
        });
        інструкціяButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(myGUI.this,
                        new String[]{"У цьому завданні програма визначає план польоту дрона.",
                                "Після натискання кнопки 'Запустити' у браузері відкріється",
                                "Google карта, де Ви маєтете вибрати територію, яку треба сфотографувати.",
                                "Дотримуйтесь інструкції, яка буде на веб сторінці."},
                        "Інструкція",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        buttonSolve23.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (Task23.isImageSet) {
                    try {
                        task23ImageFirst = Mat2BufferedImage(reSizeOnlyOne(Task23.img));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    try {
                        task23ImageSecond = Mat2BufferedImage(reSizeOnlyOne(Task23.img2));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    findTransformMatrix();
                    if (diffFound) {
                        setValue();
                        try {
                            task23Imgage = Mat2BufferedImage(reSizeOnlyOne(solve()));
                            imageTask23.setIcon(new ImageIcon(task23Imgage));
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        buttonTask23FirstImage.setEnabled(true);
                        buttonTask23SecondImage.setEnabled(true);
                        buttonTask23FinalImage.setEnabled(false);
                    } else {
                        JOptionPane.showMessageDialog(myGUI.this,
                                new String[]{"Не вдалося знайти спільні точки"},
                                "Відповідь",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
    }

    //Mat color1, color2, hsvColor1, hsvColor2;
    //BufferedImage col1 = null;
    //BufferedImage col2 = null;
    public void drawColors() {
        task6Color1.setIcon(createIcon(color1, 16, 16));
        task6Color2.setIcon(createIcon(color2, 16, 16));
    }


    public static void loadOpenCV_Lib() throws Exception {
        String model = System.getProperty("sun.arch.data.model");
        String libraryPath = "D:\\myProjects\\TUI\\opencv\\build\\java\\x86\\";
        if (model.equals("64")) {
            libraryPath = "D:\\myProjects\\TUI\\opencv\\build\\java\\x64\\";
        }
        System.setProperty("java.library.path", libraryPath);
        Field sysPath = ClassLoader.class.getDeclaredField("sys_paths");
        sysPath.setAccessible(true);
        sysPath.set(null, null);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }


    public static void main(String[] args) throws Exception {

    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        //   $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        MyPanel = new JPanel();
        MyPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        MyPanel.setBackground(new Color(-986896));
        MyPanel.setMinimumSize(new Dimension(818, 800));
        MyPanel.setPreferredSize(new Dimension(818, 800));
        JTable = new JTabbedPane();
        JTable.setBackground(new Color(-986896));
        JTable.setTabPlacement(2);
        MyPanel.add(JTable, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        Task4 = new JPanel();
        Task4.setLayout(new GridBagLayout());
        Task4.setAlignmentX(0.0f);
        Task4.setAlignmentY(0.0f);
        Task4.setBackground(new Color(-2953488));
        JTable.addTab("Завдання 4", Task4);
        button2 = new JButton();
        button2.setAlignmentY(0.0f);
        button2.setBackground(new Color(-2694187));
        Font button2Font = this.$$$getFont$$$(null, -1, 16, button2.getFont());
        if (button2Font != null) button2.setFont(button2Font);
        button2.setText("Вибрати файл");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.001;
        gbc.insets = new Insets(10, 0, 10, 0);
        Task4.add(button2, gbc);
        button3 = new JButton();
        button3.setAlignmentY(0.0f);
        button3.setBackground(new Color(-2694187));
        button3.setEnabled(false);
        button3.setFocusPainted(true);
        Font button3Font = this.$$$getFont$$$(null, -1, 16, button3.getFont());
        if (button3Font != null) button3.setFont(button3Font);
        button3.setOpaque(true);
        button3.setText("Виконати");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.001;
        Task4.add(button3, gbc);
        buttonTask4Next = new JButton();
        buttonTask4Next.setAlignmentY(0.0f);
        buttonTask4Next.setBackground(new Color(-2694187));
        buttonTask4Next.setEnabled(false);
        Font buttonTask4NextFont = this.$$$getFont$$$(null, -1, 15, buttonTask4Next.getFont());
        if (buttonTask4NextFont != null) buttonTask4Next.setFont(buttonTask4NextFont);
        buttonTask4Next.setText("Наступне зображення");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.insets = new Insets(10, 0, 0, 150);
        Task4.add(buttonTask4Next, gbc);
        buttonTask4Previous = new JButton();
        buttonTask4Previous.setAlignmentY(0.0f);
        buttonTask4Previous.setBackground(new Color(-2694187));
        buttonTask4Previous.setEnabled(false);
        Font buttonTask4PreviousFont = this.$$$getFont$$$(null, -1, 16, buttonTask4Previous.getFont());
        if (buttonTask4PreviousFont != null) buttonTask4Previous.setFont(buttonTask4PreviousFont);
        buttonTask4Previous.setText("Попереднє зображення");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(10, 150, 0, 0);
        Task4.add(buttonTask4Previous, gbc);
        інструкціяButton4 = new JButton();
        інструкціяButton4.setBackground(new Color(-2694187));
        Font інструкціяButton4Font = this.$$$getFont$$$(null, -1, 16, інструкціяButton4.getFont());
        if (інструкціяButton4Font != null) інструкціяButton4.setFont(інструкціяButton4Font);
        інструкціяButton4.setText("Інструкція");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        Task4.add(інструкціяButton4, gbc);
        imageTask4 = new JLabel();
        imageTask4.setAlignmentY(0.0f);
        imageTask4.setIcon(new ImageIcon(getClass().getResource("/dron.jpg")));
        imageTask4.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.weighty = 1.0E-4;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(0, 0, 30, 0);
        Task4.add(imageTask4, gbc);
        buttonPanorama = new JButton();
        buttonPanorama.setBackground(new Color(-2694187));
        buttonPanorama.setEnabled(false);
        Font buttonPanoramaFont = this.$$$getFont$$$(null, -1, 16, buttonPanorama.getFont());
        if (buttonPanoramaFont != null) buttonPanorama.setFont(buttonPanoramaFont);
        buttonPanorama.setText("Побудувати панораму");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.008;
        Task4.add(buttonPanorama, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return MyPanel;
    }

}


