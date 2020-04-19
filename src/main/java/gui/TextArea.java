package gui;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
public class TextArea extends JTextArea implements DocumentListener {

    private static final long serialVersionUID = 4987895228329643607L;
    private Panel parent;

    public TextArea(Panel parent) {
        super();
        this.parent = parent;
        getDocument().addDocumentListener(this);
        getDocument().putProperty("name", "Text Area");
        setColumns(80);
        setRows(30);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        try {
            update(e.getDocument().getText(0, e.getDocument().getLength()));
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        try {
            update(e.getDocument().getText(0, e.getDocument().getLength()));
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        try {
            update(e.getDocument().getText(0, e.getDocument().getLength()));
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }

    private void update(String text) {
        parent.update(text);
    }
}