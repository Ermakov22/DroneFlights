import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartMenu {
    private JButton початиButton;
    private JLabel Info;
    private JPanel Panel;
    public static JFrame frame;

    public StartMenu() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                Info.setText("<html>Роботу виконали учні <br> Дніпровського ліцею інформаційних технологій <br> імені Олеся Гончара:" +
                        "<br> Арчаков Всеволод <br> Єрмаков Сергій <br> Перекопський Михайло <br> Денисов Костянтин <br> Карпусь Артур</html>");
                Info.setHorizontalAlignment(SwingConstants.RIGHT);
            }
        });
        початиButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                myGUI f = new myGUI();
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("");
        frame.setContentPane(new StartMenu().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 600);
        try {
            BufferedImage img = ImageIO.read(new File(new File("").getAbsolutePath() + "\\src\\drone.png"));
            frame.setIconImage(img);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int x, y;
        x = (Toolkit.getDefaultToolkit().getScreenSize().width - frame.getWidth()) / 2;
        y = (Toolkit.getDefaultToolkit().getScreenSize().height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
        frame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        Panel = new JPanel();
        Panel.setLayout(new GridBagLayout());
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$(null, -1, 18, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Планування та обробка даних польотів дронів");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        Panel.add(label1, gbc);
        початиButton = new JButton();
        Font початиButtonFont = this.$$$getFont$$$(null, -1, 14, початиButton.getFont());
        if (початиButtonFont != null) початиButton.setFont(початиButtonFont);
        початиButton.setText("Почати");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        Panel.add(початиButton, gbc);
        Info = new JLabel();
        Info.setText("___");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.EAST;
        Panel.add(Info, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Турнір Юних Інформатиків");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 0.05;
        gbc.anchor = GridBagConstraints.NORTH;
        Panel.add(label2, gbc);
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
        return Panel;
    }

}
