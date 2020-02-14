package me.Samkist.Sort;

import BreezySwing.GBDialog;

import javax.swing.*;
import java.util.ArrayList;

public class SortPrintDialog extends GBDialog {
    private JTextArea area = addTextArea("", 0, 0 ,1 ,1);

    public SortPrintDialog(JFrame jFrame, ArrayList<Student> list) {
        super(jFrame);
        area.setEditable(false);
        StringBuilder builder = new StringBuilder();
        list.forEach(s -> {
            builder.append(s.print()).append("\n");
        });
        area.setText(builder.toString());
        setTitle("Sorter");
        setSize(400, 400);
        setVisible(true);
    }
}
