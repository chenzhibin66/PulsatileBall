package binean;

import javax.swing.*;
import java.awt.*;

public class Bounce {
    public static void main(String [] args){
        EventQueue.invokeLater(() ->{
            JFrame jFrame =new BounceFrame();
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setVisible(true);
        });
    }
}
