package gui;

import javax.swing.GroupLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import counter.Counter;

public class Panel extends JPanel {

    private static final long serialVersionUID = 8306160747680364587L;
    private TextArea textarea;
    private JLabel label;
    private JButton button;
    private Counter counter;

    public Panel() {
        super();
        counter = new Counter("");

        label = new JLabel("Nincs szöveg");
        button = new JButton("Törlés");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });

        
        // Adding button to panel, to align it to the right
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(button);
        
        // Adding a version JLabel in a JPanel
        JPanel versionPanel = new JPanel();
        versionPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        versionPanel.add(new JLabel("v1.2"));
        
        // Make scrollable panel
        textarea = new TextArea(this);
        textarea.addMouseListener(new ContextMenuMouseListener());
        JScrollPane scrollPane = new JScrollPane(textarea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Make group layout
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Create bottom line
        JPanel pane = new JPanel();
        GroupLayout layoutPane = new GroupLayout(pane);
        pane.setLayout(layoutPane);
        layoutPane.setAutoCreateGaps(true);
        layoutPane.setAutoCreateContainerGaps(false);

        layoutPane.setHorizontalGroup(
            layoutPane.createSequentialGroup()
                .addComponent(label)
                .addComponent(buttonPanel)
            );
        layoutPane.setVerticalGroup(
            layoutPane.createSequentialGroup()
                .addGroup(layoutPane.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(label)
                    .addComponent(buttonPanel))
        );
        


        // Main layout
        layout.setHorizontalGroup(
        layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane)
            .addComponent(pane)
            .addComponent(versionPanel))
        );
        layout.setVerticalGroup(
        layout.createSequentialGroup()
            .addComponent(versionPanel)
            .addComponent(scrollPane)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(pane))
        );

    }

    public void update(String text) {
        // if (text.equals("Szeretlek")) {
        //     label.setText("Én is Téged, Kincsem!");
        //     return;
        // }
        
        counter.setText(text);

        if (text.length() > 0) {   
            String newLabelText = counter.countLines() + " sor " + counter.countWords() + " szó " + counter.countLetters() + " betű";
            label.setText(newLabelText);
        } else {
            label.setText("Nincs szöveg");
        }
    }

    public void delete() {
        textarea.setText("");
    }
}