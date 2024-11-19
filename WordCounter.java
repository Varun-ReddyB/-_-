import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JLabel resultLabel;
    private JButton countButton;

    public WordCounter() {
        setTitle("Word Counter Application");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);

        countButton = new JButton("Count Words");
        countButton.addActionListener(this);

        resultLabel = new JLabel("Word Count: 0");

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(countButton, BorderLayout.SOUTH);
        add(resultLabel, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countButton) {
            String inputText = textArea.getText();
            int wordCount = countWords(inputText);
            resultLabel.setText("Word Count: " + wordCount);
        }
    }

    private int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WordCounter app = new WordCounter();
            app.setVisible(true);
        });
    }
}
