/* This file is part of BIRPN.
 *
 * BIRPN is free software: you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * BIRPN is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Lesser GNU General Public License for more details.
 *
 * You should have received a copy of the Lesser GNU General Public
 * License along with BIRPN.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.birpn;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static org.birpn.BIRPN.*;

/**
 *
 * @author Daniel Gronau
 * @version 1.0
 */
public class Main {

    private final JTextArea area = new JTextArea(10, 50);
    private List<String> undo = new ArrayList<String>();
    private List<Op> ops;
    private List<String> displayOps = new ArrayList<String>();
    private List<Meta> metas;
    private final Action functionAction = new AbstractAction("f(x)=") {
        public void actionPerformed(ActionEvent e) {
            JComboBox box = new JComboBox(displayOps.toArray());
            int result = JOptionPane.showConfirmDialog(area.getParent(), box,
                    "Select a Function", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION && box.getSelectedIndex() >= 0) {
              area.insert(ops.get(box.getSelectedIndex()).toString() + " ",
                      area.getCaretPosition());
            }
        }
    };
    private final Action metaAction = new AbstractAction("meta(f(x))") {
        public void actionPerformed(ActionEvent e) {
            JComboBox box = new JComboBox(metas.toArray());
            int result = JOptionPane.showConfirmDialog(area.getParent(), box,
                    "Select a Meta-Function", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION && box.getSelectedIndex() >= 0) {
              area.insert(box.getSelectedItem() + ":",  area.getCaretPosition());
            }
        }
    };
    private Action clearAction = new AbstractAction("Clear") {
        public void actionPerformed(ActionEvent e) {
            area.setText("");
        }
    };
    private Action evalAction = new AbstractAction("Run") {
        public void actionPerformed(ActionEvent e) {
            try {
                String s = area.getText().replaceAll("\n", "");
                List<BigInteger> list = results(s);
                StringBuilder sb = new StringBuilder();
                for(BigInteger bi : list) {
                    if(bi == TRUE) {
                        sb.append("true ");
                    } else if(bi == FALSE) {
                        sb.append("false ");
                    } else {
                        sb.append(bi).append(" ");
                    }
                }
                undo.add(area.getText());
                area.setText(sb.toString());
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(area.getParent(),
                        new JScrollPane(new JTextArea(ex.getMessage())),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    };
    private Action undoAction = new AbstractAction("Undo") {
        public void actionPerformed(ActionEvent e) {
            if(! undo.isEmpty()) {
              area.setText(undo.remove(undo.size()-1));
            }
        }
    };

    public Main() {
        initOps();
        showFrame();
    }

    private void initOps() {
        ops = getOperations();
        Collections.sort(ops, new Comparator<Op>() {
            public int compare(Op o1, Op o2) {
                return o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());
            }
        });
        displayOps = new ArrayList(ops.size());
        for (Op op : ops) {
            displayOps.add(op.getClass().getSimpleName() + ": " + op.toString());
        }
        metas = getMetas();
        Collections.sort(metas, new Comparator<Meta>() {
            public int compare(Meta m1, Meta m2) {
                return m1.toString().compareTo(m2.toString());
            }
        });
    }

    private void showFrame() {
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        JFrame frame = new JFrame("BIRPN Calculator");
        frame.setLocation(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(area));
        frame.getContentPane().add(getButtons(), BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    private JComponent getButtons() {
        Box box = Box.createHorizontalBox();
        box.add(new JButton(functionAction));
        box.add(Box.createHorizontalStrut(10));
        box.add(new JButton(metaAction));
        box.add(Box.createHorizontalStrut(10));
        box.add(new JButton(clearAction));
        box.add(Box.createHorizontalStrut(10));
        box.add(new JButton(undoAction));
        box.add(Box.createHorizontalGlue());
        box.add(new JButton(evalAction));
        return box;
    }

    public static void main(String[] args) {
        new Main();
    }
}
